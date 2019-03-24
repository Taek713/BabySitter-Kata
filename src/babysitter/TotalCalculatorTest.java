package babysitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TotalCalculatorTest {

	TotalCalculator totalCalculator;
	public String start;
	public String end;

//Generated before annotation
	@Before
	public void setup() {
		totalCalculator = new TotalCalculator(start, end);

	}

	@Test
	public void famABeforeElevenTotalCalculation() {
		totalCalculator = new TotalCalculator(start, end);
		totalCalculator.setStart("05:00");
		totalCalculator.setEnd("10:59");
		assertEquals(90, totalCalculator.famATotalCalculation(totalCalculator.getStart(), totalCalculator.getEnd()));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
