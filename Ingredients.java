/**
 * Coded By: Gianluca Zambito
 */
public class Ingredients
{
    private String name;
    private double amount;
    private UnitEnum unit;
    
    public Ingredients(String name, double amount, UnitEnum unit){
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
    
    public String getName(){
        return name;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public UnitEnum getUnit(){
        return unit;
    }
    
    public void setAmount(double newAmount){
        amount = newAmount;
    }
}
