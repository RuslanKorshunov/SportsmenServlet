package dao;

import conncetion.DataBaseException;
import conncetion.MyConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<T>
{
    protected static final int RANGE=4;

    protected static String query;

    protected MyConnection connection;

    public AbstractDAO() throws DataBaseException
    {
        connection=new MyConnection();
    }

    public abstract List<T> find(int indexFirst) throws DataBaseException;

    protected void closeStatement(Statement statement)
    {
        if(statement!=null)
        {
            try
            {
                statement.close();
            }
            catch (SQLException e)
            {
                //TODO добавить лог
            }
        }
    }

    public void close()
    {
        try
        {
            connection.close();
        }
        catch (SQLException e)
        {
            //TODO добавить лог
        }
    }
}