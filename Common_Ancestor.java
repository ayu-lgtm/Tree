class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;

    }
}

public class Common_Ancestor {
    public static Node common(Node head,int m ,int n){
        if(head==null)return null;
        if(head.data==m||head.data==n){
            return head;

        }
        Node lca1 = common(head.left, m, n);
        Node lca2 = common(head.right, m, n);

        if(lca1!=null && lca2!=null){
            return head;
        }
        if(lca1!=null){
            return lca1;
        }else{
            return lca2;
        }


    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Node p=common(head,4,5);
        System.out.print(p.data);
    }
}
