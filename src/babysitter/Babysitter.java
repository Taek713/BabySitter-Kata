package babysitter;

import java.util.ArrayList;

public class Babysitter {

	public static void main(String[] args) {
		int pay = 0;

		Time time = new Time();
		
		String start = time.getStartFromUser();
		System.out.println();
		String end = time.getEndFromUser();
		System.out.println();
		
		ArrayList<String> times = time.validatedStartAndEnd(start, end);
		String famInput = TotalCalculator.getFamFromUser();
		
		String validatedStart = times.get(0);//starting index at 0 or beginning 
		String validatedEnd = times.get(1);
		if(famInput.equals("a")) {
		pay = TotalCalculator.famATotalCalculation(validatedStart,validatedEnd);
	}else if(famInput.equals("b")) {
		pay = TotalCalculator.famBTotalCalculation(validatedStart,validatedEnd);

	}else if (famInput.equals("c")) {
		pay = TotalCalculator.famCTotalCalculation(validatedStart,validatedEnd);

	}
		
		System.out.println();
		System.out.println("Your Total Pay " + Time.getUserStart()+ " and " + Time.getUserEnd() + " for family " + famInput.toUpperCase() + " is " + "$" + pay);

		
	}

}
