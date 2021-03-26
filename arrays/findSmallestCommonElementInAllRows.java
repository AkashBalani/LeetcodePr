public class Solution {
    public int smallestCommonElement(int[][] mat) {
        if(mat.length == 0) return -1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(i == 0){
                    map.put(mat[0][j], 1);
                }
                else{
                    if(map.containsKey(mat[i][j])){
                        map.put(mat[i][j], map.get(mat[i][j]) + 1);
                    }
                }
            }
        }
        
        for(Map.Entry<Integer, Integer> itr: map.entrySet()){
            if(itr.getValue() == mat.length)
                return itr.getKey();
        }
        // 0. Return something
        return -1;
    }
}

// Using Binary Search
public class Solution1{
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                found = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }
            if (found) {
                return mat[0][j];
            }
        }
        return -1;
    }
}