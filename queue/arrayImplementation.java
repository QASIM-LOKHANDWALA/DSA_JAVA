package queue;

public class arrayImplementation {
    public static class queueA{
        int f = -1;
        int r =-1;
        int size = 0;
        int[] arr = new int[100];
        public void add(int val){
            if(r==arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(f == -1){
                f=r=0;
                arr[0]=val;
            }else{
                arr[++r]=val;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            int x = arr[f];
            f++;
            size--;
            return x;
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[f];
        }
        public boolean isEmpty(){
            if(size == 0){
                return true;
            }else{
                return false;
            }
        }
        public void display(){
            if(size == 0){
                System.out.println("Queue is empty");
            }else{
                for(int i = f;i<=r;i++){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        queueA a = new queueA();
        a.display();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.display();
        a.remove();
        a.display();
        System.out.println(a.peek());
        System.out.println(a.size);

    }
}
