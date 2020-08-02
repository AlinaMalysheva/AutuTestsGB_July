package hw3;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;
import java.util.Date;
import java.util.Objects;

public class JDBCApp {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement insertNewStudentStatement;

   //public static void main(String[] args) {
JDBCApp(){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:lessJDBC.db");
            statement = connection.createStatement();
            performDropDB();
            performTableCreate();
            insertNewStudentStatement = connection.prepareStatement(
                    "INSERT INTO logs (text,fromWho,time) VALUES (?,?,?);");

        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
            e.printStackTrace();
        }catch (SQLException throwables){
            System.out.println("SQL Ex");
            throwables.printStackTrace();
        }
    }


    private static void performTableCreate() throws SQLException {
        statement.executeUpdate("CREATE TABLE logs (\n" +
                "    id      INTEGER PRIMARY KEY,\n" +
                "    text    TEXT,\n" +
                "    fromWho         NOT NULL,\n" +
                "    time    TEXT    NOT NULL\n" +
                ");\n");
    }

    private static void performDropDB() throws SQLException {
        statement.executeUpdate("DROP TABLE logs");
    }

    public static void readLogsFromDB() throws SQLException {
        //statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM logs");
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+
                    " | " +
                    resultSet.getString(2)+ " | " +
                    resultSet.getString(3)+ " | " +
                    resultSet.getString(4));
        }
    }

    public static void putDataInLogs(String text, String from, String time) throws  SQLException {
        insertNewStudentStatement.setString(1, text);
        insertNewStudentStatement.setString(2, from);
        insertNewStudentStatement.setString(3, time);
        insertNewStudentStatement.addBatch();
        insertNewStudentStatement.executeBatch();
        //readLogsFromDB();
    }

}
