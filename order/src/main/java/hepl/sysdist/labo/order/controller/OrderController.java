package hepl.sysdist.labo.order.controller;


import hepl.sysdist.labo.order.dao.CommandeDao;
import hepl.sysdist.labo.order.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class OrderController {

    @Autowired
    private CommandeDao commandeDao;

    @PostMapping("/order/{cart}{user_id}")
    public Commande createOrder(@RequestBody Cart cart){

        return null;
    }
    


    @GetMapping("/commande/{id}")
    public Commande getCommande(@PathVariable("id") int id) {
        return commandeDao.findCommandeById(id);
    }

    @GetMapping("/commandes/{user_id}")
    public ArrayList<Commande> getCommandeByClientId(@PathVariable("user_id") int user_id) {
        return commandeDao.findCommandesByClientId(user_id);
    }

}
