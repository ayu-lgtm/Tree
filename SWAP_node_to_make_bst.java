class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class SWAP_node_to_make_bst {
    static Node prev=null,second=null;
    static Node first=null;
    public static void Make_bst(Node head){
        if(head==null)return;
        Make_bst(head.left);
        if(prev!=null && head.data<prev.data){
            if(first==null){
                first=prev;
            }
            second=head;
        }
        prev=head;
        Make_bst(head.right);
    }
    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        Make_bst(head);

    }
}
