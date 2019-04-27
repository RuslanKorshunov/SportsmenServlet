package command;

import conncetion.DataBaseException;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand
{
    public abstract Router execute(HttpServletRequest request) throws DataBaseException;
}
