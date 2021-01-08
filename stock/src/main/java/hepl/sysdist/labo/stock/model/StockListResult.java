//Auteur : HENDRICK Samuel                                                                                              
//Projet : stock                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.stock.model;

import java.util.ArrayList;
import java.util.List;

public class StockListResult
{
    /********************************/
    /*           Variables          */
    /********************************/
    private ArrayList<Item> items;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public StockListResult() { }

    public StockListResult(ArrayList<Item> items) {
        this.items = items;
    }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
