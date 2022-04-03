class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}
public class Check_for_balancetree {
    public static int check(Node head){
        if(head==null)return 0;
        int lh=check(head.left);
        if(lh==-1)return -1;
        int rh=check(head.right);
        if(rh==-1)return -1;
        if(Math.abs(lh-rh)>1)return -1;
        return 1+Math.max(lh,rh);
    }
    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        System.out.print("Balance :"+check(head));
    }
}
