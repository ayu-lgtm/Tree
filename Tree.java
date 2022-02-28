import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int x){
        data=x;
    }
}

public class Tree {
    
    public static void PRINTInorder(Node head){
        if(head==null){
            return;
        }
        PRINTInorder(head.left);
        System.out.print(head.data+" ");
        PRINTInorder(head.right);
    }

    public static void PRINTPostorder(Node head){
        if(head==null){
            return;
        }
        PRINTPostorder(head.left);
        PRINTPostorder(head.right);
        System.out.print(head.data+" ");
    }

    public static void PRINTPrefixorder(Node head){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        PRINTPostorder(head.left);
        PRINTPostorder(head.right);
        
    }
    public static int Height(Node head){
        if(head==null)return 0;
        return Math.max(Height(head.left),Height(head.right))+1;
    }
    public static void kthlevelNode(Node root,int k){
        if(root==null){
            return;
        }
        if(k==0)System.out.print(root.data+" ");

        else{
            kthlevelNode(root.left, k-1);
            kthlevelNode(root.right, k-1);
        }
    }
    public static void PRINTLevelorder(Node head){
        if(head==null){
            return;
        }
        Queue<Node> q=new LinkedList<Node>();
        q.add(head);
        while(q.isEmpty()==false){
            Node temp=q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }

        }
        
    }
    //size of bst
    public static int size(Node root){
        if(root==null)return 0;
        return 1+size(root.left)+size(root.right);
    }


    //maximum in bst
    public static int Max(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(Max(root.left),Max(root.right)));
    }

    //Iterative solution of inorder traversal
    public static void IterativeInOrder(Node curr){
        Stack<Node> st = new Stack<Node>();
        Node root=curr;
        while(root!=null||st.isEmpty()==false){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            System.out.print(root.data+" ");
            root=root.right;
        }
    }

    //iTERATIVE PREORDER
    public static void IterativePreOrder(Node curr){
        Stack<Node> st = new Stack<Node>();
        st.push(curr);
        while(st.isEmpty()==false){
            Node root=st.pop();
            System.out.print(root.data+" ");
            
            if(root.right!=null){
                st.push(root.right);
            }
            if(root.left!=null){
                st.push(root.left);
            }
        }
    }

    public static void main(String args[]){
        
        Node head=null;
        head =  new Node(2);
        head.left=new Node(3);
        head.right=new Node(4);
        head.left.left=new Node(5);
        head.left.right=new Node(6);
        head.right.left=new Node(7);
        head.right.right=new Node(5);

        PRINTInorder(head);
        System.out.print("\n");
        PRINTPostorder(head);
        System.out.print("\n");
        PRINTPrefixorder(head);
        System.out.print("\n");
        int h=Height(head);
        System.out.print("Height of Tree :"+h);
        System.out.print("\n");
        kthlevelNode(head, 2);
        System.out.print("\n");
        PRINTLevelorder(head);
        System.out.print("\n");
        System.out.print("Size :"+size(head));
        System.out.print("\n");
        System.out.print("Max :"+Max(head));
        System.out.print("\n");
        IterativeInOrder(head);
        System.out.print("\n");
        IterativePreOrder(head);
    }
}
