package dbConnection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DBConnectionHelperTest {
    private static Connection connection;

    @Test
    void getConnection() throws SQLException {
        connection = DBConnectionHelper.getConnection();
        assertTrue(connection.isValid(1));
        assertFalse(connection.isClosed());
    }

    @AfterAll
    static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}