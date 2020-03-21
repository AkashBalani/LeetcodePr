// Accepted Solution
// Uses DFS approach

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
class Solution{
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return java.lang.Math.max(left_height, right_height) + 1;
    }
}