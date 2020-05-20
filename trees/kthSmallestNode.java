import java.util.ArrayList;

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