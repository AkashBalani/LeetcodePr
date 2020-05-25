class Solution {
    public int rob(int[] nums) {
        int evenSum = 0;
        int oddSum = 0;
        for(int i = 0; i < nums.length; i+=2)
            evenSum += nums[i];
        for(int i = 1; i < nums.length; i+=2)
            oddSum += nums[i];
        return evenSum > oddSum ? evenSum : oddSum;
    }
}

class Solution1{
    public int rob(int[] nums){
        int prevMax = 0;
        int currMax = 0;
        for(int x : nums){
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}