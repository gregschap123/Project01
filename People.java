package Project01;

import Project01.PeopleType;

/**
 * People class:
 * This class is for:
 * - assigning and tracking the information of a person
 * (see Tribe class for example of it being used)
 * (their nation's name, tribe name, their description, and current life point value)
 * - tracking if a person is still alive
 *
 * the description comes from PeopleType, and is what class they are (Warrior, Healer, Wizard)
 *
 * Note that individual people are not named. The variable for it exists, but is never implemented.
 *
 * "encounterStrategy" has yet to be implemented, but has a description of what it should be doing.
 *
 */

public class People
{
    /**
     * Variable for personName exists, but is never used
     */
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    private String myDescription;
    private int myLifePoints;

    /**
     * Gets the details of a person (nation and tribe names, descriptions, and life points)
     *
     * @param nation
     * Stores the name of the nation
     * @param tribe
     * Stores the name of the tribe
     * @param person
     * Stores a single person
     * @param lifePoints
     * the person's current life point value
     *
     * myDescription uses the description value for person under the PeopleType class
     * (Warrior, Healer, Wizard)
     */

    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
    }

    /**
     *
     * @return
     * gets the person's class from PeopleType (Warrior, Healer, etc.)
     */
    public PeopleType getType()
    {
        return me;
    }

    /**
     *
     * @return
     * gets the tribe name
     */
    public String getTribe()
    {
        return myTribe;
    }

    /**
     *
     * @return
     * gets the nation name
     */
    public String getNation()
    {
        return myNation;
    }

    /**
     *
     * @return
     * checks if the person's current life point value is greater then 0
     */
    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     *
     * @return
     * gets current life point value
     */
    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * @param otherPerson
     * - not yet implemented
     * - Describes priorities on what should be occurring
     * - Groups come from a single tribe
     * - Groups can capture other groups, with lower life point values
     * - Captured opponents are less efficient (attack and heal for lower values)
     * - If they other person is from the same nation, then healers will heal normally
     */
    public void encounterStrategy(People otherPerson)
    {
        if(myNation == otherPerson.getNation())
        {
            // There will be an ugly confrontation
            // Groups attack groups. Group can be an individual or several individuals from any set of tribes
            // if a group has enough lifePoints it can capture its opponent and make it part of the group.
            // Captured opponents do not fight or heal very well. The healers can heal people from same nation
            // normally.
        }
        else
        {
            // there will be a peaceful confrontation
            // warriors - warrior ignore each other if different tribes increase life points
            // healer - healer ignore each other
            // healer - warrior - healer can heal warrior. Heals warrior from same tribe better
        }
    }


    /**
     * @param points
     * reduces a nation's current amount of life points by the value in the parameter
     */
    public void reduceLifePoints(int points)
    {
        myLifePoints = myLifePoints - points;
    }


    /**
     * @return
     * returns an overall profile of nation, including the nation name, the tribes, people, a description,
     * and the amount of life points left. Sort of like a "current status" for the nation.
     */
    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

