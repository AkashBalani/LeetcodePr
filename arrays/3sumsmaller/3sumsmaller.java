// Initial Submission
// Brute Force

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        // based on 2 pointers
        int result = 0;
        for(int i = 0; i <= nums.length-1; i++){
            for(int j = i+1; j <= nums.length-1; j++){
                for(int k = j+1; k <= nums.length-1; k++){
                    if((nums[i] + nums[j] + nums[k]) < target){
                        result++;
                    }
                }
            }    
        }
        return result;
    }
}