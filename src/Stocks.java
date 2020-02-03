public class Stocks extends Asset{
    private double expected5YearReturn;
    private double expected1YearReturn;
    private double expected90DayReturn;

    public Stocks(double expected5YearReturn, double expected1YearReturn, double expected90DayReturn, String name, String ID, int amountInvested) {
        super(name,ID,amountInvested);
        this.expected5YearReturn = expected5YearReturn;
        this.expected1YearReturn = expected1YearReturn;
        this.expected90DayReturn = expected90DayReturn;

    }

    public int expectedValueInTenYears(double expected90DayReturn, double expected1YearReturn, double expected5YearReturn){
        double valueIn10 = .06 * expected5YearReturn + .02*expected1YearReturn + .2 * expected90DayReturn;
        return (int)valueIn10;
    }
}
