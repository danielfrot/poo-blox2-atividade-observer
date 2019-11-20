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
public interface Subject {
   
    public void attach(Observer Obs);
    public void detach(Observer Obs);
    public void nofityObservers();
   
}
