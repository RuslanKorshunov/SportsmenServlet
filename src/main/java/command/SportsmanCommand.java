package command;

import conncetion.DataBaseException;
import dao.AbstractDAO;
import dao.SportsmanDAO;
import entity.Sportsman;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SportsmanCommand extends AbstractCommand
{
    private static final String SPORTSMEN="sportsmen";

    @Override
    public void execute(HttpServletRequest request) throws DataBaseException
    {
        List<Sportsman> sportsmen;
        AbstractDAO dao=new SportsmanDAO();
        sportsmen=dao.find();
        dao.close();
        request.setAttribute(SPORTSMEN, sportsmen);
    }
}
