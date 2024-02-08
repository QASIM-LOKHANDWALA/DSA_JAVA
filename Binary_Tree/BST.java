package Binary_Tree;

public class BST {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(new BSTNode(5));
        tree.insert(new BSTNode(6));
        tree.insert(new BSTNode(9));
        tree.insert(new BSTNode(5));
        tree.insert(new BSTNode(3));
        tree.insert(new BSTNode(7));
        tree.insert(new BSTNode(4));

        tree.display();

        System.out.println(tree.search(0));
        System.out.println(tree.search(5));
        System.out.println(tree.search(7));

        tree.remove(5);
        tree.remove(10);

        tree.display();
    }

    BSTNode root;
    public void insert(BSTNode node){
        root = insertHelp(root, node);
    }
    private BSTNode insertHelp(BSTNode root , BSTNode node){
        int data = node.data;
        if(root == null){
            root = node;
            return root;
        }else if(data < root.data){
            root.left = insertHelp(root.left, node);
        }else if(data > root.data){
            root.right = insertHelp(root.right, node);
        }
        return root;
    }

    public void display(){
        displayHelp(root);
    }
    private void displayHelp(BSTNode root){
        if(root!=null){
            displayHelp(root.left);
            System.out.println(root.data);
            displayHelp(root.right);
        }
    }

    public boolean search(int data){
        return searchHelp(root, data);
    }
    private boolean searchHelp(BSTNode root , int data){
        if (root==null) {
            return false;
        }else if(root.data == data){
            return true;
        }else if(root.data > data){
            return searchHelp(root.left, data);
        }else{
            return searchHelp(root.right, data);
        }
    }

    public void remove(int data){
        if(search(data)){
            removeHelp(root, data);
        }else{
            System.out.println("NO DATA FAOUND");
        }
    }
    private BSTNode removeHelp(BSTNode root , int data){
        if(root == null){
            return root;
        }else if(data < root.data){
            root.left = removeHelp(root.left, data);
        }else if(data > root.data){
            root.left = removeHelp(root.right, data);
        }else{
            if(root.right == null && root.right == null){
                root = null;
            }else if(root.right != null){
                root.data = successor(root);
                root.right = removeHelp(root.right, root.data);
            }else{
                root.data = predecessor(root);
                root.left = removeHelp(root.right, root.data);
            }
        }
        return root;
    }
    private int successor(BSTNode root){
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    private int predecessor(BSTNode root){
        root = root.left;
        while (root.left != null) {
            root = root.right;
        }
        return root.data;
    }
}

