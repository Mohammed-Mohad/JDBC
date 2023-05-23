public class basePlusCommissionEmp extends commissionEmp {
    private double baseSalary;
    public basePlusCommissionEmp() {
        super();
    }
    public basePlusCommissionEmp(String fName, String lName, int ssn, double grossSales, double commissionRate, double baseSalary) {
        super(fName, lName, ssn, grossSales, commissionRate);
        this.baseSalary = baseSalary;
    }
    public double earnings() {
        return super.earnings() + baseSalary;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public String toString() {
        return super.toString() + "\nBase Salary: " + baseSalary;
    }
    
}
