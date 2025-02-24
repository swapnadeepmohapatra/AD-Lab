
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String jdbcUrl = "jdbc:postgresql://localhost:5432/swapnadeepmohapatra";
        String username = "postgres";
        String password = "password";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS employee (" + "eno SERIAL PRIMARY KEY, " + "ename VARCHAR(100) NOT NULL, " + "edesg VARCHAR(100) NOT NULL, " + "edob DATE NOT NULL, " + "esalary DECIMAL(10,2) NOT NULL)";
            statement.executeUpdate(createTableQuery);

            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM employee");
            rs.next();
            if (rs.getInt(1) == 0) {
                String insertQuery = "INSERT INTO employee (ename, edesg, edob, esalary) VALUES " + "('John Doe', 'Manager', '1985-07-12', 75000.00), " + "('Jane Smith', 'Developer', '1990-05-22', 60000.00), " + "('Mike Johnson', 'Analyst', '1992-10-10', 55000.00), " + "('Emily Davis', 'HR', '1988-03-25', 58000.00), " + "('Robert Brown', 'Clerk', '1995-09-18', 40000.00), " + "('Alice Green', 'Designer', '1987-11-30', 62000.00), " + "('David White', 'Sales', '1993-08-14', 50000.00), " + "('Sarah Wilson', 'Support', '1996-01-05', 45000.00), " + "('Daniel Lee', 'Admin', '1984-06-29', 70000.00), " + "('Laura Taylor', 'Executive', '1991-04-07', 64000.00)";
                statement.executeUpdate(insertQuery);
                System.out.println("Inserted 10 sample employee records.");
            }

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert Employee");
                System.out.println("2. Search Employee");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Display Employees (Ascending by Salary)");
                System.out.println("6. Display Employees (Descending by Salary)");
                System.out.println("7. Find Min Salary Employee");
                System.out.println("8. Find Max Salary Employee");
                System.out.println("9. Show all Employees");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Employee Name: ");
                        String ename = scanner.nextLine();
                        System.out.print("Enter Designation: ");
                        String edesg = scanner.nextLine();
                        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
                        String edob = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double esalary = scanner.nextDouble();

                        String insertSql = "INSERT INTO employee (ename, edesg, edob, esalary) VALUES (?, ?, ?, ?)";
                        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
                        insertStmt.setString(1, ename);
                        insertStmt.setString(2, edesg);
                        insertStmt.setDate(3, Date.valueOf(edob));
                        insertStmt.setDouble(4, esalary);
                        insertStmt.executeUpdate();
                        System.out.println("Employee inserted successfully.");
                        break;

                    case 2:
                        System.out.print("Enter Employee No (eno) to Search: ");
                        int searchEno = scanner.nextInt();
                        String searchSql = "SELECT * FROM employee WHERE eno = ?";
                        PreparedStatement searchStmt = connection.prepareStatement(searchSql);
                        searchStmt.setInt(1, searchEno);
                        ResultSet searchRs = searchStmt.executeQuery();
                        if (searchRs.next()) {
                            System.out.println("Employee Found: "
                                    + " Eno: " + searchRs.getInt("eno")
                                    + ", Name: " + searchRs.getString("ename")
                                    + ", Designation: " + searchRs.getString("edesg")
                                    + ", DOB: " + searchRs.getDate("edob")
                                    + ", Salary: " + searchRs.getDouble("esalary"));
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee No (eno) to Update Salary: ");
                        int updateEno = scanner.nextInt();
                        System.out.print("Enter New Salary: ");
                        double newSalary = scanner.nextDouble();
                        String updateSql = "UPDATE employee SET esalary = ? WHERE eno = ?";
                        PreparedStatement updateStmt = connection.prepareStatement(updateSql);
                        updateStmt.setDouble(1, newSalary);
                        updateStmt.setInt(2, updateEno);
                        int updated = updateStmt.executeUpdate();
                        if (updated > 0) {
                            System.out.println("Salary updated successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Employee No (eno) to Delete: ");
                        int deleteEno = scanner.nextInt();
                        String deleteSql = "DELETE FROM employee WHERE eno = ?";
                        PreparedStatement deleteStmt = connection.prepareStatement(deleteSql);
                        deleteStmt.setInt(1, deleteEno);
                        int deleted = deleteStmt.executeUpdate();
                        if (deleted > 0) {
                            System.out.println("Employee deleted successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }
                        break;

                    case 5:
                        displayEmployees(connection, "ASC");
                        break;

                    case 6:
                        displayEmployees(connection, "DESC");
                        break;

                    case 7:
                        findMinMaxSalary(connection, "MIN");
                        break;

                    case 8:
                        findMinMaxSalary(connection, "MAX");
                        break;

                    case 9:
                        displayAllEmployees(connection);
                        break;

                    case 10:
                        System.out.println("Exiting...");
                        scanner.close();
                        connection.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void displayAllEmployees(Connection connection) throws SQLException {
        String query = "SELECT * FROM employee";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Employee List:");
        while (rs.next()) {
            System.out.println("Eno: " + rs.getInt("eno")
                    + ", Name: " + rs.getString("ename")
                    + ", Designation: " + rs.getString("edesg")
                    + ", DOB: " + rs.getString("edob")
                    + ", Salary: " + rs.getDouble("esalary"));
        }
    }

    private static void displayEmployees(Connection connection, String order) throws SQLException {
        String query = "SELECT * FROM employee ORDER BY esalary " + order;
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Employee List (Ordered by Salary " + order + "):");
        while (rs.next()) {
            System.out.println("Eno: " + rs.getInt("eno")
                    + ", Name: " + rs.getString("ename")
                    + ", Salary: " + rs.getDouble("esalary"));
        }
    }

    private static void findMinMaxSalary(Connection connection, String type) throws SQLException {
        String query = "SELECT * FROM employee WHERE esalary = (SELECT " + type + "(esalary) FROM employee)";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println(type + " Salary Employee: "
                    + " Eno: " + rs.getInt("eno")
                    + ", Name: " + rs.getString("ename")
                    + ", Salary: " + rs.getDouble("esalary"));
        }
    }
}
