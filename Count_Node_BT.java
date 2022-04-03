
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;

    }
}

public class Count_Node_BT {
    public static int count(Node head) {
        if (head == null)
            return 0;
        Node curr = head;
        int lh = 0, rh = 0;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = head;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }
        if (lh == rh) {
            return ((int) Math.pow(2, lh)) - 1;
        }
        return 1 + count(head.left) + count(head.right);
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        System.out.print(count(head));
    }
}
