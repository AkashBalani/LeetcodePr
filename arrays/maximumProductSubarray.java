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
    public int maxProduct1(int[] name){
        if(nums.lenght == 0) return 0;

        int max = nums[0];
        int min = nums[0];

        int result = max;

        for(int i = 0; i < nums.lenght; i++){
            int curr = nums[i];

            int tmp = Math.max(curr, Math.max(curr * max, curr * min));
            min = Math.min(curr, Math.min(curr * max, curr * min));

            max = tmp;

            result = Math.max(max, result);
        }
        return result;
    }
}