# Valid Triangle Number

**LeetCode Link:** https://leetcode.com/problems/valid-triangle-number/

## DESCRIPTION (inspired by Leetcode.com)

Given an integer array `nums`, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

## Triangle Inequality Theorem

A valid triangle must satisfy the triangle inequality theorem: the sum of the lengths of any two sides must be greater than the length of the remaining side. If we have three sides `a`, `b`, and `c`:
- `a + b > c`
- `a + c > b`
- `b + c > a`

However, if we sort the three sides such that `a ≤ b ≤ c`, we only need to check: `a + b > c` (the other two conditions are automatically satisfied).

## Example 1:

**Input:**
```
nums = [2,2,3,4]
```

**Output:**
```
3
```

**Explanation:** Valid combinations are:
- 2,3,4 (using the first 2)
- 2,3,4 (using the second 2)
- 2,2,3

## Example 2:

**Input:**
```
nums = [4,2,3,4]
```

**Output:**
```
4
```

## Constraints:

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`

## Solution Explanation:

### Algorithm: Sort + Two Pointers

After sorting the array, we can use a two-pointer approach combined with a fixed pointer to efficiently count valid triangles.

**Algorithm Steps:**

1. **Sort the array:**
   - Sort nums in ascending order
   - Time: O(n log n)

2. **Fix the largest side:**
   - Iterate from right to left (largest elements first)
   - For each index `k` as the longest side

3. **Use two pointers for the other two sides:**
   - Set `left` pointer at the beginning (index 0)
   - Set `right` pointer at `k-1` (before the longest side)
   - While `left < right`:
     - If `nums[left] + nums[right] > nums[k]`, all pairs from left to right-1 combined with right can form valid triangles with k
       - Add `(right - left)` to count (all these combinations are valid)
       - Move `right--` to check the next element
     - Else if `nums[left] + nums[right] <= nums[k]`, move `left++` to increase the sum

4. **Return the total count**

**Why This Works:**

- By sorting, if `a ≤ b ≤ c` and `a + b > c`, we know `a + c > b` and `b + c > a` are automatically true
- When we find that `nums[left] + nums[right] > nums[k]`, all pairs (left, left+1, ..., right-1) combined with right and k form valid triangles
- We can count all these at once: `right - left` combinations

### Example Walkthrough (Example 1):

```
nums = [2,2,3,4]
After sorting: [2,2,3,4]

k=3 (nums[k]=4):
  left=0, right=2
  sum = 2 + 3 = 5 > 4, valid! count += (2-0) = 2
  Triangles: [2,3,4] with first 2, [2,3,4] with second 2
  right--
  
  left=0, right=1
  sum = 2 + 2 = 4 NOT > 4, invalid
  left++
  
  left >= right, stop

k=2 (nums[k]=3):
  left=0, right=1
  sum = 2 + 2 = 4 > 3, valid! count += (1-0) = 1
  Triangle: [2,2,3]
  right--
  
  left >= right, stop

k=1: similar (no valid triangles)
k=0: can't form triangles with single element

Total count = 2 + 1 = 3 ✓
```

### Time and Space Complexity:

| Metric | Value |
|--------|-------|
| **Time Complexity** | O(n²) - O(n log n) for sorting + O(n²) for nested loops |
| **Space Complexity** | O(1) - Only using pointers, not counting output |

### Edge Cases Handled:

- Array with zeros → correctly excluded (no valid triangles)
- Array with single large element and others → correctly handled
- Array with all same values → correctly identifies all valid triplets
- Array shorter than 3 elements → returns 0
- Very small and very large values → works correctly
