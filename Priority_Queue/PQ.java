package Priority_Queue;

import java.util.ArrayList;

public class PQ {
    private ArrayList<Integer> heap;
    PQ(){
        heap = new ArrayList<>();
    }
    boolean isEmpty(){
        return heap.size()==0;
    }
    int size(){
        return heap.size();
    }
    int getMin() throws PQEmptyException{
        if (isEmpty()) {
            throw new PQEmptyException();
        }
        return heap.get(0);
    }
    void insert(int n){
        heap.add(n);
        int childIdx = heap.size()-1;
        int parentIdx = (childIdx-1)/2;

        while (childIdx>0) {
            if(heap.get(childIdx)<heap.get(parentIdx)){
                int temp = heap.get(childIdx);
                heap.set(childIdx, heap.get(parentIdx));
                heap.set(parentIdx, temp);
                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }else{
                return;
            }
        }
    }
    int removeMin() throws PQEmptyException{
        if (isEmpty()) {
            throw new PQEmptyException();
        }
        int minElem = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int idx = 0;
        int minIdx = idx;
        int left = 1;
        int right = 2;

        while (left<heap.size()) {
            if (heap.get(left)<heap.get(minIdx)) {
                minIdx = left;
            }
            if (right<heap.size() && heap.get(right)<heap.get(minIdx)) {
                minIdx = right;
            }
            if (minIdx == idx) {
                break;
            }else{
                int temp = heap.get(idx);
                heap.set(idx, heap.get(minIdx));
                heap.set(minIdx, temp);
                idx = minIdx;
                left = 2*idx + 1;
                right = 2*idx + 2;
            }
        }
        
        return minElem;
    }
}
