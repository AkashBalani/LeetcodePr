class Solution1{
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x; }
    }
    public ListNode middleElement(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while(fast != null){
            fast = fast.next;
            i += 1;
            if(i % 2 == 0) slow = slow.next;
        }
        return slow;
    }
}