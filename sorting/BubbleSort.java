package sorting;
import java.util.Arrays;

public class BubbleSort {
    static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSorted;
        for(int i=0 ; i<n ; i++){
            isSorted=true;
            for(int j=1 ; j<n-i ; j++){
                if(arr[j]<arr[j-1]){
                   swap(arr,j,j-1);
                   isSorted=false;
                }
            }
            if(isSorted){
                return;
            }
        }
    }
    public static void swap(int[] arr,int idx1,int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,56,1,3,77,8,23,212,12};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
