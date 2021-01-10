package hepl.sysdist.labo.cart.controller;

import hepl.sysdist.labo.cart.dao.CartDao;
import hepl.sysdist.labo.cart.model.Cart;
import hepl.sysdist.labo.cart.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CartController
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private CartDao cartDao;

    /********************************/
    /*           Methodes           */
    /********************************/
    @GetMapping("/item/{client_id}")
    public Cart getCart(@PathVariable int client_id){
        Cart cart = new Cart();
        cart.setCartItems(cartDao.getCartItemsByClientId(client_id));
        return cart;
    }

    @PostMapping("/item/{client_id}")
    public Cart addToCart(@PathVariable int client_id, @RequestBody CartItem item){
        CartItem tmpItem = cartDao.getCartItemByClientIdAndItemId(client_id, item.getItemId());
        if(tmpItem != null){
            tmpItem.setQuantity(tmpItem.getQuantity() + item.getQuantity());
            if(tmpItem.getQuantity() <= 0)
                cartDao.deleteById(tmpItem.getId());
            else
                cartDao.save(tmpItem);
        }else{
            if(item.getQuantity() > 0)
            {
                item.setClientId(client_id);
                cartDao.save(item);
            }
        }

        return this.getCart(client_id);
    }

    @DeleteMapping("/item/{client_id}")
    public void deleteFromCart(@PathVariable int client_id){
        ArrayList<CartItem> items = cartDao.getCartItemsByClientId(client_id);
        for(CartItem item: items)
        {
            cartDao.delete(item);
        }
    }

}
