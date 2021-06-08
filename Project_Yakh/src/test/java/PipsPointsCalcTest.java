

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PipsPointsCalcTest {

	@Test
	public void test() {
		
		PipsPointsCalc PP = new PipsPointsCalc();
		
		Float current = 200F;
		Float trade = 5000000F;
		
		Float pip = PP.PipsFormule(current, trade);
		
		if (pip==2.5F)
			assertTrue(true);
		else
			assertTrue(false);
		
	}

}

