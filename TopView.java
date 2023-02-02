/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void topView(Node root) {
        class qobj{
            Node node ;
            int index;
            qobj(Node node, int indx){
                this.node = node;
                this.index = indx;
            }
        }
    	Queue<qobj> view = new LinkedList<qobj>();
        Map<Integer,Node> map = new TreeMap<>();
    	if(root ==null){
            return ;
        }
        else{
            qobj obj = new qobj(root,0);
            view.add(obj);
            
        }
        while(!view.isEmpty()){
            qobj temp  = view.poll();
            if(!map.containsKey(temp.index)){
                map.put(temp.index,temp.node);
            }
            if(temp.node.left!=null ){
                view.add(new qobj(temp.node.left,temp.index-1));
            }
            if(temp.node.right!=null ){
                view.add(new qobj(temp.node.right,temp.index+1));
            }
        }
        for(Map.Entry<Integer,Node>  i : map.entrySet()){
            System.out.print(i.getValue().data +" ");
        }
      
    }