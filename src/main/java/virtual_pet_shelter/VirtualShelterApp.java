package virtual_pet_shelter;

import java.util.Scanner;

public class VirtualShelterApp {

	public static void main(String[] args) {
		VirtualPetShelter myShelter = new VirtualPetShelter();
		Scanner input = new Scanner(System.in);
		String mainMenuChoice;
		String dogChoice;
		// App Intro and default dog added
		System.out.println("Welcome to the Harding Hotel for Misfit Dogs!");
		System.out.println();
		System.out.println(
				"We currently have no dogs in the shelter, but fortunatly there is a traveling dog circus in town.\n"
						+ "I'm sure that means we will be able to acquire some misfit mutts from the streets when they leave.");
		System.out.println();
		System.out.println("A single dog walks down the street towards you, it has no collar.\n"
				+ "It stops and lefts it's leg up and pees on your boot. I think we have our first misfit dog!");
		System.out.println();
		System.out.println("After a fierce fight you finally bring the dog inside the shelter.\n"
				+ "You decide to name him Bruce Wee, and it appears that he likes to bite and fight!");

		myShelter.admit(new VirtualPet("Bruce Wee", "he likes to bite and fight!"));
		System.out.println("Bruce Wee is a " + myShelter.findPet("Bruce Wee").getDnaTrait() + " dog.");

		System.out.println();
		// Game Loop
		while (!myShelter.isThereADeadPet()) {
			if (myShelter.getNumberOfPets() < 1) {
				System.out.println("We are out of pets! Go find some more before we lose our grant money.");
				System.out.println();

			} else {
				if (myShelter.getNumberOfPets() == 1) {
					System.out.println("This is how your dog is doing:");
				} else {
					System.out.println("This is how your dogs are doing:");
				}
			}

			System.out.println();
			System.out.println("Name\t\t|Hunger\t|Thirst\t|Boredom");
			System.out.println("----------------|-------|-------|-------");
			System.out.println(myShelter.displayStatus());
			System.out.println();
			System.out.println("What would you like to do next?");
			System.out.println("-------------------------------");
			System.out.println("1. Feed all dogs.");
			System.out.println("2. Water all dogs.");
			System.out.println("3. Play with a dog.");
			System.out.println("4. Bring a dog in off the streets.");
			System.out.println("5. Send a dog to a new home.");
			System.out.println();
			mainMenuChoice = input.nextLine();

			switch (mainMenuChoice) {
			case "1": {
				myShelter.feedPets();
				break;
			}
			case "2": {
				myShelter.waterPets();
				break;
			}
			case "3": {
				System.out.println("Which dog would you like to play with?");
				System.out.println(myShelter.displayNamesAndDescriptions());
				dogChoice = input.nextLine();
				myShelter.playWithPet(dogChoice);
				break;
			}
			case "4": {
				System.out.println("You found another circus dog in the alley behind the shelter.");
				System.out.println("The dog looks at you and barks excitedly! What would you like to name this dog?");

				String nameChoice = input.nextLine();

				System.out.println(nameChoice + " barks in agreement to their new name.");
				System.out.println("What kind of behavior does he show?");

				String descriptionChoice = input.nextLine();

				myShelter.admit(new VirtualPet(nameChoice, descriptionChoice));

				System.out.println(nameChoice + " is a " + myShelter.findPet(nameChoice).getDnaTrait() + " dog.");
				break;
			}
			case "5": {
				System.out.println("A nice family shows up and wants a circus dog for their own!");
				System.out.println("Which dog would you like to let them take home?");
				System.out.println(myShelter.displayNamesAndDescriptions());
				dogChoice = input.nextLine();
				myShelter.adoptOut(dogChoice);

				System.out.println(dogChoice
						+ " barks at his new family, they look a little nervous in their car and they are on their way.");
				break;
			}
			default: {
				System.out.println("Huh?");
			}
			}
			myShelter.tick();
			for (int i = 0; i < 4; i++) {
				System.out.println();
			}
		}
		System.out.println("You didn't take care of your dogs and one of them passed away.\n"
				+ "The state has shut down your shelter and the dogs were set free to terrorize the streets once more.");

		input.close();
	}
}
