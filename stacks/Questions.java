package stacks;
import java.util.*;

public class Questions {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the Bracket Sequence : ");
        // String bracket = sc.nextLine();
        // System.out.println("IS BALANCED : " + isBalanced(bracket));
        // if(!isBalanced(bracket)){
        //     System.out.println("Min brackets to be removed to balance : " + minRemove(bracket));
        // }
        int[] arr = {1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        int[] removed = removeSubsequense(arr);
        for (int i=0 ; i<removed.length ; i++) {
            System.out.print(removed[i]+" ");
        }
    }

    //  BALANCED BRACKETS
    public static boolean isBalanced(String bracket){
        if(bracket.length()%2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int n = bracket.length();
        for(int i=0 ; i<n ; i++){
            char ch = bracket.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size()==0){
                    return false;
                }else if(st.peek() == '('){
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    //  MIN BRACKETS TO BE REMOVED TO BALANCED BRACKETS
    public static int minRemove(String bracket){
        int counter = 0;
        Stack<Character> st = new Stack<>();
        int n = bracket.length();
        for(int i=0 ; i<n ; i++){
            char ch = bracket.charAt(i);
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size()==0){
                    counter++;
                    continue;
                }else if(st.peek() == '('){
                    st.pop();
                }
            }
        }
        return st.size()+counter;
    }

    //  REMOVE CONSECUTIVE SUBSEQUENCES THAT CONTAINS SAME ELEMENT
    public static int[] removeSubsequense(int[] arr){
        Stack<Integer> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            if(st.isEmpty() || st.peek()!=arr[i]){
                st.push(arr[i]);
            }else if(st.peek()==arr[i]){
                if(i==arr.length-1 || arr[i]!=arr[i+1]){
                    st.pop();
                }
            }
        }
        int[] result = new int[st.size()];
        for(int i=st.size()-1 ; i>=0 ; i--){
            result[i] = st.pop(); 
        }
        return result;
    }
}
