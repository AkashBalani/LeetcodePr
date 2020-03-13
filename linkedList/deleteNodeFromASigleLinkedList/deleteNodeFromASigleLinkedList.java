// In this code we are just given the node to be deleted, no the head node

// This won't work if the node the tail

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public void deleteNode(ListNode node){
		node.val = node.next.val;
		node.next = node.next.next;
	}
}

// Again this fails if this is the tail
