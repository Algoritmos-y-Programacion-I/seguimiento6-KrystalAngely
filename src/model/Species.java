package model;

public class Species {

    private String name;
    private String scientificName;
    private SpeciesType type;

    // Flora tributes
    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    // fauna atributes
    private boolean isMigratory;
    private double maxWeight;

    /**
     * Constructor for Species. Initializes a species with a name, scientific name,
     * and type.
     * 
     * @param name           The common name of the species.
     * @param scientificName The scientific name of the species.
     * @param type           The type of the species (FLORA or FAUNA).
     *                       Pre: name, scientificName, and type are
     *                       non-null values.
     *                       Pos: A new Species instance is created.
     */
    public Species(String name, String scientificName, SpeciesType type) {
        this.name = name;
        this.scientificName = scientificName;
        this.type = type;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public SpeciesType getType() {
        return type;
    }

    public void setType(SpeciesType type) {
        this.type = type;
    }

    // flora
    public boolean hasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean hasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    // fauna
    public boolean isMigratory() {
        return isMigratory;
    }

    public void setMigratory(boolean isMigratory) {
        this.isMigratory = isMigratory;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
