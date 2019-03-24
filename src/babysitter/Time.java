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

	public static String getUserStart() {
		return userStart;
	}

	public static void setUserStart(String userStart) {
		Time.userStart = userStart;
	}

	public static String getUserEnd() {
		return userEnd;
	}

	public static void setUserEnd(String userEnd) {
		Time.userEnd = userEnd;
	}

//Keeping time as military
	String start = "17:00";
	String end = "04:00";

	public String properTime(String time) {
		LocalTime convertedFormat;
		try {
			convertedFormat = LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"));

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
		int five = 16;

		if (hour >= four && hour <= five) {
			System.out.println("These arent working hours");
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

		if (charStart1 != '0' && charEnd1 == '0') {
			return true;
		} else if (charStart1 == '0' && charEnd1 != '0') {
			System.out.println("Start time cant be after end time.");
			return false;
		} else if (startInt - endInt <= 0) {
			return true;
		}
		System.out.println("Time cant be before start time.");
		return false;
	}
//Getting start time from user 
	public String getStartFromUser() {
		System.out.println("Enter start time followed by a space with AM or PM. eg. 05:00 PM : ");
		String userTime = scnr.nextLine();
		String time = properTime(userTime);
		while (time == null) {
		   System.out.println("Enter start time followed by a space with AM or PM. eg. 05:00 PM : ");
			userTime = scnr.nextLine();
			time = properTime(userTime);
		}
		setUserStart(userTime);
		return time;
	}
	//Same method as above, only end instead of start
	public String getEndFromUser() {
		System.out.println("Enter end time followed by a space with AM or PM. eg. 05:00 PM: ");
		String userTime = scnr.nextLine();
		String time = properTime(userTime);
		while (time == null) {
			System.out.println("Enter end time followed by a space with AM or PM. eg. 05:00 PM : ");
			userTime = scnr.nextLine();
			time = properTime(userTime);
		}
		setUserStart(userTime);
		return time;
	}
	
	public ArrayList<String> validatedStartAndEnd(String start, String end){
		ArrayList<String> times = new ArrayList<String>();
		while(!timeCheck(start,end)) {
			start = getStartFromUser();
			end = getEndFromUser();
		}
		times.add(start);
		times.add(end);
		return times;
		
	}
	
	
}
