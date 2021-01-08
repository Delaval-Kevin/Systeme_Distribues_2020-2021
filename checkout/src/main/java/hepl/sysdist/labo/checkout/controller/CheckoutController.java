package hepl.sysdist.labo.checkout.controller;

import hepl.sysdist.labo.checkout.dao.ClientDao;
import hepl.sysdist.labo.checkout.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CheckoutController
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private ClientDao clientDao;

    /********************************/
    /*           Methodes           */
    /********************************/
    @PostMapping ("/checkout")
    public CheckoutResponse doCheckout(@RequestBody Commande commande){
        int fraisLivraison;
        CheckoutResponse rep = new CheckoutResponse();
        Client cli = clientDao.getClientById(commande.getClientId());

        //calcul de la nouvelle balance du client
        if(commande.isExpress())
            fraisLivraison = 10;
        else
            fraisLivraison = 5;

        cli.setBalance(cli.getBalance()-(commande.getTotal() + fraisLivraison));

        //creation du paiement du paiement
        cli.getPaiements().add(new Paiement(commande.getId()));

        //sauvegarde du client et de ses nouvelles infos
        clientDao.saveAndFlush(cli);

        //set de la reponse
        rep.setClient(clientDao.getClientById(commande.getClientId()));
        rep.setTotalCheckout(commande.getTotal() + fraisLivraison);
        return rep;
    }

    @GetMapping("/checkout/{user_id}")
    public Client GetClient(@PathVariable("user_id") int user_id) {
        return clientDao.getClientById(user_id);
    }

}
