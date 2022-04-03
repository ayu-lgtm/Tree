import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;

    }
}

class Pair {
    int val;
    Node node;

    Pair(Node n, int x) {
        val = x;
        node = n;
    }
}

public class BottomView {
    public static void bottomview(Node head) {
        if (head == null)
            return;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(head, 0));
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        while (q.isEmpty() == false) {
            Pair p = q.poll();
            Node curr = p.node;
            int val = p.val;
            tm.put(val, curr.data);
            if (curr.left != null) {
                q.add(new Pair(curr.left, val - 1));
            }
            if (curr.right != null) {
                q.add(new Pair(curr.right, val + 1));
            }
        }

        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            System.out.print(e.getValue() + " ");
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
        bottomview(head);
    }
}
