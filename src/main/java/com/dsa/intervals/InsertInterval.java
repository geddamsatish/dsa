package com.dsa.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * LeetCode: https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    /**
     * Inserts a new interval into a list of non-overlapping intervals
     * and returns the merged intervals.
     *
     * @param intervals list of non-overlapping sorted intervals
     * @param newInterval the interval to insert
     * @return merged list of intervals after insertion
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before new interval starts (no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        // Step 2: Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Step 3: Add the merged interval
        merged.add(newInterval);

        // Step 4: Add all remaining intervals that start after merged interval ends (no overlap)
        for(int j = i; j < n; j++) {
            merged.add(intervals[j]);
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
