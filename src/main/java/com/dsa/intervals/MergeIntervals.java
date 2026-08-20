package com.dsa.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Merge Intervals
 * LeetCode: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    /**
     * Merges all overlapping intervals and returns an array of non-overlapping intervals.
     *
     * @param intervals array of intervals where intervals[i] = [start, end]
     * @return array of merged non-overlapping intervals
     */
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals by start time
        // This ensures overlapping intervals come consecutively
        Arrays.sort(intervals, (a, b)-> Integer.compare(a[0],b[0]));

        List<int[]> result = new ArrayList<>();

        // Step 2: Iterate through sorted intervals and merge overlaps
        for (int i = 0; i < intervals.length; i++) {
            // Step 3: Check if current interval overlaps with last merged interval
            // No overlap if: result is empty OR last interval's end < current interval's start
            if(result.isEmpty() || result.get(result.size()-1)[1] < intervals[i][0]) {
                // No overlap - add current interval as new group
                result.add(intervals[i]);
            } else {
                // Overlap detected - merge by extending last interval's end
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
