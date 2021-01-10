//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 10/01/2021

package hepl.sysdist.labo.api.controller;

import hepl.sysdist.labo.api.models.Checkout.Client;
import hepl.sysdist.labo.api.models.Checkout.Paiement;
import hepl.sysdist.labo.api.models.Order.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public String listUserCommands(Model model,
                                   HttpServletResponse httpResponse)
    {
        Client client = restTemplate.getForObject("http://checkout/checkout/1", Client.class);
        model.addAttribute("client", client);
        ArrayList<Commande> commandes = new ArrayList<>();

        for (Paiement paiement : client.getPaiements())
        {
            Commande commande = restTemplate.getForObject("http://order/commande/"+paiement.getIdCommande(),Commande.class);
            commandes.add(commande);
            //todo: recup les infos des objets dans la commande
        }

        model.addAttribute("commandes", commandes);
        model.addAttribute("title", "Compte");
        return "userDetails";
    }

}
