public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
    if(root == null)
        return null;

    if(root.val <= p.val){
        return inorderSuccessor(root.right, p);
    }
    else{
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null) ? left : root;
    }
}

public TreeNode inorderSuccessor2(TreeNode root, TreeNode p){
    TreeNode succ = null;
    while(root != null){
        if(p.val < root.val){
            succ = root;
            root = root.left;
        }
        else{
            root = root.right;
        }
    }
    return succ;
}