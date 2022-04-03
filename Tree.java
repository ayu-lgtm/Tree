import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

class Pair {
    int x;
    Node node;

    Pair(Node n, int v) {
        node = n;
        x = v;
    }
}

class Tree {
    public static void verticalView(Node head) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        q.add(new Pair(head, 0));
        while (q.isEmpty() == false) {
            Pair x = q.poll();
            Node temp = x.node;
            int data = x.x;
            if (tm.containsKey(data)) {
                tm.get(data).add(temp.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(temp.data);
                tm.put(data, al);
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, data - 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, data + 1));
            }

        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : tm.entrySet()) {
            System.out.print(e.getKey() + " " + e.getValue()+" ");
            int sum=0;
            for(Integer k:e.getValue()){
                sum+=k;
            }
            System.out.println("Sum :"+sum);
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

        verticalView(head);
    }
}