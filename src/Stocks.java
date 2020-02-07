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

    public Stocks(){
        this.expected1YearReturn = 0;
        this.expected5YearReturn = 0;
        this.expected90DayReturn = 0;
    }

    public double getExpected5YearReturn() {
        return expected5YearReturn;
    }

    public void setExpected5YearReturn(double expected5YearReturn) {
        this.expected5YearReturn = expected5YearReturn;
    }

    public double getExpected1YearReturn() {
        return expected1YearReturn;
    }

    public void setExpected1YearReturn(double expected1YearReturn) {
        this.expected1YearReturn = expected1YearReturn;
    }

    public double getExpected90DayReturn() {
        return expected90DayReturn;
    }

    public void setExpected90DayReturn(double expected90DayReturn) {
        this.expected90DayReturn = expected90DayReturn;
    }

    @Override
    public String toString() {
        return "Stocks{" + getName()+" "+getID()+" "+
                "expected5YearReturn=" + expected5YearReturn +
                ", expected1YearReturn=" + expected1YearReturn +
                ", expected90DayReturn=" + expected90DayReturn +
                '}';
    }
}
