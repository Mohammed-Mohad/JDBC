public class hourlyEmp extends emp{
    private double wage, hours;
    private int hourly_employee_ID;
    public hourlyEmp() {
        super();
    }
    public hourlyEmp(String fName, String lName, int ssn, double wage, double hours) {
        super(fName, lName, ssn);
        this.wage = wage;
        this.hours = hours;
    }
    public double earnings() {
        if (hours <= 40) {
            return wage * hours;
        } else {
            return (40 * wage) + ((hours - 40) * wage * 1.5);
        }
    }
    public int getHourlyEmployeeID() {
        return hourly_employee_ID;
    }
    public void setHourlyEmployeeID(int hourly_employee_ID) {
        this.hourly_employee_ID = hourly_employee_ID;
    }
    public double getWage() {
        return wage;
    }
    public double getHours() {
        return hours;
    }
    public void setWage(double wage) {
        this.wage = wage;
    }
    public void setHours(double hours) {
        this.hours = hours;
    }
    public String toString() {
        return super.toString() + "\nWage: " + wage + "\nHours: " + hours;
    }
    
}
