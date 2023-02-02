/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeastCommonAncestor {
    private List<TreeNode> path1 = new ArrayList<>();
    private List<TreeNode> path2 = new ArrayList<>();

    public boolean findPath(TreeNode root , int p, List<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.val == p || findPath(root.left, p ,path) || findPath(root.right,p,path)){
            return true;
        }
        path.remove(root);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root,p.val,path1) ;
        findPath(root,q.val,path2);
        int i;
        for( i=0 ;i <path1.size() && i<path2.size();i++){
            if(!path1.get(i).equals(path2.get(i))){
                break;
            }
        }
        return path1.get(i-1);
        
    }
}