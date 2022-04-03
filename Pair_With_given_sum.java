import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Pair_With_given_sum {

    public static boolean PairSum(Node head, int sum, HashSet<Integer> hs) {
        if (head == null)
            return false;
        if (PairSum(head.left, sum, hs) == true)
            return true;
        if (hs.contains(sum - head.data) == true)
            return true;
        hs.add(head.data);
        return PairSum(head.right, sum, hs);
    }

    public static void main(String args[]) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(7);

        HashSet<Integer> hs = new HashSet<>();
        System.out.print(PairSum(head, 9, hs));

    }
}
