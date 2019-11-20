/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class StockExchange implements Subject{
    // lista de observadores
    
    private ArrayList<Observer> observers;
    private double Dollar;
    private double Gold;
    private double Soy;

    public StockExchange() {
        // instanciar a lista de todos os observers
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public void attach(Observer Obs) {
        // adiciona a lista
        if (Obs != null){
            observers.add(Obs);
        }
    }

    @Override
    public void detach(Observer Obs) {
        // pegar o index do observador
        int observerIndex = observers.indexOf(Obs);
        System.out.println("Observer "+ (observerIndex + 1) + " was removed!");
        // removing observer from list
        observers.remove(observerIndex);
    }

    @Override
    public void nofityObservers() {
        // cycle throught all observers and notifies
        // them of price changes
        for(Observer obs: observers){
            obs.update(this.Dollar, this.Gold, this.Soy);
        }
    }
    
    public void setPrices(double newDollar, double newGold, double newSoy){
        this.Dollar = newDollar;
        this.Gold = newGold;
        this.Soy = newSoy;
        nofityObservers();
    }
    
    public double getDollarPrice(){
        return Dollar;
    }
    
    public double getGoldPrice(){
        return Gold;
    }
    
    public double getSoyPrice(){
        return Soy;
    }
}
