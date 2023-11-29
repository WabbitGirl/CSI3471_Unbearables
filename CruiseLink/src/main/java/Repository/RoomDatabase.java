package Repository;

import Domain.Guest;
import Domain.Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RoomDatabase {
    public Map<Guest, ArrayList<Reservation>> roomMap;

    public RoomDatabase(){
        roomMap = new HashMap<>();
    }

    // Begin Kyle Hoang's implementation of Apache Derby Reservation Database
    /**
     * Author: Kyle Hoang
     * Created on: 11/01/2023
     *
     * This class provides methods for creating and deleting a database table for Rooms.
     * It also includes a method for obtaining a connection to the database.
     *
     * The reservation table, named "ROOM," stores details such as room number, smoking status, bed type,
     * number of beds, reservation status, and quality level.
     *
     * Methods:
     * - {@link #createRoomDatabase() createRoomDatabase}
     * - {@link #deleteRoomDatabase() deleteRoomDatabase}
     */

    private static  String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static  String DB_CONNECTION = "jdbc:derby:ex1connect;create=true"; //"jdbc:derby:ex1connect;";
    private static  String DB_USER = "";
    private static  String DB_PASSWORD = "";

/*    public static void main(String[] argv) {
    try {
        createReservationDatabase();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}*/

    /**
     * @author Kyle Hoang
     *
     * This function creates a new database table ROOM for the Rooms
     * @throws SQLException if a SQL exception occurs during the database operations.
     */
    public  void createRoomDatabase() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE ROOM(" + "ROOM_NUM INTEGER NOT NULL VARCHAR(20), " +
                "IS_SMOKING SMALLINT NOT NULL, " + "BED_TYPE VARCHAR(20) NOT NULL, " + "NUM_BEDS INTEGER NOT NULL, " +
                "IS_RESERVED SMALLINT NOT NULL, " + "QUALITY_LVL VARCHAR(20) NOT NULL, "
                + "CONSTRAINT primary_key PRIMARY KEY (ROOM_NUM) " + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(createTableSQL);
            // Execute SQL statement to create the table
            statement.execute(createTableSQL);
            System.out.println("Table \"ROOM\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This method deletes the ROOM database
     */
    public void deleteRoomDatabase() {
        Connection dbConnection = null;
        Statement statement = null;
        String deleteTableSQL = "DROP TABLE ROOM";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            System.out.println(deleteTableSQL);
            // Execute SQL statement to drop the table
            statement.execute(deleteTableSQL);
            System.out.println("Table \"ROOM\" is dropped!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }

            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }

    /**
     * @author Kyle Hoang
     * This function gets the connection to the database
     * @return Connection used to connect to the ROOM database
     */
    public Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
