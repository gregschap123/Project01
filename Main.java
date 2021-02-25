package Project01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import Project01.Nation;
import Project01.Tribe;
import Project01.PlayGame;


public class Main {
    /**
    * Starting point of the program where it adds new nations in the game and starts playing game.
    * Prints out the winning nation
    */
    public static void main(String[] args)
    {
       int gameLifePoints = 2000;
       ArrayList<Nation> nations = new ArrayList<>() ; // nations create tribes create people
       PlayGame game = new PlayGame();

  	   nations.add(new Nation("Idiots", (gameLifePoints / 6)));
  	   nations.add(new Nation("Minions", (gameLifePoints) / 6));
  	   nations.add(new Nation("Smilons", (gameLifePoints)/ 6));
  	   nations.add(new Nation("Naveed", (gameLifePoints) / 6));
  	   nations.add(new Nation("Perez", (gameLifePoints) / 6));
  	   nations.add(new Nation("Toyberg", (gameLifePoints) / 6));


  	   for(int i = 0; i < 40; i++)
         {
             System.out.println("Round number: " + i);
             if (game.playOneRound(nations))
             {
                 System.out.println("There is a winner!");
                 break; // game over
             }
         }

  	   System.out.println("The winning nation is " + game.getWinner() + ".");
    }
}
