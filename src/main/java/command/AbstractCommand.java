package command;

import conncetion.ConnectionException;
import dao.DAOException;
import exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand
{
    public abstract Router execute(HttpServletRequest request) throws ConnectionException,
                                                                        IncorrectDataException,
                                                                        DAOException;
}
