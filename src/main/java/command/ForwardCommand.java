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

public class ForwardCommand extends AbstractCommand
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
        int size=0;
        int indexFirst=0;
        switch (commandConst)
        {
            case MEDALS:
                dao=new MedalDAO();
                size=dao.getSize();
                indexFirst=page*SIZE_SAMPLE;
                if(indexFirst<size)
                {
                    indexFirst=page*SIZE_SAMPLE;
                    page++;
                }
                else
                {
                    indexFirst=(page-1)*SIZE_SAMPLE;
                }
                List<Medal> medals=dao.find(indexFirst);
                request.setAttribute(CommandConst.MEDALS.getValue(), medals);
                router.setTarget(Page.MEDALS.getPage());
                dao.close();
                break;
            case SPORTSMEN:
                dao=new SportsmanDAO();
                size=dao.getSize();
                indexFirst=page*SIZE_SAMPLE;
                if(indexFirst<size)
                {
                    indexFirst=page*SIZE_SAMPLE;
                    page++;
                }
                else
                {
                    indexFirst=(page-1)*SIZE_SAMPLE;
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
