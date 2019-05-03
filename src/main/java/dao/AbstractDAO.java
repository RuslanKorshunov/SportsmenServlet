package dao;

import conncetion.ConnectionException;
import conncetion.MyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<T>
{
    protected static final int SIZE_SAMPLE=5;

    protected static String query;

    protected MyConnection connection;

    protected String table;

    public AbstractDAO() throws ConnectionException
    {
        connection=new MyConnection();
    }

    public abstract List<T> find(int indexFirst) throws DAOException;

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

    public int getSize() throws DAOException
    {
        return getSize(table);
    }

    private int getSize(String table) throws DAOException
    {
        int size=0;
        Statement statement=null;
        try
        {
            String query="select count(*) from "+table;
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next())
            {
                size=rs.getInt(1);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("DAO can't read data from database.");
        }
        finally
        {
            closeStatement(statement);
        }
        return size;
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