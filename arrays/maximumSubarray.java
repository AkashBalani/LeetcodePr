// Not Optimal but accepted
class Solution{
    public int maxSubarray(int[] nums){
        int sum = Integer.MIN_VALUE, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum = nums[i];
            maxSum = Math.max(maxSum, sum);
            for(int j = 0; j < nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}

// Accepted Solution
// Reduces the unnecessary outer loop
class Solution1{
    public int maxSubarray(int[] nums){
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < n; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(currSum, maxSum);  
        }
        return maxSum;
    }
}