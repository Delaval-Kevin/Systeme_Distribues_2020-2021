package hepl.sysdist.labo.stock.controller;

import hepl.sysdist.labo.stock.model.Item;
import hepl.sysdist.labo.stock.model.Stock;
import hepl.sysdist.labo.stock.model.StockListResult;
import hepl.sysdist.labo.stock.model.StockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class StockController {

    @Autowired
    private Stock stock;

    @GetMapping("/article/{id}")
    public StockResult checkInventory(@PathVariable("id") int id, @RequestParam(defaultValue = "1") int think){
        /*
        *
        * Using @RequestParam as
        *
        * public @ResponseBody item getitem(@RequestParam("data") String itemid){
        *
        * requires data query parameter to be always present.
        *
        * Instead if you use it this way
        *
        * public @ResponseBody item getitem(@RequestParam Map<String, String> queryParameters){
        *
        * , it makes data to be optional – samsri Jan 19 '18 at 9:13
        *
        * https://stackoverflow.com/questions/32201441/how-do-i-retrieve-query-parameters-in-spring-boot
        *
        * */

        StockResult sr = new StockResult();

        if(stock.inventory.containsKey(id))
        {
            Item item = stock.inventory.get(id);
            sr.setItem(item);
            sr.setSufficient(item.quantity >= think);

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
        ArrayList<Item> res = new ArrayList<>(stock.inventory.values());
        return new StockListResult(res);
    }

    @PostMapping("article/{id}")
    public void removeItem(@PathVariable("id") int id, @RequestParam(defaultValue = "1") int remove)
    {
        StockResult sr = new StockResult();

        if(stock.inventory.containsKey(id))
        {
            Item item = stock.inventory.get(id);
            item.quantity -= remove;
        }
    }
}
