class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left=null;
        right=null;
    }
}

public class DiaMeter {
    
    public static void main(String args[]) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        
        System.out.println("Height: "+height(head));
    	System.out.println("Diameter: "+res);
    }
    static int res=0;
    public static int height(Node root){
        if(root==null)
            return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        res=Math.max(res,1+lh+rh);
        
        return 1+Math.max(lh,rh);
    } 
}
