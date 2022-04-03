
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Spiral_Traversal {
    // static ArrayList<Integer> al = new ArrayList<>();
    /*
     * public static void spiral(Node head) {
     * Queue<Node> q = new LinkedList<>();
     * q.add(head);
     * Stack<Integer> st = new Stack<>();
     * 
     * boolean b = true;
     * 
     * while (q.isEmpty() == false) {
     * int s = q.size();
     * 
     * for (int i = 0; i < s; i++) {
     * 
     * Node temp = q.poll();
     * if (b == false) {
     * st.push(temp.data);
     * } else {
     * System.out.print(temp.data + " ");
     * }
     * if (temp.left != null) {
     * q.add(temp.left);
     * }
     * if (temp.right != null) {
     * q.add(temp.right);
     * }
     * }
     * 
     * if (b == false) {
     * while (st.isEmpty() == false) {
     * System.out.print(st.pop() + " ");
     * }
     * }
     * b = !b;
     * System.out.println();
     * 
     * }
     * }
     */
    public static void spiral(Node head) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(head);
        while (st1.isEmpty() == false || st2.isEmpty() == false) {
            while (st1.isEmpty() == false) {
                Node temp = st1.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    st2.push(temp.left);
                }
                if (temp.right != null) {
                    st2.push(temp.right);
                }
            }
            System.out.println();
            while (st2.isEmpty() == false) {
                Node temp = st2.pop();
                if (temp.right != null) {
                    st1.push(temp.right);
                }
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    st1.push(temp.left);
                }

            }
            System.out.println();
        }

    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.left.left.left = new Node(8);
        head.left.left.right = new Node(9);
        head.right.left.left = new Node(10);
        head.right.left.right = new Node(11);
        spiral(head);
    }
}
