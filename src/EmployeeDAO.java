import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {

  private static final String URL = "jdbc:mariadb://localhost:3306/myDataBase";
  private static final String USERNAME = "mexql";
  private static final String password = "mySqlPassword";

  public void addEmployee(emp employee) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "INSERT INTO Employee (f_name, l_name, ssn) VALUES (?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, employee.getFName());
    stmt.setString(2, employee.getLName());
    stmt.setInt(3, employee.getSsn());
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

  public void readEmployee() throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "SELECT * FROM Employee";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      System.out.println("First Name: " + rs.getString("f_name"));
      System.out.println("Last Name: " + rs.getString("l_name"));
      System.out.println("SSN: " + rs.getInt("ssn"));
      System.out.println("Salary: " + rs.getDouble("salary"));
    }
    rs.close();
    stmt.close();
    conn.close();
  }

  public void getEmployee(int ssn) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "SELECT * FROM Employee WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, ssn);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      System.out.println("First Name: " + rs.getString("f_name"));
      System.out.println("Last Name: " + rs.getString("l_name"));
      System.out.println("SSN: " + rs.getInt("ssn"));
    }
    rs.close();
    stmt.close();
    conn.close();
  }

  public void updateEmployee(emp employee) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "UPDATE Employee SET f_name = ?, l_name = ? WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, employee.getFName());
    stmt.setString(2, employee.getLName());
    stmt.setInt(3, employee.getSsn());
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

  public void deleteEmployee(int ssn) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "DELETE FROM Employee WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, ssn);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }
}
