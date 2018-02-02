package virtual_pet_shelter;

import java.util.HashMap;
import java.util.Map;

public class Shelter {
	private Map<String, Pet> shelterPets = new HashMap<>();

	public int amountOfPets() {

		return this.shelterPets.size();
	}

	public String getPetName(String name) {
		return shelterPets.get(name).getName();

	}

	public int getPetThirst(String name) {
		return shelterPets.get(name).getThirst();
	}

	public int getPetHunger(String name) {
		return shelterPets.get(name).getHunger();
	}

	public int getPetBoredom(String name) {

		return shelterPets.get(name).getBoredom();
	}

	public void admitNew(Pet newPet) {
		this.shelterPets.put(newPet.getName(), newPet);
	}

	public void adoptOutPet(String name) {
		this.shelterPets.remove(name);
	}

	public void feedAllPets() {
		for (String fedPet : shelterPets.keySet()) {
			shelterPets.get(fedPet).feedPet();
		}

	}

	public void waterAllPets() {
		for (String wateredPet : shelterPets.keySet()) {
			shelterPets.get(wateredPet).waterPet();
		}
	}

	public void playWithAPet(String name) {

		this.shelterPets.get(name).playwith();
	}

	public void tick() {
		for (String tickedPet : shelterPets.keySet()) {
			shelterPets.get(tickedPet).tick();

		}
	}

}
