class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Childrensum {
    public static boolean sum(Node head){
        if(head==null)return true;
        if(head.left==null && head.right==null){
            return true;
        }
        int Ssum=0;
        if(head.left!=null){
            Ssum += head.left.data;
        }
        if(head.right!=null){
            Ssum += head.right.data;

        }
        return ((head.data==Ssum) && sum(head.left) && sum(head.right));
        
    }
    public static void main(String args[]) {
        Node head = new Node(20);
        head.left = new Node(8);
        head.right = new Node(12);
        head.left.left = new Node(3);
        head.left.right = new Node(5);
        
        System.out.print("Possible :"+sum(head));
    }
}
