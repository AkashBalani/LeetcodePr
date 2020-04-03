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