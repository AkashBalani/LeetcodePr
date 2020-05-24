import java.util.Arrays;
import java.util.HashMap;

class Solution{
    int pre_idx = 0;
    int[] preorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right){
        if(in_left == in_right)
            return null;

        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;

        root_left = helper(in_left, index);
        root_right = helper(index + 1, in_right);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder){
        this.preorder = preorder;
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);

        int idx = 0;
        for(Integer val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
    }
}