/*
 * File: Asset.java
 * Author: Anthony Smith
 * Date: 2/12/2020
 * Course: COP 5007
 * Purpose: This class is an abstract parent class of StableAssests and Stocks
 * */
//declare abstract class and fields
public abstract class Asset {
    private String name;
    private String ID;
    private int amountInvested;
    private int profit;
    int valueInTenYears;

    //constructor with name and ID
    public Asset(String ID, String name) {
        this.name = name;
        this.ID = ID;

    }
    //constructor with name id invested and profit
    public Asset(String ID,String name, int AmountInvested, int profit){
        this.amountInvested = AmountInvested;
        this.profit = profit;
    }

    //default constructor
    public Asset(){
    }

    public int valueInTenYears(int amountInvested){
        return valueInTenYears;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAmountInvested() {
        return amountInvested;
    }

    public void setAmountInvested(int amountInvested) {
        this.amountInvested = amountInvested;
    }
}
