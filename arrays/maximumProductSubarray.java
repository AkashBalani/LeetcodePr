class Solution{
    public int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        int currentMax;
        for(int i = 0; i < nums.length; i++){
            currentMax = 1;
            for(int j = i; j < nums.length; j++){
                currentMax = currentMax * nums[j];
                max = Math.max(currentMax, max);
            }
        }
        return max;
    }
}