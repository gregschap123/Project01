package Project01;
import Project01.Nation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.*;
/**
* PlayGame.java is where the 
*/
public class PlayGame
{

    ArrayList<Nation> allLivingNations = new ArrayList<>();
    ArrayList<Project01.People> worldLivingPopulation = new ArrayList<>();
    Random generator;

    /**
    * This class will start the game and determine which nation will in the game. 
    */
    public PlayGame()
    {
        Date seed = new Date();
        generator = new Random(seed.getTime());
    }

    /**
    * Adding the total population of the world by counting each nation's population.
    * @param nations An Arraylist of nations in the world
	*/
    public void getWorldLivingPopulation(ArrayList<Nation> nations)
    {
        // add all living people to world list
        worldLivingPopulation.clear();
        //System.out.println(allLivingNations);
        for(int nation = 0; nation < nations.size(); nation++)
            //System.out.println(nations.get(nation));
            worldLivingPopulation.addAll(nations.get(nation).getNationPopulation());
        //System.out.println(worldLivingPopulation);
    }


    /**
    * Adding nations in the allLivingNations ArrayList if they are alive.
    * @param nations ArrayList of nations in the world.
    */
    public void getAllLivingNations(ArrayList<Nation> nations)
    {
        getWorldLivingPopulation(nations);
        allLivingNations.clear();
        for(int nation = 0; nation < nations.size(); nation++)
        {
            if(nations.get(nation).isNationAlive())
            {
                allLivingNations.add(nations.get(nation));
            }
        }
        //System.out.print(allLivingNations);
    }


    /**
    * This method takes a parameter of two people and checks if the two people are not from the same 
    * nation. Then the two people fight each other and both loses damage. It prints out a statement
    * of the life points of each other.
    * @param p1 A person from the People class
    * @param p2 A person from the People class
    */
    public void encounter(Project01.People p1, Project01.People p2)
    {
        // need to fix this to take strategies into account.
        if(p1.getNation() != p2.getNation())
        {
            System.out.print(p1 + " encounters " + p2);
            int p1Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            int p2Damage = (int) (generator.nextFloat() * generator.nextInt(20));
            p1.reduceLifePoints(p1Damage);
            p2.reduceLifePoints(p2Damage);

            System.out.println("\t\tp1 damage is " + p1Damage + ". p2 damage is " + p2Damage + ".");
        }
    }



    /**
    * This method calls getAllLivingNations with parameter and use a while loop to check if the arraylist 
    * is greater than 1 and index is less the size of worldLivingPopulation Arraylist
    * @param nations An Arraylist of nations
    * @return Boolean 
    */
    public Boolean playOneRound(ArrayList<Nation> nations)
    {
        getAllLivingNations(nations);
        int index = 0;
        while((allLivingNations.size() > 1) && (index < worldLivingPopulation.size()))
        {
            //encounter(worldLivingPopulation.get(pointers.get(index)), worldLivingPopulation.get(pointers.get(index+1)));
            //System.out.println((worldLivingPopulation.size()-1) + "\t" + limit + "\t" + index + "\t" + (index+1));
            int p1Index = generator.nextInt(worldLivingPopulation.size());
            int p2Index;
            do
                p2Index = generator.nextInt(worldLivingPopulation.size());
            while(p1Index == p2Index);
            encounter(worldLivingPopulation.get(p1Index), worldLivingPopulation.get(p2Index));
            getAllLivingNations(nations);
            if(allLivingNations.size() < 2)
                break;
            index = index + 1;
        }

        return (allLivingNations.size() < 2);


    }

    /**
    * @return a string of nation that won or no one
    */
    public String getWinner()
    {
        if (allLivingNations.size() == 0)
            return "No Winner!";
        else
            return allLivingNations.get(0).getNationName();
    }
}
