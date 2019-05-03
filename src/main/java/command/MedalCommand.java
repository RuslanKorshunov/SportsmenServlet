package command;

import conncetion.ConnectionException;
import dao.AbstractDAO;
import dao.DAOException;
import dao.MedalDAO;
import entity.Medal;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MedalCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws ConnectionException, DAOException
    {
        Router router=new Router();
        router.setTarget(Page.MEDALS.getPage());
        AbstractDAO dao=new MedalDAO();
        int indexFirst=0;
        int page=1;
        List<Medal> medals=dao.find(indexFirst);
        dao.close();
        request.setAttribute(CommandConst.MEDALS.getValue(), medals);
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}