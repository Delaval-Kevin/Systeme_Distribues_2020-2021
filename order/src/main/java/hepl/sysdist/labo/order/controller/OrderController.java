package hepl.sysdist.labo.order.controller;


import hepl.sysdist.labo.order.dao.CommandeDao;
import hepl.sysdist.labo.order.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class OrderController
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private CommandeDao commandeDao;

    /********************************/
    /*           Methodes           */
    /********************************/
    @PostMapping("/commande/create")
    public Commande createCommande(@RequestBody Cart cart){
        //AtomicReference = une référence vers une valeur volatile ( pas celle en cash )
        AtomicReference<Float> total = new AtomicReference<>((float) 0);
        Commande com = new Commande();
        com.setClientId(cart.getClientId());
        com.setItems(new ArrayList<OrderItem>());

        cart.getCartItems().forEach(cartItem -> {
          OrderItem orderItem = new OrderItem();
          orderItem.setIdArticle(cartItem.getIdArticle());
          orderItem.setQuantity(cartItem.getQuantity());
          orderItem.setTypeTVA(TypeTVA.valueOf(cartItem.getCategory().toUpperCase()));
          orderItem.setPrice(cartItem.getFinalPrice());

          total.set(total.get() + (cartItem.getFinalPrice() * cartItem.getQuantity()));

          com.getItems().add(orderItem);
        });

        com.setTotal(total.get());

        com.setStatus(OrderStatus.PREPARING);

        return commandeDao.saveAndFlush(com);
    }

    @PostMapping("/commande/changestate")
    public Commande changeCommandeState(@RequestBody Commande commande){
        Commande com = commandeDao.findCommandeById(commande.getId());
        com.setStatus(commande.getStatus());

        return commandeDao.saveAndFlush(com);
    }

    @GetMapping("/commande/{id_commande}")
    public Commande getCommande(@PathVariable("id_commande") int id_commande) {
        return commandeDao.findCommandeById(id_commande);
    }

    @GetMapping("/commandes/{id_client}")
    public ArrayList<Commande> getCommandeByClientId(@PathVariable("id_client") int id_client) {
        return commandeDao.findCommandesByClientId(id_client); //todo: pas renvoyer une liste
    }

}
