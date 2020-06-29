public class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(ListNode node, int level){
        if(levels.size() == level)
            levels.add(new ArrayList<>);

        levels.get(level).add(node.val);

        if(node.left != null)
            helper(node.left, level + 1);

        if(node.right != null)
            helper(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        if(root == null) return 0;
        helper(root, 0);
        return levels;
    } 
}