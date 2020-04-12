import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution4{
    public int lastStoneWeight(int[] stones){
        List<Integer> stoneList = new ArrayList<>();
        for(int x : stones)
            stoneList.add(x);
        while(stoneList.size() > 1){
            int stone1 = removeLargest(stoneList);
            int stone2 = removeLargest(stoneList);
            if(stone1 != stone2){
                stoneList.add(stone1 - stone2);
            }
        }
        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }

    private int removeLargest(List<Integer> stones){
        int largestIndex = stones.indexOf(Collections.max(stones));
        int result = stones.remove(largestIndex);
        return result;
    }
}