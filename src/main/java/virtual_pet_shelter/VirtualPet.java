package virtual_pet_shelter;

public class VirtualPet {
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int boredom;

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

	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	@Override
	public String toString() {
		return name + " | " + description + " | " + hunger + " | " + thirst + " | " + boredom;
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
	}
}
