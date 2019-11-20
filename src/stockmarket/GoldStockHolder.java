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
public class GoldStockHolder implements Observer {

    private double GoldPrice;
    // variável estática usada para fazer contagem
    private static int observerIDTracker = 0;
    // Oberserver id
    private int ObserverID;
    // Will hold reference to the Market 
    private Subject market;
    
    
    public GoldStockHolder(Subject market) {
        this.market = market;
        // Assing oa Observer ID and increment static counter
        this.ObserverID = ++observerIDTracker;
        // Message of new Observer
        System.out.println("New Gold Observer ID: "+ this.ObserverID);
        // Adding observer to subject arraylist
        this.market.attach(this);
    }
    
    

    @Override
    public void update(double Dollar, double Gold, double Soy) {
        this.GoldPrice = Gold;
        BuyAndSell();
    }

    private void BuyAndSell() {
        System.out.println("Gold Observer ID: "+ this.ObserverID + " Gold Price: " + this.GoldPrice);
        if(this.GoldPrice > 130){
            System.out.println("Selling Gold!\n");
        }else if( this.GoldPrice <= 100){
            System.out.println("Buying Gold! \n");
        }else{
            System.out.println("Holding Position!\n");
        }
    }
    
}
