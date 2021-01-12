//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 08/01/2021

package hepl.sysdist.labo.api.controller;

import com.netflix.discovery.converters.Auto;
import hepl.sysdist.labo.api.config.Session;
import hepl.sysdist.labo.api.models.Cart.Cart;
import hepl.sysdist.labo.api.models.Cart.CartAddRequest;
import hepl.sysdist.labo.api.models.Cart.CartItem;
import hepl.sysdist.labo.api.models.Checkout.CheckoutResponse;
import hepl.sysdist.labo.api.models.Order.Commande;
import hepl.sysdist.labo.api.models.Order.OrderItem;
import hepl.sysdist.labo.api.models.Order.OrderStatus;
import hepl.sysdist.labo.api.models.StockResult;
import hepl.sysdist.labo.api.models.Tva.TVAResponse;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommandeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Session session;

    @PostMapping("/command/preview")
    public String previewCommande(@RequestParam("user-id") int id,
                                  Model model,
                                  HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        session.CheckUserConnection(httpServletRequest, httpServletResponse);
        int userId = session.getUserId(httpServletRequest);
        model.addAttribute("title", "Preview");

        Cart cart = restTemplate.getForObject("http://cart/item/"+userId, Cart.class);
        for (CartItem item: cart.getCartItems()) {
            StockResult stockres = restTemplate.getForObject("http://stock/article/"+ item.getItemId()+"?think="+item.getQuantity(), StockResult.class);

            item.setName(stockres.getItem().getName());
            item.setSufficient(stockres.isSufficient());
            item.setPrice(stockres.getItem().getPrice());
            item.setCategory(stockres.getItem().getCategory());

            TVAResponse tvaResponse = restTemplate.getForObject("http://tva/tva?category="+item.getCategory(), TVAResponse.class);
            item.setTva((float)tvaResponse.getTax());
        }
        cart.setClientId(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Cart> httpEntity = new HttpEntity<>(cart, headers);

        Commande commande = restTemplate.postForObject("http://order/commande/create", httpEntity, Commande.class);
        for (OrderItem item: commande.getItems()) {
            StockResult stockres = restTemplate.getForObject("http://stock/article/" + item.getIdArticle() + "?think=" + item.getQuantity(), StockResult.class);
            item.setName(stockres.getItem().getName());
        }

        model.addAttribute("commande", commande);

        return "preview";
    }

    @PostMapping("/command/validate")
    public String validateCommande(@RequestParam("user-id") int id, @RequestParam("delivery") boolean fastDelivery,
                                   @RequestParam("command-id") int commandId,
                                   Model model,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        session.CheckUserConnection(httpServletRequest, httpServletResponse);
        int userId = session.getUserId(httpServletRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Commande commande = restTemplate.getForObject("http://order/commande/"+commandId,Commande.class);
        for (OrderItem item: commande.getItems()) {
            StockResult stockres = restTemplate.getForObject("http://stock/article/" + item.getIdArticle() + "?think=" + item.getQuantity(), StockResult.class);
            item.setName(stockres.getItem().getName());
        }

        /* vider le stock */
        for(OrderItem item: commande.getItems())
        {
            HttpEntity<OrderItem> httpEntity = new HttpEntity<>(item, headers);
            restTemplate.postForObject("http://stock/article/", httpEntity, Object.class);
        }

        /*changement de l'etat de la commande*/
        commande.setStatus(OrderStatus.PREPARING);
        commande.setId(commandId);

        headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Commande> httpEntity = new HttpEntity<>(commande, headers);

        commande = restTemplate.postForObject("http://order/commande/changestate", httpEntity, Commande.class);
        /*FIN changement de l'etat de la commande*/

        /* Envoi sur le checkout */
        commande.setExpress(fastDelivery);
        model.addAttribute("commande", commande);
        httpEntity = new HttpEntity<>(commande, headers);

        CheckoutResponse checkoutResponse = restTemplate.postForObject("http://checkout/checkout", httpEntity, CheckoutResponse.class);
        model.addAttribute("client", checkoutResponse.getClient());
        model.addAttribute("total", checkoutResponse.getTotalCheckout());

        restTemplate.delete("http://cart/item/"+userId);

        model.addAttribute("title", "Commande");

        return "recap";
    }

    @PostMapping("/command/cancel")
    public String cancelCommande(  @RequestParam("command-id") int commandId,
                                   Model model,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        session.CheckUserConnection(httpServletRequest, httpServletResponse);
        int userId = session.getUserId(httpServletRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Commande commande = new Commande();
        commande.setId(commandId);

        HttpEntity<Commande> httpEntity = new HttpEntity<>(commande, headers);

        restTemplate.postForObject("http://order/commande/cancel", httpEntity, Object.class);

        return "redirect:/";
    }

}
