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
 import java.util.Queue;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        boolean isforward =true;
        q.add(root);
        while(q.size()>0){
            List<Integer> b=  new ArrayList<>();
            int n = q.size();
            for(int i =0 ; i < n;i++){
                TreeNode temp = q.peek();
                if(isforward&&temp!=null){
                    b.add(temp.val);
                    
                }
                else if(!isforward && temp!=null){
                    b.add(0,temp.val);
                }
                if(temp!=null){
                    if(temp.left!=null){
                        q.add(temp.left);
                    }
                    if(temp.right!=null){
                        q.add(temp.right);
                    }
                }
                q.remove(temp);
            }
            isforward = isforward==true ? false : true;
            if(b.size()>0)
            list.add(b);
        }
        return list;
    }
}