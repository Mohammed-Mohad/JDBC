import java.sql.*;

public class commissionEmpDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/myDataBase";
    private static final String USERNAME = "mexql";
    private static final String password = "mySqlPassword";

    public void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql =  "CREATE TABLE IF NOT EXISTS Commission_Employee (f_name VARCHAR(20),l_name VARCHAR(20),commission_employee_id INT PRIMARY KEY AUTO_INCREMENT,ssn INT ,grossSales DOUBLE,commissionRate DOUBLE,FOREIGN KEY(ssn) REFERENCES Employee(ssn));";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
    public void addCommissionEmployee(commissionEmp employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "INSERT INTO Commission_Employee (f_name, l_name, ssn, grossSales, commissionRate) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFName());
        stmt.setString(2, employee.getLName());
        stmt.setInt(3, employee.getSsn());
        stmt.setDouble(4, employee.getGrossSales());
        stmt.setDouble(5, employee.getCommissionRate());
        System.out.println(stmt);
        stmt.executeUpdate();
        System.out.println("Employee added successfully");
        stmt.close();
        conn.close();
    }

    public void readCommissionEmployee() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "SELECT * FROM Commission_Employee";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("First Name: " + rs.getString("f_name"));
            System.out.println("Last Name: " + rs.getString("l_name"));
            System.out.println("SSN: " + rs.getInt("ssn"));
            System.out.println("Gross Sales: " + rs.getDouble("grossSales"));
            System.out.println("Commission Rate: " + rs.getDouble("commissionRate"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void getCommissionEmployee(int ssn) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "SELECT * FROM Commission_Employee WHERE ssn = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ssn);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("First Name: " + rs.getString("f_name"));
            System.out.println("Last Name: " + rs.getString("l_name"));
            System.out.println("SSN: " + rs.getInt("ssn"));
            System.out.println("Gross Sales: " + rs.getDouble("grossSales"));
            System.out.println("Commission Rate: " + rs.getDouble("commissionRate"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public void updateCommissionEmployee(commissionEmp employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "UPDATE Commission_Employee SET f_name = ?, l_name = ?, grossSales = ?, commissionRate = ? WHERE ssn = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFName());
        stmt.setString(2, employee.getLName());
        stmt.setDouble(3, employee.getGrossSales());
        stmt.setDouble(4, employee.getCommissionRate());
        stmt.setInt(5, employee.getSsn());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deleteCommissionEmployee(int ssn) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "DELETE FROM Commission_Employee WHERE ssn = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, ssn);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
