package dao;

import conncetion.DataBaseException;
import entity.Medal;
import entity.MedalEnum;
import entity.Sportsman;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedalDAO extends AbstractDAO<Medal>
{
    public MedalDAO() throws DataBaseException
    {
        super();
        query="select sportsmen.idSportsmen, " +
                "sportsmen.nameSp, " +
                "sportsmen.surnameSp, " +
                "medals.numberOG, " +
                "medals.eventOG, " +
                "medals.medal " +
                "from medals join sportsmen " +
                "on medals.idSportsmen=sportsmen.idSportsmen";
    }

    @Override
    public List<Medal> find(int indexFirst) throws DataBaseException
    {
        List<Medal> medals=new ArrayList<>();
        Statement statement=null;
        try
        {
            int indexLast=indexFirst+RANGE;
            query+=" where sportsmen.idSportsmen>="+indexFirst+" and sportsmen.idSportsmen<="+indexLast;
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while (rs.next())
            {
                Medal medal=new Medal();
                Sportsman sportsman=new Sportsman();
                int id=rs.getInt(1);
                sportsman.setId(id);
                String name=rs.getString(2);
                sportsman.setName(name);
                String surname=rs.getString(3);
                sportsman.setSurname(surname);
                medal.setSportsman(sportsman);
                int year=rs.getInt(4);
                medal.setYearOfGame(year);
                String event=rs.getString(5);
                medal.setEvent(event);
                MedalEnum medalEnum=MedalEnum.valueOf(rs.getString(6).toUpperCase());
                medal.setType(medalEnum);
                medals.add(medal);
            }
        }
        catch (SQLException e)
        {
            throw new DataBaseException("MedalDAO can't read data from database.");
        }
        finally
        {
            closeStatement(statement);
        }
        return medals;
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
