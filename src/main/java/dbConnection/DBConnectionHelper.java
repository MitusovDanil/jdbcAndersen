package dbConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionHelper {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
                Properties properties = new Properties();
                properties.load(resourceAsStream);

                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

                Class.forName(driver);

                connection = DriverManager.getConnection(url, user, password);

            } catch (ClassNotFoundException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }

}

