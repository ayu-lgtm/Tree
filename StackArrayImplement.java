

class MyStack{
    int arr[];
    int cap;
    int top;
    MyStack(int c){
        top=-1;
        cap=c;
        arr=new int[cap];
    }
    void push(int x){
        if(top==cap){
            System.out.println("Overflow");
            return;
        }
        top++;
        arr[top]=x;
        System.out.println("Inserted :"+x);
    }
    void pop(){
        if(top==-1){
            System.out.println("Underflow");
            return;
        }
        int x=arr[top];
        System.out.println("Deleted  :"+x);
        top--;   
    }
    void peek(){
        if(top==-1)
        {
            System.out.println("Empty");
            return;
        }
        System.out.print("Peek :"+arr[top]);
    }
    void size(){
        if(top==-1){
            System.out.println("Empty");
            return;
        }
        System.out.println("Size :"+(top+1));
    }
    boolean isEmpty(){
       return(top==-1);
    }
    void printStack(){
        System.out.print("Stack : ");
        for(int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
    }
}

class StackArrayImplement{
    public static void main(String args[]){

        MyStack s=new MyStack(5);
        s.push(5);
        s.push(4);
        s.pop();
        s.push(20);
        s.printStack();
    }
}