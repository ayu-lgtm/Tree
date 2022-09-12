
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }
}

class Pair {
    Node x;
    int h;

    Pair(Node a, int b) {
        x = a;
        h = b;
    }
}

public class Main {

    public static void main(String[] args) {

        // System.out.println("Hello World!");
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.left.left = new Node(80);
        root.right.left = new Node(50);
        root.right.right = new Node(60);

        // System.out.println(Maximum_Width(root));
        // Node dL = returnList(root);
        //// Display(dL);

        int inOrder[] = { 40, 20, 50, 10, 30, 80, 70, 90 };
        int preOrder[] = { 10, 20, 40, 50, 30, 70, 80, 90 };

        Node tree = BinaryTree(inOrder, preOrder, 0, inOrder.length - 1);

        // PrintTree(tree);
        // spiralTraversal(tree);

        // System.out.println(Diameter_Of_Tree(tree));
        // System.out.println(lowest_common_Ancestor(tree,30,70).data);

        // System.out.println(countNode(tree));
        // System.out.println();
        ArrayList<Integer> al = new ArrayList<>();
        serialize(tree, al);

        Node res = deserialize(al);

        PrintTree(res);

        // System.out.println();
        VerticalTraverse(tree);

        root = insertNode(root, 10);
        root = insertNode(root, 20);
        root = insertNode(root, 30);
        root = insertNode(root, 40);
        root = insertNode(root, 25);
        root = insertNode(root, 32);
        root = insertNode(root, 48);

        PrintTree(root);

        System.out.println();
        deleteNode(root, 32);
        PrintTree(root);

        System.out.println();
        deleteNode(root, 30);
        PrintTree(root);

    }

    public static void VerticalTraverse(Node root) {
        Queue<Pair> q = new LinkedList<>();

        Map<Integer, ArrayList<Integer>> hm = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (q.isEmpty() == false) {
            Pair p = q.poll();
            Node temp = p.x;
            int hd = p.h;

            if (hm.containsKey(hd)) {
                hm.get(hd).add(temp.data);
            } else {
                ArrayList<Integer> alk = new ArrayList<Integer>();
                alk.add(temp.data);
                hm.put(hd, alk);
            }

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, ArrayList<Integer>> e : hm.entrySet()) {
            int sum = e.getValue().stream().mapToInt(Integer::intValue).sum();
            System.out.println(e.getValue() + "  Sum => " + sum);
        }
    }

    static int index1 = 0;

    public static Node deserialize(ArrayList<Integer> al) {
        if (al.size() == index1)
            return null;

        int data = al.get(index1++);
        if (data == -1) {
            return null;
        }

        Node temp = new Node(data);

        temp.left = deserialize(al);
        temp.right = deserialize(al);

        return temp;

    }

    public static void serialize(Node root, ArrayList<Integer> al) {
        if (root == null) {
            al.add(-1);
            return;
        }

        al.add(root.data);
        serialize(root.left, al);
        serialize(root.right, al);
    }

    public static int countNode(Node root) {
        if (root == null)
            return 0;
        int lh = 0;
        int rh = 0;
        Node curr = root;
        while (curr != null) {
            lh++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rh++;
            curr = curr.right;
        }

        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        } else {
            return 1 + countNode(root.left) + countNode(root.right);
        }
    }

    public static Node lowest_common_Ancestor(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node lc1 = lowest_common_Ancestor(root.left, n1, n2);
        Node lc2 = lowest_common_Ancestor(root.right, n1, n2);

        if (lc1 != null && lc2 != null) {
            return root;
        }
        if (lc1 != null) {
            return lc1;
        } else {
            return lc2;
        }
    }

    public static int Height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(Height(root.left), Height(root.right));
    }

    public static int Diameter_Of_Tree(Node root) {
        if (root == null)
            return 0;

        int d1 = 1 + Height(root.left) + Height(root.right);
        int d2 = Diameter_Of_Tree(root.left);
        int d3 = Diameter_Of_Tree(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }

    public static void spiralTraversal(Node root) {
        if (root == null)
            return;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.add(root);
        while (!st1.isEmpty() || !st2.isEmpty()) {
            while (!st1.isEmpty()) {
                Node temp = st1.pop();
                System.out.print(temp.data + " ");
                if (temp.right != null) {
                    st2.add(temp.right);
                }
                if (temp.left != null) {
                    st2.add(temp.left);
                }
            }

            while (!st2.isEmpty()) {
                Node temp = st2.pop();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    st1.add(temp.left);
                }
                if (temp.right != null) {
                    st1.add(temp.right);
                }

            }
        }
    }

    public static void PrintTree(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (q.isEmpty() == false) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    static int index = 0;

    public static Node BinaryTree(int in[], int pre[], int s, int e) {

        if (s > e) {
            return null;
        }
        Node root = new Node(pre[index++]);

        int idx = s;

        for (int i = s; i <= e; i++) {
            if (in[i] == root.data) {
                idx = i;
                break;
            }
        }

        root.left = BinaryTree(in, pre, s, idx - 1);
        root.right = BinaryTree(in, pre, idx + 1, e);

        return root;

    }

    public static void Display(Node root) {
        if (root == null)
            return;

        while (root != null) {
            System.out.print(root.data + " ");
            root = root.left;
        }
    }

    public static int Maximum_Width(Node root) {
        if (root == null)
            return 0;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        int maxWidth = Integer.MIN_VALUE;
        while (q.isEmpty() == false) {
            int size = q.size();
            maxWidth = Math.max(maxWidth, size);

            for (

                    int i = 0; i < size; i++) {
                Node temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxWidth;
    }

    public static Node res = null;

    public static Node returnList(Node root) {
        if (root == null)
            return root;
        Node temp = returnList(root.left);

        if (res == null) {
            res = temp;
        } else {
            root.left = res;
            res.right = root;
        }

        res = root;
        returnList(root.right);
        return res;

    }

    public static Node insertNode(Node root, int x) {
        if (root == null) {
            return new Node(x);

        }

        else if (root.data > x) {
            root.left = insertNode(root.left, x);
        } else if (root.data < x) {
            root.right = insertNode(root.right, x);
        }

        return root;
    }

    public static Node deleteNode(Node root, int x) {
        if (root == null)
            return null;
        else if (root.data > x) {
            root.left = deleteNode(root.left, x);

        } else if (root.data < x) {
            root.right = deleteNode(root.right, x);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node succ = getSucc(root);
                root.data = succ.data;
                root.right = deleteNode(root.right, succ.data);
            }

        }

        return root;

    }

    public static Node getSucc(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }

}
