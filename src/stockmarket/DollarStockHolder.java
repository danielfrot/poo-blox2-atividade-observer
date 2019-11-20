/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

/**
 *
 * @author Daniel
 */
public class DollarStockHolder implements Observer {

    private double DollarPrice;
    // variável estática usada para fazer contagem
    private static int observerIDTracker = 0;
    // Oberserver id
    private int ObserverID;
    // Will hold reference to the Market 
    private Subject market;
    private double ValueSell;
    private double ValueBuy;

    public void setValueSell(double ValueSell) {
        this.ValueSell = ValueSell;
    }

    public void setValueBuy(double ValueBuy) {
        this.ValueBuy = ValueBuy;
    }

    public DollarStockHolder(Subject market) {
        this.market = market;
        // Assing oa Observer ID and increment static counter
        this.ObserverID = ++observerIDTracker;
        // Message of new Observer
        System.out.println("New Dollar Observer ID: "+ this.ObserverID);
        // Adding observer to subject arraylist
        this.market.attach(this);
    }
    
    // called to update all observers
    @Override
    public void update(double Dollar, double Gold, double Soy) {
        this.DollarPrice = Dollar;
        BuyAndSell();
    }

    private void BuyAndSell(){
        System.out.println("Dollar Observer ID: "+ this.ObserverID + " Dollar Price: " + this.DollarPrice);
        if(this.DollarPrice >= ValueSell){
            System.out.println("Selling Dollares!\n");
        }else if( this.DollarPrice <= ValueBuy){
            System.out.println("Buying Dollars! \n");
        }else{
            System.out.println("Holding Position!\n");
        }
    }
    
}
