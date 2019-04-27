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
    private static final String PAGE="page";

    @Override
    public Router execute(HttpServletRequest request) throws DataBaseException
    {
        Router router=new Router();
        router.setTarget(Page.MEDALS.getPage());
        List<Medal> medals;
        AbstractDAO dao=new MedalDAO();
        int indexFirst=1;
        int page=1;
        medals=dao.find(indexFirst);
        dao.close();
        request.setAttribute(MEDALS, medals);
        request.setAttribute(PAGE, page);
        return router;
    }
}
