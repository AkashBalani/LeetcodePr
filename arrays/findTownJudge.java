
// Passed all the test cases except one
class Solution {
    public int findJudge(int N, int[][] trust) {
        //int[] new_arr = new int[N];
        List<Integer> alist = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(i + 1, 0);
        }
        for(int[] ch : trust){
            int x = ch[0];
            if(map.get(x) == 0)
                map.put(x, map.get(x) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 0)
                alist.add(entry.getKey());
        }
        if(alist.size() > 1) return -1;
        else if (alist.size() == 1) return alist.get(0);
        return -1;
    }
}