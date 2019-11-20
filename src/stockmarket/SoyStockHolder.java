package stockmarket;
public class SoyStockHolder implements Observer{
    private double soyPrice;
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
    public SoyStockHolder(Subject market) {
        this.market = market;
        // Assing oa Observer ID and increment static counter
        this.ObserverID = ++observerIDTracker;
        // Message of new Observer
        System.out.println("New Soy Observer ID: "+ this.ObserverID);
        // Adding observer to subject arraylist
        this.market.attach(this);
    }
    @Override
    public void update(double Dollar, double Gold, double Soy) {
        this.soyPrice = Soy;
        BuyAndSell();
    }
    private void BuyAndSell(){
        System.out.println("Soy Observer ID: "+ this.ObserverID + " Soy Price: " + this.soyPrice);
        if(this.soyPrice >= ValueSell){
            System.out.println("Selling Soy!\n");
        }else if( this.soyPrice <= ValueBuy){
            System.out.println("Buying Soy! \n");
        }else{
            System.out.println("Holding Position!\n");
        }
    }
}