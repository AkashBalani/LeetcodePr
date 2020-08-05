class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int times;
            if(map.containsKey(nums[i]))
                times = map.get(nums[i]) + 1;
            else
                times = 1;
            if(times > nums.length/2)
                return nums[i];
            map.put(nums[i], times);
        }
        return 0;
    }
}