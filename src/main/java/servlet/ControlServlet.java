package servlet;

import command.*;
import conncetion.ConnectionException;
import dao.DAOException;
import exception.IncorrectDataException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControlServlet", urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet
{
    private static final String BUTTON="button";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (ConnectionException | IncorrectDataException | DAOException e)
        {
            e.printStackTrace();
            //TODO добавить лог
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        }
        catch (ConnectionException | IncorrectDataException | DAOException e)
        {
            e.printStackTrace();
            //TODO добавить лог
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ConnectionException,
                                                                                            IncorrectDataException,
                                                                                            IOException,
                                                                                            ServletException,
                                                                                            DAOException
    {
        //TODO поменять это
        AbstractCommand command;
        String buttonValue=request.getParameter(BUTTON);
        CommandConst commandConst=CommandConst.getConst(buttonValue);
        Router router=null;
        switch (commandConst)
        {
            case BACKWARD:
                command=new BackwardCommand();
                router=command.execute(request);
                break;
            case FORWARD:
                command=new ForwardCommand();
                router=command.execute(request);
                break;
            case SPORTSMEN:
                command=new SportsmanCommand();
                router=command.execute(request);
                break;
            case MEDALS:
                command=new MedalCommand();
                router=command.execute(request);
                break;
        }
        if(router.getType()== Router.Type.FORWARD)
        {
            request.getRequestDispatcher(router.getTarget()).forward(request ,response);
        }
        else
        {
            response.sendRedirect(router.getTarget());
        }
    }
}
