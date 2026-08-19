package com.dsa;

import com.dsa.twopointers.TwoSumSortedArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumSortedArrayTest {

    @Test
    public void testExample1() {
        int[] nums = {1, 3, 4, 6, 8, 10, 13};
        int target = 13;
        assertTrue(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = {1, 3, 4, 6, 8, 10, 13};
        int target = 6;
        assertFalse(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testTwoElementsMatch() {
        int[] nums = {1, 2};
        int target = 3;
        assertTrue(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testTwoElementsNoMatch() {
        int[] nums = {1, 2};
        int target = 5;
        assertFalse(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int target = 5;
        assertFalse(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testSingleElement() {
        int[] nums = {5};
        int target = 10;
        assertFalse(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testNegativeNumbers() {
        int[] nums = {-10, -5, -2, 0, 3, 5, 10};
        int target = 0;
        assertTrue(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testDuplicates() {
        int[] nums = {1, 1, 2, 2, 3, 3};
        int target = 4;
        assertTrue(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testLargeNumbers() {
        int[] nums = {1, 100, 1000, 10000};
        int target = 1100;
        assertTrue(TwoSumSortedArray.twoSum(nums, target));
    }

    @Test
    public void testFirstAndLastElement() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        assertTrue(TwoSumSortedArray.twoSum(nums, target)); // 1 + 5 = 6
    }

    @Test
    public void testNoMatchOutOfRange() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 20;
        assertFalse(TwoSumSortedArray.twoSum(nums, target));
    }
}
