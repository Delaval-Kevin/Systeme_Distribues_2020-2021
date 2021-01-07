package hepl.sysdist.labo.checkout.controller;

import hepl.sysdist.labo.checkout.dao.ClientDao;
import hepl.sysdist.labo.checkout.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckoutController {

    @Autowired
    private ClientDao clientDao;

    @GetMapping("/{user_id}")
    public CheckoutResponse doCheckout(@RequestBody Cart cart, @PathVariable("user_id") int user_id){
        return new CheckoutResponse();
    }

}
