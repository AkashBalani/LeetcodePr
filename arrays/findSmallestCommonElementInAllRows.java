// Passed 10/12
class Solution {
    public int smallestCommonElement(int[][] mat) {
        // 1. Take the first array into hashmap
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
        return 0;
    }
}