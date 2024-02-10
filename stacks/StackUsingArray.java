package stacks;

public class StackUsingArray {
    private int data[];
    private int top;
    public StackUsingArray(){
        data = new int[15];
        top = -1;
    }
    public StackUsingArray(int capacity){
        data = new int[capacity];
        top = -1;
    }

    private void doubleCapacity() {
        int[] temp = data;
        data = new int[2* temp.length];
        for(int x:temp){
            data[x] = temp[x];
        }
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public int size(){
        return (top+1);
    }
    public void push(int value){
        if(data.length == (top+1)){
            doubleCapacity();
        }else{
            top++;
            data[top] = value;
        }
    }
    public int peek(){
        if(size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return data[top];
        }
    }
    public int pop(){
        if(size() == 0){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int temp = data[top];
            top--;
            return temp;
        }
    }
    public void display(){
        if(size() == 0){
            System.out.println("Stack is empty");
        }else{
            for(int x=0 ; x<=(top) ; x++){
                System.out.print(data[x] + " ");
            }
        }
    }

}
