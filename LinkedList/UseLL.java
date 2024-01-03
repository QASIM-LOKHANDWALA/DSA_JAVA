package LinkedList;
import java.util.*;

public class UseLL {
    public static void main(String[] args) {
        // CREATING THE LL USING BASICS
        // Node<Integer> n1 = new Node<Integer>(10);
        // Node<Integer> n2 = new Node<Integer>(11);
        // Node<Integer> n3 = new Node<Integer>(12);
        // Node<Integer> n4 = new Node<Integer>(13);
        // Node<Integer> n5 = new Node<Integer>(14);
        // Node<Integer> n6 = new Node<Integer>(15);
        // n1.next = n2;       // STORING THE REFRENCE OF N2 IN N1
        // n2.next = n3;       // STORING THE REFRENCE OF N3 IN N2
        // n3.next = n4;       // STORING THE REFRENCE OF N4 IN N3
        // n4.next = n5;       // STORING THE REFRENCE OF N5 IN N4
        // n5.next = n6;       // STORING THE REFRENCE OF N6 IN N5
        Node<Integer> head = takeInput();
        head = insertAt(head, 100, 0);
        print(head);
    }

    // PRINTING THE LINKED LIST
    public static void print(Node<Integer> temp){
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    // TAKE LL INPUT
    public static Node<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        Node<Integer> head = null , tail = null;
        int data = 0;
        System.out.print("Enter the data: ");
        data = sc.nextInt();
        while(data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                // Node<Integer> t = head;      // APPROACH WITHOUT USING TAIL NODE TIME COMPLEXITY IS O(n^2)
                // while(t.next != null){
                //     t = t.next;
                // }
                // t.next = newNode;
                tail.next = newNode;            // APPROACH USING TAIL NODE TIME COMPLEXITY IS O(n)
                tail = newNode;
            }
            System.out.print("Enter the data: ");
            data = sc.nextInt();
        }
        sc.close();
        return head;
    }
    // INSERT NODE AT A GIVEN INDEX
    public static Node<Integer> insertAt(Node<Integer> head,int data,int idx){
        int x = 0;
        Node<Integer> newNode = new Node<>(data);
        if(idx==0){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node<Integer> temp = new Node<>(data);
        while(x<idx-1){
            temp = temp.next;
            x++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
}
