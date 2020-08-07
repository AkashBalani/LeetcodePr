class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);
        while(Q.size() > 0){
            int size = Q.size();
            for(int i = 0; i < size; i++){
                Node node = Q.poll();
                if(i < size - 1)
                    node.next = Q.peek();
                if(node.left != null)
                    Q.add(node.left);
                if(node.right != null)
                    Q.add(node.right);
            }
        }
        return root;
    }
}

class Solution1 {
    public Node connect(Node root) {
        
        if (root == null) {
            return root;
        }
        
        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        Node leftmost = root;
        
        // Once we reach the final level, we are done
        while (leftmost.left != null) {
            
            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the 
            // corresponding links for the next level
            Node head = leftmost;
            
            while (head != null) {
                
                // CONNECTION 1
                head.left.next = head.right;
                
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Progress along the list (nodes on the current level)
                head = head.next;
            }
            
            // Move onto the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}