package ui;

import java.util.Scanner;

import model.Species;
import model.SpeciesController;
import model.SpeciesType;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	 /**
     * Main method to initiate the SpeciesExecutable application.
     * It creates an instance of SpeciesExecutable and displays the main menu.
     * @param args Command-line arguments (not used).
     */
	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}
/**
     * Constructor for SpeciesExecutable. Initializes the scanner and species controller.
     * Pre: None.
     * Pos: reader and speciesController are initialized.
     */
	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	/**
     * Displays the main menu and allows user to select actions to register, edit, delete, or view species.
     * Pre: None.
     * Pos: Executes the selected option and performs the associated actions.
     */
	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. View Species list");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					registerSpecies();
					break;
				case 2:
					editSpecies();
					break;
				case 3:
					deleteSpecies();
					break;
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	 /**
     * Registers a new species by prompting user input for species details.
     * Pre: User provides valid input details.
     * Pos: A new species is registered if input is valid.
     */
	public void registerSpecies() {
		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("Choose the new Species' type: 1. Flora 2. Fauna");
		int typeOption = reader.nextInt();
		SpeciesType type = null;

		switch (typeOption) {
			case 1:
				type = SpeciesType.FLORA;
				break;
			case 2:
				type = SpeciesType.FAUNA;
				break;
			default:
				System.out.println("Invalid species type selected.");
				return;
		}

		if (type == SpeciesType.FLORA) {
			System.out.println("Does it have flowers? (true/false): ");
			boolean hasFlowers = reader.nextBoolean();
			System.out.println("Does it have fruits? (true/false): ");
			boolean hasFruits = reader.nextBoolean();
			System.out.println("What is the maximum height? ");
			double maxHeight = reader.nextDouble();

			if (speciesController.registerSpecies(name, scientificName, type, hasFlowers, hasFruits, maxHeight)) {
				System.out.println("Species registered successfully");
			} else {
				System.out.println("Error, Species couldn't be registered");
			}
		} else if (type == SpeciesType.FAUNA) {
			System.out.println("Is it migratory? (true/false): ");
			boolean isMigratory = reader.nextBoolean();
			System.out.println("What is the maximum weight? ");
			double maxWeight = reader.nextDouble();

			if (speciesController.registerSpecies(name, scientificName, type, isMigratory, maxWeight)) {
				System.out.println("Species registered successfully");
			} else {
				System.out.println("Error, Species couldn't be registered");
			}
		}
	}

	 /**
     * Edits an existing species by prompting user input for the species to edit and new details.
     * Pre: Species exists in the controller list.
     * Pos: Species details are updated based on user input.
     */
	public void editSpecies() {
		while (true) {
			
		
		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			reader.nextLine(); 
			String speciesNameToEdit = reader.nextLine();

			Species speciesToEdit = speciesController.findSpeciesByName(speciesNameToEdit);

			if (speciesToEdit != null) {
				System.out.println("Editing species: " + speciesToEdit.getName());

				// change name
				System.out.println("Enter the new name for the species (or press Enter to keep the same):");
				String newName = reader.nextLine();
				if (!newName.trim().isEmpty()) {
					speciesToEdit.setName(newName);
				}

				// change c name
				System.out.println("Enter the new scientific name for the species (or press Enter to keep the same):");
				String newScientificName = reader.nextLine();
				if (!newScientificName.trim().isEmpty()) {
					speciesToEdit.setScientificName(newScientificName);
				}

				if (speciesToEdit.getType() == SpeciesType.FLORA) {
					System.out.println("Edit the Flora attributes:");
					
					System.out.println("Does it have flowers? (true/false, or press Enter to keep the same): ");
					String hasFlowersInput = reader.nextLine();
					if (!hasFlowersInput.trim().isEmpty()) {
						boolean hasFlowers = Boolean.parseBoolean(hasFlowersInput);
						speciesToEdit.setHasFlowers(hasFlowers);
					}
	
					System.out.println("Does it have fruits? (true/false, or press Enter to keep the same): ");
					String hasFruitsInput = reader.nextLine();
					if (!hasFruitsInput.trim().isEmpty()) {
						boolean hasFruits = Boolean.parseBoolean(hasFruitsInput);
						speciesToEdit.setHasFruits(hasFruits);
					}
	
					System.out.println("What is the new maximum height? (or press Enter to keep the same): ");
					String maxHeightInput = reader.nextLine();
					if (!maxHeightInput.trim().isEmpty()) {
						double maxHeight = Double.parseDouble(maxHeightInput);
						speciesToEdit.setMaxHeight(maxHeight);
					}
				} else if (speciesToEdit.getType() == SpeciesType.FAUNA) {
					System.out.println("Edit the Fauna attributes:");
	
					System.out.println("Is it migratory? (true/false, or press Enter to keep the same): ");
					String isMigratoryInput = reader.nextLine();
					if (!isMigratoryInput.trim().isEmpty()) {
						boolean isMigratory = Boolean.parseBoolean(isMigratoryInput);
						speciesToEdit.setMigratory(isMigratory);
					}
	
					System.out.println("What is the new maximum weight? (or press Enter to keep the same): ");
					String maxWeightInput = reader.nextLine();
					if (!maxWeightInput.trim().isEmpty()) {
						double maxWeight = Double.parseDouble(maxWeightInput);
						speciesToEdit.setMaxWeight(maxWeight);
					}
				}
	

				speciesController.updateSpecies(speciesToEdit);
				System.out.println("Species edited successfully.");
				break;
			} else {
				System.out.println("The species was not found: " + speciesNameToEdit);
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}
}

	/**
     * Deletes an existing species based on user input.
     * Pre: Species exists in the controller list.
     * Pos: Species is removed if found.
     */
	public void deleteSpecies() {
		while (true) {
			
		
    System.out.println("Which Species do you want to delete?");

    String query = speciesController.showSpeciesList();

    if (!query.equals("")) {
        System.out.println(query);

        reader.nextLine(); // Clean buffer
        String speciesNameToDelete = reader.nextLine();

        
        Species speciesToDelete = speciesController.findSpeciesByName(speciesNameToDelete);

        if (speciesToDelete != null) {
            
            if (speciesController.removeSpecies(speciesToDelete)) {
                System.out.println("Species deleted successfully.");
				break;
            } else {
                System.out.println("Error deleting species: " + speciesNameToDelete);
            }
        } else {
            System.out.println("The species was not found: " + speciesNameToDelete);
        }
    } else {
        System.out.println("There aren't any species registered yet");
    }
}
	}

  /**
     * Displays the details of a specific species based on user input.
     * Pre: Species exists in the controller list.
     * Pos: Species details are shown if found.
     */
	public void showSpecies() {
		
		System.out.println("Which Species do you want to review? (write the name of the species)");
		String query = speciesController.showSpeciesList();

		if (!query.isEmpty()) {
			System.out.println(query);

			reader.nextLine(); // clean buffer
			String speciesNameToReview = reader.nextLine();
			Species speciesToShow = speciesController.findSpeciesByName(speciesNameToReview);

			if (speciesToShow != null) {
				System.out.println("Species Details:");
				System.out.println("Name: " + speciesToShow.getName() + "\n" + "Scientific Name: "
						+ speciesToShow.getScientificName() + "\n" + "Type: " + speciesToShow.getType());
						
				if (speciesToShow.getType() == SpeciesType.FLORA) {
					System.out.println("Has Flowers: " + speciesToShow.hasFlowers()+"\n"+"Has Fruits: " + speciesToShow.hasFruits()+"\n"+"Max Height: " + speciesToShow.getMaxHeight());
				} else if (speciesToShow.getType() == SpeciesType.FAUNA) {
					System.out.println("Is Migratory: " + speciesToShow.isMigratory()+"n"+"Max Weight: " + speciesToShow.getMaxWeight());
				}
			} else {
				System.out.println("The species was not found: " + speciesNameToReview);
			}
		} else {
			System.out.println("There aren't any species registered yet");
		}
	}
}