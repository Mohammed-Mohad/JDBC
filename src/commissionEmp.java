public class commissionEmp extends emp {
    private double grossSales, commissionRate;
    public commissionEmp() {
        super();
    }
    public commissionEmp(String fName, String lName, int ssn, double grossSales, double commissionRate) {
        super(fName, lName, ssn);
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }
    public double earnings() {
        return grossSales * commissionRate;
    }
    public double getGrossSales() {
        return grossSales;
    }
    public double getCommissionRate() {
        return commissionRate;
    }
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }
    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    public String toString() {
        return super.toString() + "\nGross Sales: " + grossSales + "\nCommission Rate: " + commissionRate;
    }
    
}
