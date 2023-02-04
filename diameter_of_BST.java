/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int l = 1+height(node.left);
        int r = 1+height(node.right);
       
        return Math.max(l,r);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int l,r;int maxdim = 0;
        if(root==null){
            return 0;
        }
        
        else{
            Stack<TreeNode> s = new Stack<>();
            s.push(root);
            
            TreeNode node = s.peek();
            while(!s.isEmpty() && node!=null){
                node = s.pop();
                if(node.left!=null){
                    s.push(node.left);
                }
                if(node.right!=null){
                    s.push(node.right);
                }
                l = height(node.left);
                r = height(node.right);
                maxdim = Math.max(l+r,maxdim);
            
            }
        }
        return maxdim;

    }
}