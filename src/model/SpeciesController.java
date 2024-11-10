package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {

		this.species = new Species[80];

	}

	 /**
     * Registers a new flora species in the system.
     * @param name The name of the species.
     * @param scientificName The scientific name of the species.
     * @param type The type of the species (e.g., Flora).
     * @param hasFlowers Whether the species has flowers.
     * @param hasFruits Whether the species has fruits.
     * @param maxHeight The maximum height of the species.
     * @return true if the species was successfully registered; false otherwise.
     * Pre: The species array has an available slot.
     * Pos: A new Species object is added to the array if there's space.
     */
	public boolean registerSpecies(String name, String scientificName, SpeciesType type, boolean hasFlowers,
			boolean hasFruits, double maxHeight) {
				if (speciesExists(name)) {
					return false; 
				}
			

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Species(name, scientificName, type);
				return true;
			}

		}

		return false;

	}

	 /**
     * Registers a new fauna species in the system.
     * @param name The name of the species.
     * @param scientificName The scientific name of the species.
     * @param type The type of the species (e.g., Fauna).
     * @param isMigratory Whether the species is migratory.
     * @param maxWeight The maximum weight of the species.
     * @return true if the species was successfully registered; false otherwise.
     * Pre: The species array has an available slot.
     * Pos: A new Species object is added to the array if there's space.
     */
	public boolean registerSpecies(String name, String scientificName, SpeciesType type, boolean isMigratory,
			double maxWeight) {
				if (speciesExists(name)) {
					return false; 
				}
			

		for (int i = 0; i < species.length; i++) {
			if (species[i] == null) {
				species[i] = new Species(name, scientificName, type);
				return true;
			}

		}

		return false;
	}

	public boolean speciesExists(String name) {
		for (Species species : this.species) {
			if (species != null && species.getName().equalsIgnoreCase(name)) {
				return true; // the specie exists
			}
		}
		return false; // specie doesnt exist
	}

	 /**
     * Builds a list of all registered species names.
     * @return A formatted string containing the names of all registered species.
     * Pre: None.
     * Pos: Returns a non-empty string if species are registered, otherwise an empty string.
     */
	public String showSpeciesList() {

		String msg = "";

		for (int i = 0; (i < species.length); i++) {
			if (species[i] != null) {
				msg += "\n" + (i + 1) + ". " + species[i].getName();
			}
		}

		return msg;

	}

	/**
     * Builds a detailed list of all registered species with their scientific names.
     * @return A formatted string of all species names and their scientific names, or a message if none are registered.
     * Pre: None.
     * Pos: Returns a list of species or a message if no species are found.
     */
	public String buildSpeciesList() {

		String list = "";

		boolean validate = false;

		for (int i = 0; i < species.length; i++) {
			if (species[i] != null) {
				list += "\n" + species[i].getName() + " - " + species[i].getScientificName();
				validate = true;
			}
		}
		if (!validate) {
			list = "No hay cartas registradas";
		}
		return list;

	}

	 /**
     * Finds a species by its name.
     * @param speciesNameToEdit The name of the species to search for.
     * @return The Species object if found; null otherwise.
     * Pre: None.
     * Pos: Returns the species with the specified name, if it exists.
     */
	public Species findSpeciesByName(String speciesNameToEdit) {
		for (Species species : species) {
			if (species != null && species.getName().equalsIgnoreCase(speciesNameToEdit)) {
				return species;
			}
		}
		return null;
	}

	/**
     * Updates an existing species with new attributes.
     * @param updatedSpecies The Species object containing updated information.
     * Pre: Species with the same name exists in the array.
     * Pos: Species attributes are updated based on the provided Species object.
     */
	public void updateSpecies(Species updatedSpecies) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[i].getName().equalsIgnoreCase(updatedSpecies.getName())) {
				species[i].setScientificName(updatedSpecies.getScientificName());
				
				SpeciesType type = species[i].getType();
				
								if (type == SpeciesType.FLORA) {
					species[i].setHasFlowers(updatedSpecies.hasFlowers());
					species[i].setHasFruits(updatedSpecies.hasFruits());
					species[i].setMaxHeight(updatedSpecies.getMaxHeight());

				} else if (type == SpeciesType.FAUNA) {
					species[i].setMigratory(updatedSpecies.isMigratory());
					species[i].setMaxWeight(updatedSpecies.getMaxWeight());

				}
			}

			
			return; 
		}
	}

	
	
  /**
     * Removes a species from the system.
     * @param speciesToDelete The species to be removed.
     * @return true if the species was successfully removed; false otherwise.
     * Pre: Species exists in the array.
     * Pos: Species is removed if it exists.
     */
	public boolean removeSpecies(Species speciesToDelete) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[i].getName().equalsIgnoreCase(speciesToDelete.getName())) {
				species[i] = null; 
				return true; 
			}
		}
		return false; 
	}

}
