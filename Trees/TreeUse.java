package Trees;
import java.util.*;

public class TreeUse {
    // TAKE TREE INPUT RECURSIVELY
    public static TreeNode<Integer> takeInput(Scanner sc){
        int n;
        System.out.print("Enter node data: ");
        n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        System.out.printf("Enter number of children of %d: ",n);
        int c = sc.nextInt();
        for(int i=0 ; i<c ; i++){
            TreeNode<Integer> child = takeInput(sc);
            root.children.add(child);
        }
        return root;
    }
    // PRINT TREE RECURSIVELY
    public static void print(TreeNode<Integer> root){
        String s = root.data + " : ";
        for(int i=0 ; i<root.children.size() ; i++){
            if(i==root.children.size()-1){
                s += root.children.get(i).data;
            }else{
                s += root.children.get(i).data + ",";
            }
        }
        System.out.println(s);
        for(int i=0 ; i<root.children.size() ; i++){
            print(root.children.get(i));
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(sc);
        print(root);

        /*
        TreeNode<Integer> root = new TreeNode<Integer>(4);
        TreeNode<Integer> n1 = new TreeNode<Integer>(2);
        TreeNode<Integer> n2 = new TreeNode<Integer>(3);
        TreeNode<Integer> n3 = new TreeNode<Integer>(6);
        TreeNode<Integer> n4 = new TreeNode<Integer>(5);
        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n4);
        n2.children.add(n3);
        System.out.println(root);
        */
    }
}
