public class StableAssets extends Asset {
    private double rateOfReturn;

    public StableAssets(String name, String ID,double rateOfReturn) {
        super(name, ID);
        this.rateOfReturn = rateOfReturn;
    }

    public StableAssets(){

    }

    public int expectedValueInTenYears(int amountInvested){
        double expectedValue = amountInvested * (1 * rateOfReturn);
        return (int)expectedValue;
    }


    @Override
    public String toString() {
        return "StableAssets{Account Type: " + getName() + ", Bank: "+ getID() +", Rate of return: " + this.rateOfReturn + "}";
    }
}
