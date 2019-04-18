package tag;

import entity.Medal;
import entity.Sportsman;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

public final class MedalTableTag<T extends Medal> extends AbstractTableTag
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
        for(ConstEnum constEnum: ConstEnum.values())
        {
            switch (constEnum)
            {
                case ID_SPORTSMEN:
                case NAME:
                case SURNAME:
                case NUMBER_OG:
                case EVENT_OG:
                case MEDAL:
                    out.write("<th scope='col'>"+constEnum.getValue()+"</th>");
                    break;
            }
        }
    }

    @Override
    protected void writeData(JspWriter out, Object entity) throws IOException
    {
        Medal medal=(Medal)entity;
        Sportsman sportsman=medal.getSportsman();
        for(ConstEnum constEnum: ConstEnum.values())
        {
            switch (constEnum)
            {
                case ID_SPORTSMEN:
                    out.write("<th scope='col'>"+sportsman.getId()+"</th>");
                    break;
                case NAME:
                    out.write("<th scope='col'>"+sportsman.getName()+"</th>");
                    break;
                case SURNAME:
                    out.write("<th scope='col'>"+sportsman.getSurname()+"</th>");
                    break;
                case NUMBER_OG:
                    out.write("<th scope='col'>"+medal.getYearOfGame()+"</th>");
                    break;
                case EVENT_OG:
                    out.write("<th scope='col'>"+medal.getEvent()+"</th>");
                    break;
                case MEDAL:
                    out.write("<th scope='col'>"+medal.getType().name()+"</th>");
                    break;
            }
        }
    }
}
