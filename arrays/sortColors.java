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

class Solution1{
    public void sortColors1(int[] nums){
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        while(curr <= p2){
            if(nums[curr] == 0){
                int tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            }
            else if(nums[curr] == 2){
                int tmp = nums[curr];
                nums[curr] = nums[p2--];
                nums[p2--] = tmp;
            }
            else curr++;
        }
    }
}