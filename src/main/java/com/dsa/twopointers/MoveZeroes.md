# Move Zeroes

**LeetCode Link:** https://leetcode.com/problems/move-zeroes/

## DESCRIPTION (inspired by Leetcode.com)

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

**Note:** You must do this **in-place** without making a copy of the array.

## Example 1:

**Input:**
```
nums = [0,1,0,3,12]
```

**Output:**
```
[1,3,12,0,0]
```

## Example 2:

**Input:**
```
nums = [0]
```

**Output:**
```
[0]
```

## Constraints:

- `1 <= nums.length <= 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`

## Follow Up:
Could you minimize the total number of operations done?

## Solution Explanation:

### Algorithm: Two-Pointer In-Place Approach

The key insight is to use two pointers: one pointer keeps track of the position where the next non-zero element should be placed, and another pointer iterates through the array to find non-zero elements.

**Algorithm Steps:**

1. **Initialize a pointer `insertPos` at 0:**
   - This pointer marks the position where the next non-zero element should be placed

2. **Iterate through the array with index `i`:**
   - For each element, if it's non-zero, place it at position `insertPos` and increment `insertPos`
   - If it's zero, skip it

3. **Fill the remaining positions with zeros:**
   - After the main loop, all positions from `insertPos` to the end should be filled with zeros

**Why This Works:**

- We only iterate through the array twice (or once with proper handling)
- We're modifying the array in-place, not using extra space
- The relative order of non-zero elements is preserved because we process them left-to-right
- Zeros naturally move to the end

**Optimization:** Instead of filling with zeros at the end, we can directly place non-zero elements when we encounter them and skip zeros.

### Example Walkthrough (Example 1):

```
nums = [0,1,0,3,12]
insertPos = 0

i=0 (nums[0]=0):
  0 is zero, skip
  
i=1 (nums[1]=1):
  1 is non-zero, nums[0] = 1, insertPos = 1
  Array: [1,1,0,3,12]
  
i=2 (nums[2]=0):
  0 is zero, skip
  
i=3 (nums[3]=3):
  3 is non-zero, nums[1] = 3, insertPos = 2
  Array: [1,3,0,3,12]
  
i=4 (nums[4]=12):
  12 is non-zero, nums[2] = 12, insertPos = 3
  Array: [1,3,12,3,12]

Fill from insertPos to end with zeros:
  nums[3] = 0, nums[4] = 0
  
Final: [1,3,12,0,0] ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n) - single pass (or two passes if counting the zero-fill) |
| **Space Complexity** | O(1) - in-place modification, no extra space |

### Edge Cases Handled:

- Array with no zeros → elements remain in same order
- Array with all zeros → remains all zeros
- Array with single element (0 or non-zero) → handled correctly
- Array with alternating zeros and non-zeros → correctly reorganized
- Negative numbers → treated as non-zero, moved forward
- Mix of positive, negative, and zero → correctly handled

### Optimization Notes:

The problem asks to minimize operations. The two-pointer approach is optimal because:
- We only visit each element once (O(n) time)
- We only perform necessary swaps/writes
- Alternative: count zeros, then in one pass move non-zeros and fill zeros (also O(n), minimal writes)
