package com.dsa.twopointers;

import java.util.Arrays;

public class ValidTriangleNumber {

    /**
     * Given an integer array, return the count of triplets that can form valid triangles.
     * A valid triangle must satisfy: sum of any two sides > third side.
     *
     * @param nums array of integers representing potential triangle sides
     * @return count of valid triangle triplets
     */
    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = nums.length-1;i>=2;i--){
            int left = 0;
            int right = i-1;
            while(left < right){
                if(nums[left]+ nums[right] > nums[i]){
                    count = count+right-left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
