package babysitter;

import java.util.Scanner;

public class TotalCalculator {
	public String start;
	public String end;

	public TotalCalculator(String start, String end) {
		this.start = start;
		this.end = end;
	}
// getters and setters for time

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	// Setting up scanner reader to get family choice from user.
	public static String getFamFromUser() {
		Scanner scnr = new Scanner(System.in);
		System.out.print("Hello! What family are you babysitting for? Enter A, B, or C: ");
		String famChar = scnr.nextLine();
		String famInput = famChar.toLowerCase();
		while (!famInput.equals("a") && !famInput.equals("b") && !famInput.equals("c")) {
			System.out.println("Enter above listed families only.");
			famChar = scnr.nextLine();
			famInput = famChar.toLowerCase();
		}
		return famInput;
	}

	public static int famATotalCalculation(String start, String end) {
		String parseStart = start.substring(0, 2) + start.substring(3, 5);
		String parseEnd = end.substring(0, 2) + end.substring(3, 5);

		int workedT;
		int eleven = 2300;
		int parseStartInt = Integer.parseInt(parseStart);
		int parseEndInt = Integer.parseInt(parseEnd);

		if (parseStartInt <= 400) {
			parseStartInt += 2400;
		}

		if (parseEndInt <= 400) {
			parseEndInt += 2400;
		}
//before 11pm
		if (parseEndInt <= eleven) {
			workedT = parseEndInt - parseStartInt;
			return 15 * (int) Math.ceil(workedT / 100.0);
		}
// after 11pm
		else if (parseStartInt >= eleven) {
			workedT = parseEndInt - parseStartInt;
			return 20 * (int) Math.ceil(workedT / 100.0);
		}

// This is before 11 and ends after 11 pm
		int allPay = 0;
		workedT = eleven - parseStartInt;
		allPay += 15 * (int) (Math.ceil(workedT / 100.0));
		workedT = eleven - parseEndInt;
		allPay += 20 * (int) (Math.ceil(workedT / 100.0));

		return allPay;

	}

	public static int famBTotalCalculation(String start, String end) {
		String parseStart = start.substring(0, 2) + start.substring(3, 5);
		String parseEnd = end.substring(0, 2) + end.substring(3, 5);

		int workedT;
		int ten = 2200;
		int twelve = 2400;
		int allPay = 0;
		int parseStartInt = Integer.parseInt(parseStart);
		int parseEndInt = Integer.parseInt(parseEnd);

		if (parseStartInt <= 400) {
			parseStartInt += 2400;
		}

		if (parseEndInt <= 400) {
			parseEndInt += 2400;
		}

		if (parseEndInt <= ten) {
			workedT = parseEndInt - parseStartInt;
			return 12 * (int) Math.ceil(workedT / 100.0);
		}
// after 10pm
		else if (parseStartInt >= ten && parseEndInt <= twelve) {
			workedT = parseEndInt - parseStartInt;
			return 8 * (int) Math.ceil(workedT / 100.0);
//after 12am
		} else if (parseStartInt >= twelve && parseEndInt >= twelve) {
			workedT = parseEndInt - parseStartInt;
			return 16 * (int) Math.ceil(workedT / 100.0);

		} else if (parseStartInt >= ten && parseEndInt > twelve) {
			workedT = ten - parseStartInt;
			allPay += 12 * (int) Math.ceil(workedT / 100.0);
			allPay += 16;
			workedT = parseEndInt - twelve;
			allPay += 16 * (int) Math.ceil(workedT / 100.0);
			return allPay;

		} else if (parseStartInt >= ten && parseEndInt <= twelve) {
			workedT = ten - parseStartInt;
			allPay += 12 * (int) Math.ceil(workedT / 100.0);
			workedT = parseEndInt - ten;
			allPay += 8 * (int) Math.ceil(workedT / 100.0);
			return allPay;
		}
//Starting after 10 and ends after 12 am
		workedT = twelve - parseStartInt;
		allPay += 8 * (int) Math.ceil(workedT / 100.0);
		workedT = parseEndInt - twelve;
		allPay += 16 * (int) Math.ceil(workedT / 100.0);
		return allPay;
	}

	public static int famCTotalCalculation(String start, String end) {
		String parseStart = start.substring(0, 2) + start.substring(3, 5);
		String parseEnd = end.substring(0, 2) + end.substring(3, 5);

		int workedT;
		int nine = 2100;
		int parseStartInt = Integer.parseInt(parseStart);
		int parseEndInt = Integer.parseInt(parseEnd);

		if (parseStartInt <= 400) {
			parseStartInt += 2400;
		}

		if (parseEndInt <= 400) {
			parseEndInt += 2400;
		}
// before 11pm
		if (parseEndInt <= nine) {
			workedT = parseEndInt - parseStartInt;
			return 21 * (int) Math.ceil(workedT / 100.0);
		}

// after 11pm
		else if (parseStartInt >= nine) {
			workedT = parseEndInt - parseStartInt;
			return 15 * (int) Math.ceil(workedT / 100.0);
		}
		int allPay = 0;
		workedT = nine - parseStartInt;
		allPay += 21 * (int) (Math.ceil(workedT / 100.0));

		workedT = parseEndInt - nine;
		allPay += 15 * (int) (Math.ceil(workedT / 100.0));
		return allPay;
	}

}
