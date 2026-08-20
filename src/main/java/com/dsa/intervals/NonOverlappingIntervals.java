package com.dsa.intervals;

import java.util.Arrays;

/**
 * Non-overlapping Intervals
 * LeetCode: https://leetcode.com/problems/non-overlapping-intervals/
 */
public class NonOverlappingIntervals {

    /**
     * Returns the minimum number of intervals to remove to make the rest non-overlapping.
     *
     * @param intervals array of intervals where intervals[i] = [start, end]
     * @return minimum number of intervals to remove
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1],b[1]));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if ( end > intervals[i][0]) {
              count++;
            } else {
               end = intervals[i][1];
            }
        }
        return count;
    }
}
