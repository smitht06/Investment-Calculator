/*
 * File: StableAssets.java
 * Author: Anthony Smith
 * Date: 2/12/2020
 * Course: COP 5007
 * Purpose: This class is a sublclass of assets for stable assets
 * */

//create stable assets class as a subclass of assets
public class StableAssets extends Asset {
    private double rateOfReturn;

    //constuctors
    public StableAssets(String ID,String name, double rateOfReturn) {
        super(name, ID);
        this.rateOfReturn = rateOfReturn;
    }

    public StableAssets() {
    }

    public StableAssets(String ID,String name, int AmountInvested, int profit){
        super(ID,name,AmountInvested,profit);
    }

    //calculate the value in 10 years for stable assets
    public int valueInTenYears(int amountInvested) {
        double expectedValue = amountInvested + amountInvested * (1 * this.rateOfReturn);
        return (int) expectedValue;
    }

    @Override
    public String toString() {
        return getID() +" "+ getAmountInvested() + " " + getProfit();
    }

}

