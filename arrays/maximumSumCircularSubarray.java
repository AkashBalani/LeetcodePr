class Solution{
    public int maxSumCircularSubarry(int[] nums){
        int total = 0, minSum = Integer.MAX_VALUE, maxSum = Integer.MIN_VALUE, currMax = 0, currMin = 0;
        for(int num : nums){
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(currMax, maxSum);
            currMin = Math.min(currMin + num, currMin);
            minSum = Math.min(currMin, minSum);
            total += num;
        }
        return (maxSum > 0) ? (Math.max(maxSum, total - minSum)) : (maxSum);
    }
}