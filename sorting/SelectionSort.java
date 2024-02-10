package sorting;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0 ; i<n ; i++){
            int minIdx = i;
            for(int x=i ; x<n ; x++){
                if(arr[x]>arr[minIdx]){
                    minIdx = x;
                }
            }
            swap1(arr,minIdx,i);
        }
    }
    private static void swap1(int[] arr,int idx1,int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,56,1,3,77,8,23,12};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
