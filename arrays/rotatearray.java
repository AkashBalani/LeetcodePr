//Brute Force
//initial Attempt

class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        int marker = k;
        if(nums.length == 1 || k < 1){
            return;
        }
        for(int i = 0; i <= k && marker <= nums.length; i++){
            //ans[i] = 0;
            ans[marker] = nums[i];
            marker++;
        }
        marker = k+1;
        for(int i = 0; i < k; i++){
            ans[i] = nums[marker];
            marker++;
        }
        System.out.println(Arrays.toString(ans));
        for(int i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }
    }
}
