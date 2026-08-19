package com.dsa.twopointers;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrappingRainWaterTest {

    @Test
    public void testExample1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testExample2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        int expected = 9;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testNoWater() {
        int[] height = {1, 2, 3, 4, 5};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testDescendingOrder() {
        int[] height = {5, 4, 3, 2, 1};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleElement() {
        int[] height = {5};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testTwoElements() {
        int[] height = {3, 0};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testUniformHeight() {
        int[] height = {2, 2, 2, 2};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testValleyShape() {
        int[] height = {3, 0, 2};
        int expected = 2;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleValleys() {
        int[] height = {3, 0, 2, 0, 4};
        int expected = 7;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testIncreasingThenDecreasing() {
        int[] height = {1, 2, 3, 4, 3, 2, 1};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testWallsWithGap() {
        int[] height = {2, 0, 2};
        int expected = 2;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testComplexPattern1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testAllZeros() {
        int[] height = {0, 0, 0};
        int expected = 0;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testTallWallsShorterFloor() {
        int[] height = {5, 4, 3, 4, 5};
        int expected = 4;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testAsymmetricWalls() {
        int[] height = {2, 1, 0, 1, 2, 1, 0, 1};
        int expected = 5;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeHeightDifference() {
        int[] height = {9, 0, 9};
        int expected = 9;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }

    @Test
    public void testLongArray() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int result = TrappingRainWater.trap(height);
        assertEquals(expected, result);
    }
}
