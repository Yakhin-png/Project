
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PipsPointsCalcTest {

	@Test
	void test() {
		
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

