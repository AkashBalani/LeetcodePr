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

// More Advanced
class Solution {

    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class Solution3 {
    public static boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
          fast = fast.next.next;
          slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        while(slow != null){
          if(fast.val != slow.val)
            return false;
          slow = slow.next;
          fast = fast.next;
        }
      return true;
      }
      public static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
          ListNode next = head.next;
          head.next = prev;
          prev = head;
          head = next;
        }
        return prev;
      }
}