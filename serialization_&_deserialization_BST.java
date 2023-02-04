/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        if(root==null){
            return null;
        }
        else{
            s.push(root);
            while(!s.isEmpty()){
            TreeNode t = s.pop();
            if(t==null){
                list.add("#");
            }
            else{
                list.add(""+t.val);
                s.push(t.right);
                s.push(t.left);
            }
            
            }

        }
        System.out.println(list);
        return String.join(",",list);
    
    }
    int t;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    if(data==null){
        return null;
    }
    String[] arr = data.split(",");
    t = 0;
    TreeNode root = helper(arr);
    return root;
    }
    public TreeNode helper(String[] arr){
        if(arr[t].equals("#")){
            return null;
        }
        
            TreeNode root = new TreeNode(Integer.parseInt(arr[t]));
            t++;
            root.left = helper(arr);
            t++;
            root.right = helper(arr);
        
        

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));