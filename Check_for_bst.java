
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Check_for_bst {
    public static boolean Check_bst(Node root, int min, int max) {
        if (root == null)
            return true;
        return ((root.data > min && root.data <= max) && Check_bst(root.left, min, root.data)
                && Check_bst(root.right, root.data, max));
    }

    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        System.out.print(Check_bst(head, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}
