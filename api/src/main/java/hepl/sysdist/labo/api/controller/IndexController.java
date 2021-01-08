//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.models.Cart.CartAddRequest;
import hepl.sysdist.labo.api.models.StockListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = {"/", "/shop"})
    public String greeting(Model model)
    {

        StockListResult response = restTemplate.getForObject("http://stock/articles", StockListResult.class);

        model.addAttribute("cartAddRequest", new CartAddRequest());
        model.addAttribute("title", "Shop");
        model.addAttribute("stock", response.getItems());
        return "greeting";
    }
}
