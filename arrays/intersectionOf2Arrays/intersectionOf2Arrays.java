import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Improved Solution
// Passed all testcases

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i]) + 1);
            else map.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            r[i] = result.get(i);
        }
        return r;
    }
}


// Accepted Solution looks more beautiful
class Solution1{
    public int[] intersect(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int k = 0;
        for(int i : nums2){
            int cnt = map.getOrDefault(i, 0);
            if(cnt > 0){
                nums1[k++] = i;
                map.put(i, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}

class Solution2{
    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]) ++i;
            else if(nums1[i] > nums2[j]) ++j;
            else{
                nums1[k++] = nums2[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}