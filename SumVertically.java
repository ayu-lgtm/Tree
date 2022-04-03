import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class SumVertically {
    public static void verticalSum(Node head, int h, TreeMap<Integer, Integer> mp) {
        if (head == null)
            return;
        verticalSum(head.left, h - 1, mp);
        int sum = (mp.get(h) == null) ? 0 : mp.get(h);
        mp.put(h, sum + head.data);
        verticalSum(head.right, h + 1, mp);
    }

    public static void main(String args[]) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        verticalSum(head, 0, mp);

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());

        }
    }
}
