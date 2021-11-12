package org.psk.practice;

/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (34.21%)
 * Total Accepted:    381K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 * Example 1:
 *
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 *
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * ———————————— PSK NOTES ————————————
 * X ~ Amount
 * - I know that just picking the most of the biggest doesn't work in all cases
 * - do we have to try all combinations?
 *  - well, cos it's DP, that implies we do.
 *  - so, what are we reusing? this is the really hard bit
 *  - 1) sub_amount -> minimal collection
 *      - the problem with this is, as always, how do you know it's minimal?
 *      - this is also predicated upon the assumtption that knowing how to get to
 *        X-1 helps you to get to X. I'm not sure about that.
 *          - e.g. can you say that minimal(X-1) + 1 is the minimal number of
 *            coins? No. But... you can then decide which "handful" of coins
 *            is the smallest at X. Can you?
 *          - so, you keep a map of N(1..X) → min_num_coins
 *              - do you need to keep a list of the coins? I don't think so.
 *              - you just update min_num_coins(N) as you find smaller numbers
 *                  - but that means you don't recompute how you get to N though, right?
 * - could you start from the smallest and then go up?
 *      - e.g. for X=17 COINS={1,2,5}
 *          - you start with 1x17, then 3x5+1+1, then 3x5+2.
 *      - what about X=17 COINS={1,2,10}
 *          - 1x17, 1x7+10,1+2x3+10
 *      - X=18 COINS={2,5,10}
 *          - 2x9 → 10,5! → 10,2x4
 *      - but where's the DP coming in?
 *
 * - how about that assumption again: COINS(X-SMALLEST) + SMALLEST = optimal change
 *  - I can feel that that's too basic.
 *  - no, it doesn't have to be that way. As long as we know the minimal change
 *    for N, we're good. I'm sure of it. and that minimal change is mutable.
 *      - no. we're not reusing existing information. we're re-exploring every
 *        time. Fuckshit this is hard.
 *
 * ———————————— PSK NOTES ————————————
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

class Solution {
    public int coinChange(final int[] coins, final int amount) {
        int[] minNumCoinsForAmount = new int[amount + 1];
        var coinsI = Arrays.stream(coins).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
        Arrays.sort(coinsI, Collections.reverseOrder());

        Arrays.fill(minNumCoinsForAmount, Integer.MAX_VALUE);
        coinsI[0] = 0;

        return coinChange(coinsI, amount);
    }

    private int coinChange(Integer[] coins, int amount) {
        int minNumCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int remainingAmount = amount;
            int face = coins[i];
            int numCoins = remainingAmount / face;
            int currNumCoins = numCoins; // don't care if it's 0
            for (int j = i + 1; j < coins.length; j++) {
                face = coins[j];
                numCoins = remainingAmount / face;
                currNumCoins += numCoins; // don't care if it's 0
                remainingAmount -= numCoins * face;
                if (remainingAmount == 0) {
                    if (currNumCoins < minNumCoins) {
                        minNumCoins = currNumCoins;
                    }
                    break;
                }
            }
        }

        return minNumCoins;
    }
}