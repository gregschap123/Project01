package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {
    /**
     * Add new nations to the game and play game.
     * Prints out the winning nation
     */
    public static void main(String[] args) {
        int gameLifePoints = 2000;
        ArrayList<Nation> nations = new ArrayList<>(); // nations create tribes create people
        PlayGame game = new PlayGame();

        // add Nations participating in the game to nations ArrayList.
        String[] nationNames = {"Smilons", "Naveed", "Perez", "Toyberg"};
        for(String name : nationNames){
            nations.add(new Nation(name, gameLifePoints / nationNames.length));
        }


        // 40 rounds max. If winner is reached before round 40, end program and declare winner.
        for(int i = 0 ; i < 40 ; i++){
            System.out.println("Round number: " + i);
            if(game.playOneRound(nations)){
                System.out.println("There is a winner!");
                break; // game over
            }
        }

        System.out.println("The winning nation is " + game.getWinner() + ".");

    }
}
