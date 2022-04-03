import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Kth_Smallest_in_Bst {
    public static void inorder(Node head, ArrayList<Integer> al) {
        if (head == null)
            return;
        inorder(head.left, al);
        al.add(head.data);
        inorder(head.right, al);
    }

    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);
        ArrayList<Integer> al = new ArrayList<>();
        inorder(head, al);
        System.out.println(al);

        int k = 3;
        System.out.println(k + "th_Smallest :" + al.get(k - 1));

    }
}
