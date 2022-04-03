
//import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = null;
        right = null;
    }
}

public class Inorder_and_preorder__to__postorder {
    static int preindex=0;
    
    public static Node function(int in[],int pre[],int m,int n){
        if(m>n)return null;
        Node temp =new Node(pre[preindex++]);
        
        int index=m;
        for(int i=m;i<=n;i++){
            if(in[i]==temp.data){
                index=i;
                break;
            }
        }
        
        temp.left=function(in, pre, m, index-1);
        temp.right=function(in, pre, index+1, n);
        return temp;
    }
    public static void main(String args[]){
        int in[]={40,20,50,10,30,80,70,90};
        int pre[]={10,20,40,50,30,70,80,90};
        function(in ,pre,0,in.length-1);
        
    }
}
