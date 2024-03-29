package model;

import dataStructures.Hashing.HashTable;
import utils.Utilities;

public class
GameMachine {

    private String name;
    private String manufacturer;
    private String description;
    private String type;
    private String media;
    private int initialLaunchYear;
    private double price;
    private String URL;

    // Taking in game title as key
    private HashTable<String,OriginalGame> games = new HashTable<>(97); // prime number

    // Taking in game title
    private HashTable<String,GamePort> portedGames = new HashTable<>(97); // prime number

    public HashTable<String, OriginalGame> getGames() {
        return this.games;
    }

    public HashTable<String, GamePort> getPortedGames() {
        return this.portedGames;
    }

    public GameMachine(String name, String manufacturer, String description, String type, String media, int initialLaunchYear, double price, String URL) {
        setName(name);
        setManufacturer(manufacturer);
        setDescription(description);
        setType(type);
        setMedia(media);
        setInitialLaunchYear(initialLaunchYear);
        setPrice(price);
        setURL(URL);
    }

    public void sortGamesByYearReleasedAscending() {
        for (int start = 0; start < games.size() - 1; start++) {
            if (games.getByIndex(start)!=null)
            {
                int smallestIndex = start;

                for (int i = start + 1; i < games.size(); i++) {
                    if(games.getByIndex(i)!=null && games.getByIndex(smallestIndex)!=null)
                    {
                        if (games.getByIndex(i).getYearReleased() < games.getByIndex(smallestIndex).getYearReleased()) {
                            smallestIndex = i;
                        }
                    }
                }
                games.swapElements(start, smallestIndex);
            }
        }
    }

    public void sortPortedGamesByYearReleasedAscending() {
        for (int start = 0; start < portedGames.size() - 1; start++) {
            if (portedGames.getByIndex(start)!=null)
            {
                int smallestIndex = start;

                for (int i = start + 1; i < portedGames.size(); i++) {
                    if(portedGames.getByIndex(i)!=null && portedGames.getByIndex(smallestIndex)!=null)
                    {
                        if (portedGames.getByIndex(i).getReleaseYear() < portedGames.getByIndex(smallestIndex).getReleaseYear()) {
                            smallestIndex = i;
                        }
                    }
                }
                portedGames.swapElements(start, smallestIndex);
            }
        }
    }

    public void sortGamesByTitleAscending() {
        for (int start = 0; start < games.size() - 1; start++) {
            if (games.getByIndex(start)!=null)
            {
                int smallestIndex = start;

                for (int i = start + 1; i < games.size(); i++) {
                    if(games.getByIndex(i)!=null && games.getByIndex(smallestIndex)!=null)
                    {
                        if (games.getByIndex(i).getTitle().length() < games.getByIndex(smallestIndex).getTitle().length()) {
                            smallestIndex = i;
                        }
                    }
                }
                games.swapElements(start, smallestIndex);
            }
        }

    }

    public void sortPortedGamesByGameTitleAscending() {
        for (int start = 0; start < portedGames.size() - 1; start++) {
            if (portedGames.getByIndex(start)!=null)
            {
                int smallestIndex = start;

                for (int i = start + 1; i < portedGames.size(); i++) {
                    if(portedGames.getByIndex(i)!=null && portedGames.getByIndex(smallestIndex)!=null)
                    {
                        if (portedGames.getByIndex(i).getOriginalGame().getTitle().length() < portedGames.getByIndex(smallestIndex).getOriginalGame().getTitle().length()) {
                            smallestIndex = i;
                        }
                    }
                }
                portedGames.swapElements(start, smallestIndex);
            }
        }

    }


    public String listGamesInGameMachine(){
        String listOfGamesInMachine = games.listTableElements();
        if(listOfGamesInMachine.isEmpty()) return "No games in machine";
        return listOfGamesInMachine;
    }

    public void addGame(OriginalGame newGame) {
        String key = newGame.getTitle();
        games.add(key,newGame);
    }

    public boolean addGamePort(String gameTitle, GamePort gamePort) {
        if(games.size()>0){
            return portedGames.add(gameTitle,gamePort);
        }
        return false;
    }

    public boolean removeGame(int indexOfGame){
        return games.remove(indexOfGame);
    }

    public boolean removeGamePort(int indexOfGamePort) {
        return portedGames.remove(indexOfGamePort);
    }

    public boolean updateGame(OriginalGame updatedDetailsOfGame, int index){
        OriginalGame foundGame = games.getByIndex(index);

        if(foundGame!=null){
            foundGame.setDescription(updatedDetailsOfGame.getDescription());
            foundGame.setPublisher(updatedDetailsOfGame.getPublisher());
            foundGame.setTitle(updatedDetailsOfGame.getTitle());
            foundGame.setURL(updatedDetailsOfGame.getURL());
            foundGame.setYearReleased(updatedDetailsOfGame.getYearReleased());
            foundGame.setOrginalDeveloper(updatedDetailsOfGame.getOrginalDeveloper());
            return true;
        }
        return false;
    }

    public boolean updatePortedGame(GamePort updatedGamePort, int indexOfPortedGame) {
        GamePort foundPortedGame = portedGames.getByIndex(indexOfPortedGame);

        if(foundPortedGame!=null){
            foundPortedGame.setGamePortDeveloper(updatedGamePort.getGamePortDeveloper());
            foundPortedGame.setReleaseYear(updatedGamePort.getReleaseYear());
            foundPortedGame.setCoverArtImageURL(updatedGamePort.getCoverArtImageURL());
            foundPortedGame.setOriginalGame(updatedGamePort.getOriginalGame());
            return true;
        }
        return false;


    }

    public String listPortedGamesForMachine(){
        String listOfPortedGamesInMachine = portedGames.listTableElements();
        if(listOfPortedGamesInMachine.isEmpty()) return "No ported games in machine";
        return listOfPortedGamesInMachine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Utilities.validStringlength(name,20)){
        this.name = name;
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if (Utilities.validStringlength(manufacturer,20)){
        this.manufacturer = manufacturer;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (Utilities.validStringlength(description,150)){
        this.description = description;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (Utilities.validStringlength(type,20)) {
            this.type = type;
        }
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        if (Utilities.validStringlength(media,20)) {
            this.media = media;
        }
    }

    public int getInitialLaunchYear() {
        return initialLaunchYear;
    }

    public void setInitialLaunchYear(int initialLaunchYear) {
        if (initialLaunchYear >= 1950 && initialLaunchYear <= 2023) {
            this.initialLaunchYear = initialLaunchYear;
        } else {
            System.out.println("Invalid initial launch year");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
            if (price == 0) {
                System.out.println("Free");
            }
        } else {
            System.out.println("Invalid price"); //where the provided price is negative
        }
    }


    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        if (Utilities.validStringlength(URL,100)) {
            this.URL = URL;
        }
    }


    @Override
    public String toString() {
        return String.format("GameMachine{name='%s', manufacturer='%s', description='%s', type='%s', " +
                        "media='%s', initialLaunchYear=%d, price=%.2f, URL='%s'}",
                name, manufacturer, description, type, media, initialLaunchYear, price, URL);
    }

}
