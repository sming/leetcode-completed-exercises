/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (28.77%)
 * Total Accepted:    638.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
package org.psk.interview_practice.median_arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double num1 = findMedian(nums1);        
    	double num2 = findMedian(nums2);
    	
    	return 0.0;
    }

    /**
     * 1, 99, 103, 207 = 101
     * 1, 99, 103, 150, 207 = 103. Len = 5. we want 3rd element. 
     * 1, 99, 207 = 103. Len = 3. we want 2nd element.
     * so for odd, it's len/2 + 1.
     * @param nums1
     * @return
     */
	private double findMedian(int[] nums1) {
		int len = nums1.length;
		
		if (len % 2 == 0) {
			return nums1[len/2] + nums1[(len/2)+1] / 2.0;
		} else {
			return nums1[(len/2)+1];
		}
	}
}
