public abstract class Asset {
    private String name;
    private String ID;
    protected int amountInvested;
    //int valueInTenYears;

    public Asset(String name, String ID, int amountInvested) {
        this.name = name;
        this.ID = ID;
        this.amountInvested = amountInvested;
    }

    public Asset(){
        this.name = "";
        this.ID = "";
        this.amountInvested = 0;
    }

}
