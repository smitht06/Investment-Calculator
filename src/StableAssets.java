

public class StableAssets extends Asset {
    private double rateOfReturn;

    public StableAssets(String ID,String name, double rateOfReturn) {
        super(name, ID);
        this.rateOfReturn = rateOfReturn;
    }

    public StableAssets() {

    }
    public StableAssets(String ID,String name, int AmountInvested, int profit){
        super(ID,name,AmountInvested,profit);
    }

    public int valueInTenYears(int amountInvested) {
        double expectedValue = amountInvested + amountInvested * (1 * this.rateOfReturn);
        return (int) expectedValue;
    }


    @Override
    public String toString() {
        return getID() +" "+ getAmountInvested() + " " + getProfit();
    }

}

