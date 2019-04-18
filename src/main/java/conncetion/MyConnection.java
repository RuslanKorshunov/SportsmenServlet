package conncetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection
{
    private static final String URL="jdbc:mysql://localhost:3306/sportsmen";
    private static final String USER="root";
    private static final String PASSWORD="12345";
    private static MyConnection instance;
    private Connection connection;

    private MyConnection() throws SQLException
    {
        connection=DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection() throws SQLException
    {
        if(instance==null)
        {
            instance=new MyConnection();
        }
        return instance.connection;
    }
}
