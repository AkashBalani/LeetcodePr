class Solution {
    public boolean helper(TreeNode node, Integer lower, Integer upper) {
      if (node == null) return true;
  
      int val = node.val;
      if (lower != null && val <= lower) return false;
      if (upper != null && val >= upper) return false;
  
      if (! helper(node.right, val, upper)) return false;
      if (! helper(node.left, lower, val)) return false;
      return true;
    }
  
    public boolean isValidBST(TreeNode root) {
      return helper(root, null, null);
    }
  }

  class Solution1 {
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(),
            lowers = new LinkedList();
  
    public void update(TreeNode root, Integer lower, Integer upper) {
      stack.add(root);
      lowers.add(lower);
      uppers.add(upper);
    }
  
    public boolean isValidBST(TreeNode root) {
      Integer lower = null, upper = null, val;
      update(root, lower, upper);
  
      while (!stack.isEmpty()) {
        root = stack.poll();
        lower = lowers.poll();
        upper = uppers.poll();
  
        if (root == null) continue;
        val = root.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        update(root.right, val, upper);
        update(root.left, lower, val);
      }
      return true;
    }
  }

  class Solution2 {
    public boolean isValidBST(TreeNode root) {
      Stack<TreeNode> stack = new Stack();
      double inorder = - Double.MAX_VALUE;
  
      while (!stack.isEmpty() || root != null) {
        while (root != null) {
          stack.push(root);
          root = root.left;
        }
        root = stack.pop();
        // If next element in inorder traversal
        // is smaller than the previous one
        // that's not BST.
        if (root.val <= inorder) return false;
        inorder = root.val;
        root = root.right;
      }
      return true;
    }
  }