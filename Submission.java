import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Submission {
  public static class BinarySearchTree {


    private Node root;

    public BinarySearchTree() {
      root = null;
    }

    private class Node {
      private int val;
      private Node left;
      private Node right;
      private int count;

      public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.count = 1;
      }
    }

    public void insert(int val) {
      root = insertHelper(root, val);
    }

    public Node insertHelper(Node root, int val) {
      if (root == null) {
        root = new Node(val);
        return root;
      }

      if (val <= root.val) {
        root.left = insertHelper(root.left, val);
      } else {
        root.right = insertHelper(root.right, val);
      }
      return root;

    }

    public void displayNodes() {
      displayNodesHelper(root);
    }

    public void displayNodesHelper(Node root) {
      if (root != null) {
        System.out.print(root.val + "(" + root.count + ")" + " ");
        displayNodesHelper(root.left);
        displayNodesHelper(root.right);
      }

    }

    public void binarySearch(int val) {
      boolean found = binarySearchHelper(root, val);
      if (found == true)
        System.out.println("Found " + val);
      else
        System.out.println("Not Found" + val);
    }

    public boolean binarySearchHelper(Node root, int val) {
      if (root == null) {
        return false;
      }
      if (val == root.val)
        return true;
      else if (val <= root.val) {
        return binarySearchHelper(root.left, val);
      } else {
        return binarySearchHelper(root.right, val);
      }
    }

    public void deleteNode() {
    }

    public void deleteNodeHelper(Node root, int val) {
      if (root == null) {
        System.out.println("No Found");
        return;
      }
    }

    public int maxNode() {
      int max = maxNodeHelper(root);
      return max;
    }

    public int maxNodeHelper(Node node) {
      if (node == null) {
        return 0;
      }

      if (node.right == null) {
        return node.val;
      }
      return maxNodeHelper(node.right);
    }

    public int minNode() {
      int min = minNodeHelper(root);
      return min;
    }

    public int minNodeHelper(Node node) {
      if (node == null) {
        return 0;
      }
      if (node.left == null) {
        return node.val;
      }
      return minNodeHelper(node.left);
    }

    // Binary Search on the Node of the Tree

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      BinarySearchTree binarySearchTree = new BinarySearchTree();

      while (true) {
        String startMessage = """
            1. Insert an element into the BST
            2. Search for an element in the BST
            3. Find the maximum element from the BST
            4. Find the minimum element from the BST
            5. Print the elements in the BST in preorder
            6. Print the elements in the BST in postorder
            7. Print the elements in the BST in inorder
            8. Delete an element
            0. To exit the program
            """;

        System.out.println(startMessage);
        String response = scanner.nextLine();

        switch (response) {
          case "1":

            int elementToInsert = scanner.nextInt();
            binarySearchTree.insert(elementToInsert);

            break;
          case "2":
            // Implement searching
            int elementToFind = scanner.nextInt();
            binarySearchTree.binarySearch(elementToFind);

            break;
          case "3":
            // Implement finding maximum
            System.out.println(binarySearchTree.maxNode());
            break;
          case "4":
            // Implement finding minimum
            System.out.println(binarySearchTree.minNode());
            break;
          case "5":
            // Implement printing preorder
            break;
          case "6":
            // Implement printing postorder
            break;
          case "7":
            // Implement printing inorder
            break;
          case "8":
            System.out.println("Enter the element to delete:");
            // Implement deletion
            break;
          case "0":
            scanner.close();
            return; // Exit the program
          default:
            binarySearchTree.displayNodes();
            System.out.println();
            break;

        }
      }
    }
  }
}
