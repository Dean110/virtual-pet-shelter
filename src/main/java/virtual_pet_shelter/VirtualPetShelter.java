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

			fedPet.getValue().feedPet();
		}
	}

	public void waterPets() {
		for (Entry<String, VirtualPet> wateredPet : shelterPets.entrySet()) {
			wateredPet.getValue().waterPet();
		}
	}

	public void playWithPet(String petName) {
		this.shelterPets.get(petName).playWithPet();

	}

	public void tick() {
		for (Entry<String, VirtualPet> tickedPet : shelterPets.entrySet()) {
			String key = tickedPet.getKey();
			shelterPets.get(key).tick();
		}

	}

	public int getNumberOfPets() {

		return shelterPets.size();
	}

	public boolean isThereADeadPet() {
		boolean doWeHaveADeadPet = false;
		for (Entry<String, VirtualPet> checkedPet : shelterPets.entrySet()) {
			String key = checkedPet.getKey();
			if (shelterPets.get(key).getIsThisPetDead()) {
				doWeHaveADeadPet = true;
			}
		}
		return doWeHaveADeadPet;
	}

	public String displayStatus() {
		String statusOfPets = "";
		for (Entry<String, VirtualPet> eachPet : shelterPets.entrySet()) {

			statusOfPets += eachPet.getValue().returnStatus() + "\n";
		}

		return statusOfPets;
	}

	public String displayNamesAndDescriptions() {
		String namesAndDescriptions = "";
		for (Entry<String, VirtualPet> eachPet : shelterPets.entrySet()) {
			namesAndDescriptions += "[" + eachPet.getValue().getName() + "] " + eachPet.getValue().getDescription()
					+ "\n";
		}
		return namesAndDescriptions;
	}

}
