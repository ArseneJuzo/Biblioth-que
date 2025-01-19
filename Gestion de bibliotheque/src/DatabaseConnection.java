import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    private static final String URL="jdbc:mysql://127.0.0.1:3306/bibliotheque";
    private static final String USER = "root";
    private static final String PASSWORD="";

    public static  Connection getConnection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }



}