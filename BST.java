import java.util.Scanner;

class Node 
{
    int key;
    Node left, right;

    public Node(int key) 
    {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST 
{
    private Node root;

    public void insert(int data) 
    {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) 
    {
        if (root == null) 
            return new Node(data);
        if (data < root.key)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    public void delete(int data) 
    {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) 
    {
        if (root == null) 
            return null;
        if (data < root.key)
            root.left = delete(root.left, data);
        else if (data > root.key)
            root.right = delete(root.right, data);
        else 
        {
            if (root.left == null) 
                return root.right;
            else if (root.right == null) 
                return root.left;
            
            Node successor = findMin(root.right);
            root.key = successor.key;
            root.right = delete(root.right, successor.key);
        }
        return root;
    }

    private Node findMin(Node root) 
    {
        while (root.left != null) 
            root = root.left;
        return root;
    }

    public void preorder() 
    {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node root) 
    {
        if (root != null) 
        {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder() 
    {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void postorder() 
    {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node root) 
    {
        if (root != null) 
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static void main(String[] args) 
    {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);
        int choice, value;
        do 
        {
            System.out.print("\n1. Insert\n2. Preorder\n3. Inorder\n4. Postorder\n5. Delete\n6. Exit\nEnter your choice: ");
            choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the node to be inserted: ");
                    value = scanner.nextInt();
                    tree.insert(value);
                    break;
                case 2:
                    tree.preorder();
                    break;
                case 3:
                    tree.inorder();
                    break;
                case 4:
                    tree.postorder();
                    break;
                case 5:
                    System.out.print("Enter the node to be deleted: ");
                    value = scanner.nextInt();
                    tree.delete(value);
                    break;
            }
        } while (choice != 6);
        scanner.close();
    }
}


