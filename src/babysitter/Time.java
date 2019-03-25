package babysitter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
//This class is for calculating the time from beginning to end when babysitting 

public class Time {
//initialize the scanner for user input 
	Scanner scnr = new Scanner(System.in);

	public static String userStart;
	public static String userEnd;

//UNCOMMENT TO MAKE THE timeWithoutSpace & timeEmptyString test classes PASS
	public Time(String userStart2) {
// Auto-generated constructor stub for the test timeWithoutSpace in the test
// class
	}

	public Time() {
//This method with no args is for the above method to also co-exist		
	}

	public static String getUserStart() {
		return userStart;
	}

	public static void setUserStart(String userStart) {
		Time.userStart = userStart;
	}
//No need for this method
//public static void timeWithoutSpace(String userStart) {
//		
//	}

	public static String getUserEnd() {
		return userEnd;
	}

	public static void setUserEnd(String userEnd) {
		Time.userEnd = userEnd;
	}

//Keeping time as normal
	String start = "5:00";
	String end = "4:00";

	// Getting start time from user
	public String getStartFromUser() {
		System.out.println("Clock in your Babysitting hours here followed by a space with AM or PM. eg. 5:00 PM : ");
		String userTime = scnr.nextLine();
		String time = properTime(userTime);
		while (time == null) {
			System.out
					.println("Clock in your Babysitting hours here followed by a space with AM or PM. eg. 5:00 PM : ");
			userTime = scnr.nextLine();
			time = properTime(userTime);
		}
		setUserStart(userTime);
		return time;
	}

	// Using the same method as above, only end instead of start
	public String getEndFromUser() {
		System.out.println("Enter clock out time followed by a space with AM or PM! eg. 8:00 PM: ");
		String userTime = scnr.nextLine();
		String time = properTime(userTime);
		while (time == null) {
			System.out.println("Enter clock out time followed by a space with AM or PM. eg. 8:00 PM : ");
			userTime = scnr.nextLine();
			time = properTime(userTime);
		}
		setUserStart(userTime);
		return time;
	}

//This method is for converting the time format input from the user
	public String properTime(String time) {
		LocalTime convertedFormat;
		try {
			convertedFormat = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mm a"));

		} catch (DateTimeParseException e) {
			System.out.println("Incorrect");
			return null;
		}

		String convertedFormatString = convertedFormat.toString();
		if (convertedFormatString.equals(start) || convertedFormatString.equals(end)) {
			return convertedFormatString;
		}

		int hour = Integer.parseInt(convertedFormatString.substring(0, 2));
		int four = 4;
		int sixteen = 16;

		if (hour >= four && hour <= sixteen) {
			System.out.println("This isnt working hours.");
			return null;
		}
		return convertedFormatString;

	}

	public boolean timeCheck(String start, String end) {
		String parseStart = start.substring(0, 2) + start.substring(3, 5);
		String parseEnd = end.substring(0, 2) + end.substring(3, 5);
		char charStart1 = parseStart.charAt(0);
		char charEnd1 = parseEnd.charAt(0);
		int startInt = Integer.parseInt(parseStart);
		int endInt = Integer.parseInt(parseEnd);

//Checking if the user time inputs are correct

		if (charStart1 != '0' && charEnd1 == '0') {
			return true;
		} else if (charStart1 == '0' && charEnd1 != '0') {
			System.out.println("Time cant be after hours(4:00 AM).");
			return false;
		} else if (startInt - endInt <= 0) {
			return true;
		}
		System.out.println("Time cant be before work hours (5:00 PM).");
		return false;
	}

	// Receiving start time and end time from user and adding it to retrieve the
	// total pay
	public ArrayList<String> validatedStartAndEnd(String start, String end) {
		ArrayList<String> times = new ArrayList<String>();
		while (!timeCheck(start, end)) {
			start = getStartFromUser();
			end = getEndFromUser();
		}
		times.add(start);
		times.add(end);
		return times;

	}

}
