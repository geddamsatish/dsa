package com.dsa.slidingwindow;

public class MaximumSumSubarrayK {

    /**
     * Find the maximum sum of any contiguous subarray of size k.
     * Uses the sliding window technique to efficiently calculate sums.
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param nums array of integers
     * @param k the size of the subarray window
     * @return the maximum sum of any contiguous subarray of size k
     */
    public static int maxSumSubarrayK(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int windowSum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];
            if (i - j + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[j];
                j++;
            }
        }
        return maxSum;
    }
}
