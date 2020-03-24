import java.util.Arrays;

// Learning example
class Solution{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

// Time Complexity O(m + n)
// Space Complexity O(m)
class Solution1{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0, p2 = 0, p = 0;
        while((p1 < m) && (p2 < n)){
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1[p1++] : nums2[p2++];
        }

        if(p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p, m + n - p);
        if(p2 < n)
            System.arraycopy(nums2, p2, nums1, p, m + n - p);
    }
}

class Solution2{
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1, p = nums1.length - 1;
        
        while( (p1 >= 0) && (p2 >= 0) )
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];

        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }
}