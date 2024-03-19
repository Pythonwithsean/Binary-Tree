import java.util.Scanner;
import java.util.ArrayList;

public class Submission {

  public Submission() {
    BinarySearchTree binarySearchTree = new BinarySearchTree();
  }

  public class Node {
    private int val;
    private Node left;
    private Node right;
  }

  public class BinarySearchTree {
    ArrayList<Node> BinarySearchTree;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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

    scanner.close();

  }

}
