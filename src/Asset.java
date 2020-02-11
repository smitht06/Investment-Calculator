public abstract class Asset {
    private String name;
    private String ID;
    private int amountInvested;
    private int profit;
    int valueInTenYears;

    public Asset(String ID, String name) {
        this.name = name;
        this.ID = ID;

    }
    public Asset(String ID,String name, int AmountInvested, int profit){
        this.amountInvested = AmountInvested;
        this.profit = profit;
    }

    public Asset(){
    }
    public int valueInTenYears(int amountInvested){
        return valueInTenYears;
    }

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

    public int getValueInTenYears() {
        return valueInTenYears;
    }

    public void setValueInTenYears(int valueInTenYears) {
        this.valueInTenYears = valueInTenYears;
    }

    public int getAmountInvested() {
        return amountInvested;
    }

    public void setAmountInvested(int amountInvested) {
        this.amountInvested = amountInvested;
    }
}
