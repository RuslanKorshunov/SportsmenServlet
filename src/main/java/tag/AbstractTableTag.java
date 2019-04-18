package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public abstract class AbstractTableTag<T> extends TagSupport
{
    protected List<T> entities;

    public void setValue(List<T> entities)//TODO переименовать метод и тег
    {
        this.entities=entities;
    }

    @Override
    public int doStartTag() throws JspException
    {
        try
        {
            JspWriter out=pageContext.getOut();

            out.write("<table border='1'><colgroup span='2' title='title' />");
            out.write("<caption>"+ "RESULT" +"</caption>");
            createHeader(out);
            out.write("</tr></thead>");

            out.write("<tbody>");
            for(T entity: entities)
            {
                out.write("<tr>");
                writeData(out, entity);
                out.write("<tr>");
            }
        }
        catch(IOException e)
        {
            //TODO добавить лог
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException
    {
        try
        {
            JspWriter out=pageContext.getOut();
            out.write("</tbody></table>");
        }
        catch (IOException e)
        {
            //TODO добавить лог
        }
        return EVAL_PAGE;
    }

    protected abstract void createHeader(JspWriter out) throws IOException;

    protected abstract void writeData(JspWriter out, T entity) throws IOException;
}