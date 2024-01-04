package Trees;
import java.util.*;

public class TreeUse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeNode<Integer> root = takeInputLevel();
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
        sc.close();
    }

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

    // TAKE INPUT LEVEL WISE
    public static TreeNode<Integer> takeInputLevel(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int n = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<Integer>(n);
        Queue<TreeNode<Integer>> pendingNode = new LinkedList<>();
        pendingNode.add(root);
        while(!pendingNode.isEmpty()){
            TreeNode<Integer> frontNode = pendingNode.remove();
            System.out.println("Enter number of children of " + frontNode.data + ": ");
            int nuChildren = sc.nextInt();
            int x=0;
            while(x!=nuChildren){
                System.out.print("Enter " + (x+1) + "th child of " + frontNode.data + ": ");
                int child = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<Integer>(child);
                pendingNode.add(childNode);
                frontNode.children.add(childNode);
                x++;
            }
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
}
