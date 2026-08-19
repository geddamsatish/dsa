# Two Sum Sorted Array

## DESCRIPTION (inspired by Leetcode.com)

Given a sorted array of integers nums, determine if there exists a pair of numbers that sum to a given target.

## Example 1:

**Input:**
```
nums = [1,3,4,6,8,10,13]
target = 13
```

**Output:**
```
True # (3 + 10 = 13)
```

## Example 2:

**Input:**
```
nums = [1,3,4,6,8,10,13]
target = 6
```

**Output:**
```
False
```

## Constraints:
- Array is sorted in ascending order
- Array may contain duplicates
- Array length can be 0 to 10^5
- Target can be any integer

## Approach:
Consider using a two-pointer approach for optimal time complexity.

## Solution Explanation:

### Algorithm: Two-Pointer Approach

The two-pointer technique is the most efficient approach for this problem since the array is already sorted.

**Algorithm Steps:**

1. **Initialize two pointers:**
   - `left` pointer starts at the beginning of the array (index 0)
   - `right` pointer starts at the end of the array (index n-1)

2. **Traverse the array:**
   - While `left < right`:
     - Calculate the sum of elements at `left` and `right` positions
     - If sum equals target, return `true` (pair found)
     - If sum is less than target, move `left` pointer to the right (to increase the sum)
     - If sum is greater than target, move `right` pointer to the left (to decrease the sum)

3. **Return `false` if no pair is found** after the loop ends

**Why This Works:**
- Since the array is sorted, moving `left` to the right increases the sum, and moving `right` to the left decreases it
- This allows us to efficiently search for the target sum in linear time

### Example Walkthrough (Example 1):

```
nums = [1, 3, 4, 6, 8, 10, 13]
target = 13

Step 1: left = 0 (1), right = 6 (13), sum = 1 + 13 = 14 > 13 → move right left
Step 2: left = 0 (1), right = 5 (10), sum = 1 + 10 = 11 < 13 → move left right
Step 3: left = 1 (3), right = 5 (10), sum = 3 + 10 = 13 = 13 → return true ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass through the array |
| **Space Complexity** | O(1) - only using two pointers |

### Edge Cases Handled:

- Empty array → return false
- Single element → return false
- Negative numbers → works correctly due to sorted property
- Duplicate elements → correctly identifies pairs
- Sum exceeds max/min values → algorithm still works
