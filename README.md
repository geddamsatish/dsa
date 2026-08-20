# DSA Interview Questions

A Java Maven project for solving Data Structures and Algorithms interview questions.

## Problems Index

| # | Problem | Difficulty | Topics | Description | Code | Tests |
|---|---------|------------|--------|-------------|------|-------|
| 1 | Two Sum Sorted Array | Easy | Two Pointers | [📄](src/main/java/com/dsa/twopointers/TwoSumSortedArray.md) | [💻](src/main/java/com/dsa/twopointers/TwoSumSortedArray.java) | [🧪](src/test/java/com/dsa/TwoSumSortedArrayTest.java) |
| 2 | Container With Most Water | Medium | Two Pointers, Array | [📄](src/main/java/com/dsa/twopointers/ContainerWithMostWater.md) | [💻](src/main/java/com/dsa/twopointers/ContainerWithMostWater.java) | [🧪](src/test/java/com/dsa/ContainerWithMostWaterTest.java) |
| 3 | 3Sum | Medium | Two Pointers, Array, Sorting | [📄](src/main/java/com/dsa/twopointers/ThreeSum.md) | [💻](src/main/java/com/dsa/twopointers/ThreeSum.java) | [🧪](src/test/java/com/dsa/ThreeSumTest.java) |
| 4 | Valid Triangle Number | Medium | Two Pointers, Array, Sorting | [📄](src/main/java/com/dsa/twopointers/ValidTriangleNumber.md) | [💻](src/main/java/com/dsa/twopointers/ValidTriangleNumber.java) | [🧪](src/test/java/com/dsa/ValidTriangleNumberTest.java) |
| 5 | Move Zeroes | Easy | Two Pointers, Array | [📄](src/main/java/com/dsa/twopointers/MoveZeroes.md) | [💻](src/main/java/com/dsa/twopointers/MoveZeroes.java) | [🧪](src/test/java/com/dsa/MoveZeroesTest.java) |
| 6 | Sort Colors | Medium | Two Pointers, Array, Sorting | [📄](src/main/java/com/dsa/twopointers/SortColors.md) | [💻](src/main/java/com/dsa/twopointers/SortColors.java) | [🧪](src/test/java/com/dsa/SortColorsTest.java) |
| 7 | Trapping Rain Water | Hard | Two Pointers, Array, Dynamic Programming | [📄](src/main/java/com/dsa/twopointers/TrappingRainWater.md) | [💻](src/main/java/com/dsa/twopointers/TrappingRainWater.java) | [🧪](src/test/java/com/dsa/twopointers/TrappingRainWaterTest.java) |
| 8 | Maximum Sum of Subarrays of Size K | Easy | Sliding Window, Array | [📄](src/main/java/com/dsa/slidingwindow/MaximumSumSubarrayK.md) | [💻](src/main/java/com/dsa/slidingwindow/MaximumSumSubarrayK.java) | [🧪](src/test/java/com/dsa/slidingwindow/MaximumSumSubarrayKTest.java) |
| 9 | Maximum Points You Can Obtain From Cards | Medium | Sliding Window, Array | [📄](src/main/java/com/dsa/slidingwindow/MaximumPointsCards.md) | [💻](src/main/java/com/dsa/slidingwindow/MaximumPointsCards.java) | [🧪](src/test/java/com/dsa/slidingwindow/MaximumPointsCardsTest.java) |
| 10 | Meeting Rooms | Easy | Intervals, Sorting | [📄](src/main/java/com/dsa/intervals/MeetingRooms.md) | [💻](src/main/java/com/dsa/intervals/MeetingRooms.java) | [🧪](src/test/java/com/dsa/intervals/MeetingRoomsTest.java) |
| 11 | Insert Interval | Medium | Intervals, Greedy | [📄](src/main/java/com/dsa/intervals/InsertInterval.md) | [💻](src/main/java/com/dsa/intervals/InsertInterval.java) | [🧪](src/test/java/com/dsa/intervals/InsertIntervalTest.java) |
| 12 | Non-overlapping Intervals | Medium | Intervals, Greedy, Sorting | [📄](src/main/java/com/dsa/intervals/NonOverlappingIntervals.md) | [💻](src/main/java/com/dsa/intervals/NonOverlappingIntervals.java) | [🧪](src/test/java/com/dsa/intervals/NonOverlappingIntervalsTest.java) |
| 13 | Merge Intervals | Medium | Intervals, Sorting | [📄](src/main/java/com/dsa/intervals/MergeIntervals.md) | [💻](src/main/java/com/dsa/intervals/MergeIntervals.java) | [🧪](src/test/java/com/dsa/intervals/MergeIntervalsTest.java) |
| 14 | Employee Free Time | Hard | Intervals, Sorting, Merging | [📄](src/main/java/com/dsa/intervals/EmployeeFreeTIme.md) | [💻](src/main/java/com/dsa/intervals/EmployeeFreeTIme.java) | [🧪](src/test/java/com/dsa/intervals/EmployeeFreeTimeTest.java) |

## Requirements

- Java 17+
- Maven 3.6+

## Building the Project

```bash
# Clean and compile
mvn clean compile

# Run all tests
mvn test

# Run a specific test
mvn test -Dtest=SolutionTest

# Package the project
mvn package
```

## Adding a New Solution

1. Create a new Java file in `src/main/java/com/dsa/` (e.g., `TwoSum.java`)
2. Implement your solution
3. Create a corresponding test file in `src/test/java/com/dsa/` (e.g., `TwoSumTest.java`)
4. Write test cases using JUnit 5

### Example Solution

```java
package com.dsa;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Implementation here
        return new int[]{0, 1};
    }
}
```

### Example Test

```java
package com.dsa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {
    @Test
    public void testTwoSum() {
        TwoSum solution = new TwoSum();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
```

## Running Solutions

Execute a solution's main method:

```bash
mvn exec:java -Dexec.mainClass="com.dsa.Solution"
```

## IDE Setup

### IntelliJ IDEA
- Open the project and IntelliJ will automatically recognize it as a Maven project
- Dependencies will be downloaded automatically

### VS Code
- Install the Extension Pack for Java
- The project will be recognized automatically

## Testing

The project uses JUnit 5 for unit testing. Run tests with:

```bash
mvn test
```

To view detailed test results, check the output after running tests.
