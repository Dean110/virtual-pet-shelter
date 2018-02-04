package virtual_pet_shelter;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {
	private String name;
	private String description;
	private int hunger = ThreadLocalRandom.current().nextInt(20, 81);
	private int thirst = ThreadLocalRandom.current().nextInt(20, 81);
	private int boredom = ThreadLocalRandom.current().nextInt(20, 81);
	private boolean isThisPetDead = false;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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

	public boolean getIsThisPetDead() {
		return isThisPetDead;
	}

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;

	}

	public void feedPet() {
		this.hunger -= 10;
	}

	public void waterPet() {
		this.thirst -= 10;
	}

	public void playWithPet() {
		this.boredom -= 10;
	}

	public void tick() {
		this.hunger += 1;
		this.thirst += 1;
		this.boredom += 1;
		if (this.hunger > 100 || this.thirst > 100) {
			this.isThisPetDead = true;
		}
	}

	public String formatPetNameWithSpaces() {
		if (this.name.length() == 16) {
			return this.name;
		} else if (this.name.length() < 16) {
			while (this.name.length() < 16) {
				this.name += " ";
			}
		} else {
			this.name = this.name.substring(0, 16);
		}
		return this.name;
	}

	public String returnStatus() {
		return formatPetNameWithSpaces() + "|" + hunger + "\t|" + thirst + "\t|" + boredom;
	}

	@Override
	public String toString() {
		return name + "\t | " + description + "\t | " + hunger + " | " + thirst + " | " + boredom;
	}

}