//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 08/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.models.Cart.Cart;
import hepl.sysdist.labo.api.models.Cart.CartItem;
import hepl.sysdist.labo.api.models.Order.Commande;
import hepl.sysdist.labo.api.models.StockResult;
import hepl.sysdist.labo.api.models.Tva.TVAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CommandeController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/command/preview")
    public String previewCommande(@RequestParam("user-id") int id,
                                  Model model,
                                  HttpServletResponse httpResponse)
    {
        model.addAttribute("title", "Preview");

        Cart cart = restTemplate.getForObject("http://cart/item/1", Cart.class); //todo: get user id
        for (CartItem item: cart.getCartItems()) {
            StockResult stockres = restTemplate.getForObject("http://stock/article/"+ item.getItemId()+"?think="+item.getQuantity(), StockResult.class);

            item.setName(stockres.getItem().getName());
            item.setSufficient(stockres.isSufficient());
            item.setPrice(stockres.getItem().getPrice());
            item.setCategory(stockres.getItem().getCategroy());

            TVAResponse tvaResponse = restTemplate.getForObject("http://tva/tva?category="+item.getCategory(), TVAResponse.class);
            item.setTva((float)tvaResponse.getTax());
        }
        cart.setClientId(1);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Cart> httpEntity = new HttpEntity<>(cart, headers);

        Commande commande = restTemplate.postForObject("http://order/commande/create", httpEntity, Commande.class);

        //todo: ajouter les infos des articles dans les objets de la commande

        model.addAttribute("commande", commande);

        return "preview";
    }

}
