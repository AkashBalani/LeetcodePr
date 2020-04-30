class Solution{
    public boolean isValidSequence(TreeNode root, int[] arr){
        if(root == null) return arr.length == 0;
        return isValid(root, arr, 0);
    }

    boolean isValid(TreeNode root, int[] arr, int idx){
        if(root.val != arr[idx]) return false;
        if(idx == arr.length - 1) return root.left == null && root.right == null;
        return ( (root.left != null && isValid(root.left, arr, idx + 1)) || (root.right != null && isValid(root.right, arr, idx + 1)) );
    }
}