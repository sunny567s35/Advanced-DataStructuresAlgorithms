/* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
public static void inorder(Node root){
    if( root ==null){
        return ;
    }System.out.println(root.data);
    inorder(root.left);
    
    inorder(root.right);
}
	public static Node insert(Node root,int data) {
        if(root==null){
            root = new Node(data);
            return root;
        }
        Node temp = root;
        Stack<Node> s = new Stack<>();
        s.push(root);
        int dir =0;
        Node pre = temp;
        Node node= s.peek();
        while(!s.isEmpty()&&node!=null){
            pre = node;
             node = s.peek();
            s.pop();
            if(node.data < data){
            	 dir =1;
                if(node.right!=null)
                s.push(node.right);
            }if(node.data > data){
                 dir =0;
                if(node.left!=null)
                s.push(node.left);
            }
        }
        if(dir==1&&node!=null){
           
             
             node.right = new Node(data);
            
        }
        else if(dir==0&&node!=null){
           
            node.left = new Node(data);
        }
        
        
        return temp;
        		 
    	
    }