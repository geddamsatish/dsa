package com.dsa;

import com.dsa.twopointers.ContainerWithMostWater;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerWithMostWaterTest {

    @Test
    public void testExample1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testExample2() {
        int[] height = {1, 1};
        assertEquals(1, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testTwoElementsSmallHeight() {
        int[] height = {1, 2};
        assertEquals(1, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testTwoElementsLargeHeight() {
        int[] height = {5, 10};
        assertEquals(5, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testIncreasingHeights() {
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(6, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testDecreasingHeights() {
        int[] height = {5, 4, 3, 2, 1};
        assertEquals(6, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testAllSameHeights() {
        int[] height = {5, 5, 5, 5, 5};
        assertEquals(20, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testPeakInMiddle() {
        int[] height = {1, 10, 1};
        assertEquals(2, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testZeroHeights() {
        int[] height = {0, 0, 0};
        assertEquals(0, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testMixedHeights() {
        int[] height = {2, 3, 4, 5, 18, 17, 6};
        assertEquals(17, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testLargeArrayWithOptimalInMiddle() {
        int[] height = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        assertEquals(25, ContainerWithMostWater.maxArea(height));
    }

    @Test
    public void testOptimalAtEnds() {
        int[] height = {10, 1, 2, 3, 4, 5, 1, 10};
        assertEquals(70, ContainerWithMostWater.maxArea(height));
    }
}
