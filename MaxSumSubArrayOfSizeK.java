/*
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Example1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Example2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int maxSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum); //update maxSum
                windowSum -= arr[windowStart]; //substract the first element in the current window
                windowStart += 1; //update start position
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int result = findMaxSumSubArray(3, new int[] { 2,1,5,1,3,2 });
        System.out.println("Max sum of subarrays of size K: " + result);
    }

}
