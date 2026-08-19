package com.dsa;

import com.dsa.twopointers.SortColors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class SortColorsTest {

    @Test
    public void testExample1() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }
    @Test
    public void testAllZeros() {
        int[] nums = {0, 0, 0};
        int[] expected = {0, 0, 0};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAllOnes() {
        int[] nums = {1, 1, 1};
        int[] expected = {1, 1, 1};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAllTwos() {
        int[] nums = {2, 2, 2};
        int[] expected = {2, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testSingleElement() {
        int[] nums = {1};
        int[] expected = {1};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testTwoElements() {
        int[] nums = {2, 0};
        int[] expected = {0, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAlreadySorted() {
        int[] nums = {0, 0, 1, 1, 2, 2};
        int[] expected = {0, 0, 1, 1, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testReverseSorted() {
        int[] nums = {2, 2, 1, 1, 0, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testRandomOrder() {
        int[] nums = {1, 0, 2, 1, 0, 1, 2};
        int[] expected = {0, 0, 1, 1, 1, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMostlyZeros() {
        int[] nums = {0, 0, 0, 1, 1, 2};
        int[] expected = {0, 0, 0, 1, 1, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMostlyTwos() {
        int[] nums = {0, 1, 2, 2, 2, 2};
        int[] expected = {0, 1, 2, 2, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testAlternatingPattern() {
        int[] nums = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        int[] expected = {0, 0, 0, 1, 1, 1, 2, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testLargeArray() {
        int[] nums = {2, 0, 1, 0, 1, 2, 1, 0, 2, 0, 1, 2};
        int[] expected = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testZerosFollowedByOnes() {
        int[] nums = {0, 0, 1, 1, 2};
        int[] expected = {0, 0, 1, 1, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testTwosFollowedByOnesFollowedByZeros() {
        int[] nums = {2, 2, 1, 1, 0, 0};
        int[] expected = {0, 0, 1, 1, 2, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    @Test
    public void testMixedSmallArray() {
        int[] nums = {2, 1, 0};
        int[] expected = {0, 1, 2};
        SortColors.sortColors(nums);
        assertArrayEquals(expected, nums);
    }
}
