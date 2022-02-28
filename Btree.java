class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
    }
}

public class Btree {
    public static Node insert(Node root, int x) {
        if (root == null) {
            return new Node(x);
        } else if (root.data < x) {
            root.right = insert(root.right, x);
        } else if (root.data > x) {
            root.left = insert(root.left, x);
        }
        return root;
    }

    public static void PrintInorder(Node root) {
        if (root != null) {
            PrintInorder(root.left);
            System.out.print(root.data + " ");
            PrintInorder(root.right);
        }
    }

    public static Node IterativeWay(Node root, int x) {
        Node temp = new Node(x);
        Node parent = null, curr = root;

        while (curr != null) {
            parent = curr;
            if (curr.data == x) {
                return root;
            } else if (curr.data > x) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (parent == null) {
            return temp;
        } else if (parent.data > x) {
            parent.left = temp;
        } else {
            parent.right = temp;
        }

        return root;
    }

    public static Node Delete(Node root,int x){
        if(root==null)return null;
        else if(root.data>x){
            root.left=Delete(root.left, x);
        }
        else if(root.data<x){
            root.right=Delete(root.right, x);
        }
        else{
            if(root.left==null)return root.right;
            else if(root.right==null)return root.left;
            else{
                Node succ = getSucc(root);
                root.data=succ.data;
                root.right=Delete(root.right, succ.data);
            }
        }
        return root;
    }
    //succesor of Node
    public static Node getSucc(Node root){
        Node curr=root.right;
        while(curr!=null && curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }

    //Floor of Node
    public static Node Floor(Node root,int x){
        Node res=null;
        while(root!=null){
            if(root.data==x){
                return root;
            }
            else if(root.data>x){
                root=root.left;
            }
            else{
                res=root;
                root=root.right;
            }
        }
        return res;
    }
    //ceil value
    public static Node Ceil(Node root,int x){
        Node res = null;
        while(root!=null){
            if(root.data==x){
                return root;
            }
            else if(root.data<x){
                root=root.right;
            }
            else{
                res=root;
                root=root.left;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Node root = null;
        root = insert(root, 4);
        root = insert(root, 1);
        root = insert(root, 2);
        root = insert(root, 3);
        root = insert(root, 6);
        root = insert(root, 7);
        root = insert(root, 11);
        root = IterativeWay(root, 9);
        root=Delete(root, 4);
        PrintInorder(root);
        System.out.print("\n");
        System.out.print(Floor(root,8).data);
        System.out.print("\n");
        System.out.print(Ceil(root,8).data);
    }
}
