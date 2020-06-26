class Solution{
    public int sumToLeaf(TreeNode node, int s){
        return sum(node, 0);
    }
    public int sum(TreeNode n, int s){
        if(n == null) return 0;
        if(n.left == null && n.right == null) return s*10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}