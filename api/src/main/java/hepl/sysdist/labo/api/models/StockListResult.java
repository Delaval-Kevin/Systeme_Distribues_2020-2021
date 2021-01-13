//Auteur : HENDRICK Samuel                                                                                              
//Projet : stock                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.api.models;

import java.util.ArrayList;

public class StockListResult
{
    /********************************/
    /*           Variables          */
    /********************************/
    private ArrayList<Item> items;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public StockListResult(ArrayList<Item> items) {
        this.items = items;
    }

    public StockListResult() { }

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
