package tag;

import entity.Medal;
import entity.Sportsman;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

public final class MedalTableTag extends AbstractTableTag
{
    @Override
    public void setValue(List entities)
    {
        super.setValue(entities);
    }

    @Override
    public int doStartTag() throws JspException
    {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException
    {
        return super.doEndTag();
    }

    @Override
    protected void createHeader(JspWriter out) throws IOException
    {
        out.write("<th scope='col'>"+ TagConst.ID_SPORTSMEN.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.NAME.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.SURNAME.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.NUMBER_OG.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.EVENT_OG.getValue()+"</th>");
        out.write("<th scope='col'>"+ TagConst.MEDAL.getValue().toLowerCase()+"</th>");
    }

    @Override
    protected void writeData(JspWriter out, Object entity) throws IOException
    {
        Medal medal=(Medal)entity;
        Sportsman sportsman=medal.getSportsman();
        out.write("<th scope='col'>"+sportsman.getId()+"</th>");
        out.write("<th scope='col'>"+sportsman.getName()+"</th>");
        out.write("<th scope='col'>"+sportsman.getSurname()+"</th>");
        out.write("<th scope='col'>"+medal.getYearOfGame()+"</th>");
        out.write("<th scope='col'>"+medal.getEvent()+"</th>");
        out.write("<th scope='col'>"+medal.getType().name()+"</th>");
    }
}
