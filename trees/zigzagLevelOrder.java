class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        
        if(root == null){
            return list;
        }
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> subList = new ArrayList<>(count);
            
            for(int i = 0; i < count; i++){
                TreeNode temp = queue.poll();
                subList.add(temp.val);
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            if(level % 2 == 0)
                Collections.reverse(subList);
            level++;
            list.add(subList);
        }
        return list;
    }
}