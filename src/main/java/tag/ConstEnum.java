package tag;

public enum ConstEnum
{
    ID_SPORTSMEN("ID"),
    NUMBER_OG("Number of OG"),
    EVENT_OG("Event"),
    MEDAL("Medal"),
    NAME("Name"),
    SURNAME("Surname"),
    COUNTRY("Country");

    private String value;

    ConstEnum(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
