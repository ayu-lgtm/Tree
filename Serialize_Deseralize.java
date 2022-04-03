import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }
}

public class Serialize_Deseralize {
    static int index = 0;

    public static Node Deserialize(int arr[]) {
        if (arr.length == index)
            return null;

        int data = arr[index];
        index++;
        if (data == -1) {
            return null;
        }
        

        Node temp = new Node(data);
        temp.left = Deserialize(arr);
        temp.right = Deserialize(arr);

        return temp;

    }

    public static void printInorder(Node head) {
        if (head != null) {
            printInorder(head.left);
            System.out.print(head.data + " ");
            printInorder(head.right);
        }
    }

    static  ArrayList<Integer> al = new ArrayList<>();
    public static void Seralize(Node head){
        if(head==null){
            al.add(-1);
            return;
        }
        Seralize(head.left);
        al.add(head.data);
        Seralize(head.right);
        
    }
    public static void main(String args[]) {
        int arr[] = { 10, 20, -1, -1, 30, -1, -1 };
        Node head = null;
        head = Deserialize(arr);

        printInorder(head);

        Seralize(head);
        System.out.print(al);
    }
}
