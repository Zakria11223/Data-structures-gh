package project8;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> {

    // root of the tree
    private TreeNode myRoot;

    // visit function for tree traversal 
    // prints data item 
    private DoSomething print = new DoPrint();

    // condtructor
    public BinaryTree() {
        myRoot = null;
    }

    public BinaryTree(TreeNode t) {
        myRoot = t;
    }

    public TreeNode root() {
        return myRoot;
    }

    //
    // insert operation inserts the new node in a proper location
    // obeying the BST ordering property.
    // A simple BST insert algorithm compares the new node with
    // the current node (initially the root).
    // Insert as left child: If the new node's key is less than
    // the current node, and the current node's left child is null,
    //  the algorithm assigns that node's left child with the new node.
    // Insert as right child: If the new node's key is greater than
    // or equal to the current node, and the current node's right
    // child is null, the algorithm assigns the node's right
    // child with the new node.
    // Search for insert location: If the left (or right) child
    // is not null, the algorithm assigns the current node with
    // that child and continues searching for a proper insert location.
    //
    @SuppressWarnings("unchecked")
    public void insert(T Data) {
        TreeNode node = new TreeNode(Data);
        insert(node);
    }

    public void insert(TreeNode node) {
        if (myRoot == null) {
            myRoot = node; // System.out.println("(empty tree)");
        } else {
            myRoot.insert(node);
        }
    }

    //
    // search returns the first node found matching key, or returns null if a not found.
    // A simple BST search algorithm checks the current node (initially the tree's root),
    // returning that node as a match, else assigning the current node with the left
    // (if key is less) or right (if key is greater) child and repeating.
    // If such a child is null, the algorithm returns null (matching node not found).
    //
    @SuppressWarnings("unchecked")
    public T search(T Data) {
        TreeNode tn = search(new TreeNode(Data));
        if (tn == null) return null;
        return (T) tn.myItem;
    }

    @SuppressWarnings("unchecked")
    public TreeNode search(TreeNode tnode) {
        if (myRoot == null) {
            return null; // System.out.println("(empty tree)");
        }
        return myRoot.search(tnode);
    }

    // BST delete operation removes the first-found matching node,
    // restructuring the tree to preserve the BST ordering property.
    // The algorithm first searches for a matching node just like the
    // search algorithm. If found (call this node X), the algorithm
    // performs one of the following sub-algorithms:
    //
    // Remove a leaf node: If X has a parent (so X is not the root),
    // the parent's left or right child (whichever points to X) is
    // assigned with null. Else, if X was the root, the root pointer
    // is assigned with null, and the BST is now empty.
    //
    // Remove an internal node with single child: If X has a parent
    // (so X is not the root), the parent's left or right child
    // (whichever points to X) is assigned with X's single child.
    // Else, if X was the root, the root pointer is assigned with
    // X's single child.
    //
    // Remove an internal node with two children: This case is the
    // hardest. First, the algorithm locates X's successor (the
    // leftmost child of X's right subtree), and copies the successor
    // to X. Then, the algorithm recursively removes the successor
    // from the right subtree.
    @SuppressWarnings("unchecked")
    public boolean delete(T Data) {
        TreeNode node = new TreeNode(Data);
        return delete(node);
    }

    @SuppressWarnings("unchecked")
    public boolean delete(TreeNode tnode) {
        if (myRoot == null) {
            return false; // System.out.println("(empty tree)");
        }
        if (myRoot.myItem.equals(tnode.myItem) && myRoot.myLeft == null && myRoot.myRight == null) {
            myRoot = null;
            return true;
        }
        myRoot.root = myRoot;
        return myRoot.delete(tnode, myRoot);
    }

    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPreorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.preorder(print);
            // myRoot.printPreorder();
            System.out.println();
        }
    }

    // Print the values in the tree in preorder: root value first,
    // then values in the left subtree (in preorder), then values
    // in the right subtree (in preorder).
    public void printPostorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.postorder(print);
            // myRoot.printPostorder();
            System.out.println();
        }
    }

    // Print the values in the tree in inorder: values in the left
    // subtree first (in inorder), then the root value, then values
    // in the right subtree (in inorder).
    public void printInorder() {
        if (myRoot == null) {
            System.out.println("(empty tree)");
        } else {
            myRoot.inorder(print);
            // myRoot.printInorder();
            System.out.println();
        }
    }

    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println(description + " in postorder");
        t.printPostorder();
        t.cambridge_notation();
        System.out.println("Height of tree " + t.height() + "\n");
        System.out.println("Count of (non emplty) nodes" + t.count() + "\n");
        System.out.println("Completely Balanced: " + t.isCompletelyBalanced() + "\n");
        BTreePrinter.printNode(t.root());
    }

    public void cambridge_notation() {
        System.out.print(cambridge_string());
    }

    public String cambridge_string() {
        if (myRoot == null) {
            return ("(empty tree)");
        } else {
            return myRoot.cambridge_string();
        }
    }

    // how hight is my tree?
    public int height() {
        int depth = 0;
        if (myRoot == null) {
            return depth;
        } else {
            depth = myRoot.height(1);
        }
        return depth;
    }

    // how many nodes are there in my tree?
    public int count() {
        if (myRoot == null) {
            return 0;
        }
        return (myRoot.count(1));
    }

    //
    // if empty - tree is completely balanced
    // if only one node  - tree is completely balanced
    //
    //  then recursively get the rest
    // iff the height of
    //    left child is equal to the height of its right child, and
    //     its left and right children are also completely balanced.
    //
    public boolean isCompletelyBalanced() {
        int count = 0;

        // if empty - tree is completely balanced
        if (myRoot == null) return true;

        // if only one node  - tree is completely balanced
        if (1 == (count = myRoot.count(0))) return true;

        return myRoot.isCompletelyBalanced();
    }

}