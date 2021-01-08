package hepl.sysdist.labo.stock.controller;

import hepl.sysdist.labo.stock.model.Item;
import hepl.sysdist.labo.stock.model.Stock;
import hepl.sysdist.labo.stock.model.StockListResult;
import hepl.sysdist.labo.stock.model.StockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class StockController
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Autowired
    private Stock stock;

    /********************************/
    /*           Methodes           */
    /********************************/
    @GetMapping("/article/{id}")
    public StockResult checkInventory(@PathVariable("id") int id, @RequestParam(defaultValue = "1") int think) {

        StockResult sr = new StockResult();

        if(stock.getInventory().containsKey(id))
        {
            Item item = stock.getInventory().get(id);
            sr.setItem(item);
            sr.setSufficient(item.getQuantity() >= think);

        }else{
            sr.setItem(null);
            sr.setSufficient(false);
            //todo: peut etre envoyer un 404
        }

        return sr;
    }

    @GetMapping("/articles")
    public StockListResult getInventory()
    {
        ArrayList<Item> res = new ArrayList<>(stock.getInventory().values());
        return new StockListResult(res);
    }

    @PostMapping("article/{id}")
    public void removeItem(@PathVariable("id") int id, @RequestParam(defaultValue = "1") int remove)
    {
        StockResult sr = new StockResult();

        if(stock.getInventory().containsKey(id))
        {
            Item item = stock.getInventory().get(id);
            item.setQuantity(item.getQuantity()-remove);
        }
    }
}
