package com.dsa.intervals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFreeTimeTest {

    private EmployeeFreeTIme solution;

    @BeforeEach
    void setUp() {
        solution = new EmployeeFreeTIme();
    }

    @Test
    void testExample1() {
        // Employee 0: [2,4],[7,10]
        // Employee 1: [1,5]
        // Employee 2: [6,9]
        // Merged busy: [1,5],[6,10]
        // Free time: [5,6]
        int[][][] schedule = {
            {{2, 4}, {7, 10}},
            {{1, 5}},
            {{6, 9}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{5, 6}, result[0]);
    }

    @Test
    void testExample2() {
        // Employee 0: [1,3],[5,6],[8,10]
        // Employee 1: [2,4]
        // Employee 2: [2,5],[9,12]
        // Merged busy: [1,6],[8,12]
        // Free time: [6,8]
        int[][][] schedule = {
            {{1, 3}, {5, 6}, {8, 10}},
            {{2, 4}},
            {{2, 5}, {9, 12}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{6, 8}, result[0]);
    }

    @Test
    void testNoFreeTime() {
        // Employee 0: [1,10]
        // Employee 1: [1,10]
        // Merged: [1,10]
        // Free time: none
        int[][][] schedule = {
            {{1, 10}},
            {{1, 10}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testMultipleFreeTimeGaps() {
        // Employee 0: [1,2],[4,5],[7,8]
        // Employee 1: [1,8]
        // Merged: [1,8]
        // Free time within range: none (fully covered)
        int[][][] schedule = {
            {{1, 2}, {4, 5}, {7, 8}},
            {{1, 8}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testSingleEmployee() {
        // Employee 0: [1,3],[5,7]
        // Merged: [1,3],[5,7]
        // Free time: [3,5]
        int[][][] schedule = {
            {{1, 3}, {5, 7}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{3, 5}, result[0]);
    }

    @Test
    void testIdenticalSchedules() {
        // All employees: [2,4],[6,8]
        // Merged: [2,4],[6,8]
        // Free time: [4,6]
        int[][][] schedule = {
            {{2, 4}, {6, 8}},
            {{2, 4}, {6, 8}},
            {{2, 4}, {6, 8}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{4, 6}, result[0]);
    }

    @Test
    void testTouchingIntervals() {
        // Employee 0: [1,3],[3,5]
        // Employee 1: [2,4]
        // Merged: [1,5]
        // Free time: none
        int[][][] schedule = {
            {{1, 3}, {3, 5}},
            {{2, 4}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testLargeTimeRanges() {
        // Employee 0: [0,1000000]
        // Employee 1: [100,200],[300,400]
        // Merged: [0,1000000]
        // Free time: none
        int[][][] schedule = {
            {{0, 1000000}},
            {{100, 200}, {300, 400}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testNegativeTimeValues() {
        // Employee 0: [-5,-1],[1,3]
        // Employee 1: [-3,0],[2,5]
        // Merged: [-5,0],[1,5]
        // Free time: [0,1]
        int[][][] schedule = {
            {{-5, -1}, {1, 3}},
            {{-3, 0}, {2, 5}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(1, result.length);
        assertArrayEquals(new int[]{0, 1}, result[0]);
    }

    @Test
    void testGapsBetweenEmployees() {
        // Employee 0: [1,2],[8,9]
        // Employee 1: [3,4],[9,10]
        // Employee 2: [5,6],[10,11]
        // Merged: [1,2],[3,4],[5,6],[8,11]
        // Free time: [2,3],[4,5],[6,8]
        int[][][] schedule = {
            {{1, 2}, {8, 9}},
            {{3, 4}, {9, 10}},
            {{5, 6}, {10, 11}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(3, result.length);
        assertArrayEquals(new int[]{2, 3}, result[0]);
        assertArrayEquals(new int[]{4, 5}, result[1]);
        assertArrayEquals(new int[]{6, 8}, result[2]);
    }

    @Test
    void testOverlappingEmployeeSchedules() {
        // Employee 0: [1,5]
        // Employee 1: [2,6]
        // Employee 2: [3,7]
        // Merged: [1,7]
        // Free time: none
        int[][][] schedule = {
            {{1, 5}},
            {{2, 6}},
            {{3, 7}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testSinglePointIntervals() {
        // Employee 0: [1,1],[3,3]
        // Employee 1: [2,2]
        // Merged: [1,1],[2,2],[3,3]
        // Free time: [1,2],[2,3]
        int[][][] schedule = {
            {{1, 1}, {3, 3}},
            {{2, 2}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(2, result.length);
        assertArrayEquals(new int[]{1, 2}, result[0]);
        assertArrayEquals(new int[]{2, 3}, result[1]);
    }

    @Test
    void testManyEmployeesComplexSchedule() {
        // Employee 0: [1,3]
        // Employee 1: [2,5]
        // Employee 2: [4,6]
        // Employee 3: [5,8]
        // Merged: [1,8]
        // Free time: none
        int[][][] schedule = {
            {{1, 3}},
            {{2, 5}},
            {{4, 6}},
            {{5, 8}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }

    @Test
    void testComplexWithMultipleGaps() {
        // Employee 0: [1,2],[4,5],[7,8]
        // Employee 1: [1,8]
        // Employee 2: [2,4],[5,7]
        // Merged: [1,8]
        // Free time: none (fully covered)
        int[][][] schedule = {
            {{1, 2}, {4, 5}, {7, 8}},
            {{1, 8}},
            {{2, 4}, {5, 7}}
        };

        int[][] result = solution.employeeFreeTime(schedule);

        assertEquals(0, result.length);
    }
}
