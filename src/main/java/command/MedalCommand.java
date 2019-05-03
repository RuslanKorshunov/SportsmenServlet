package command;

import conncetion.DataBaseException;
import dao.AbstractDAO;
import dao.MedalDAO;
import entity.Medal;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MedalCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws DataBaseException
    {
        Router router=new Router();
        router.setTarget(Page.MEDALS.getPage());
        AbstractDAO dao=new MedalDAO();
        int indexFirst=1;
        int page=1;
        List<Medal> medals=dao.find(indexFirst);
        dao.close();
        request.setAttribute(CommandConst.MEDALS.getValue(), medals);
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}