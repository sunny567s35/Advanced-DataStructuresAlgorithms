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
    int height(TreeNode node){
        int l ,r,h;
        h=0;
        l=0;r=0;
        if(node==null){
            return 0;
        }
        
        l = height(node.left);
        r = height(node.right);
        if(r==0&&l>0){
            h=l;
        }else{
        h = l==0 ? r: (l<r ?l : r);}
        return h+1;
        
    }
    
    public int minDepth(TreeNode root) {
        return height(root);
    }
}