import java.util.ArrayList;
import java.util.List;

class Solution{
    public boolean isPalindrome(ListNode head){
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            list.add(current.val);
            current = current.next;
        }
        int front = 0;
        int back = list.size() - 1;
        while(front < back){
            if(!list.get(front).equals(list.get(back)))
                return false;
            front++;
            back--;
        }
        return true;
    }
}

// Advanced Solution
class Solution1{
    ListNode front;
    public boolean isPalindrome(ListNode head){
        front = head;
        return recursively(front);
    }
    public boolean recursively(ListNode current){
        if(current != null){
            if(!recursively(current.next)) return false;
            if(current.val != front.val) return false;
            current = current.next;
        }
        return true;
    }
}