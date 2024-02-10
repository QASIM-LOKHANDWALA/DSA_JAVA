package stacks;

public class usingSA {
    public static void main(String[] args){
        StackUsingArray stack = new StackUsingArray();
        for(int i=0 ; i<20 ; i++){
            stack.push(i);
        }
        stack.display();


    }
}
