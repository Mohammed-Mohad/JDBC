import java.sql.*;

public class hourlyEmpDAO {
    private static final String URL = "jdbc:mariadb://localhost:3306/myDataBase";
    private static final String USERNAME = "mexql";
    private static final String password = "mySqlPassword";

    public void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "CREATE TABLE IF NOT EXISTS Hourly_Employee (f_name VARCHAR(20),l_name VARCHAR(20),hourly_employee_id INT PRIMARY KEY,ssn INT ,wage DOUBLE,FOREIGN KEY(ssn) REFERENCES Employee(ssn));";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
      }
     
     public void addHourlyEmployee(hourlyEmp employee) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "INSERT INTO Hourly_Employee (f_name, l_name, hourly_employee_id, wage, ssn) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, employee.getFName());
        stmt.setString(2, employee.getLName());
        stmt.setInt(3, employee.getHourlyEmployeeID());
        stmt.setDouble(4, employee.getWage());
        stmt.setInt(5, employee.getSsn());
        System.out.println(stmt);
        stmt.executeUpdate();
        System.out.println("Employee added successfully");
        stmt.close();
        conn.close();
     } 
    
     public void readHourlyEmployee() throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USERNAME, password);
        String sql = "SELECT * FROM Hourly_Employee";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          System.out.println("First Name: " + rs.getString("f_name"));
          System.out.println("Last Name: " + rs.getString("l_name"));
          System.out.println("SSN: " + rs.getInt("ssn"));
          System.out.println("Wage: " + rs.getDouble("wage"));
        }
        rs.close();
        stmt.close();
        conn.close();
     }

        public void getHourlyEmployee(int ssn) throws SQLException {
            Connection conn = DriverManager.getConnection(URL, USERNAME, password);
            String sql = "SELECT * FROM Hourly_Employee WHERE ssn = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ssn);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            System.out.println("First Name: " + rs.getString("f_name"));
            System.out.println("Last Name: " + rs.getString("l_name"));
            System.out.println("SSN: " + rs.getInt("ssn"));
            System.out.println("Wage: " + rs.getDouble("wage"));
            }
            rs.close();
            stmt.close();
            conn.close();
        }

        public void updateHourlyEmployee(hourlyEmp employee) throws SQLException {
            Connection conn = DriverManager.getConnection(URL, USERNAME, password);
            String sql = "UPDATE Hourly_Employee SET f_name = ?, l_name = ?, wage = ? WHERE ssn = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employee.getFName());
            stmt.setString(2, employee.getLName());
            stmt.setDouble(3, employee.getWage());
            stmt.setInt(4, employee.getSsn());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }

        public void deleteHourlyEmployee(int ssn) throws SQLException {
            Connection conn = DriverManager.getConnection(URL, USERNAME, password);
            String sql = "DELETE FROM Hourly_Employee WHERE ssn = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ssn);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        
}
