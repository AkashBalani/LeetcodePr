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