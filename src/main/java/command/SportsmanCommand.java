package command;

import conncetion.ConnectionException;
import dao.AbstractDAO;
import dao.DAOException;
import dao.SportsmanDAO;
import entity.Sportsman;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SportsmanCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws ConnectionException, DAOException
    {
        Router router=new Router();
        router.setTarget(Page.SPORTSMEN.getPage());
        AbstractDAO dao=new SportsmanDAO();
        int indexFirst=0;
        int page=1;
        List<Sportsman> sportsmen=dao.find(indexFirst);
        dao.close();
        request.setAttribute(CommandConst.SPORTSMEN.getValue(), sportsmen);
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}
