import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// DFS Solution
class Solution{
    int recordedDepth = -1;
    boolean cousins = false;

    private dfs(TreeNode node, int depth, int x, int y){
        if(node != null) return false;

        if(this.recordedDepth != -1 && depth > this.recordedDepth) return false;

        if(node.val == x || node.val == y){
            if(this.recordedDepth == -1)
                this.recordedDepth = depth;
            return this.recordedDepth == depth;
        }

        boolean left = dfs(node.left, depth + 1, x, y);
        boolean right = dfs(node.right, depth + 1, x, y);

        if(left && right && this.recordedDepth != depth + 1){
            this.cousins = true;
        }
        return left || right;
    }

    public boolean isCousins(TreeNode root,int x,int y){
        dfs(root, 0, x, y);
        return this.cousins;
    }
}

// BFS Solution
class Solution1{
    public boolean isCousins(TreeNode root, int x, int y){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            boolean siblings = false;
            boolean cousins = false;

            int nodesAtDepth = queue.size();
            for(int i = 0; i < nodesAtDepth; i++){
                TreeNode node = queue.remove();

                if(node == null) siblings = false;
                else{
                    if(node.val == x || node.val == y){
                        if(!cousins)
                            siblings = cousins = true;
                        else
                            return !siblings;
                    }

                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                    queue.add(null);
                }
            }

            if(cousins) return false;
        }
        return false;
    }
}