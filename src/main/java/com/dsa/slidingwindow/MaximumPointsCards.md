# Maximum Points You Can Obtain From Cards

**LeetCode Link:** https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

## DESCRIPTION

There are several cards arranged in a row, and each card has an associated number of points. You want to pick up some cards in this row in order to maximize the total points collected.

However, you are restricted in the way you pick them up. Specifically, you may pick cards from the beginning or from the end of the row. In one step, you pick one card from either end of the remaining row, and you cannot pick a card from the middle. You can repeat this process until you have picked exactly `k` cards.

Given an array of integers `cardPoints`, return the maximum points you can obtain.

## Example 1:

**Input:**
```
cardPoints = [1,2,3,4,5,6,1]
k = 3
```

**Output:**
```
12
```

**Explanation:** After the first step, your score will always be 1. However, you can choose to take cards 6 (which is index 5) from the end and achieve a higher score. Selecting the last card along with cards 1 and 6 gives a total score of 1 + 6 + 5 = 12.

## Example 2:

**Input:**
```
cardPoints = [2,2,2]
k = 2
```

**Output:**
```
4
```

## Example 3:

**Input:**
```
cardPoints = [9,76,64,21,97,60]
k = 5
```

**Output:**
```
322
```

## Constraints:

- `1 <= cardPoints.length <= 10^5`
- `1 <= cardPoints[i] <= 10^4`
- `1 <= k <= cardPoints.length`

## Solution Explanation:

### Algorithm: Sliding Window Approach

The key insight is to think about this problem inversely. Instead of maximizing the sum of cards taken from the beginning and end, we can minimize the sum of cards left in the middle.

If we take `k` cards from the ends, we leave `n - k` cards in the middle. So:
- Total points = sum of all cards - sum of middle (n-k) cards
- We need to find the minimum sum of any contiguous subarray of size (n-k)
- Then subtract that from total to get maximum

**Algorithm Steps:**

1. **Calculate the total sum of all cards**

2. **Find the minimum sum of a contiguous subarray of size (n-k) using sliding window**
   - Create a window of size (n-k)
   - Calculate sum of first window
   - Slide the window and update minimum sum
   - Track the minimum sum found

3. **Return total sum - minimum window sum**
   - This gives us the maximum points from taking k cards from ends

**Why This Works:**

- We must take exactly k cards from the ends, leaving n-k cards in the middle
- To maximize points from ends, we minimize points left in middle
- Sliding window finds the minimum contiguous subarray sum in O(n)
- The remaining cards (left in middle) form a contiguous subarray

### Example Walkthrough (Example 1):

```
cardPoints = [1,2,3,4,5,6,1]
k = 3
n = 7, middle size = 7 - 3 = 4

Total sum = 1+2+3+4+5+6+1 = 22

Find minimum sum of 4 consecutive cards:
  [1,2,3,4] = 10
  [2,3,4,5] = 14
  [3,4,5,6] = 18
  [4,5,6,1] = 16

Minimum = 10

Maximum from ends = 22 - 10 = 12 ✓

This means taking cards: [6,5,1] from ends leaving [1,2,3,4] in middle
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass to sum all, then sliding window |
| **Space Complexity** | O(1) - only a few variables for tracking |

### Edge Cases Handled:

- k equals 1 → take either first or last card (maximum of both)
- k equals array length → take all cards
- Take all from beginning → last (k) cards from start
- Take all from end → last (k) cards from end
- Take from both ends → combination of first i and last (k-i) cards
- All same values → any combination gives same result
- Large values at ends → algorithm correctly identifies optimal selection
- Small values in middle → algorithm maximizes by taking from ends

### Why Sliding Window vs Brute Force:

- **Brute Force (O(k*n)):** Try all combinations of taking i cards from start and (k-i) from end
- **Sliding Window (O(n)):** Find minimum middle subarray, subtract from total
- Sliding window is optimal and more elegant

### Visual Representation:

```
Array:    [1,  2,  3,  4,  5,  6,  1]
Indices:   0   1   2   3   4   5   6
                    k=3

Option 1: Take [1, 2, 3] from start:     sum = 6
Option 2: Take [1, 2, 1] (start+end):    sum = 4
Option 3: Take [1, 6, 5] (start+end):    sum = 12 ← Maximum
Option 4: Take [6, 5, 1] from end:       sum = 12 ← Maximum
Option 5: Take [6, 1] from end only:     sum = 7

Best: Take from both ends to get 12
Middle left alone: [1, 2, 3, 4] = 10
Total - Middle = 22 - 10 = 12 ✓
```

### Key Insight:

The problem becomes: **Take k cards from ends** = **Leave n-k cards in middle**
Therefore: **Maximize(cards from ends) = Total - Minimize(middle n-k cards)**
