package aw2m.common.core;

import aw2m.common.serialize.Deserialize;
import aw2m.common.serialize.Serialize;
import aw2m.remote.creator.maploader.MapCatalog;
import aw2m.remote.creator.maploader.MapLoader;

/**
 * The main method of this class will host the mainGameInstance flow, with
 * players taking turns and actions within them.
 *
 * @author Alejandro Téllez G. <java.util.fck@hotmail.com>
 * @date 23/07/2013 - 08:21:44 PM
 */
public class GameFlow {

    static GameInstance mainGameInstance;

    /**
     *
     *
     * @param args
     */
    public static void main(String args[]) {
        //Game Started
        System.out.println("Gameflow starated");

        //First, an instance of GameInstance must be created
        System.out.println("Creating GameInstance");
        mainGameInstance = new GameInstance();
        //Players are initialized
        //A map must be loaded unto that mainGameInstance
        System.out.println("Loading map");

        MapLoader.loadMapFromCatalog(mainGameInstance, mainGameInstance.mapChosen);
        //game.map = MapLoader.map;

        //DEBUG
        System.out.println("Number of players on map: " + MapCatalog.getNoOfPlayers(mainGameInstance.mapChosen));


        //Testing Serialize
        Serialize s = new Serialize();

        //Testing serialize players
        System.out.println("Serialized players");
        System.out.println(s.serializePlayers(mainGameInstance));

        //Testing serialize terrain
        System.out.println("Serialized terrain");
        System.out.println(s.serializeTerrain(mainGameInstance));

        //Testing serialize properties
        System.out.println("Serialized properties");
        System.out.println(s.serializeProperties(mainGameInstance));

        //Testing serialize units
        Unit u1 = new Unit();
        u1.location = mainGameInstance.map[9][9];
        u1.unitType = Unit.ROCKETS;
        u1.player = mainGameInstance.players[1];
        u1.currentHP = 10;
        u1.currentFuel = Unit.getTotalFuel(u1.unitType);
        u1.currentAmmo = 4;
        mainGameInstance.players[1].units.add(u1);

        Unit u2 = new Unit();
        u2.location = mainGameInstance.map[8][4];
        u2.unitType = Unit.T_COPTER;
        u2.player = mainGameInstance.players[2];
        u2.currentHP = 2;
        u2.currentFuel = Unit.getTotalFuel(u2.unitType);
        u2.currentAmmo = Unit.getTotalAmmo(u2.unitType);
        mainGameInstance.players[2].units.add(u2);

        System.out.println("Serialized units");
        System.out.println(s.serializeUnits(mainGameInstance));

        //Testing deserialize
        Deserialize d = new Deserialize();

        //Testing deserealize players
        System.out.println("Deseralized players:");
        d.deserializePlayers(s.serializePlayers(mainGameInstance));

        //Testing deserealize terrain
        System.out.println("Deseralized terrain:");
        d.deserializeTerrain(s.serializeTerrain(mainGameInstance), MapCatalog.getXsize(mainGameInstance.mapChosen), MapCatalog.getYsize(mainGameInstance.mapChosen));

        //Testing deserealize properties
        System.out.println("Deseralized properties:");
        d.deserializeProperties(s.serializeProperties(mainGameInstance),
                                d.deserializeTerrain(
                s.serializeTerrain(mainGameInstance),
                MapCatalog.getXsize(mainGameInstance.mapChosen),
                MapCatalog.getYsize(mainGameInstance.mapChosen)),
                                d.deserializePlayers(
                s.serializePlayers(mainGameInstance)));

        //Testing deserealize units
        System.out.println("Deserealized units:");
        d.deserializeUnits(s.serializeUnits(mainGameInstance),
                           d.deserializeTerrain(
                s.serializeTerrain(mainGameInstance),
                MapCatalog.getXsize(mainGameInstance.mapChosen),
                MapCatalog.getYsize(mainGameInstance.mapChosen)),
                           d.deserializePlayers(
                s.serializePlayers(mainGameInstance)));

    }
}
