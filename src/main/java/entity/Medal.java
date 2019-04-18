package entity;

public class Medal
{
    private Sportsmen sportsmen;
    private int numberOfGame;
    private String event="";
    private MedalEnum type;

    public Sportsmen getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(Sportsmen sportsmen) {
        this.sportsmen = sportsmen;
    }

    public int getNumberOfGame() {
        return numberOfGame;
    }

    public void setNumberOfGame(int numberOfGame) {
        this.numberOfGame = numberOfGame;
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
}
