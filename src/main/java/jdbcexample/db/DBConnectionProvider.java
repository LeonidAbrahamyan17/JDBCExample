package jdbcexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private static DBConnectionProvider instance = new DBConnectionProvider();

    private  Connection connection;
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user?characterEncoding=utf8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private DBConnectionProvider() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static DBConnectionProvider getInstance() {
        return instance;
    }

    public Connection getConnection(){
        try {
            if (connection== null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL,
                        USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}