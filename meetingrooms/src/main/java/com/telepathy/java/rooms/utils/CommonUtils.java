package com.telepathy.java.rooms.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * This Class with help to read the input from text file.
 *
 */
public class CommonUtils {

	private static Scanner read;

	/**
	 * Help to read the text from directory
	 * 
	 * @param args
	 * @param startTime
	 * @param endTime
	 */
	public static void FileReader(String[] args, List<Double> startTime, List<Double> endTime) {
		String line;
		try {
			File file = new File(args[0]);
			read = new Scanner(file);
		} catch (IOException ioException) {
			System.err.println("Cannot open file.");
			System.exit(1);
		}
		try {
			while (read.hasNextLine()) {
				line = read.nextLine();
				String[] arr = line.split("-");
				startTime.add(helperConverter(arr[0]));
				endTime.add(helperConverter(arr[1]));
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Error message: " + e.getMessage());
		}
	}

	/**
	 * helper method using to conversion
	 * 
	 * @param String
	 * @return double
	 */
	private static double helperConverter(String s) {
		try {
			String[] hourMin = s.split(":");
			int hour = Integer.parseInt(hourMin[0]);
			int mins = Integer.parseInt(hourMin[1]);
			double time = Double.parseDouble(hour + "." + mins);
			return time;
		} catch (Exception e) {
			System.err.println("helper method having error.");
		}
		return 0;
	}
}
