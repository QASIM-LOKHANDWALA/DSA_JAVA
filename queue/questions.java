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
