import java.util.LinkedList;

import javax.swing.tree.TreeNode;

// Accepted Solution
// Uses DFS approach

// public class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode(int x){
//         val = x;
//     }
// }
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

// Accepted Solution
// DFS + Iterative
class Solution1{
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        int depth = 0, current_depth = 0;
        stack.add(root);
        depths.add(1);
        while(!stack.isEmpty()){
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if(root != null){
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                depths.add(current_depth + 1);
                stack.add(root.right);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }
}