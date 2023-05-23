import java.sql.*;

public class salaryDAO {

  private static final String URL = "jdbc:mariadb://localhost:3306/myDataBase";
  private static final String USERNAME = "mexql";
  private static final String password = "mySqlPassword";

public void createTable() throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "CREATE TABLE IF NOT EXISTS Salary_Employee (f_name VARCHAR(255),l_name VARCHAR(255),weekly_employee_id INT PRIMARY KEY,ssn INT ,salary DOUBLE,FOREIGN KEY(ssn) REFERENCES Employee(ssn));";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

  public void addSalaryEmployee(salaryEmployee employee) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "INSERT INTO Salary_Employee (f_name, l_name, weekly_employee_id, salary, ssn) VALUES (?, ?, ?, ?, ?);";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, employee.getFName());
    stmt.setString(2, employee.getLName());
    stmt.setInt(3, employee.getWeeklyEmployeeID());
    stmt.setDouble(4, employee.getWeeklySalary());
    stmt.setInt(5, employee.getSsn());
    System.out.println(stmt);
    stmt.executeUpdate();
    System.out.println("Employee added successfully");
    stmt.close();
    conn.close();
}


  public void readSalaryEmployee() throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "SELECT * FROM Salary_Employee";
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

  public void getSalaryEmployee(int ssn) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "SELECT * FROM Salary_Employee WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, ssn);
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

  public void updateSalaryEmployee(salaryEmployee employee) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "UPDATE Salary_Employee SET f_name = ?, l_name = ?, salary = ? WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, employee.getFName());
    stmt.setString(2, employee.getLName());
    stmt.setDouble(3, employee.getWeeklySalary());
    stmt.setInt(4, employee.getSsn());
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }
  public void deleteSalaryEmployee(int ssn) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USERNAME, password);
    String sql = "DELETE FROM Salary_Employee WHERE ssn = ?";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, ssn);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
  }

}
