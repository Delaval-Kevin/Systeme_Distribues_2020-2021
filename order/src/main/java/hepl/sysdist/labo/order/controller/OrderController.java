package hepl.sysdist.labo.order.controller;


import hepl.sysdist.labo.order.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {


    @PostMapping("/order/{cart}{user_id}")
    public Commande createOrder(@RequestBody Cart cart){

        return null;
    }

    @GetMapping("/commande/{id}")
    public Commande getCommande(@PathVariable("id") int id) {
        return null;
    }

    @GetMapping("/commandes/{user_id}")
    public OrderResponse getCommandeByClientId(@PathVariable("user_id") int id) {
        return null;
    }

}
