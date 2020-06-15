class Solution{
    public searchBst(TreeNode root, int val){
        if(root == null)
            return null;
        if(val > root.val) return searchBST(root.right, val);
        if(val < root.val) return searchBST(root.left, val);
        if(val == root.val) return root;
        return null;
    }
}

class Solution1 {
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null || val == root.val) return root;
  
      return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
  }