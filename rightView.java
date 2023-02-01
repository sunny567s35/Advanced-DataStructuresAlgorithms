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
 *      L=   this.right = right;
 *     }
 * }
 */

 import java.util.*;
class rightView {
   
    public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode> s = new LinkedList<>();
        s.add(root);
       
        List<Integer> rviewElement = new ArrayList<>();
        if(root==null){
        return rviewElement;

        }
        
        TreeNode node =s.peek();
        while(!s.isEmpty() && node!=null){
            
            
            int n = s.size();
            for(int i =0;i<n;i++){
                 node =s.peek();
                s.poll();
                if(node.left!=null){
                    s.add(node.left);
                }
                if(node.right!=null){
                    s.add(node.right);
                }
                
               
               }

                rviewElement.add(node.val);
            }

                 return rviewElement;
            

        }

    }
