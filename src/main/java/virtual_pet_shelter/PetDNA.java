package virtual_pet_shelter;

public class PetDNA {

	private String trait;

	public PetDNA(String trait) {
		this.trait = trait;
	}

	public int getHungerMultiplier() {
		switch (trait) {
		case "hungry": {
			return 3;
		}
		default: {
			return 1;
		}
		}

	}

	public int getThirstMultiplier() {
		switch (trait) {
		case "thirsty": {
			return 3;
		}
		default: {
			return 1;
		}
		}
	}

	public int getBoredomMultiplier() {
		switch (trait) {
		case "restless": {
			return 3;
		}
		default: {
			return 1;
		}
		}
	}

	public String getTrait() {
		// TODO Auto-generated method stub
		return this.trait;
	}

}
