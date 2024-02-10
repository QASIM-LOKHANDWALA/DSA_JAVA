package queue;

import java.util.LinkedList;
import java.util.Queue;
public class basicSTL {
    public static void main(String[] args){
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        System.out.println(que);
        que.remove();
        System.out.println(que);
        que.poll();                        //same as remove
        System.out.println(que);
        System.out.println(que.element()); //returns top most element
        System.out.println(que.size());    //returns size

    }
}
