package LinkedList;

public class Node<T> {
    // GENERIC NODE CLASS
    T data;             // LL NODE CONTAINS A VALUE CAN BE OF ANY TYPE
    Node<T> next;       // IT ALSO STORES THE ADDRESS OF THE NEXT NODE
    Node(T data){       // INITIALISE THE NODE USING CONSTRUCTOR
        this.data = data;
        next = null;
    }
}
