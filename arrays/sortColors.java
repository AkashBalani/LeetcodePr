class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int noOfZeros =  map.getOrDefault(0, 0);
        int noOfOnes = map.getOrDefault(1, 0);
        int noOfTwos = map.getOrDefault(2, 0);
        int i = 0;
        while(noOfZeros != 0){
            nums[i] = 0;
            noOfZeros--;
            i++;
        }
        while(noOfOnes != 0){
            nums[i] = 1;
            noOfOnes--;
            i++;
        }
        while(noOfTwos != 0){
            nums[i] = 2;
            noOfTwos--;
            i++;
        }
    }
}