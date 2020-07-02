class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length * (nums.length + 1))/2;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return expectedSum - sum;
    }
}

class Solution1{
    public int missingNumber(int[] nums){
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}