# Sort Colors

**LeetCode Link:** https://leetcode.com/problems/sort-colors/

## DESCRIPTION (inspired by Leetcode.com)

Given an array `nums` with `n` objects colored red, white, or blue, sort them **in-place** so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers `0`, `1`, and `2` to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

## Example 1:

**Input:**
```
nums = [2,0,2,1,1,0]
```

**Output:**
```
[0,0,1,1,2,2]
```

## Example 2:

**Input:**
```
nums = [2,4,1]
```

**Output:**
```
[1,2,4]
```

## Constraints:

- `n == nums.length`
- `1 <= n <= 300`
- `nums[i]` is either `0`, `1`, or `2`

## Follow Up:

Could you come up with a one-pass algorithm using only constant extra space?

## Solution Explanation:

### Algorithm: Dutch National Flag (Three-Pointer Approach)

The key insight is to use three pointers to partition the array into three regions: one for 0s, one for 1s, and one for 2s.

**Algorithm Steps:**

1. **Initialize three pointers:**
   - `low = 0` (marks the boundary where the next 0 should be placed)
   - `mid = 0` (current element being examined)
   - `high = n - 1` (marks the boundary where the next 2 should be placed)

2. **Iterate with mid pointer from 0 to high:**
   - If `nums[mid] == 0`: swap with `nums[low]`, increment both `low` and `mid`
   - If `nums[mid] == 1`: just increment `mid`
   - If `nums[mid] == 2`: swap with `nums[high]`, decrement `high` (don't increment `mid` yet, as we need to check the swapped element)

3. **Continue until `mid > high`:**
   - At this point, all 0s are on the left, all 2s are on the right, and all 1s are in the middle

**Why This Works:**

- The algorithm partitions the array in a single pass
- Each element is visited and moved to its correct position
- No extra space is used beyond a few pointers
- The relative order of elements isn't required to be preserved

### Example Walkthrough (Example 1):

```
nums = [2,0,2,1,1,0]
low = 0, mid = 0, high = 5

Step 1 (mid=0, nums[0]=2):
  2 == 2, swap nums[0] and nums[5]: [0,0,2,1,1,2], high = 4
  
Step 2 (mid=0, nums[0]=0):
  0 == 0, swap nums[0] and nums[0]: [0,0,2,1,1,2], low = 1, mid = 1
  
Step 3 (mid=1, nums[1]=0):
  0 == 0, swap nums[1] and nums[1]: [0,0,2,1,1,2], low = 2, mid = 2
  
Step 4 (mid=2, nums[2]=2):
  2 == 2, swap nums[2] and nums[4]: [0,0,1,1,2,2], high = 3
  
Step 5 (mid=2, nums[2]=1):
  1 == 1, increment mid: [0,0,1,1,2,2], mid = 3
  
Step 6 (mid=3, nums[3]=1):
  1 == 1, increment mid: [0,0,1,1,2,2], mid = 4
  
mid > high (4 > 3), loop ends
Final: [0,0,1,1,2,2] ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass through the array |
| **Space Complexity** | O(1) - in-place modification, only a few pointers |

### Edge Cases Handled:

- Array with all same color (all 0s, 1s, or 2s) → remains unchanged
- Array with single element → handled correctly
- Array with two elements → correctly sorted
- Already sorted array → remains unchanged
- Reverse sorted array → correctly sorted to [0,0,...,1,1,...,2,2,...]
- Mixed distribution of colors → correctly partitioned

### Why One-Pass?

The Dutch National Flag algorithm solves this in one pass because:
- We scan through the array once with the `mid` pointer
- We place elements directly in their final positions
- We don't need to scan multiple times
- The three regions (0s, 1s, 2s) are built simultaneously
