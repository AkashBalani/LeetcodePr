// Accepted Solution

class Solution {
    public int removeDuplicates(int[] nums) {
    int i = nums.length > 0 ? 1 : 0;  // This one makes sure that if nums.length == 0 we dont process it
    for (int n : nums) // Enhanced for loop
        if (n > nums[i-1])
            nums[i++] = n;
    return i;
    }
}