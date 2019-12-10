//////// 1. Two Sum /////////
//////// Brute Force ////////

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i <= len; i++){
            for(int j = i; j <= len; j++){
                if(nums[i] + nums[j] == target){
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        return null;
    }
}
