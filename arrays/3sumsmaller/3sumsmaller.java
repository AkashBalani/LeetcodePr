// Given an array of "n" integers "nums" and a "target", find the number of index triplets "i, j, k" with "0 <= i < j < k < n" that satisfy the condition "nums[i] + nums[j] + nums[k] < target"

// INPUT: nums = [-2, 0, 1, 3], and target = 2
// OUTPUT: 2
// EXPLANATION: [-2,0,1] and [-2,0,3]
// Accepted Solution

public class Solution {
    int count;
    
    public int threeSumSmaller(int[] nums, int target) {
        count = 0;
        Arrays.sort(nums);
        int len = nums.length;
    
        for(int i=0; i<len-2; i++) {
            int left = i+1, right = len-1;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    System.out.println(count);
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}
