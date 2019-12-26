// Initial Code
// Time Limit Exceeded

class Solution {
    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> arrli = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(arrli.contains(nums[i])){
                return true;
            }
            else{
                arrli.add(nums[i]);
            }
        }
        return false;
    }
}