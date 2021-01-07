package hepl.sysdist.labo.stock.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Stock {

    public HashMap<Integer, Item> inventory;

    public Stock(){
        this.inventory = new HashMap<Integer, Item>();
        this.inventory.put(1, new Item(1, "Cereales", 2, 3.99f, "other"));
        this.inventory.put(2, new Item(2, "Console", 2, 3.99f, "other"));
        this.inventory.put(3, new Item(3, "Outils", 2, 3.99f, "other"));
        this.inventory.put(4, new Item(4, "Books", 2, 3.99f, "book"));
    }

}
