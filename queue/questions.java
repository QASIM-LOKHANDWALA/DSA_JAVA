package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class questions {
    public static void main(String[] args) {
        // Reverse the Queue
        /*
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);

        Queue<Integer> reversed = reverseQueue(q);
        System.out.println(reversed.toString());
        */

        // Reverse the First K Elements In Queue
        /* 
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);

        Queue<Integer> reversed = reverseKElements(q, 3);
        System.out.println(reversed.toString());
        */

        // Implement Stack Using Queue
        /* 
        StackUsingQueue1 stack = new StackUsingQueue1();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);

        System.out.println(stack.top());

        System.out.println(stack.pop());
        */

        // Implement Queue Using Stack 
        /*
        QueueUsingStack2 queue = new QueueUsingStack2();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.push(40);
        queue.push(50);
        queue.push(60);
        queue.push(70);

        System.out.println(queue.pop());
        System.out.println(queue.peek());

        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " ");
        }
        */

        //  First Negative in each window of size k
        /* 
        long[] arr = {12,-1,-7,8,-15,30,16,28};
        long[] result = firstNeg(arr, 3);
        for (int i=0 ; i<result.length ; i++) {
            System.out.println(result[i]);
        }
        */

        //  Reorder the queue such that you interleave 1st and 2nd half
        /*
        Queue<Integer> q = new LinkedList<>();
        for(int i=1 ; i<=8 ; i++){
            q.add(i);
        }
        reorder(q);
        */

        // Evaluating Infix Expression
        String str = "9-5+3+4/6";
        infix(str);

    }

    // Reverse the Queue
    static Queue<Integer> reverseQueue(Queue<Integer> q){
        Stack<Integer> temp = new Stack<>();
        while(!q.isEmpty()){
            temp.push(q.remove());
        }
        while(temp.size()>0){
            q.add(temp.pop());
        }
        return q;
    }

    // Reverse the First K Elements In Queue
    static Queue<Integer> reverseKElements(Queue<Integer> q,int n){
        Stack<Integer> temp = new Stack<>();
       for(int i=0 ; i<n ; i++){
        temp.push(q.remove());
       }
        while(temp.size()>0){
            q.add(temp.pop());
        }
        for(int i=0 ; i<q.size()-n ; i++){
            q.add(q.remove());
        }
        return q;
    }

    //  First Negative in each window of size k
    static long[] firstNeg(long[] arr,int k){
        Queue<Integer> temp = new LinkedList<>();
        int size = arr.length-k+1;
        long[] result = new long[size];

        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]<0){
                temp.add(i);
            }
        }
        for(int i=0 ; i<arr.length-k+1 ; i++){
            if(temp.size()>0 && temp.peek()<i) temp.remove();

            if(temp.size()>0 && temp.peek()<=i+k-1) result[i] = arr[temp.peek()];
            else if(temp.size()==0) result[i] = 0;
            else result[i] = 0;
        }

        return result;
    }

    //  Reorder the queue such that you interleave 1st and 2nd half
    static void reorder(Queue<Integer> q){
       int n = q.size();
       Stack<Integer> st = new Stack<>();
       for(int i=1 ; i<=n/2 ; i++){
        st.push(q.remove());
       } 
       while (st.size()>0) {
        q.add(st.pop());
       }
       for(int i=1 ; i<=n/2 ; i++){
        st.push(q.remove());
       } 
       while (st.size()>0) {
        q.add(st.pop());
        q.add(q.remove());
       }

       while (q.size()>0) {
        st.push(q.remove());
       }
       while (st.size()>0) {
        q.add(st.pop());
       }

       System.out.println(q.toString());
    }

    // Evaluating Infix Expression
    static void infix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);    
            int ascii = (int)ch;    // ASCII '0' -> 48 , '9' -> 57
            if(ascii>=48 && ascii<=57){
                val.push(ascii - 48);
            } else if(op.size()==0){
                op.push(ch);
            } else {
                if(ch=='+' || ch =='-') {
                    int val2 = val.pop();
                    int val1 = val.pop();
                    if(op.peek() == '-') val.push(val1-val2);
                    if(op.peek() == '*') val.push(val1*val2); 
                    if(op.peek() == '/') val.push(val1/val2); 
                    if(op.peek() == '+') val.push(val1+val2); 
                    op.pop();
                    op.push(ch);
                }
                if(ch=='*' || ch =='/') {
                    if(op.peek()=='*' || op.peek()=='/'){
                        int val2 = val.pop();
                        int val1 = val.pop();
                        if(op.peek() == '/') val.push(val1/val2); 
                        if(op.peek() == '*') val.push(val1*val2); 
                        op.pop();
                        op.push(ch);
                    }else{
                        op.push(ch);
                    }
                }
            }
        }
        while (val.size()>1) {
            int val2 = val.pop();
            int val1 = val.pop();

            if(op.peek() == '-') val.push(val1-val2);
            if(op.peek() == '*') val.push(val1*val2); 
            if(op.peek() == '/') val.push(val1/val2); 
            if(op.peek() == '+') val.push(val1+val2); 

            op.pop();
        }
        System.out.println(val.peek());
    }
}

// Implement Stack Using Queue
// Time Complexities --> push O(1) , pop & top O(n)
class StackUsingQueue1{
    Queue<Integer> q = new LinkedList<>();
    
    public void push(int x){
        q.add(x);
    }
    public int top(){
        for(int i=1 ; i<=q.size()-1 ; i++){
            q.add(q.remove());
        }
        int element = q.remove();
        q.add(element);
        return element;
    }
    public int pop(){
        for(int i=1 ; i<=q.size()-1 ; i++){
            q.add(q.remove());
        }
        return q.remove();
    }
    public boolean isEmpty(){
        return q.size()==0;
    }
}
// Implement Stack Using Queue
// Time Complexities --> pop & top O(1) , push O(n)
class StackUsingQueue2{
    Queue<Integer> q = new LinkedList<>();
    
    public void push(int x){
        q.add(x);
        for(int i=1 ; i<=q.size()-1 ; i++){
            q.add(q.remove());
        }
    }
    public int top(){
        return q.peek();
    }
    public int pop(){
        return q.remove();
    }
    public boolean isEmpty(){
        return q.size()==0;
    }
}

// Implementing Queue using Stacks
// push efficient code
class QueueUsingStack1{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public void push(int x){
        st.push(x);
    }
    public int pop(){
        while(st.size()>1){
            helper.push(st.pop());
        }
        int x = st.pop();
        while (helper.size()>0) {
            st.push(helper.pop());
        }
        return x;
    }
    public int peek(){
        while(st.size()>1){
            helper.push(st.pop());
        }
        int x = st.peek();
        while (helper.size()>0) {
            st.push(helper.pop());
        }
        return x;
    }
    public boolean isEmpty(){
        return st.size()==0;
    }
}

// Implementing Queue using Stacks
// pop & peek efficient code
class QueueUsingStack2{
    Stack<Integer> st = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public void push(int x){
        if(st.isEmpty()){
            st.push(x);
        }else{
            while (st.size()>0) {
                helper.push(st.pop());
            }
            st.push(x);
            while (helper.size()>0) {
                st.push(helper.pop());
            }
        }
    }
    public int pop(){
        return st.pop();
    }
    public int peek(){
        return st.peek();
    }
    public boolean isEmpty(){
        return st.size()==0;
    }
}
