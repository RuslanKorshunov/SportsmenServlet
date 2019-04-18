package command;

import conncetion.DataBaseException;
import dao.AbstractDAO;
import dao.MedalDAO;
import entity.Medal;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MedalCommand extends AbstractCommand
{
    private static final String MEDALS="medals";

    @Override
    public void execute(HttpServletRequest request) throws DataBaseException
    {
        List<Medal> medals;
        AbstractDAO dao=new MedalDAO();
        medals=dao.find();
        medals.forEach(medal -> System.out.println(medal));
        request.setAttribute(MEDALS, medals);
    }
}
