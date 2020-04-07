import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Accepted Solution

class Solution2 {
    public int countElements(int arr[]){
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int totalCount = 0;
        for(int i = 0; i < arr.length; i++){
            int res = map.get(arr[i]);
            if(map.containsKey(arr[i] + 1)){
                totalCount += res;
                map.put(arr[i], 0);
            }
        }
        return totalCount;
    }
}

// Accepted Solution
class Solution3{
    public int countElements(int arr[]){
        Set<Integer> set = new HashSet<>();
        for(int x : arr){
            set.add(x);
        }
        int count = 0;
        for(int x : arr){
            if(set.contains(x + 1)) count += 1;
        }
        return count;
    }
}