import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// Fails when the value is never used
class Solution{
    class LRU{
        int cap = 0;
        Map<Integer, Integer> map;
        Deque<Integer> deque;

        public LRUCache(int capacity){
            cap = capacity;
            map = new HashMap<>(capacity);
            deque = new ArrayDeque<Integer>();
        }

        public int get(int key){
            int value = map.getOrDefault(key, -1);
            if(value != -1){
                if(deque.contains(value)) deque.removeFirstOccurance(value);
                deque.addFirst(value);
            }
            return value;
        }

        public int put(int key, int value){
            if(map.size() == cap){
                int remValue = deque.removeFirst();
                int strValue = 0;
                for(Map.Entry entry: map.entrySet()){
                    if(remValue == (int)entry.getValue()){
                        strKey = (int)entry.getKey();
                        break;
                    }
                }
                map.remove(strKey);
            }
            map.put(key, value);
        }
    }
}