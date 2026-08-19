package com.dsa.twopointers;

public class TrappingRainWater {

    /**
     * Calculate the amount of water that can be trapped after it rains given an elevation map.
     * Water trapped at each position is determined by the minimum of the maximum heights on both sides.
     * Time Complexity: O(n), Space Complexity: O(1)
     *
     * @param height array representing the elevation map
     * @return the total amount of water trapped
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int count = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    count += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    count += rightMax - height[right];
                }
                right--;
            }
        }
        return count;
    }
}
