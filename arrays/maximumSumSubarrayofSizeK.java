/*

Given an array of positive numbers and a positive number 'k', find the
maximum sum of contiguous subarray of size 'k'.

Example 1:
Input: [2, 1, 5, 1, 3, 2], K = 3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3]

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

*/

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr){
        int[] result = new int[arr.length - k + 1];
        int windowSum = 0;
        int windowStart = 0;
        int max = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];  // Add the new element going into the window
            if(windowEnd >= k - 1){
                // We'll get into this condition only if we have arr.length > k
                result[windowStart] = windowSum;
                if(max < windowSum){
                    max = windowSum;
                }
                windowSum -= arr[windowStart]; // Subtract the element going out of the sliding window
                windowStart++; // Slide the window ahead
            }
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println("Maximum sum of a subarray of size K: " + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: " + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
    }
}
