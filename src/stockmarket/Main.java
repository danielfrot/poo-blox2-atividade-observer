package stockmarket;

public class Main {


    public static void main(String[] args) {
        
        StockExchange myStockPVH = new StockExchange();
        
        // creating observers to myStockPVH
        DollarStockHolder obs1 = new DollarStockHolder(myStockPVH);
        DollarStockHolder obs2 = new DollarStockHolder(myStockPVH);
        GoldStockHolder obs3 = new GoldStockHolder(myStockPVH);
        GoldStockHolder obs4 = new GoldStockHolder(myStockPVH);
        SoyStockHolder obs5 = new SoyStockHolder(myStockPVH);
        SoyStockHolder obs6 = new SoyStockHolder(myStockPVH);
        //Business rules
        obs1.setValueBuy(3.5);
        obs1.setValueSell(4.0);
        
        obs2.setValueBuy(3.2);
        obs2.setValueSell(5.05);
        
        obs5.setValueBuy(90.4);
        obs5.setValueSell(99);
        // changing subject states
        myStockPVH.setPrices(4.05, 100, 90.5);
        
        myStockPVH.setPrices(3.50, 115, 99);
        
        myStockPVH.setPrices(3.10, 135, 87.4);
        
    }
    
}
