package queue;

public class LLImplementation {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }
    }
    public static class queueLL{
        Node head=null;
        Node tail=null;
        int size=0;
        public void add(int x){
            Node temp = new Node(x);
            if(size==0){
               head=temp;
            }else{
                tail.next=temp;
            }
            tail=temp;
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }else{
                int x = head.val;
                head = head.next;
                size--;
                return x;
            }
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.val;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is empty");
            }else{
                Node temp = head;
                while(temp!=null){
                    System.out.print(temp.val + " ");
                    temp=temp.next;
                }
                System.out.println();
            }
        }
        public boolean isEmpty(){
            if(size==0){return true;}
            else{return false;}
        }
    }
    public static void main(String[] args){
        queueLL q = new queueLL();
        q.display();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.display();
        System.out.println(q.peek());
        q.remove();
        q.display();

    }
}
