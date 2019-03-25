package babysitter;

import java.util.ArrayList;

public class BabysitterMain {

	public static void main(String[] args) {
		int pay = 0;
		Time time = new Time();

		String start = time.getStartFromUser();
		System.out.println();
		String end = time.getEndFromUser();
		System.out.println();

		ArrayList<String> times = time.validatedStartAndEnd(start, end);
		String famInput = TotalCalculator.getFamFromUser();
		String validatedStart = times.get(0);// starting index at 0
		String validatedEnd = times.get(1);// Ending index is next for simplicity

		// If input for family options match, then it receives the validated starting
		// and ending work hours
		if (famInput.equals("a")) {
			pay = TotalCalculator.famATotalCalculation(validatedStart, validatedEnd);
		} else if (famInput.equals("b")) {
			pay = TotalCalculator.famBTotalCalculation(validatedStart, validatedEnd);

		} else if (famInput.equals("c")) {
			pay = TotalCalculator.famCTotalCalculation(validatedStart, validatedEnd);

		}

		// After calculations, what the total pay is then returned below.

		System.out.println();
		System.out.println("Your Total Pay working until " + Time.getUserStart() + " for family "
				+ famInput.toUpperCase() + " is " + "$" + pay + ". Thanks for babysitting!");

	}

}
