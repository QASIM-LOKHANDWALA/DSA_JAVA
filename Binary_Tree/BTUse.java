package Binary_Tree;

import java.util.Scanner;

public class BTUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node<Integer> root = takeInput(sc);
        printTree(root);
    }

    // TAKE INPUT RECURSIVELY
    public static Node<Integer> takeInput(Scanner sc){
        int rootData;
        System.out.print("Enter root data: ");
        rootData = sc.nextInt();
        if(rootData == -1){
            return null;
        }
        Node<Integer> root  = new Node<Integer>(rootData);
        root.left = takeInput(sc);
        root.right = takeInput(sc);
        return root;
    }

    // PRINT TREE RECURSUVELY
    public static void printTree(Node<Integer> root){
        if(root==null){
            return;
        }
        String s = root.data + " : ";
        if(root.left != null){
            s += "L " + root.left.data + " , ";
        }
        if(root.left != null){
            s += "R " + root.right.data;
        }
        System.out.println(s);
        printTree(root.left);
        printTree(root.right);
    }
}
