class Solution {
    public void nextPermutation(int[] nums) {
        int numsLength = nums.length;
        int i = numsLength - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]){
            i--;
        }
        if( i >= 0){
            int j = numsLength - 1;
            while(nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1);
    }
    public void reverse(int[] nums, int i){
        int j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}