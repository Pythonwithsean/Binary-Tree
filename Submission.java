import java.util.Scanner;

public class Submission {

  public static class BinarySearchTree {
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

    public BinarySearchTree() {
      root = null;
    }

    public void insert(int val) {
      root = insertHelper(root, val);
    }

    private Node insertHelper(Node root, int val) {
      if (root == null) {
        root = new Node(val);
        return root;
      }

      if (root.val == val) {
        root.count++;
      } else if (val < root.val) {
        root.left = insertHelper(root.left, val);
      } else {
        root.right = insertHelper(root.right, val);
      }
      return root;
    }

    public void binarySearch(int val) {
      Node found = binarySearchHelper(root, val);
      if (found != null) {
        System.out.println(found.val + "(" + found.count + ")");
      } else {
        System.out.println(val + "(0)");
      }
    }

    private Node binarySearchHelper(Node root, int val) {
      if (root == null) {
        return null;
      }
      if (val == root.val) {
        return root;
      } else if (val < root.val) {
        return binarySearchHelper(root.left, val);
      } else {
        return binarySearchHelper(root.right, val);
      }
    }

    public Node maxNode() {
      return maxNodeHelper(root);
    }

    private Node maxNodeHelper(Node node) {
      if (node == null) {
        return null;
      }
      if (node.right == null) {
        return node;
      }
      return maxNodeHelper(node.right);
    }

    public Node minNode() {
      return minNodeHelper(root);
    }

    private Node minNodeHelper(Node node) {
      if (node == null) {
        return null;
      }
      if (node.left == null) {
        return node;
      }
      return minNodeHelper(node.left);
    }

    public void printPreOrder() {
      printPreOrderHelper(root);
    }

    private void printPreOrderHelper(Node root) {
      if (root == null) {
        return;
      }
      System.out.print(root.val + " " + "(" + root.count + ")");
      printPreOrderHelper(root.left);
      printPreOrderHelper(root.right);
    }

    public void printInOrder() {
      printInOrderHelper(root);
    }

    private void printInOrderHelper(Node root) {
      if (root == null) {
        return;
      }
      printInOrderHelper(root.left);
      System.out.print(root.val + " " + "(" + root.count + ")");
      printInOrderHelper(root.right);
    }

    public void printPostOrder() {
      printPostOrderHelper(root);
    }

    private void printPostOrderHelper(Node node) {
      if (node == null) {
        return;
      }
      printPostOrderHelper(node.left);
      printPostOrderHelper(node.right);
      System.out.print(node.val + " " + "(" + node.count + ")");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinarySearchTree binarySearchTree = new BinarySearchTree();

    while (scanner.hasNext()) {
      int response = scanner.nextInt();

      switch (response) {
        case 1:
          int elementToInsert = scanner.nextInt();
          binarySearchTree.insert(elementToInsert);
          break;
        case 2:
          int elementToFind = scanner.nextInt();
          binarySearchTree.binarySearch(elementToFind);
          break;
        case 3:
          BinarySearchTree.Node maxNode = binarySearchTree.maxNode();
          System.out.print(maxNode != null ? maxNode.val + "(" + maxNode.count + ")" : "0(0)");
          System.out.println();
          break;
        case 4:
          BinarySearchTree.Node minNode = binarySearchTree.minNode();
          System.out.print(minNode != null ? minNode.val + "(" + minNode.count + ")" : "0(0)");
          System.out.println();
          break;
        case 5:
          binarySearchTree.printPreOrder();
          System.out.println();
          break;
        case 6:
          binarySearchTree.printPostOrder();
          System.out.println();
          break;
        case 7:
          binarySearchTree.printInOrder();
          System.out.println();
          break;
        case 8:
          System.out.println("Deletion feature not implemented yet.");
          break;
        case 0:
          scanner.close();
          return;
      }

    }

    scanner.close();
  }

}
