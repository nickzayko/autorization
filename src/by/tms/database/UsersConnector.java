package by.tms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UsersConnector {
    private static final String URL = "jdbc:mysql://localhost/users";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;



    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

