package stacks;

public class StackUsingLL<T> {
    private Node<T> head;
    private int size;

    public StackUsingLL(){
        head = null;
        size = 0;
    }
    boolean isEmpty(){
        return (size==0);
    }
    int size(){
        return size;
    }
    T top(){
        if(size()==0){
            System.out.println("Stack is empty");
        }
        return head.data;
    }
    void push(T value){
        Node<T> temp = new Node<>(value);
        temp.next = head;
        head = temp;
        size++;
    }
    T pop(){
        if(size()==0){
            System.out.println("Stack is empty.");
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }
    void display(){
        Node<T> temp;
        temp = head;
        for(int i=1 ; i<=size ; i++){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
