public abstract class Asset {
    private String name;
    private String ID;

    int valueInTenYears;

    public Asset(String name, String ID) {
        this.name = name;
        this.ID = ID;

    }

    public Asset(){
        this.name = "";
        this.ID = "";

    }
    public int valueInTenYears(){
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

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getValueInTenYears() {
        return valueInTenYears;
    }

    public void setValueInTenYears(int valueInTenYears) {
        this.valueInTenYears = valueInTenYears;
    }
}
