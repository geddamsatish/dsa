package com.dsa;

import com.dsa.slidingwindow.MaximumSumSubarrayK;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumSumSubarrayKTest {

    @Test
    public void testExample1() {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int expected = 9;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testSingleWindow() {
        int[] nums = {1, 2, 3};
        int k = 3;
        int expected = 6;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testWindowSizeOne() {
        int[] nums = {5, 3, 8, 2, 1};
        int k = 1;
        int expected = 8;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testAllNegative() {
        int[] nums = {-5, -3, -8, -2, -1};
        int k = 2;
        int expected = -3;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMixedPositiveNegative() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int k = 3;
        int expected = 4;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testAllPositive() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 9;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {100, 200, 300, 150};
        int k = 2;
        int expected = 500;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAtStart() {
        int[] nums = {10, 1, 2, 3};
        int k = 2;
        int expected = 11;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxAtEnd() {
        int[] nums = {1, 2, 3, 10};
        int k = 2;
        int expected = 13;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxInMiddle() {
        int[] nums = {1, 2, 10, 11, 3, 4};
        int k = 2;
        int expected = 21;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testAlternatingValues() {
        int[] nums = {1, -1, 1, -1, 1};
        int k = 2;
        int expected = 1;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testWithZeros() {
        int[] nums = {0, 0, 0, 5, 5, 5};
        int k = 3;
        int expected = 15;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeK() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        int expected = 15;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testRepeatedElements() {
        int[] nums = {5, 5, 5, 5, 5};
        int k = 3;
        int expected = 15;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMultipleWindows() {
        int[] nums = {2, 3, 4, 1, 2, 3, 4};
        int k = 3;
        int expected = 9;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testNegativeAtStart() {
        int[] nums = {-5, 10, 15, 1, 2};
        int k = 2;
        int expected = 25;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLongArray() {
        int[] nums = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 3;
        int expected = 13;
        int result = MaximumSumSubarrayK.maxSumSubarrayK(nums, k);
        assertEquals(expected, result);
    }
}
