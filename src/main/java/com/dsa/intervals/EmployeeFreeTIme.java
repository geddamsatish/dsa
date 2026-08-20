package com.dsa.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Employee Free Time
 * LeetCode: https://leetcode.com/problems/employee-free-time/
 */
public class EmployeeFreeTIme {

    /**
     * Finds the free time windows that are available for all employees.
     *
     * @param schedule 3D array where schedule[i] contains intervals for employee i
     * @return 2D array of free time intervals (sorted)
     */
    public int[][] employeeFreeTime(int[][][] schedule) {
        // Step 1: Flatten all intervals from all employees into a single list
        List<int[]> flattened = new ArrayList<>();
        for (int[][] employee : schedule) {
            for (int[] interval: employee) {
                flattened.add(interval);
            }
        }

        // Step 2: Sort all intervals by start time
        // This allows us to identify overlapping intervals
        Collections.sort(flattened, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Merge overlapping intervals to get total busy time
        List<int[]> mergedList = new ArrayList<>();
        for(int[] interval: flattened) {
            // If no overlap with last merged interval, add current as new group
            if(mergedList.isEmpty() || mergedList.get(mergedList.size()-1)[1] < interval[0]) {
                mergedList.add(interval);
            } else {
                // Overlap detected - extend the end time of last merged interval
                mergedList.get(mergedList.size()-1)[1] = Math.max(mergedList.get(mergedList.size()-1)[1], interval[1]);
            }
        }

        // Step 4: Find gaps between merged intervals (these are the free times)
        List<int[]> freeTimes = new ArrayList<>();
        for(int i = 1; i < mergedList.size(); i++){
            int start = mergedList.get(i-1)[1];
            int end = mergedList.get(i)[0];
            freeTimes.add(new int[]{start, end});
        }

        return freeTimes.toArray(new int[freeTimes.size()][]);

    }
}
