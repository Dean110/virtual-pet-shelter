package virtual_pet_shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VirtualPetShelter {
	private Map<String, VirtualPet> shelterPets = new HashMap<>();

	public void admit(VirtualPet pet) {
		this.shelterPets.put(pet.getName(), pet);
	}

	public VirtualPet findPet(String petName) {

		return this.shelterPets.get(petName);
	}

	public Collection<VirtualPet> pets() {

		return this.shelterPets.values();
	}

	public void adoptOut(String petName) {
		this.shelterPets.remove(petName);
	}

	public void feedPets() {
		for (Entry<String, VirtualPet> fedPet : shelterPets.entrySet()) {
			String key = fedPet.getKey();
			shelterPets.get(key).feedPet();
		}
	}

	public void waterPets() {
		for (Entry<String, VirtualPet> wateredPet : shelterPets.entrySet()) {
			String key = wateredPet.getKey();
			shelterPets.get(key).waterPet();
		}
	}

	public void playWithPet(String petName) {
		this.shelterPets.get(petName).playWithPet();
		
	}

	public void tick() {
		for (Entry<String, VirtualPet> wateredPet : shelterPets.entrySet()) {
			String key = wateredPet.getKey();
			shelterPets.get(key).tick();
		}
		
	}

}
