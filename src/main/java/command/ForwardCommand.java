package command;

import conncetion.DataBaseException;
import dao.AbstractDAO;
import dao.MedalDAO;
import entity.Medal;
import exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ForwardCommand extends AbstractCommand
{
    private static final int SIZE_SAMPLE=5;

    @Override
    public Router execute(HttpServletRequest request) throws DataBaseException, IncorrectDataException
    {
        Router router=new Router();
        String table=request.getParameter(CommandConst.TABLE.getValue());
        CommandConst commandConst=CommandConst.getConst(table);
        int page=Integer.parseInt(request.getParameter(CommandConst.PAGE.getValue()));
        AbstractDAO dao=null;
        switch (commandConst)
        {
            case MEDALS:
                dao=new MedalDAO();
                int indexFirst=page*SIZE_SAMPLE+1;
                List<Medal> medals=dao.find(indexFirst);
                request.setAttribute(CommandConst.MEDALS.getValue(), medals);
                router.setTarget(Page.MEDALS.getPage());
                break;
            case SPORTSMEN:
                break;
            default:
                throw new DataBaseException("Attribute table has invalid value.");
        }
        page++;
        request.setAttribute(CommandConst.PAGE.getValue(), page);
        return router;
    }
}
