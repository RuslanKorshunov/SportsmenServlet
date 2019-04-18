package entity;

public class Medal
{
    private Sportsman sportsman;
    private int yearOfGame;
    private String event="";
    private MedalEnum type;

    public Sportsman getSportsman() {
        return sportsman;
    }

    public void setSportsman(Sportsman sportsman) {
        this.sportsman = sportsman;
    }

    public int getYearOfGame() {
        return yearOfGame;
    }

    public void setYearOfGame(int yearOfGame) {
        this.yearOfGame = yearOfGame;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public MedalEnum getType() {
        return type;
    }

    public void setType(MedalEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "sportsman=" + sportsman +
                ", yearOfGame=" + yearOfGame +
                ", event='" + event + '\'' +
                ", type=" + type +
                '}';
    }
}
