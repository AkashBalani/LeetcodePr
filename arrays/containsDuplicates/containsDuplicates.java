// Brute Force
// Accepted Answer somehow?
// Space --> O(1) and Time --> O(n*logn)
// This is not including the sort, shame

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
}