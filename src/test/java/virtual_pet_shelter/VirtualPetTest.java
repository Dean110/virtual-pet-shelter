package virtual_pet_shelter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {
	final static String PET_NAME = "Foo";
	final static String PET_DESCRIPTION = "Bar";
	final static int PET_HUNGER = 50;
	final static int PET_THIRST = 50;
	final static int PET_BOREDOM = 50;
	private VirtualPet testPet;

	@Before
	public void setup() {
		testPet = new VirtualPet(PET_NAME, PET_DESCRIPTION);
	}

	@Test
	public void shouldHaveASecondContructor() {
		assertThat(testPet.getName(), is(PET_NAME));
		assertThat(testPet.getDescription(), is(PET_DESCRIPTION));
	}

	@Test
	public void shouldChangeNameTo16CharString() {
		VirtualPet anotherTestPet = new VirtualPet("Bruce Wee The Fifteenth", PET_DESCRIPTION);
		String result = testPet.formatPetNameWithSpaces();
		String anotherResult = anotherTestPet.formatPetNameWithSpaces();
		assertThat(result.length(), is(16));
		assertThat(anotherResult.length(), is(16));
	}

	@Test
	public void petsShouldHaveARandomStartingHungerBetween20And80() {
		assertThat(testPet.getHunger()>=20, is(true));
		assertThat(testPet.getHunger()<=80, is(true));
	}
	@Test
	public void petsShouldHaveARandomStartingThirstBetween20And80() {
		assertThat(testPet.getThirst()>=20, is(true));
		assertThat(testPet.getThirst()<=80, is(true));
	}
	@Test
	public void petsShouldHaveARandomStartingBoredomBetween20And80() {
		assertThat(testPet.getBoredom()>=20, is(true));
		assertThat(testPet.getBoredom()<=80, is(true));
	}
}
