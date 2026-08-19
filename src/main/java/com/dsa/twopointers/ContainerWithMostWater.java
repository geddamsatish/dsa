package com.dsa.twopointers;

public class ContainerWithMostWater {

    /**
     * Given an array of heights, find two lines that together with the x-axis form a container
     * that holds the most water.
     *
     * @param height array of integers representing heights of lines
     * @return the maximum area of water that can be contained
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else{
                right--;
            }
        }
        return maxArea;
    }
}
