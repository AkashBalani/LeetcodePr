// Brute Force
// Time Limit Exceeded

class Solution{
    public int subarraySum(int[] nums, int k){
        int result = 0;
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                int sum = 0;
                for(int i = start; i < end; i++)
                    sum += nums[i];
                if(sum == k)
                    result += 1;
            }
        }
        return result;
    }
}

// Accepted Solution

class Solution1{
    public int subarraySum(int[] nums, int k){
        int result = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                if(sum[end] - sum[start] == k)
                    result += 1;
            }
        }
        return result;
    }
}