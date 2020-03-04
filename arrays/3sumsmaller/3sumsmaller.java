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
        // This sorting should take O(nlogn)
        int len = nums.length;
    
        for(int i=0; i<len-2; i++) {
            // For loop takes n iterations
            int left = i+1, right = len-1;
            while(left < right) {
                // This while loop would make the complexity O(n2)
                if(nums[i] + nums[left] + nums[right] < target) {
                    count += right-left;
                    // This line is the main reason this code is so small, we are essentially saying that if we have found such a condition where i, left and right added up are less than target than any elements in between would also satisfy this condition as the array is sorted             
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
