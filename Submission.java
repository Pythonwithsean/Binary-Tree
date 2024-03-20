import java.util.Scanner;
import java.util.ArrayList;

public class Submission {


  public static class BinarySearchTree {

    public static int deleted = 0;
    public static int inserted = 0;

    ArrayList<Node> BinarySearchTree;

    private Node root;

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

    public void printElement() {
      System.out.println(String.format("%s(%s)", this.root.val, this.root.count));
      System.out.println();

    }
  }

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
        System.out.println("Enter the element to insert:");
        int elementToInsert = scanner.nextInt();

        break;
      case "2":
        // Implement searching
        binarySearchTree.printElement();
        break;
      case "3":
        // Implement finding maximum
        break;
      case "4":
        // Implement finding minimum
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

        break;
      case "0":
        scanner.close();
        return; // Exit the program
      default:
        System.out.println("Invalid input! Please enter a number between 0 and 8.");
    }
    ;

  }

  }

}
