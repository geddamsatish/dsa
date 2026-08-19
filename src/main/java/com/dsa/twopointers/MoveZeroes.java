package com.dsa.twopointers;

public class MoveZeroes {

    /**
     * Move all zeros to the end of the array while maintaining relative order of non-zero elements.
     * Must be done in-place without making a copy of the array.
     *
     * @param nums array of integers to modify in-place
     */
    public static void moveZeroes(int[] nums) {
        int slowPtr = 0;
        for(int fastPtr = 0; fastPtr < nums.length; fastPtr++) {
            if(nums[fastPtr] != 0) {
                if(fastPtr != slowPtr) {
                    int temp = nums[fastPtr];
                    nums[fastPtr] = nums[slowPtr];
                    nums[slowPtr] = temp;
                }
                slowPtr++;
            }
        }
    }
}
