package com.telepathy.java.rooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.telepathy.java.rooms.utils.CommonUtils;

/**
 * Find how many meeting rooms are required 
 * Input: a local file, containing several lines and each line is the start time / end time of a meeting (24 hour format). 
 * A meeting will NOT end after midnight, ie, End time will not be later than 23:59).
 *
 */
public class FindMeetingRooms {

	public static void main(String[] args) throws Exception {

		// check if file specified
		if (args.length == 0) {
			System.out.println("File name not specified.");
			System.exit(1);
		}

		List<Double> startTime = new ArrayList<Double>();
		List<Double> endTime = new ArrayList<Double>();

		CommonUtils.FileReader(args, startTime, endTime);
		System.out.println("output " + toFindMeetingRooms(startTime, endTime));
	}

	/**
	 * Check how many meeting rooms are required
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static int toFindMeetingRooms(List<Double> start, List<Double> end) {

		Collections.sort(start);
		Collections.sort(end);

		double meetingEndTime = 23.59;
		for (double eTime : end) {
			if (eTime > meetingEndTime) {
				System.err.println("End time will not be later than 23:59");
				return 0;
			}
		}

		int len = start.size();
		int i = 1;
		int j = 0;

		int minMeetingRoomsRequired = 1;
		int noOfOngoingMeetings = 1;

		while (i < len && j < len) {
			if (end.get(j) > start.get(i)) {
				noOfOngoingMeetings++;
				if (minMeetingRoomsRequired < noOfOngoingMeetings) {
					minMeetingRoomsRequired = noOfOngoingMeetings;
				}
				i++;
			} else {
				noOfOngoingMeetings--;
				j++;
			}
		}
		return minMeetingRoomsRequired;
	}

}
