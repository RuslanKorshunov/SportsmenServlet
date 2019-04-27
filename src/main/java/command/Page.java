package command;

public enum Page
{
    HEADER("jsp/header.jsp"),
    MAIN("jsp/main.jsp"),
    MEDALS("jsp/medals.jsp"),
    SPORTSMEN("jsp/sportsmen.jsp");

    private String page;

    Page(String page)
    {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
