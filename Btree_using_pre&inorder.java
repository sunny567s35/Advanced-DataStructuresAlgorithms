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
//  */
class Solution {
    public static int pindex=0;
    HashMap<Integer,Integer> map;

    public  TreeNode TreeBuilder(int start , int end ,int[] preorder) {
      
        if( pindex >= preorder.length){
            return null;
        }
        int rootval = preorder[pindex++];
        TreeNode root = new TreeNode(rootval); 
        int index = map.get(rootval);
        if(index - start >0)root.left = TreeBuilder(start,index-1,preorder);
        if(end - index>0)root.right = TreeBuilder(index+1,end,preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            pindex =0;
             map =new HashMap<Integer,Integer>();
            for(int i =0 ; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
           
            return TreeBuilder(0,preorder.length-1,preorder);
    }
}