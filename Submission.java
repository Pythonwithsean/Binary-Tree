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

    int minValue(Node root) {
      int minv = root.val;
      while (root.left != null) {
        minv = root.left.val;
        root = root.left;
      }
      return minv;
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

    public void deleteNode(int val) {

      root = deleteNodeHelper(root, val);
    }

    // Function to delete a given key from the BST
    public Node deleteNodeHelper(Node root, int val) {

      if (root == null) {
        return root;
      } else if (root.val > val) {
        root.left = deleteNodeHelper(root.left, val);
      } else {
        root.right = deleteNodeHelper(root.right, val);
      }

      if (root.val == val) {
        if (root.count > 1) {
          root.count--;
          return root;
        } else {
          if (root.left == null && root.right == null) {
            return null;
          } else if (root.left == null) {
            return root.right;
          } else if (root.right == null) {
            return root.left;
          }
          // node with two children: Get the inorder successor (smallest node on the
          // right)
          if (root.left != null && root.right != null) {
            // First strat get the smallest on the right subtree
            Node largestLeftTree = maxNodeHelper(root.left);
            root.val = largestLeftTree.val;
            root.left = deleteNodeHelper(root.left, largestLeftTree.val);
          } else {
            // Seconed strat get the largest on the left subtree
            Node smallestRightTree = minNodeHelper(root.right);
            root.val = smallestRightTree.val;
            root.right = deleteNodeHelper(root.right, smallestRightTree.val);
          }

          // Seconed strat get the largest on the left subtree
          // Node maxLeftNode = maxNodeHelper(root.left);
          // root.val = maxLeftNode.val;
          // root.left = deleteNodeHelper(root.left, maxLeftNode.val);

        }
      }

      return root;
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
          int elementToDelete = scanner.nextInt();
          binarySearchTree.deleteNode(elementToDelete);

          break;
        case 0:
          scanner.close();
          return;
      }

    }

    scanner.close();
  }

}
