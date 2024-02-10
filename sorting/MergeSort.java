package sorting;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] arr){
        if(arr.length<2) return;

        //split array in half
        int middle = arr.length/2;
        int[] left = new int[middle];
        for(int i=0 ; i<middle ; i++){
            left[i] = arr[i];
        }
        int[] right = new int[arr.length-middle];
        for(int i=middle ; i<arr.length ; i++){
            right[i-middle] = arr[i];
        }

        //recursive call to split array till it has single element
        mergeSort(left);
        mergeSort(right);

        //merging the split array after checking the values
        merge(right,left,arr);
    }
    private static void merge(int[] right ,int[] left,int[] result){
        int i=0,j=0,k=0;
        while(i<left.length && j< right.length){
            if(left[i] <= right[j]){
                result[k++]=left[i++];
            }else{
                result[k++]=right[j++];
            }
        }
        while(i<left.length){
            result[k++]=left[i++];
        }
        while(j<right.length){
            result[k++]=right[j++];
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,56,1,3,77,8,23,12};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
