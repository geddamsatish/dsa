package com.dsa.twopointers;

public class SortColors {

    /**
     * Sort an array containing only 0s, 1s, and 2s (representing red, white, and blue).
     * Must be sorted in-place without making a copy of the array.
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param nums array of integers containing only 0, 1, and 2
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            } else {
                i++;
            }
        }




    }
}
