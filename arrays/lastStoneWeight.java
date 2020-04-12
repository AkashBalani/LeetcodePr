import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

class Solution5{
    public int lastStoneWeight(int[] stones){
        List<Integer> stoneList = new ArrayList<>();
        for(int x : stones)
            stoneList.add(x);
        Collections.sort(stoneList);
        while(stoneList.size() > 1){
            int stone1 = stoneList.remove(stoneList.size() - 1);
            int stone2 = stoneList.remove(stoneList.size() - 1);
            if(stone1 != stone2){
                int newStone = stone1 - stone2;
                int index = Collections.binarySearch(stoneList, newStone);
                if(index < 0){
                    stoneList.add(- index - 1, newStone);
                }
                else{
                    stoneList.add(index, newStone);
                }
            }
        }
        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }
}

class Solution6{
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x : stones)
            heap.add(x);
        
        while(heap.size() > 1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();
            if(stone1 != stone2){
                heap.add(stone1 - stone2);
            }
        }
        return heap.isEmpty() ? 0 : heap.remove();
    }
}