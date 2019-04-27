package command;

import conncetion.DataBaseException;

import javax.servlet.http.HttpServletRequest;

public class BackwardCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws DataBaseException
    {
        return null;
    }
}
