package dao;

import conncetion.ConnectionException;
import entity.Sportsman;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SportsmanDAO extends AbstractDAO<Sportsman>
{

    public SportsmanDAO() throws ConnectionException
    {
        super();
        query="select * from sportsmen";
        table="sportsmen";
    }

    @Override
    public List<Sportsman> find(int indexFirst) throws DAOException
    {
        List<Sportsman> sportsmen=new ArrayList<>();
        Statement statement=null;
        try
        {
            query+=" limit "+indexFirst+", "+SIZE_SAMPLE;
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next())
            {
                Sportsman sportsman=new Sportsman();
                int id=rs.getInt(1);
                sportsman.setId(id);
                String name=rs.getString(2);
                sportsman.setName(name);
                String surname=rs.getString(3);
                sportsman.setSurname(surname);
                String country=rs.getString(4);
                sportsman.setCountry(country);
                sportsmen.add(sportsman);
            }
        }
        catch (SQLException e)
        {
            throw new DAOException("SportsmanDAO can't read data from database.");
        }
        finally
        {
            closeStatement(statement);
        }
        return sportsmen;
    }

    @Override
    protected void closeStatement(Statement statement) {
        super.closeStatement(statement);
    }

    @Override
    public void close() {
        super.close();
    }
}
