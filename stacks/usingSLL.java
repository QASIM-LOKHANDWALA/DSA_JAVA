package stacks;

public class usingSLL {
    public static void main(String[] args){
        StackUsingLL<Integer> stack = new StackUsingLL<>();
        for(int j=1; j<=5 ; j++){
            stack.push(j);
        }
        stack.display();
        for(int j=1; j<=2 ; j++){
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        stack.display();
    }
}
