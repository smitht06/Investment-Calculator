public class StableAssets extends Asset {
    private double rateOfReturn;

    public StableAssets(String name, String ID,double rateOfReturn) {
        super(name, ID);
    }

    public StableAssets(){
        this.rateOfReturn = 0;
    }

    public int expectedValueInTenYears(int amountInvested){
        double expectedValue = amountInvested * (1 * rateOfReturn);
        return (int)expectedValue;
    }

}
