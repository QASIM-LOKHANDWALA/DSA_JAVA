package Binary_Tree;

import java.util.Scanner;

public class BTUse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTUse t = new BTUse();
        Node<Integer> root = t.takeInput(sc);
        t.printTree(root);
    }

    // TAKE INPUT RECURSIVELY
    public Node<Integer> takeInput(Scanner sc){
        int rootData;
        System.out.print("Enter node data: ");
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
    public void printTree(Node<Integer> root){
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
    }
}
