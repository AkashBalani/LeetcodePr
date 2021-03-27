public class Solution {
    public boolean pathSum(TreeNode root, int target){
        return sum(root, 0, target);
    }
    public boolean sum(TreeNode root, int currSum, int target){
        boolean left = false;
        boolean right = false;
        if(root == null)
            return false;
        currSum += root.val;
        if(sum == target && root.left == null && root.right == null)
            return true;
        if(root.left != null)
            left = sum(root.left, currSum, target);
        if(root.right != null)
            right = sum(root.right, currSum, target);
        return left||right;
    }
}
