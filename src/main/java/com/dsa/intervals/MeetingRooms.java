package com.dsa.intervals;

import java.util.Arrays;

/**
 * Meeting Rooms
 * LeetCode: https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms {

    /**
     * Determines if a person can attend all meetings.
     *
     * @param intervals array of meeting intervals [start, end]
     * @return true if person can attend all meetings, false otherwise
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) {
            return false;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }
}
