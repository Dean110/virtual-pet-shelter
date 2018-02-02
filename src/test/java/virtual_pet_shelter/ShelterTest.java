package virtual_pet_shelter;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;

public class ShelterTest {
	// Arrange
	Shelter underTest = new Shelter();
	String name = "Bruce";
	String description = "likes to fight and bite";
	Pet testPet = new Pet(name, description);
	final static String DEFAULT_NAME = "Default";
	final static String DEFAULT_DESCRIPTION = "doesn't matter";
	final static int DEFAULT_HUNGER = 20;
	final static int DEFAULT_THIRST = 20;
	final static int DEFAULT_BOREDOM = 20;

	@Test
	public void shelterShouldHaveACollectionOfPets() {
		// Act
		int result = underTest.amountOfPets();
		// Assert
		Assert.assertEquals(0, result);
	}

	@Test
	public void shelterShouldAdmitAPet() {
		// Act
		underTest.admitNew(testPet);
		int result = underTest.amountOfPets();
		// Assert
		Assert.assertEquals(1, result);
	}

	@Test
	public void shelterShouldReturnAPetByName() {
		underTest.admitNew(testPet);
		// Act
		String result = underTest.getPetName(name);
		// Assert
		Assert.assertEquals("Bruce", result);
	}

	@Test
	public void shelterShouldAllowAdoption() {
		underTest.admitNew(testPet);
		underTest.adoptOutPet(name);
		int result = underTest.amountOfPets();
		Assert.assertEquals(0, result);
	}

	@Test
	public void shelterShouldFeedAllPets() {
		underTest.admitNew(new Pet(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.admitNew(new Pet(name, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.feedAllPets();
		int result = underTest.getPetHunger(DEFAULT_NAME);
		int result1 = underTest.getPetHunger(name);
		assertEquals(10, result);
		assertEquals(10, result1);
	}

	@Test
	public void shelterShouldWaterAllPets() {
		underTest.admitNew(new Pet(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.admitNew(new Pet(name, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.waterAllPets();
		int result = underTest.getPetThirst(DEFAULT_NAME);
		int result1 = underTest.getPetThirst(name);
		assertEquals(10, result);
		assertEquals(10, result1);
	}

	@Test
	public void shelterShouldPlayWithAPet() {
		underTest.admitNew(new Pet(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.admitNew(new Pet(name, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.playWithAPet(DEFAULT_NAME);
		int result = underTest.getPetBoredom(DEFAULT_NAME);
		int result1 = underTest.getPetBoredom(name);
		assertEquals(10, result);
		assertEquals(20, result1);
	}

	@Test
	public void tickShouldIncreaseAllPetAttributes() {
		underTest.admitNew(new Pet(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.admitNew(new Pet(name, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM));
		underTest.tick();
		int result = underTest.getPetBoredom(DEFAULT_NAME);
		int result1 = underTest.getPetBoredom(name);
		assertEquals(21, result);
		assertEquals(21, result1);
	}
}
