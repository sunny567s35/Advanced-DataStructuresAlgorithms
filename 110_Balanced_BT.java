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
 import java.lang.Math.*;
 
class Solution {
    public int computeHeight(TreeNode n){
        if (n==null){
            return 0;
        }
        return 1+ Math.max(computeHeight(n.left),computeHeight(n.right));
    }
    public boolean isBalanced(TreeNode root) {
       int lh,rh;
       if(root==null){
           return true;
       }
        lh = computeHeight(root.left);
        rh = computeHeight(root.right);

        if(Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
       return false;
    }
}