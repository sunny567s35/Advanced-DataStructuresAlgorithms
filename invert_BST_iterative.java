class Solution {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null){
            return null;
        }
        q.add(root);
        while(!q.isEmpty()){
                TreeNode temp = q.poll();
                TreeNode ans = temp.left;
                temp.left = temp.right;
                temp.right = ans;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
        }

    return root;
    }
}