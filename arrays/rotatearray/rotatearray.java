//Brute Force
//Accepted Answer

public class Solution {
    public void rotate(int[] nums, int k) {           //Example nums = [1, 2, 3, 4, 5, 6, 7], k = 4
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
