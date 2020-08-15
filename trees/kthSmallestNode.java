import java.util.ArrayList;
import java.util.LinkedList;

class Solution{
    public int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> num = inorder(root, new ArrayList<Integer>());
        return num.get(k - 1);
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}

// Iterative Solution
class Solution1{
    public int kthSmallest(TreeNode root, int k){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}