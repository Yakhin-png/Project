
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FibonacciCalcTest {

	@Test
	public void test() {
		FibonacciCalc fib = new FibonacciCalc();
		
		Float high = 11000F;
		Float low = 1000F;
		double per = 50D;
		
		String res = fib.SwitchStyle(high, low, per);
		
		if (res.equals("6000.0"))
			assertTrue(true);
		else
			assertTrue(false);
	}
	
}

