package command;

import conncetion.ConnectionException;

import javax.servlet.http.HttpServletRequest;

public class BackwardCommand extends AbstractCommand
{
    @Override
    public Router execute(HttpServletRequest request) throws ConnectionException
    {
        return null;
    }
}
