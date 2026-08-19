package com.dsa.slidingwindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumPointsCardsTest {

    @Test
    public void testExample1() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int expected = 12;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testExample2() {
        int[] cardPoints = {2, 2, 2};
        int k = 2;
        int expected = 4;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testExample3() {
        int[] cardPoints = {9, 76, 64, 21, 97, 60};
        int k = 5;
        int expected = 322;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testKEqualsOne() {
        int[] cardPoints = {1, 2, 3, 4, 5};
        int k = 1;
        int expected = 5;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testKEqualsArrayLength() {
        int[] cardPoints = {1, 2, 3, 4, 5};
        int k = 5;
        int expected = 15;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testTakingFromBeginningOnly() {
        int[] cardPoints = {10, 1, 1, 1, 1};
        int k = 1;
        int expected = 10;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testTakingFromEndOnly() {
        int[] cardPoints = {1, 1, 1, 1, 10};
        int k = 1;
        int expected = 10;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testBalancedDistribution() {
        int[] cardPoints = {5, 5, 5, 5, 5, 5};
        int k = 3;
        int expected = 15;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeValuesAtEnds() {
        int[] cardPoints = {100, 1, 2, 3, 4, 5, 100};
        int k = 2;
        int expected = 200;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testSmallMiddleValues() {
        int[] cardPoints = {50, 1, 1, 1, 50};
        int k = 2;
        int expected = 100;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testIncreasingSequence() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int expected = 18;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testDecreasingSequence() {
        int[] cardPoints = {8, 7, 6, 5, 4, 3, 2, 1};
        int k = 3;
        int expected = 16;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testMixedPattern() {
        int[] cardPoints = {10, 20, 30, 40, 50, 60};
        int k = 2;
        int expected = 70;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testLargeArray() {
        int[] cardPoints = {1, 2, 3, 4, 5, 100, 6, 7, 8, 9, 10, 100};
        int k = 4;
        int expected = 200;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testOptimalTakeFromBoth() {
        int[] cardPoints = {50, 1, 1, 1, 50, 1, 1, 1, 50};
        int k = 3;
        int expected = 100;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testSmallArrayKTwo() {
        int[] cardPoints = {5, 10, 15};
        int k = 2;
        int expected = 20;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }

    @Test
    public void testAllSameValues() {
        int[] cardPoints = {7, 7, 7, 7, 7};
        int k = 3;
        int expected = 21;
        int result = MaximumPointsCards.maxPoints(cardPoints, k);
        assertEquals(expected, result);
    }
}
