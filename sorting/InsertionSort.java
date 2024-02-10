package sorting;

import java.util.Arrays;

public class InsertionSort {
    static void insertionSort(int[] arr){
        for(int i=1 ; i<arr.length ; i++){
            var current = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>current){
                arr[j+1] = arr[j];
                j--;

            }
            arr[j+1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,56,1,3,77,8,23,12};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
