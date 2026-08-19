package com.dsa.twopointers;

public class TwoSumSortedArray {

    /**
     * Determines if there exists a pair of numbers in a sorted array that sum to a target.
     *
     * @param nums sorted array of integers
     * @param target the target sum
     * @return true if a pair exists that sums to target, false otherwise
     */
    public static boolean twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return true;
            }
            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
