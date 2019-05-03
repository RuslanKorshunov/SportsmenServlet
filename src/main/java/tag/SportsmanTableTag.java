package tag;

import entity.Sportsman;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

public final class SportsmanTableTag extends AbstractTableTag
{
    @Override
    public void setValue(List entities) {
        super.setValue(entities);
    }

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        return super.doEndTag();
    }

    @Override
    protected void createHeader(JspWriter out) throws IOException
    {
        out.write("<th scope='col'>"+ TagConst.ID_SPORTSMEN.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.NAME.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.SURNAME.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.COUNTRY.getValue()+"</th>");
    }

    @Override
    protected void writeData(JspWriter out, Object entity) throws IOException
    {
        Sportsman sportsman=(Sportsman)entity;
        out.write("<th scope='col'>"+sportsman.getId()+"</th>");
        out.write("<th scope='col'>"+sportsman.getName()+"</th>");
        out.write("<th scope='col'>"+sportsman.getSurname()+"</th>");
        out.write("<th scope='col'>"+sportsman.getCountry()+"</th>");
    }
}
