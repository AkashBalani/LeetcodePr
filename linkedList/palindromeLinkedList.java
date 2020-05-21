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