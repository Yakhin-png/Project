
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class FibonacciCalcTest {

	@Test
	void test() {
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

