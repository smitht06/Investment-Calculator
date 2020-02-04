public class StableAssets extends Asset {
    private double rateOfReturn;

    public StableAssets(String name, String ID, int amountInvested,double rateOfReturn) {
        super(name, ID, amountInvested);
    }

    public StableAssets(){
        this.rateOfReturn = 0;
    }

    public int expectedValueInTenYears(){
        double expectedValue = amountInvested * (1 * rateOfReturn);
        return (int)expectedValue;
    }

}
