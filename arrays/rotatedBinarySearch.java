class Solution{
    public int search(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[end]) end = mid - 1;
                else start = mid + 1; 
            }
            else{
                if(target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
    // Writing another solution just for understanding
    public int search1(int[] nums, int target){
        // Checking the boundary conditions first
        if(nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        // In this loop we are trying to find the smallest element
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid - 1;
        }
        // This should give us the smallest index on left

        int start = left;
        left = 0;
        right = nums.length - 1;

        // For example nums = [4, 5, 6, 7, 0, 1, 2, 3]
        // By this point we have figured out that start will be 4
        // if target is greater than nums[4] = 0 and less than nums[7] = 3
        // then we search on the right side
        // else we search on the left side
        if(target >= nums[start] && target <= nums[right]){
            left = start;
        }
        else
            right = start;

        // From here we will do a simple binary search
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }
}