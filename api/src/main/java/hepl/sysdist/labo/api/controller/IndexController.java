//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.api.controller;

import com.netflix.discovery.converters.Auto;
import hepl.sysdist.labo.api.config.Session;
import hepl.sysdist.labo.api.models.Cart.CartAddRequest;
import hepl.sysdist.labo.api.models.StockListResult;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController
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
    @GetMapping(value = {"/", "/shop"})
    public String greeting(Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        session.CheckUserConnection(httpServletRequest, httpServletResponse);

        StockListResult response = restTemplate.getForObject("http://stock/articles", StockListResult.class);

        //model avec des clé - valeurs
        model.addAttribute("cartAddRequest", new CartAddRequest());
        model.addAttribute("title", "Shop");
        model.addAttribute("stock", response.getItems());
        //retourne le nom de la vue
        return "greeting";
    }
}
