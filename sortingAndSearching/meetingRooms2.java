class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] t: intervals){
            map.put(t[0], map.getOrDefault(t[0], 0) + 1);
            map.put(t[1], map.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for(int v: map.values()){
            res = Math.max(res, cur += v);
        }
        return res;
    }
}

/*
    int[] intervals = [[0, 30],[5, 10],[15, 20]]
    map = {(0, 1), (5, 1), (10, -1), (15, 1), (20, -1), (30, -1)}
    minMeetingRooms(intervals)
        for([15, 20] : intervals)
            map.put(15, 1)
                map.getOrDefault(15, 0) + 1 --> 1
            map.put(20, 1)
                map.getOrDefault(20, 0) + 1 --> 1
        res = 1, cur = 0
        for(int -1: values)
            res = max(1, 0)
*/