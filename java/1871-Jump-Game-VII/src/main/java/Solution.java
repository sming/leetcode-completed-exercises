/**
 * You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning,
 * you are standing at index 0, which is equal to '0'. You can move from index i to index j if the
 * following conditions are fulfilled:
 *
 * <p>i + minJump <= j <= min(i + maxJump, s.length - 1), and s[j] == '0'. Return true if you can
 * reach index s.length - 1 in s, or false otherwise.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "011010", minJump = 2, maxJump = 3 Output: true Explanation: In the first step,
 * move from index 0 to index 3. In the second step, move from index 3 to index 5. Example 2:
 *
 * <p>Input: s = "01101110", minJump = 2, maxJump = 3 Output: false
 *
 * <p>Constraints:
 *
 * <p>2 <= s.length <= 105 s[i] is either '0' or '1'. s[0] == '0' 1 <= minJump <= maxJump < s.length
 */
public class Solution {
  public boolean canReach(String binarySteps, int minJump, int maxJump) {
    return canReach(binarySteps, 0, minJump, maxJump);
  }

  private boolean canReach(String binarySteps, int currIdx, int minJump, int maxJump) {
    if (currIdx > binarySteps.length() - 1) {
      return false;
    }

    if (binarySteps.charAt(currIdx) != '0') {
      return false;
    }

    if (currIdx == binarySteps.length() - 1) {
      return true;
    }

    if (canReach(binarySteps, currIdx + minJump, minJump, maxJump)) {
      return true;
    }

    if (canReach(binarySteps, currIdx + maxJump, minJump, maxJump)) {
      return true;
    }
    return false;
  }
}
