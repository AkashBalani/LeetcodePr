// First Attempt
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }
}

// Accepted Solution
class Solution {
    public static int minDepth(TreeNode root) {
	    if (root == null)	return 0;
	    if (root.left == null)	return minDepth(root.right) + 1;
	    if (root.right == null) return minDepth(root.left) + 1;
	    return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
}