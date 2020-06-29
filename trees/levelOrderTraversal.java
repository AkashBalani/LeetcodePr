import java.util.ArrayList;

import javax.swing.tree.TreeNode;

import sun.misc.Queue;

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

class Solution1{
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null) return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            levels.add(new ArrayList<Integer>());

            int level_length = queue.size();
            for(int i = 0; i < level_length; i++){
                TreeNode node = queue.remove();

                levels.get(level).add(node.val);

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            level++;
        }
    }
}