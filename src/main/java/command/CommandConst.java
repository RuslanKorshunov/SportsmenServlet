package command;

import exception.IncorrectDataException;

public enum CommandConst
{
    BACKWARD("backward"),
    FORWARD("forward"),
    SPORTSMEN("sportsmen"),
    MEDALS("medals"),
    TABLE("table"),
    PAGE("page");

    private String value;

    CommandConst(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static CommandConst getConst(String command) throws IncorrectDataException
    {
        switch (command)
        {
            case "backward":
                return BACKWARD;
            case "forward":
                return FORWARD;
            case "sportsmen":
                return SPORTSMEN;
            case "medals":
                return MEDALS;
            case "table":
                return TABLE;
            case "page":
                return PAGE;
                default:
                    throw new IncorrectDataException("command has invalid value.");
        }
    }
}
