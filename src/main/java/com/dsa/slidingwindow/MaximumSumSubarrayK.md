# Maximum Sum of Subarrays of Size K

**LeetCode Link:** https://leetcode.com/problems/maximum-average-subarray-i/ (Similar Problem)

## DESCRIPTION

Given an array of integers `nums` and an integer `k`, find the maximum sum of any contiguous subarray of size exactly `k`.

A subarray is a contiguous part of the array. The subarray must have exactly `k` elements.

## Example 1:

**Input:**
```
nums = [2, 1, 5, 1, 3, 2]
k = 3
```

**Output:**
```
9
```

**Explanation:** The subarray with the maximum sum is [5, 1, 3] with a sum of 9.

## Example 2:

**Input:**
```
nums = [1, 4, 2, 10, 2, 3, 1, 0, 20]
k = 4
```

**Output:**
```
24
```

**Explanation:** The subarray [10, 2, 3, 1, 0] actually has length 5, so it's invalid. The valid subarrays are:
- [1, 4, 2, 10] = 17
- [4, 2, 10, 2] = 18
- [2, 10, 2, 3] = 17
- [10, 2, 3, 1] = 16
- [2, 3, 1, 0] = 6
- [3, 1, 0, 20] = 24 ✓ (Maximum)

## Constraints:

- `k <= nums.length`
- `1 <= k <= 10^5`
- `-10^4 <= nums[i] <= 10^4`

## Follow Up:

Can you solve it without using loops to iterate through the array multiple times?

## Solution Explanation:

### Algorithm: Sliding Window Approach

The key insight is to use a sliding window of fixed size `k` and maintain a running sum, avoiding redundant recalculations.

**Algorithm Steps:**

1. **Calculate the sum of the first window (first k elements)**
   - Iterate through the first k elements and sum them
   - Store this as `maxSum` and `currentSum`

2. **Slide the window across the array:**
   - For each subsequent position (from k to n-1):
     - Remove the leftmost element from the current sum: `currentSum -= nums[i - k]`
     - Add the new rightmost element: `currentSum += nums[i]`
     - Update `maxSum` if `currentSum` is greater: `maxSum = Math.max(maxSum, currentSum)`

3. **Return the maximum sum found**

**Why This Works:**

- We calculate the first window's sum in O(k) time
- Each subsequent window is calculated by removing one element and adding one element in O(1) time
- Total time complexity is O(n)
- We only use a few variables, so space complexity is O(1)

### Example Walkthrough (Example 1):

```
nums = [2, 1, 5, 1, 3, 2]
k = 3

Step 0 (Calculate first window):
  window = [2, 1, 5]
  currentSum = 2 + 1 + 5 = 8
  maxSum = 8

Step 1 (i=3, nums[3]=1):
  Remove nums[0]=2: currentSum = 8 - 2 = 6
  Add nums[3]=1: currentSum = 6 + 1 = 7
  window = [1, 5, 1]
  maxSum = max(8, 7) = 8

Step 2 (i=4, nums[4]=3):
  Remove nums[1]=1: currentSum = 7 - 1 = 6
  Add nums[4]=3: currentSum = 6 + 3 = 9
  window = [5, 1, 3]
  maxSum = max(8, 9) = 9

Step 3 (i=5, nums[5]=2):
  Remove nums[2]=5: currentSum = 9 - 5 = 4
  Add nums[5]=2: currentSum = 4 + 2 = 6
  window = [1, 3, 2]
  maxSum = max(9, 6) = 9

Final Result: maxSum = 9 ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass through the array |
| **Space Complexity** | O(1) - only a few variables, no extra data structures |

### Edge Cases Handled:

- Single window (k == n) → return sum of entire array
- Window size of 1 (k == 1) → return maximum element
- All positive numbers → result is always sum of last k elements (maximum)
- All negative numbers → result is the least negative sum of k elements
- Array with zeros → handles correctly
- Large numbers → works with any integer values
- Mixed positive and negative numbers → finds correct maximum

### Why Sliding Window Over Other Approaches:

- **Naive Approach (O(n*k)):** Recalculate sum for each position - slow for large k
- **Sliding Window (O(n)):** Update sum incrementally - optimal solution
- **Prefix Sum (O(n)):** Pre-compute prefix sums, then use formula - also O(n) but uses O(n) space

The sliding window approach is the most efficient in both time and space for this problem.

### Visual Representation:

```
Array:    [2,  1,  5,  1,  3,  2]
Index:     0   1   2   3   4   5
           k=3

Window 1:  [2,  1,  5]           sum = 8
Window 2:      [1,  5,  1]       sum = 7
Window 3:          [5,  1,  3]   sum = 9 ← Maximum
Window 4:              [1,  3,  2] sum = 6
```
