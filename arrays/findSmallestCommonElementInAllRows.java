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

// Slight improvement to the above solution
public class Solution2{
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int pos[] = new int[n];
        for (int j = 0; j < m; ++j) {
            boolean found = true;
            for (int i = 1; i < n && found; ++i) {
                pos[i] = Arrays.binarySearch(mat[i], pos[i], m, mat[0][j]);
                if (pos[i] < 0) {
                    found = false;
                    pos[i] = -pos[i] - 1;
                    if (pos[i] >= m) {
                        return -1;
                    }
                }
            }
            if (found) {
                return mat[0][j];
            }
        }
        return -1;
    }
}

// Row Positions
public class Solution3{
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int pos[] = new int[n], cur_max = 0, cnt = 0;
        while (true) {
            for (int i = 0; i < n; ++i) {
                while (pos[i] < m && mat[i][pos[i]] < cur_max) {
                    ++pos[i];
                }
                if (pos[i] >= m) {
                    return -1;
                }
                if (mat[i][pos[i]] != cur_max) {
                    cnt = 1;
                    cur_max = mat[i][pos[i]];
                } else if (++cnt == n) {
                    return cur_max;
                }
            }
        }
    }
}