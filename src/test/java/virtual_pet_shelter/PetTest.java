package virtual_pet_shelter;

import static org.junit.Assert.*;

import org.junit.Test;

public class PetTest {
	final static String DEFAULT_NAME = "Default";
	final static String DEFAULT_DESCRIPTION = "doesn't matter";
	final static int DEFAULT_HUNGER = 1;
	final static int DEFAULT_THIRST = 1;
	final static int DEFAULT_BOREDOM = 1;

	@Test
	public void shouldAcceptDefaultValuesForTesting() {
		Pet underTest = new Pet(DEFAULT_NAME, DEFAULT_DESCRIPTION, DEFAULT_HUNGER, DEFAULT_THIRST, DEFAULT_BOREDOM);
		int result = underTest.getHunger();
		assertEquals(1, result);
	}
	
}
