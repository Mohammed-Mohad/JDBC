import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      String cont;
      do{
        
        System.out.println("***********MENU***********");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Get Employee");
        System.out.println("5. Get All Employees");
        System.out.println("6. Exit");
        System.out.println("**************************");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter Employee Type You Want TO Add: ");
                System.out.println("1. Commission Employee");
                System.out.println("2. Base Plus Commission Employee");
                System.out.println("3. Hourly Employee");
                System.out.println("4. Salaried Employee");
                System.out.println("5. Exit");
                System.out.println("**************************");
                System.out.println("Enter your choice: ");
                int choice1 = sc.nextInt();
                switch(choice1){
                    case 1:
                        System.out.println("Enter First Name: ");
                        String fName = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn = sc.nextInt();
                        System.out.println("Enter Gross Sales: ");
                        double grossSales = sc.nextDouble();
                        System.out.println("Enter Commission Rate: ");
                        double commissionRate = sc.nextDouble();
                        EmployeeDAO employee = new EmployeeDAO();
                        commissionEmp ce = new commissionEmp(fName, lName, ssn, grossSales, commissionRate);
                        commissionEmpDAO ced = new commissionEmpDAO();
                        employee.addEmployee(ce);
                        ced.addCommissionEmployee(ce);
                        break;
                    case 2:
                        System.out.println("Enter First Name: ");
                        String fName1 = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName1 = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn1 = sc.nextInt();
                        System.out.println("Enter Gross Sales: ");
                        double grossSales1 = sc.nextDouble();
                        System.out.println("Enter Base Salary: ");
                        double baseSalary = sc.nextDouble();
                        System.out.println("Enter Commission Rate: ");
                        double commissionRate1 = sc.nextDouble();
                        basePlusCommissionEmp bpce = new basePlusCommissionEmp(fName1, lName1, ssn1, grossSales1, baseSalary, commissionRate1);
                        EmployeeDAO ebpc = new EmployeeDAO();
                        ebpc.addEmployee(bpce);
                        commissionEmpDAO cebpc = new commissionEmpDAO();
                        cebpc.addCommissionEmployee(bpce);
                        basePlusCommissionDAO bpcd = new basePlusCommissionDAO();
                        bpcd.addBasePlusCommissionEmployee(bpce);
                        break;
                    case 3:
                        System.out.println("Enter First Name: ");
                        String fName2 = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName2 = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn2 = sc.nextInt();
                        System.out.println("Enter Wage: " );
                        double wage = sc.nextDouble();
                        System.out.println("Enter Hours: ");
                        double hours = sc.nextDouble();
                        hourlyEmp he = new hourlyEmp(fName2, lName2, ssn2, wage, hours);
                        EmployeeDAO ehe = new EmployeeDAO();
                        ehe.addEmployee(he);
                        hourlyEmpDAO hed = new hourlyEmpDAO();
                        hed.addHourlyEmployee(he);
                        break;
                    case 4:
                        System.out.println("Enter First Name: ");
                        String fName3 = sc.nextLine();
                        System.out.println("Enter Last Name: ");
                        String lName3 = sc.nextLine();
                        System.out.println("Enter SSN: ");
                        int ssn3 = sc.nextInt();
                        System.out.println("Enter Salary: ");
                        double salary = sc.nextDouble();
                        System.out.println("Enter Employee ID: ");
                        int empID = sc.nextInt();
                        salaryEmployee se = new salaryEmployee(fName3, lName3, ssn3, salary,empID);
                        EmployeeDAO ese = new EmployeeDAO();
                        ese.addEmployee(se);
                        salaryDAO sed = new salaryDAO();
                        sed.addSalaryEmployee(se);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                break;
            case 2:
                System.out.println("Enter Employee Type You Want to Update: ");
                System.out.println("1. Commission Employee");
                System.out.println("2. Base Plus Commission Employee");
                System.out.println("3. Hourly Employee");
                System.out.println("4. Salaried Employee");
                System.out.println("5. Exit");
                System.out.println("**************************");
                System.out.println("Enter your choice: ");
                int choice2 = sc.nextInt();
                switch(choice2){
                    case 1:
                        System.out.println("Enter First Name: ");
                        String fName = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn = sc.nextInt();
                        System.out.println("Enter Gross Sales: ");
                        double grossSales = sc.nextDouble();
                        System.out.println("Enter Commission Rate: ");
                        double commissionRate = sc.nextDouble();
                        commissionEmp ce = new commissionEmp(fName, lName, ssn, grossSales, commissionRate);
                        EmployeeDAO employee = new EmployeeDAO();
                        employee.updateEmployee(ce);
                        commissionEmpDAO ced = new commissionEmpDAO();
                        ced.updateCommissionEmployee(ce);
                        break;
                    case 2:
                        System.out.println("Enter First Name: ");
                        String fName1 = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName1 = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn1 = sc.nextInt();
                        System.out.println("Enter Gross Sales: ");
                        double grossSales1 = sc.nextDouble();
                        System.out.println("Enter Base Salary: ");
                        double baseSalary = sc.nextDouble();
                        System.out.println("Enter Commission Rate: ");
                        double commissionRate1 = sc.nextDouble();
                        basePlusCommissionEmp bpce = new basePlusCommissionEmp(fName1, lName1, ssn1, grossSales1, baseSalary, commissionRate1);
                        EmployeeDAO ebpc = new EmployeeDAO();
                        ebpc.updateEmployee(bpce);
                        commissionEmpDAO cebpc = new commissionEmpDAO();
                        cebpc.updateCommissionEmployee(bpce);
                        basePlusCommissionDAO bpcd = new basePlusCommissionDAO();
                        commissionEmpDAO ced1 = new commissionEmpDAO();
                        ced1.updateCommissionEmployee(bpce);
                        bpcd.updateBasePlusCommissionEmployee(bpce);
                        break;
                    case 3:
                        System.out.println("Enter First Name: ");
                        String fName2 = sc.next();
                        System.out.println("Enter Last Name: ");
                        String lName2 = sc.next();
                        System.out.println("Enter SSN: ");
                        int ssn2 = sc.nextInt();
                        System.out.println("Enter Wage: " );
                        double wage = sc.nextDouble();
                        System.out.println("Enter Hours: ");
                        double hours = sc.nextDouble();
                        hourlyEmp he = new hourlyEmp(fName2, lName2, ssn2, wage, hours);
                        EmployeeDAO ehe = new EmployeeDAO();
                        ehe.updateEmployee(he);
                        hourlyEmpDAO hed = new hourlyEmpDAO();
                        hed.updateHourlyEmployee(he);
                        break;
                    case 4:
                        System.out.println("Enter First Name: ");
                        String fName3 = sc.nextLine();
                        System.out.println("Enter Last Name: ");
                        String lName3 = sc.nextLine();
                        System.out.println("Enter SSN: ");
                        int ssn3 = sc.nextInt();
                        System.out.println("Enter Salary: ");
                        double salary = sc.nextDouble();
                        System.out.println("Enter Employee ID: ");
                        int empID4 = sc.nextInt();
                        salaryEmployee se = new salaryEmployee(fName3, lName3, ssn3, salary,empID4);
                        EmployeeDAO ese = new EmployeeDAO();
                        ese.updateEmployee(se);
                        salaryDAO sed = new salaryDAO();
                        sed.updateSalaryEmployee(se);
                        break;
                    case 5:
                        System.exit(0);
                        break;  
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
                break;
            case 3:
                System.out.println("Enter Employee Type You Want to Delete: ");
                System.out.println("1. Commission Employee");
                System.out.println("2. Base Plus Commission Employee");
                System.out.println("3. Hourly Employee");
                System.out.println("4. Salaried Employee");
                System.out.println("5. Exit");
                System.out.println("**************************");
                System.out.println("Enter your choice: ");
                int choice3 = sc.nextInt();
                switch(choice3){
                    case 1:
                        System.out.println("Enter Employee ID: ");
                        int empID = sc.nextInt();
                        EmployeeDAO employee = new EmployeeDAO();
                        employee.deleteEmployee(empID);
                        commissionEmpDAO ced = new commissionEmpDAO();
                        ced.deleteCommissionEmployee(empID);
                        break;
                    case 2:
                        System.out.println("Enter Employee ID: ");
                        int empID1 = sc.nextInt();
                        EmployeeDAO ebpc = new EmployeeDAO();
                        ebpc.deleteEmployee(empID1);
                        commissionEmpDAO cebpc = new commissionEmpDAO();
                        cebpc.deleteCommissionEmployee(empID1);
                        basePlusCommissionDAO bpcd = new basePlusCommissionDAO();
                        bpcd.deleteBasePlusCommissionEmployee(empID1);
                        break;
                    case 3:
                        System.out.println("Enter Employee ID: ");
                        int empID2 = sc.nextInt();
                        EmployeeDAO ehe = new EmployeeDAO();
                        ehe.deleteEmployee(empID2);
                        hourlyEmpDAO hed = new hourlyEmpDAO();
                        hed.deleteHourlyEmployee(empID2);
                        break;
                    case 4:
                        System.out.println("Enter Employee ID: ");
                        int empID3 = sc.nextInt();
                        EmployeeDAO ese = new EmployeeDAO();
                        ese.deleteEmployee(empID3);
                        salaryDAO sed = new salaryDAO();
                        sed.deleteSalaryEmployee(empID3);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                break;
            case 4:
                System.out.println("Enter Employee Type You Want to Get: ");
                System.out.println("1. Commission Employee");
                System.out.println("2. Base Plus Commission Employee");
                System.out.println("3. Hourly Employee");
                System.out.println("4. Salaried Employee");
                System.out.println("5. Exit");
                System.out.println("**************************");
                System.out.println("Enter your choice: ");
                int choice4 = sc.nextInt();
                switch(choice4){
                    case 1:
                        System.out.println("Enter Employee ID: ");
                        int empID = sc.nextInt();
                        commissionEmpDAO ced = new commissionEmpDAO();
                        ced.getCommissionEmployee(empID);
                        break;
                    case 2:
                        System.out.println("Enter Employee ID: ");
                        int empID1 = sc.nextInt();
                        basePlusCommissionDAO bpcd = new basePlusCommissionDAO();
                        bpcd.getBasePlusCommissionEmployee(empID1);
                        break;
                    case 3:
                        System.out.println("Enter Employee ID: ");
                        int empID2 = sc.nextInt();
                        hourlyEmpDAO hed = new hourlyEmpDAO();
                        hed.getHourlyEmployee(empID2);
                        break;
                    case 4:
                        System.out.println("Enter Employee ID: ");
                        int empID3 = sc.nextInt();
                        salaryDAO sed = new salaryDAO();
                        sed.getSalaryEmployee(empID3);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                break;
            case 5:
                System.out.println("Enter Employee Type You Want to Get All: ");
                System.out.println("1. Commission Employee");
                System.out.println("2. Base Plus Commission Employee");
                System.out.println("3. Hourly Employee");
                System.out.println("4. Salaried Employee");
                System.out.println("5. All Employees");
                System.out.println("6. Exit");
                System.out.println("**************************");
                System.out.println("Enter your choice: ");
                int choice5 = sc.nextInt();
                switch(choice5){
                    case 1:
                        commissionEmpDAO ced = new commissionEmpDAO();
                        ced.readCommissionEmployee();
                        break;
                    case 2:
                        basePlusCommissionDAO bpcd = new basePlusCommissionDAO();
                        bpcd.readBasePlusCommissionEmployee();
                        break;
                    case 3:
                        hourlyEmpDAO hed = new hourlyEmpDAO();
                        hed.readHourlyEmployee();
                        break;
                    case 4:
                        salaryDAO sed = new salaryDAO();
                        sed.readSalaryEmployee();
                        break;
                    case 5:
                        EmployeeDAO ed = new EmployeeDAO();
                        ed.readEmployee();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
    
                            
              }
              System.out.println("Do you want to continue? (Y/N)");
              cont = sc.next();
            }while(cont.equalsIgnoreCase("Y"));
      sc.close(); 
}
}
