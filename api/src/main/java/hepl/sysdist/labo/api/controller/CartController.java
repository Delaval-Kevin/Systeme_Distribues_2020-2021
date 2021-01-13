//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 08/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.config.Session;
import hepl.sysdist.labo.api.models.Cart.Cart;
import hepl.sysdist.labo.api.models.Cart.CartAddRequest;
import hepl.sysdist.labo.api.models.Cart.CartItem;
import hepl.sysdist.labo.api.models.StockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CartController
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Session session;

    /********************************/
    /*           Methodes           */
    /********************************/
    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        session.CheckUserConnection(httpServletRequest, httpServletResponse);

        model.addAttribute("title", "Cart");

        int idUser = session.getUserId(httpServletRequest);

        Cart cart = restTemplate.getForObject("http://cart/item/"+idUser, Cart.class);
        for (CartItem item: cart.getCartItems())
        {
            StockResult stockres = restTemplate.getForObject("http://stock/article/"+ item.getItemId()+"?think="+item.getQuantity(), StockResult.class);

            item.setName(stockres.getItem().getName());
            item.setSufficient(stockres.isSufficient());
            item.setPrice(stockres.getItem().getPrice());
            item.setCategory(stockres.getItem().getCategory());
        }

        model.addAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("/cart")   //@ModelAttribute avec Thymeleaf on peutt jouer avec les models
    public String addItemToCart(@ModelAttribute CartAddRequest cartAddRequest, Model model,
                                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CartAddRequest> httpEntity = new HttpEntity<>(cartAddRequest, headers);

        int idUser = session.getUserId(httpServletRequest);
        Cart cart = restTemplate.postForObject("http://cart/item/"+idUser, httpEntity, Cart.class);

        model.addAttribute("cart", cart);

        try
        {
            httpServletResponse.sendRedirect("/");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return "cart";
    }

    @PostMapping("/cart/item")
    public String removeItemFromCart(@RequestParam("item-id") int id, @RequestParam("quantity") int quantity,
                                     Model model,
                                     HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        CartAddRequest cartAddRequest = new CartAddRequest();
        cartAddRequest.setId(id);
        cartAddRequest.setQuantity(-quantity);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CartAddRequest> httpEntity = new HttpEntity<>(cartAddRequest, headers);

        int idUser = session.getUserId(httpServletRequest);
        Cart cart = restTemplate.postForObject("http://cart/item/"+idUser, httpEntity, Cart.class); //todo: get id personne

        try
        {
            httpServletResponse.sendRedirect("/cart");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return cart(model, httpServletRequest, httpServletResponse);
    }
}
