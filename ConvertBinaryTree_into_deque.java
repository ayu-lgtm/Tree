class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class ConvertBinaryTree_into_deque {
    static Node prev = null;

    public static Node dequechange(Node head) {
        if (head == null)
            return null;
        Node temp = dequechange(head.left);
        if (prev == null) {
            temp = head;
        } else {
            head.left = prev;
            prev.right = head;

        }
        prev = head;
        dequechange(head.right);
        return temp;
    }

    public static void main(String args[]) {

        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        dequechange(head);

    }
}
