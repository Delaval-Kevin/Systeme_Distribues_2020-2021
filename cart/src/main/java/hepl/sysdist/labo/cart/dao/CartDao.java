package hepl.sysdist.labo.cart.dao;

import hepl.sysdist.labo.cart.model.Cart;
import hepl.sysdist.labo.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CartDao extends JpaRepository<CartItem, Integer>
{

    ArrayList<CartItem> getCartItemsByClientId(int clientId);

    CartItem getCartItemByClientIdAndItemId(int clientId, int itemId);

}
