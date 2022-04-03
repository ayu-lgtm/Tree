class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Left_view {
    static int maxlevel = 0;

    public static void leftview(Node head, int level) {
        if (head == null)
            return;
        if (maxlevel < level) {
            System.out.print(head.data + " ");
            maxlevel = level;
        }
        leftview(head.left, level + 1);
        leftview(head.right, level + 1);
    }

    static int maxxlevel = 0;

    public static void rightview(Node head, int level) {
        if (head == null)
            return;
        if (maxxlevel < level) {
            System.out.print(head.data + " ");
            maxxlevel = level;
        }
        rightview(head.right, level + 1);
        rightview(head.left, level + 1);

    }

    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        leftview(head, 1);
        System.out.println();
        rightview(head, 1);
    }
}
