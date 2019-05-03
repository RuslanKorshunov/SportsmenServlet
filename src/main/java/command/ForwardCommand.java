package command;

import conncetion.ConnectionException;
import dao.AbstractDAO;
import dao.DAOException;
import dao.MedalDAO;
import entity.Medal;
import exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ForwardCommand extends AbstractCommand
{
    private static final int SIZE_SAMPLE=5;

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
        switch (commandConst)
        {
            case MEDALS:
                dao=new MedalDAO();
                int size=dao.getSize();
                int indexFirst=page*SIZE_SAMPLE;

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
                break;
            default:
                throw new IncorrectDataException("Attribute table has invalid value.");
        }
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}
