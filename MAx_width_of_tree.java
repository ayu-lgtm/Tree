import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left,right;
    Node(int x){
        data=x;
    }
} 

public class MAx_width_of_tree {
    public static int maxwidth(Node head){
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        int res=0;
        
        while(q.isEmpty()==false){
            int count=q.size();
            res=Math.max(count,res);
            for(int i=0;i<count;i++){
                Node temp=q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.print("MAX_WIDTH : "+maxwidth(head));
    }
}
