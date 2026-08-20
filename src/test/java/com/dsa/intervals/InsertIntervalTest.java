package com.dsa.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {

    private InsertInterval solution;

    @BeforeEach
    void setUp() {
        solution = new InsertInterval();
    }

    @Test
    void testInsertIntoEmpty() {
        int[][] intervals = {};
        int[] newInterval = {5, 7};
        int[][] expected = {{5, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertNoOverlap() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 9}};
        int[] newInterval = {10, 12};
        int[][] expected = {{1, 2}, {3, 5}, {6, 9}, {10, 12}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertWithOverlapExample1() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 7};
        int[][] expected = {{1, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertWithOverlapExample2() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 9}};
        int[] newInterval = {4, 8};
        int[][] expected = {{1, 2}, {3, 9}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertMergesMultiple() {
        int[][] intervals = {{1, 3}, {4, 6}, {7, 9}};
        int[] newInterval = {2, 8};
        int[][] expected = {{1, 9}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertBeforeAll() {
        int[][] intervals = {{3, 5}, {6, 9}};
        int[] newInterval = {1, 2};
        int[][] expected = {{1, 2}, {3, 5}, {6, 9}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertAfterAll() {
        int[][] intervals = {{1, 2}, {3, 5}};
        int[] newInterval = {6, 8};
        int[][] expected = {{1, 2}, {3, 5}, {6, 8}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertTouchingStart() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {5, 7};
        int[][] expected = {{1, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertTouchingEnd() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {-1, 1};
        int[][] expected = {{-1, 5}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertContainsAllIntervals() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        int[] newInterval = {0, 7};
        int[][] expected = {{0, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertIsContainedByInterval() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] expected = {{1, 5}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertIdentical() {
        int[][] intervals = {{2, 5}};
        int[] newInterval = {2, 5};
        int[][] expected = {{2, 5}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertComplexOverlap() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 7}};
        int[] newInterval = {2, 6};
        int[][] expected = {{1, 7}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertLargeGaps() {
        int[][] intervals = {{1, 3}, {10, 12}, {20, 25}};
        int[] newInterval = {5, 8};
        int[][] expected = {{1, 3}, {5, 8}, {10, 12}, {20, 25}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertSingleElement() {
        int[][] intervals = {{1, 1}};
        int[] newInterval = {2, 2};
        int[][] expected = {{1, 1}, {2, 2}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }

    @Test
    void testInsertNegativeValues() {
        int[][] intervals = {{-5, -2}, {0, 2}};
        int[] newInterval = {-2, 1};
        int[][] expected = {{-5, 2}};
        assertArrayEquals(expected, solution.insert(intervals, newInterval));
    }
}
