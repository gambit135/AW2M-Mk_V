package aw2m.common.core;

import aw2m.remote.creator.maploader.MapCatalog;

/**
 *
 * @author Alejandro Téllez G. <java.util.fck@hotmail.com>
 */
public class GameInstance {

    /**
     * The player in turn
     */
    Player currentPlayer;
    byte currentPlayerID;
    /**
     * The number of players (i.e, colors available), as determined by map
     * conditions. By default, 2 players (1 and 2) will be assumed. A third
     * player (player 0) will act as GAIA, not taking turns but only existing to
     * solve property owning.
     */
    public byte numberOfPlayers;
    //Should be initialized before the map is loaded
    public Player players[];
    public byte weather;
    public byte currentWeather;
    public byte mapChosen;
    public GridCell[][] map;

    /**
     * GameInstance constructor should initialize players. Default constructor
     * sets Spann Island as map and initializes two players.
     */
    public GameInstance() {
        //Setting number of players on the map
        this.numberOfPlayers = MapCatalog.getNoOfPlayers(mapChosen);
        //Initializing players
        System.out.println("Initializing players");
        //+1 cause of GAIA
        this.players = new Player[numberOfPlayers + 1];
        for (byte c = 0; c < players.length; c++) {
            players[c] = Player.getGenericPlayer(c);
        }
        System.out.println("Number of total players: (including GAIA) " + players.length);
        mapChosen = MapCatalog.SPANN_ISLAND;

        /*
         //Loading a map
         MapLoader.loadMapFromCatalog(mapChosen);
         this.map = MapLoader.map;
         */
        //Debug


        //Player 1 is Human
        this.players[1].isHuman = true;

        //Map is ready to be played. Set first turn
        this.currentPlayer = players[1];
        this.currentPlayerID = 1;

        //Start playing
        //Game.play();
         
    }

    /**
     * The main method of this class will host the game dynamics.
     *
     * @param args
     */
    public void main(String args[]) {
    }

    void play() {
        do {
            //Request player to move, whether the player is human or AI.
            playerMove();

            //Change turn
            nextTurn();
        }
        while (true);
    }

    void nextTurn() {
        this.currentPlayerID++;
        if (currentPlayerID > this.numberOfPlayers) {
            this.currentPlayerID = 1;
        }
        this.currentPlayer = this.players[this.currentPlayerID];
    }

    void playerMove() {
        if (this.currentPlayer.isHuman) {
        }
        else {
        }
    }
}
