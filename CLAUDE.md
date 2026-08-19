# Project Context: DSA Interview Questions

## Project Overview
This is a Java Maven project for solving LeetCode-style Data Structures and Algorithms problems.

## Project Structure
- **Main code:** `src/main/java/com/dsa/{category}/` (e.g., `twopointers/`)
- **Tests:** `src/test/java/com/dsa/`
- **Documentation:** Each problem has a `.md` file alongside its `.java` implementation

## Adding New Problems

### File Structure Pattern
When adding a new problem, create three files:

1. **Implementation:** `src/main/java/com/dsa/{category}/{ProblemName}.java`
   - Contains the main solution method with JavaDoc
   - Leave gap for solution with `// TODO: Implement solution here`

2. **Tests:** `src/test/java/com/dsa/{ProblemNameTest.java}`
   - Comprehensive test cases using JUnit 5
   - Includes edge cases, examples, and boundary conditions
   - 10-15 test methods per problem

3. **Documentation:** `src/main/java/com/dsa/{category}/{ProblemName}.md`
   - LeetCode link at the top
   - Problem description with examples
   - Algorithm explanation with walkthrough
   - Time/Space complexity table
   - Edge cases handled

### Markdown Format Template
```markdown
# [Problem Name]

**LeetCode Link:** https://leetcode.com/problems/[slug]/

## DESCRIPTION (inspired by Leetcode.com)
[Problem description]

## Example 1:
**Input:** ...
**Output:** ...

## Constraints:
[List constraints]

## Solution Explanation:
### Algorithm: [Name]
[Explanation]

### Example Walkthrough:
[Step-by-step example]

### Time and Space Complexity:
[Table with metrics]

### Edge Cases Handled:
[List edge cases]
```

## README Update
Add new problems to the Problems Index table in README.md with:
- Problem # (sequential)
- Problem name
- Difficulty level
- Topics/algorithms
- Links to .md, .java, and Test.java files

## Commit Convention
**Important:** Do NOT include Claude as co-author in commits. Do NOT commit CLAUDE.md to git. Use only the user's name (geddamsatish@gmail.com).

Commit format:
```
git commit -m "Add [Problem Name] implementation and tests"
```

## Testing
Run tests with: `mvn test`

Run specific test: `mvn test -Dtest=SortColorsTest`
