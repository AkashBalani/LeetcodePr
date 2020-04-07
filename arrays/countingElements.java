import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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