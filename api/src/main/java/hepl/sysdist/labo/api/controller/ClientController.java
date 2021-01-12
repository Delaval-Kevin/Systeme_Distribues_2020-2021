//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 10/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.config.Session;
import hepl.sysdist.labo.api.models.Checkout.Client;
import hepl.sysdist.labo.api.models.Checkout.Paiement;
import hepl.sysdist.labo.api.models.Order.Commande;
import hepl.sysdist.labo.api.models.Order.OrderItem;
import hepl.sysdist.labo.api.models.StockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Session session;

    @GetMapping("/user")
    public String listUserCommands(Model model,
                                   HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        int userId = session.CheckUserConnection(httpServletRequest, httpServletResponse);

        Client client = restTemplate.getForObject("http://checkout/checkout/"+userId, Client.class);
        model.addAttribute("client", client);
        ArrayList<Commande> commandes = new ArrayList<>();

        for (Paiement paiement : client.getPaiements())
        {
            Commande commande = restTemplate.getForObject("http://order/commande/"+paiement.getIdCommande(),Commande.class);
            if(commande != null)
            {
                commandes.add(commande);
                for (OrderItem item: commande.getItems()) {
                    StockResult stockres = restTemplate.getForObject("http://stock/article/" + item.getIdArticle() + "?think=" + item.getQuantity(), StockResult.class);
                    item.setName(stockres.getItem().getName());
                }
            }
        }

        model.addAttribute("commandes", commandes);
        model.addAttribute("title", "Compte");
        return "userDetails";
    }

}
