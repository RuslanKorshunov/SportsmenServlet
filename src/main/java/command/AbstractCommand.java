package command;

import conncetion.DataBaseException;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand
{
    public abstract void execute(HttpServletRequest request) throws DataBaseException;
}
