package virtual_pet_shelter;

import java.util.concurrent.ThreadLocalRandom;

public class Pet {
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public int getHunger() {

		return hunger;
	}

	public int getThirst() {

		return thirst;
	}

	public int getBoredom() {

		return boredom;
	}

	public Pet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = ThreadLocalRandom.current().nextInt(10, 51);
		this.thirst = ThreadLocalRandom.current().nextInt(10, 51);
		this.boredom = ThreadLocalRandom.current().nextInt(10, 51);

	}

	public Pet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}


	public void feedPet() {
		this.hunger -= 10;
	}
	public void waterPet() {
		this.thirst -= 10;
	}
	public void playwith() {
		this.boredom -=10;	
	}
	@Override
	public String toString() {
		return name + " | " + description + " | " + hunger + " | " + thirst + " | " + boredom;
	}

	public void tick() {
		this.hunger += 1;
		this.thirst += 1;
		this.boredom += 1;
	}


}
