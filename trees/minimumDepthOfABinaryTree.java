// First Attempt
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }
}