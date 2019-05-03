package tag;

public enum TagConst
{
    ID_SPORTSMEN("ID"),
    NUMBER_OG("Number of OG"),
    EVENT_OG("Event"),
    MEDAL("Medal"),
    NAME("Name"),
    SURNAME("Surname"),
    COUNTRY("Country");

    private String value;

    TagConst(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
