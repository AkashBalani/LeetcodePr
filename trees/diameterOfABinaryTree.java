class Solution2{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){ val = x; }
    }
    int numberOfNodes;
    public int diameterOfBinaryTree(TreeNode root){
        numberOfNodes = 1;
        depth(root);
        return numberOfNodes - 1;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        numberOfNodes = Math.max(numberOfNodes, L + R + 1);
        return Math.max(L, R) + 1;
    }
}