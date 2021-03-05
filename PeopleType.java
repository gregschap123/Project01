package Project01;

/**
 * Using enum this class represents
 * the different people located inside of a tribe.
 * Each person has a description of their role in the game.
 */
public enum PeopleType {
    warrior("Solder"),
    wizzard("Tricky"),
    healer("Medic");

    private String description;

    /**
     * @param types takes the current people type and sets the associated
     *              description along with that type.
     */
    PeopleType(String types) {
        description = types;
    }

    /**
     * @return the description of the people type.
     */
    public String getDescription() {
        return description;
    }
}
