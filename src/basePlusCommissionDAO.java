import java.sql.*;

public class basePlusCommissionDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/myDataBase";
    private static final String USERNAME = "mexql";
    private static final String password = "mySqlPassword";

    public void createTable() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql =  "CREATE TABLE IF NOT EXISTS Base_Plus_Commission_Employee (f_name VARCHAR(20),l_name VARCHAR(20),BasePlus_commission_employee_id INT PRIMARY KEY AUTO_INCREMENT,ssn INT ,grossSales DOUBLE,baseSalary DOUBLE,commissionRate DOUBLE,FOREIGN KEY(ssn) REFERENCES Commission_Employee(ssn));";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        con.close();

    }  
    public void addBasePlusCommissionEmployee(basePlusCommissionEmp employee) throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "INSERT INTO Base_Plus_Commission_Employee (f_name, l_name, ssn, grossSales, baseSalary, commissionRate) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, employee.getFName());
        stmt.setString(2, employee.getLName());
        stmt.setInt(3, employee.getSsn());
        stmt.setDouble(4, employee.getGrossSales());
        stmt.setDouble(5, employee.getBaseSalary());
        stmt.setDouble(6, employee.getCommissionRate());
        stmt.executeUpdate();
        System.out.println("Employee added successfully");
        stmt.close();
        con.close();
    }
    public void readBasePlusCommissionEmployee() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "SELECT * FROM Base_Plus_Commission_Employee";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("First Name: " + rs.getString("f_name"));
            System.out.println("Last Name: " + rs.getString("l_name"));
            System.out.println("SSN: " + rs.getInt("ssn"));
            System.out.println("Gross Sales: " + rs.getDouble("grossSales"));
            System.out.println("Base Salary: " + rs.getDouble("baseSalary"));
            System.out.println("Commission Rate: " + rs.getDouble("commissionRate"));
        }
        rs.close();
        stmt.close();
        con.close();
    }
    public void getBasePlusCommissionEmployee(int ssn) throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "SELECT * FROM Base_Plus_Commission_Employee WHERE ssn = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ssn);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("First Name: " + rs.getString("f_name"));
            System.out.println("Last Name: " + rs.getString("l_name"));
            System.out.println("SSN: " + rs.getInt("ssn"));
            System.out.println("Gross Sales: " + rs.getDouble("grossSales"));
            System.out.println("Base Salary: " + rs.getDouble("baseSalary"));
            System.out.println("Commission Rate: " + rs.getDouble("commissionRate"));
        }
        rs.close();
        stmt.close();
        con.close();
    }

    public void updateBasePlusCommissionEmployee(basePlusCommissionEmp employee) throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "UPDATE Base_Plus_Commission_Employee SET f_name=?, l_name=?, grossSales = ?, baseSalary = ?, commissionRate = ? WHERE ssn = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, employee.getFName());
        stmt.setString(2,employee.getLName());
        stmt.setDouble(3, employee.getGrossSales());
        stmt.setDouble(4, employee.getBaseSalary());
        stmt.setDouble(5, employee.getCommissionRate());
        stmt.setInt(6, employee.getSsn());
        stmt.executeUpdate();
        System.out.println("Employee updated successfully");
        stmt.close();

    }

    public void deleteBasePlusCommissionEmployee(int ssn) throws SQLException{
        Connection con = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "DELETE FROM Base_Plus_Commission_Employee WHERE ssn = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, ssn);
        stmt.executeUpdate();
        System.out.println("Employee deleted successfully");
        stmt.close();
        con.close();
    }
}
