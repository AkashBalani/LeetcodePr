import jdk.internal.agent.resources.agent;

class Solution{
    public int findMin(int[] nums){
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int i = 0, j = nums.length - 1;
        while(i < j){
            int mid = (i + j) / 2;
            if(arr[mid] > arr[mid + 1])
                return arr[mid + 1];
            if(arr[mid] < arr[mid - 1])
                return arr[mid];
            if(arr[mid] > arr[i])
                i = mid - 1;
            else
                j = mid + 1;
        }
        return -1;
    }
}