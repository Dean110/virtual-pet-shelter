package virtual_pet_shelter;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	final static String PET_NAME = "Foo";
	final static String PET_DESCRIPTION = "Bar";
	final static int PET_HUNGER = 50;
	final static int PET_THIRST = 50;
	final static int PET_BOREDOM = 50;
	private VirtualPetShelter underTest;
	private VirtualPet testPet;

	@Before
	public void setup() {
		// Arrange
		underTest = new VirtualPetShelter();
		testPet = new VirtualPet(PET_NAME, PET_DESCRIPTION, PET_HUNGER, PET_THIRST, PET_BOREDOM);
	}

	@Test
	public void shouldAdmitPet() {
		underTest.admit(testPet);
		VirtualPet retrieved = underTest.findPet(PET_NAME);
		assertThat(retrieved, is(testPet));
	}

	@Test
	public void shouldAdmitMultiplePets() {
		// Arrange
		String anotherPetName = "Bruce";
		VirtualPet anotherTestPet = new VirtualPet(anotherPetName, PET_DESCRIPTION, PET_HUNGER, PET_THIRST,
				PET_BOREDOM);
		// Act
		underTest.admit(testPet);
		underTest.admit(anotherTestPet);
		// Assert
		Collection<VirtualPet> pets = underTest.pets();
		assertThat(pets, containsInAnyOrder(testPet, anotherTestPet));
	}

	@Test
	public void shouldAdoptPetOutOfShelter() {
		// arrange
		underTest.admit(testPet);
		;

		// act
		underTest.adoptOut(PET_NAME);

		// assert
		VirtualPet found = underTest.findPet(PET_NAME);
		assertThat(found, is(nullValue()));
	}

	@Test
	public void shouldFeedAllPetsInShelter() {
		// Arrange
		String anotherPetName = "Bruce";
		VirtualPet anotherTestPet = new VirtualPet(anotherPetName, PET_DESCRIPTION, PET_HUNGER, PET_THIRST,
				PET_BOREDOM);
		// Act
		underTest.admit(testPet);
		underTest.admit(anotherTestPet);
		underTest.feedPets();

		// Assert
		int petHunger = underTest.findPet(PET_NAME).getHunger();
		int anotherPetHunger = underTest.findPet(anotherPetName).getHunger();
		assertThat(petHunger, is(40));
		assertThat(anotherPetHunger, is(40));
	}

	@Test
	public void shouldWaterAllPetsInShelter() {
		// Arrange
		String anotherPetName = "Bruce";
		VirtualPet anotherTestPet = new VirtualPet(anotherPetName, PET_DESCRIPTION, PET_HUNGER, PET_THIRST,
				PET_BOREDOM);
		// Act
		underTest.admit(testPet);
		underTest.admit(anotherTestPet);
		underTest.waterPets();

		// Assert
		int petThirst = underTest.findPet(PET_NAME).getThirst();
		int anotherPetThirst = underTest.findPet(anotherPetName).getThirst();
		assertThat(petThirst, is(40));
		assertThat(anotherPetThirst, is(40));
	}

	@Test
	public void shouldPlayWithOnePet() {
		// Arrange
		String anotherPetName = "Bruce";
		VirtualPet anotherTestPet = new VirtualPet(anotherPetName, PET_DESCRIPTION, PET_HUNGER, PET_THIRST,
				PET_BOREDOM);
		// Act
		underTest.admit(testPet);
		underTest.admit(anotherTestPet);
		underTest.playWithPet(PET_NAME);

		// Assert
		int petBoredom = underTest.findPet(PET_NAME).getBoredom();
		int anotherPetBoredom = underTest.findPet(anotherPetName).getBoredom();
		assertThat(petBoredom, is(40));
		assertThat(anotherPetBoredom, is(50));
	}

	@Test
	public void tickShouldIncreaseHungerThirstAndBoredomByOne() {
		// Act
		underTest.admit(testPet);
		underTest.tick();
		//Assert
		int petHunger = underTest.findPet(PET_NAME).getHunger();
		int petThirst = underTest.findPet(PET_NAME).getThirst();
		int petBoredom = underTest.findPet(PET_NAME).getBoredom();
		assertThat(petHunger, is(51));
		assertThat(petThirst, is(51));
		assertThat(petBoredom, is(51));
	}
}
