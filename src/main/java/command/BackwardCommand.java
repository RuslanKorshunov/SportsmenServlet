package command;

import conncetion.ConnectionException;
import dao.AbstractDAO;
import dao.DAOException;
import dao.MedalDAO;
import dao.SportsmanDAO;
import entity.Medal;
import entity.Sportsman;
import exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BackwardCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws ConnectionException,
                                                                IncorrectDataException,
                                                                DAOException
    {
        Router router=new Router();
        String table=request.getParameter(CommandConst.TABLE.getValue());
        CommandConst commandConst=CommandConst.getConst(table);
        int page=Integer.parseInt(request.getParameter(CommandConst.PAGE.getValue()));
        AbstractDAO dao;
        int indexFirst;
        switch (commandConst)
        {
            case MEDALS:
                dao=new MedalDAO();
                if(page==1)
                {
                    indexFirst=0;
                }
                else
                {
                    indexFirst=(page-2)*SIZE_SAMPLE;
                    page--;
                }
                List<Medal> medals=dao.find(indexFirst);
                request.setAttribute(CommandConst.MEDALS.getValue(), medals);
                router.setTarget(Page.MEDALS.getPage());
                dao.close();
                break;
            case SPORTSMEN:
                dao=new SportsmanDAO();
                if(page==1)
                {
                    indexFirst=0;
                }
                else
                {
                    indexFirst=(page-2)*SIZE_SAMPLE;
                    page--;
                }
                List<Sportsman> sportsmen=dao.find(indexFirst);
                request.setAttribute(CommandConst.SPORTSMEN.getValue(), sportsmen);
                router.setTarget(Page.SPORTSMEN.getPage());
                dao.close();
                break;
            default:
                throw new IncorrectDataException("Attribute table has invalid value.");
        }
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}
