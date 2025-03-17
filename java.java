import java.sql.*;

public class java {
    public static void main(String[] args) {
        String userInput = args[0]; // User input (vulnerable to injection)
        String dbUrl = "jdbc:mysql://localhost:3306/mydb";
        String dbUser = "root";
        String dbPassword = "password";

        // SQL Injection vulnerability
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Command Injection vulnerability
        try {
            Runtime.getRuntime().exec("echo " + userInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}