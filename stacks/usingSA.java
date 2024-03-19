package stacks;

public class usingSA {
    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray();
        for(int i=0 ; i<20 ; i++){
            stack.push(i);
        }
        stack.display();
        System.out.println();
        System.out.print("3rd Element from top is : ");
        stack.peep(3);
        System.out.print("10th Element from top is : ");
        stack.peep(10);
    }
}
