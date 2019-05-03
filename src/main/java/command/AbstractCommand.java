package command;

import conncetion.ConnectionException;
import dao.DAOException;
import exception.IncorrectDataException;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCommand
{
    protected static final int SIZE_SAMPLE=5;

    public abstract Router execute(HttpServletRequest request) throws ConnectionException,
                                                                        IncorrectDataException,
                                                                        DAOException;
}
