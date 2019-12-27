// Initial Solution
// Passed some testcases

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    res[count] = nums1[i];
                    nums2[j] = Integer.MAX_VALUE;
                    count++;
                }    
            }
        }
        return res;
    }
}