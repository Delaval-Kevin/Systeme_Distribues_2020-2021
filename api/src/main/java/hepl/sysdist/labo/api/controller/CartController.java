//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 08/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.models.Cart.Cart;
import hepl.sysdist.labo.api.models.Cart.CartAddRequest;
import hepl.sysdist.labo.api.models.Cart.CartItem;
import hepl.sysdist.labo.api.models.StockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CartController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cart")
    public String cart(Model model)
    {
        model.addAttribute("title", "Cart");

        Cart cart = restTemplate.getForObject("http://cart/item/1", Cart.class); //todo: get user id
        for (CartItem item: cart.getCartItems()) {
            StockResult stockres = restTemplate.getForObject("http://stock/article/"+ item.getItemId()+"?think="+item.getQuantity(), StockResult.class);

            item.setName(stockres.getItem().getName());
            item.setSufficient(stockres.isSufficient());
            item.setPrice(stockres.getItem().getPrice());
            item.setCategory(stockres.getItem().getCategory());
        }

        model.addAttribute("cart", cart);

        return "cart";
    }

    @PostMapping("/cart")
    public String addItemToCart(@ModelAttribute CartAddRequest cartAddRequest, Model model, HttpServletResponse httpResponse)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CartAddRequest> httpEntity = new HttpEntity<>(cartAddRequest, headers);

        Cart cart = restTemplate.postForObject("http://cart/item/1", httpEntity, Cart.class);

        model.addAttribute("cart", cart);

        try {
            httpResponse.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "cart";
    }

    @PostMapping("/cart/item")
    public String removeItemFromCart(@RequestParam("item-id") int id, @RequestParam("quantity") int quantity,
                                     Model model,
                                     HttpServletResponse httpResponse)
    {
        System.out.println((id + " ** " + quantity));
        CartAddRequest cartAddRequest = new CartAddRequest();
        cartAddRequest.setId(id);
        cartAddRequest.setQuantity(-quantity);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CartAddRequest> httpEntity = new HttpEntity<>(cartAddRequest, headers);

        Cart cart = restTemplate.postForObject("http://cart/item/1", httpEntity, Cart.class);

        try {
            httpResponse.sendRedirect("/cart");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cart(model);
    }


}
