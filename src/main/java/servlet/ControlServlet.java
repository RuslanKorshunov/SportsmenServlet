package servlet;

import command.AbstractCommand;
import command.MedalCommand;
import conncetion.DataBaseException;
import dao.MedalDAO;
import entity.Medal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        catch (DataBaseException e)
        {
            e.printStackTrace();
            //TODO добавить лог
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.doPost(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws DataBaseException,
                                                                                            IOException,
                                                                                            ServletException
    {
        String buttonValue=request.getParameter(BUTTON);
        switch (buttonValue)
        {
            case "sportsmen":
                break;
            case "medals":
                MedalCommand command=new MedalCommand();
                command.execute(request);
                request.getRequestDispatcher("jsp/medals.jsp").forward(request, response);
                break;
        }
    }
}
