public abstract class Asset {
    String name;
    String ID;
    int amountInvested;
    //int valueInTenYears;

    public Asset(String name, String ID, int amountInvested) {
        this.name = name;
        this.ID = ID;
        this.amountInvested = amountInvested;
    }

    abstract int expectedValueInTenYears();

}
