public class salaryEmployee extends emp{
    private double weeklySalary;
    private int weekly_employee_ID;
    public salaryEmployee() {
        super();
    }
    public salaryEmployee(String fName, String lName, int ssn, double weeklySalary,int weekly_employee_ID) {
        super(fName, lName, ssn);
        this.weeklySalary = weeklySalary;
        this.weekly_employee_ID = weekly_employee_ID;
    }
    public double earnings() {
        return weeklySalary;
    }
    public double getWeeklySalary() {
        return weeklySalary;
    }
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    public int getWeeklyEmployeeID() {
        return weekly_employee_ID;
    }
    public void setWeeklyEmployeeID(int weekly_employee_ID) {
        this.weekly_employee_ID = weekly_employee_ID;
    }
    public String toString() {
        return super.toString() + "\nWeekly Salary: " + weeklySalary + "\nWeekly Employee ID: " + weekly_employee_ID;
    }

}
