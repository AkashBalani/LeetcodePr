import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

// Accepted Solution
class Solution1{
    class LRUCache extends LinkedHashMap<Integer, Integer>{
        private int capacity;

        public LRUCache(int capacity){
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key){
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value){
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest){
            return size() > capacity;
        }
    }
}

class Solution2{
    public class LRUCache {

        class DLinkedNode {
          int key;
          int value;
          DLinkedNode prev;
          DLinkedNode next;
        }
      
        private void addNode(DLinkedNode node) {
          /**
           * Always add the new node right after head.
           */
          node.prev = head;
          node.next = head.next;
      
          head.next.prev = node;
          head.next = node;
        }
      
        private void removeNode(DLinkedNode node){
          /**
           * Remove an existing node from the linked list.
           */
          DLinkedNode prev = node.prev;
          DLinkedNode next = node.next;
      
          prev.next = next;
          next.prev = prev;
        }
      
        private void moveToHead(DLinkedNode node){
          /**
           * Move certain node in between to the head.
           */
          removeNode(node);
          addNode(node);
        }
      
        private DLinkedNode popTail() {
          /**
           * Pop the current tail.
           */
          DLinkedNode res = tail.prev;
          removeNode(res);
          return res;
        }
      
        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;
      
        public LRUCache(int capacity) {
          this.size = 0;
          this.capacity = capacity;
      
          head = new DLinkedNode();
          // head.prev = null;
      
          tail = new DLinkedNode();
          // tail.next = null;
      
          head.next = tail;
          tail.prev = head;
        }
      
        public int get(int key) {
          DLinkedNode node = cache.get(key);
          if (node == null) return -1;
      
          // move the accessed node to the head;
          moveToHead(node);
      
          return node.value;
        }
      
        public void put(int key, int value) {
          DLinkedNode node = cache.get(key);
      
          if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
      
            cache.put(key, newNode);
            addNode(newNode);
      
            ++size;
      
            if(size > capacity) {
              // pop the tail
              DLinkedNode tail = popTail();
              cache.remove(tail.key);
              --size;
            }
          } else {
            // update the value.
            node.value = value;
            moveToHead(node);
          }
        }
      }
}