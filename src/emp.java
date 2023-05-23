public abstract class emp {
    private String fName, lName;
    private int ssn;
    public  emp() {
        
    }
    public emp(String fName, String lName, int ssn) {
        this.fName = fName;
        this.lName = lName;
        this.ssn = ssn;
    }
    public abstract double earnings();
    public String getFName() {
        return fName;
    }   
    public String getLName() {
        return lName;
    }
    public int getSsn() {
        return ssn;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }
    public String toString() {
        return "First Name: " + fName + "\nLast Name: " + lName + "\nSSN: " + ssn;
    }
}
