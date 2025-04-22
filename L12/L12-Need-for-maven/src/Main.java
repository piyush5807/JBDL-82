import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        // jdbc - is a protocol (java database connectivity) which is used for interaction b/w java applications and relational databases

        /**
         * Connect to a mysql database and create a table
         *
         * 1. Connect to the mysql database which might be either running on my local host or it could be running somewhere in the cloud
         *
         */

        String url = "jdbc:mysql://127.0.0.1:3306/jbdl_test";
        Connection connection = DriverManager.getConnection(url, "root", "");
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE assignments(id int, name varchar(50))";
        boolean result = statement.execute(sql);

        System.out.println(result);

    }
}