public class Stocks extends Asset{
    private double expected5YearReturn;
    private double expected1YearReturn;
    private double expected90DayReturn;

    public Stocks(String ID,String name,double expected5YearReturn, double expected1YearReturn, double expected90DayReturn) {
        super(name,ID);
        this.expected5YearReturn = expected5YearReturn;
        this.expected1YearReturn = expected1YearReturn;
        this.expected90DayReturn = expected90DayReturn;
    }

    public Stocks(String ID,String name, int AmountInvested, int profit){
        super(ID,name,AmountInvested,profit);
    }

    public Stocks(){
        this.expected1YearReturn = 0;
        this.expected5YearReturn = 0;
        this.expected90DayReturn = 0;
    }





    public int valueInTenYears(int amountInvested) {
        double expectedValue = amountInvested * (0.6 * expected5YearReturn + 0.2 * expected1YearReturn + 0.2 * expected1YearReturn) + amountInvested;
        return (int) expectedValue;
    }

    @Override
    public String toString() {
        return "Stocks{" + " "+getID()+" "+getAmountInvested()+" "+getProfit()+

                "}\n";
    }
}
