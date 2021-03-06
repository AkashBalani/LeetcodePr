// Accpeted Solution
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
	public ListNode() {
	}
}

class Solution{
	public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode temp = new ListNode();
		temp.next = head;
		ListNode fast = temp;
		ListNode slow = temp;
		for(int i = 0; i <= n; i++){
			fast = fast.next;
		}
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return temp.next;
	}
}
