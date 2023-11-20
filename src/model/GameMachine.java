package model;

import dataStructures.Hashing.HashTable;
import utils.Utilities;

public class GameMachine {
    private String name;
    private String manufacturer;
    private String description;
    private String type;
    private String media;
    private int initialLaunchYear;
    private double price;
    private String URL;

    private HashTable<Game> games = new HashTable<>(100);
    private HashTable<GamePort> gamePorts = new HashTable<>(100);

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

    //TODO - listGamesinMachine()
    public String listGamesInGameMachine(){
        return games.listTableElements();
    }

    //TODO
    public void addGame(Game newGame) {
     //   int key = Math.random()%games.
     //   games.add()
    }

    //TODO
    public String listGamePortsForMachine(){
        return gamePorts.listTableElements();
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
        return "GameMachine { " +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", media='" + media + '\'' +
                ", initialLaunchYear=" + initialLaunchYear +
                ", price=" + price +
                ", URL='" + URL + '\'' +
                '}';
    }
}
