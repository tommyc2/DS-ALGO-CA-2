package model;
import utils.Utilities;
public class GamePort {
    private String gamePortDeveloper = "";
    private int releaseYear = 2023;
    private String coverArtImageURL = "";
    private OriginalGame gameBeingPorted;
    private GameMachine newMachine;

    public GamePort(GameMachine newMachine, OriginalGame gameBeingPorted, String gamePortDeveloper, int releaseYear, String coverArtImageURL) {
        setGamePortDeveloper(gamePortDeveloper);
        setReleaseYear(releaseYear);
        setCoverArtImageURL(coverArtImageURL);
        this.gameBeingPorted = gameBeingPorted;
        setGameMachine(newMachine);
    }

    private void setGameMachine(GameMachine newMachine) {
        this.newMachine = newMachine;
    }

    public OriginalGame getOriginalGame(){
        return gameBeingPorted;
    }

    public String getGamePortDeveloper() {
        return gamePortDeveloper;
    }

    public void setGamePortDeveloper(String gamePortDeveloper) {
        this.gamePortDeveloper = Utilities.truncateString(gamePortDeveloper,30);
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        /* Validation in driver */
        this.releaseYear = releaseYear;
    }

    public String getCoverArtImageURL() {
        return coverArtImageURL;
    }

    public void setCoverArtImageURL(String coverArtImageURL) {
        this.coverArtImageURL = Utilities.truncateString(coverArtImageURL,90);
    }

    @Override
    public String toString() {
        return "GamePort {" +
                "gamePortDeveloper = '" + gamePortDeveloper + '\'' +
                ", releaseYear = " + releaseYear +
                ", coverArtImageURL = '" + coverArtImageURL + '\'' +
                '}';
    }
}