package servlet;

import command.*;
import conncetion.DataBaseException;
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
        catch (DataBaseException|IncorrectDataException e)
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
        catch (DataBaseException|IncorrectDataException e)
        {
            e.printStackTrace();
            //TODO добавить лог
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws DataBaseException,
                                                                                            IncorrectDataException,
                                                                                            IOException,
                                                                                            ServletException
    {
        //TODO поменять это
        AbstractCommand command;
        String buttonValue=request.getParameter(BUTTON);
        Router router=null;
        switch (buttonValue)
        {
            case "backward":
                break;
            case "forward":
                command=new ForwardCommand();
                router=command.execute(request);
                break;
            case "sportsmen":
                command=new SportsmanCommand();
                router=command.execute(request);
                break;
            case "medals":
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
