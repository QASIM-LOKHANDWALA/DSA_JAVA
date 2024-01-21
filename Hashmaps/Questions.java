package Hashmaps;
import java.util.*;

public class Questions {
    public static void main(String[] args) {
        int[] arr = {5,9,6,1,5,1,5,8,8,7,1,6,5,6,7};
        ArrayList<Integer> ans = removeDuplicate(arr);
        System.out.println(ans.toString());
    }

    //  Time Complexity O(n)
    static ArrayList<Integer> removeDuplicate(int arr[]){
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer,Boolean> seen = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++){
            if(seen.containsKey(arr[i])){
                continue;
            }
            output.add(arr[i]);
            seen.put(arr[i], true);
        }
        return output;
    }
}
