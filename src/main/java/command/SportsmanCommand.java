package command;

import conncetion.DataBaseException;
import dao.AbstractDAO;
import dao.SportsmanDAO;
import entity.Sportsman;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SportsmanCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws DataBaseException
    {
        Router router=new Router();
        router.setTarget(Page.SPORTSMEN.getPage());
        List<Sportsman> sportsmen;
        AbstractDAO dao=new SportsmanDAO();
        sportsmen=dao.find(1);
        dao.close();
        request.setAttribute(CommandConst.SPORTSMEN.getValue(), sportsmen);
        return router;
    }
}
