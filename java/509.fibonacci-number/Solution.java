import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (67.05%)
 * Total Accepted:    528.4K
 * Total Submissions: 779.3K
 * Testcase Example:  '2'
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * 
 * Given n, calculate F(n).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 30
 * 
 * 
 */
class Solution {
    private final Map<Integer, Integer> cache = new HashMap<>();
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int previousNumResult = getPreviousResult(n - 1);
        int previousPreviousNumResult = getPreviousResult(n - 2);

        var result = previousNumResult + previousPreviousNumResult;
        if (!cache.containsKey(n))
            cache.put(n, result);

        return result;
    }

    private int getPreviousResult(int n) {
        int previousNumResult;
        if (cache.containsKey(n))
            previousNumResult = cache.get(n);
        else
            previousNumResult = fib(n);
        return previousNumResult;
    }
}
