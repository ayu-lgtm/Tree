import java.util.ArrayList;
import java.util.TreeSet;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }

}

public class Ceiling_of_left_Side {
    public static void ceiling_left_side(ArrayList<Integer> al,int n){
        TreeSet<Integer> ts = new TreeSet<>();
        
        System.out.print(-1+" ");
        ts.add(al.get(0));//smaller which is greater or equal to given element
        for(int i=1;i<n;i++){
            System.out.print(ts.ceiling(al.get(i))+"-");
            if(ts.ceiling(al.get(i)) != null){
                System.out.print(ts.ceiling(al.get(i))+" ");
            }
            else{
                System.out.print(-1+" ");
            }

            ts.add(al.get(i));
        }

    }
    public static void preorder(Node head, ArrayList<Integer> al) {
        if (head == null)
            return;
        al.add(head.data);
        preorder(head.left, al);
        
        preorder(head.right, al);
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

        preorder(head, al);
        System.out.println(al);
        ceiling_left_side(al,al.size());
    }
}
