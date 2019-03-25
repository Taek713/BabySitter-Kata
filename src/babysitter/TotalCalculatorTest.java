package babysitter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TotalCalculatorTest {

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	TotalCalculator totalCalculator;
	public String start;
	public String end;

//Generated before annotation
	@Before
	public void setup() {
		totalCalculator = new TotalCalculator(start, end);

	}

//Testing Families A, B and C with different time inputs and different total pay
	@SuppressWarnings("static-access")
	@Test
	public void famABeforeElevenTotalCalculation() {
		totalCalculator = new TotalCalculator(start, end);
		totalCalculator.setStart("05:00");
		totalCalculator.setEnd("10:59");
		assertEquals(90, totalCalculator.famATotalCalculation(totalCalculator.getStart(), totalCalculator.getEnd()));
	}

	@SuppressWarnings("static-access")
	@Test
	public void famBBeforeTenTotalCalculation() {
		totalCalculator = new TotalCalculator(start, end);
		totalCalculator.setStart("05:00");
		totalCalculator.setEnd("10:00");
		assertEquals(60, totalCalculator.famBTotalCalculation(totalCalculator.getStart(), totalCalculator.getEnd()));
	}

	@SuppressWarnings("static-access")
	@Test
	public void famCBeforeTenTotalCalculation() {
		totalCalculator = new TotalCalculator(start, end);
		totalCalculator.setStart("05:00");
		totalCalculator.setEnd("08:59");
		assertEquals(84, totalCalculator.famCTotalCalculation(totalCalculator.getStart(), totalCalculator.getEnd()));
	}

//Testing the time formats
//Initialize time class
//Then adding before constructor for time testing 
	Time time;
	public String userStart;

	@Before
	public void setup2() {
		time = new Time(userStart);
	}

	@SuppressWarnings("static-access")
	@Test
	public void timeWithoutSpace() {
		time = new Time(userStart);
		time.setUserStart("05:00 PM");
		assertEquals(null, time.properTime("05:00PM"));
	}

	@SuppressWarnings("static-access")
	@Test
	public void timeEmptyString() {
		time = new Time(userStart);
		time.setUserStart("11:30 PM");
		assertEquals(null, time.properTime(""));
	}

}
