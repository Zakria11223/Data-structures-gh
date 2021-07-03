package project8;

import java.util.*;

public class BinaryTreeTester extends assertEquals {

    /*************************************
     * public TreeNode(Object obj) {
     * myItem = obj;
     * myLeft = null;
     * myRight = null;
     * }
     * public TreeNode(Object obj, TreeNode left, TreeNode right) {
     * myItem = obj;
     * myLeft = left;
     * myRight = right;
     * }
     *************************************/

    // TreeNode structure
    //    Object    myItem
    //    TreeNode  myLeft
    //    TreeNode  myRight
    //
    // contructors can take a single Object (myItem) or Object and two TreeNodes)
    //  e.g.    TreeNode tr1 = new TreeNode("F");
    //
    //         F
    //
    //          TreeNode tr2 = new TreeNode("T", tr1, new TreeNode("B", null,null));
    //
    //         T
    //      F    B
    //
    //
    // (A (B) (C (D (E)(F) ) () ) )
    //
    //          (A
    //    (B)          (C
    //            (D)   () )
    //         (E)  (F)
    //
    //          A
    //        /    \
    //       B       C
    //               /
    //             D
    //           /  \
    //          E    F
    //
    //  fill Sample tress functions
    //
    //
    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree0(BinaryTree t) {
        BinaryTree bt = new BinaryTree(null); // empty tree
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree1(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(tn);
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree2(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        /*
        bt.insert(new String("M"));
        bt.insert(new String("B"));
        bt.insert(new String("A"));
        bt.insert(new String("C"));
        bt.insert(new String("Y"));
        bt.insert(new String("X"));
        bt.insert(new String("Z"));
        */
        bt.insert(new String("A"));
        bt.insert(new String("B"));
        bt.insert(new String("C"));
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree2A(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(new String("A"));
        bt.insert(new String("B"));
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree2B(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(new String("C"));
        bt.insert(new String("B"));
        bt.insert(new String("A"));
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree2C(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(new String("C"));
        bt.insert(new String("B"));
        bt.insert(new String("D"));
        bt.insert(new String("E"));
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree3(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(new String("H"));
        bt.insert(new String("D"));
        bt.insert(new String("L"));
        bt.insert(new String("B"));
        bt.insert(new String("F"));
        bt.insert(new String("J"));
        bt.insert(new String("N"));
        bt.insert(new String("A"));
        bt.insert(new String("C"));
        bt.insert(new String("E"));
        bt.insert(new String("G"));
        bt.insert(new String("I"));
        bt.insert(new String("K"));
        bt.insert(new String("M"));
        bt.insert(new String("O"));
        return bt;
    }
    //
    //                      H
    //           D                       L
    //     B          F           J            N
    //  A     C    E     G    I       K     M      O

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree4(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("D"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(tn);
        bt.insert(new String("F"));
        bt.insert(new String("A"));
        bt.insert(new String("A"));
        bt.insert(new String("H"));
        bt.insert(new String("B"));
        bt.insert(new String("E"));

        String searches[] = {"E", "D", "Z", "A"};
        for (String key : searches) {
            System.out.println("Looking for " + key);
            String found = (String) bt.search(key);
            if (found != null) System.out.println("Found " + found);
            else System.out.println("Not found");
        }
        return bt;
    }

    @SuppressWarnings("unchecked")
    public static BinaryTree fillSampleTree5(BinaryTree t) {
        TreeNode tn = new TreeNode(new String("A"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(new String("H"));
        bt.insert(new String("D"));
        bt.insert(new String("L"));
        bt.insert(new String("B"));
        bt.insert(new String("F"));
        bt.insert(new String("J"));
        bt.insert(new String("N"));
        bt.insert(new String("A"));
        bt.insert(new String("C"));
        bt.insert(new String("E"));
        bt.insert(new String("G"));
        bt.insert(new String("I"));
        bt.insert(new String("K"));
        bt.insert(new String("M"));
        bt.insert(new String("O"));
        return bt;
    }
    //                      H
    //           D                       L
    //     B          F           J            N
    //  A     C    E     G    I       K     M      O

    public static void testInsert() {
        System.out.println("/*****************************************************/");
        System.out.println("/*****************************************************/");
        BinaryTree t = new BinaryTree();
        System.out.println(t.cambridge_string());
        assertEquals("(empty tree)", t.cambridge_string());

        t.insert("E");
        System.out.println(t.cambridge_string());
        assertEquals("(E())", t.cambridge_string());

        t.insert("B");
        t.insert("I");
        System.out.println(t.cambridge_string());
        assertEquals("(E(A())(I()))", t.cambridge_string());

        BTreePrinter.printNode(t.root());

        t.insert("A");
        t.insert("H");
        System.out.println(t.cambridge_string());
        assertEquals("(E(B(A())())(I(H())()))", t.cambridge_string());
        BTreePrinter.printNode(t.root());
        System.out.println("\n***********************************************\n");
        System.out.println("/*****************************************************/");
    }

    public static void testSearch() {
        System.out.println("/*****************************************************/");
        System.out.println("/*****************************************************/");
        TreeNode tn = new TreeNode(new String("D"));
        BinaryTree bt = new BinaryTree(null);
        bt.insert(tn);
        bt.insert(new String("F"));
        bt.insert(new String("A"));
        bt.insert(new String("A"));
        bt.insert(new String("H"));
        bt.insert(new String("B"));
        bt.insert(new String("E"));
        System.out.println(bt.cambridge_string());
        BTreePrinter.printNode(bt.root());

        String found = "";
        String searches[] = {"E", "D", "Z", "A"};
        found += "Looking for ";
        for (String key : searches) {
            found += " " + key;
            System.out.println("Looking for " + key);
            found += " found: " + bt.search(key) + " ";
            // if (found != null) System.out.println("Found "+found);
            // else System.out.println("Not found");
        }
        System.out.println(found);
        assertEquals("Looking for  E found: E  D found: D  Z found: null  A found: A ", found);

        BTreePrinter.printNode(bt.root());
        System.out.println("/*****************************************************/");
        System.out.println("/*****************************************************/");
    }

    public static void testDelete() {
        System.out.println("/*****************************************************/");
        System.out.println("/*****************************************************/");
        BinaryTree t = new BinaryTree(null);
        System.out.println("\ncalling print on sample tree 5\n\n");
        t = fillSampleTree5(t);
        print(t, "sample tree 5");
        System.out.println(t.cambridge_string());
        assertEquals(
                "(H(D(B(A())(C()))(F(E())(G())))(L(J(I())(K()))(N(M())(O()))))",
                t.cambridge_string());
        t.delete("C");
        print(t, "sample tree 5  - after remove 'C' ");
        System.out.println(t.cambridge_string());
        assertEquals(
                "(H(D(B(A())())(F(E())(G())))(L(J(I())(K()))(N(M())(O()))))", t.cambridge_string());
        t.delete("M");
        print(t, "sample tree 5  - after remove 'M' ");
        System.out.println(t.cambridge_string());
        assertEquals(
                "(H(D(B(A())())(F(E())(G())))(L(J(I())(K()))(N()(O()))))", t.cambridge_string());
        t.delete("L");
        print(t, "sample tree 5  - after remove 'L' ");
        System.out.println(t.cambridge_string());
        assertEquals("(H(D(B(A())())(F(E())(G())))(N(J(I())(K()))()))", t.cambridge_string());
        t.delete("H");
        print(t, "sample tree 5 - after remove 'H'  ");
        System.out.println(t.cambridge_string());
        assertEquals("(I(D(B(A())())(F(E())(G())))(N(J()(K()))()))", t.cambridge_string());
        System.out.println("/*****************************************************/");
        System.out.println("/*****************************************************/");
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();

        // testInsert();
        // testSearch();
        testDelete();

        /*
        t = fillSampleTree0(t);
        System.out.println("\ncalling print on an empty tree\n\n");
        print(t, "sample tree 0");


        System.out.println("\ncalling print on sample tree 1\n\n");
        t = fillSampleTree1(t);
        print(t, "sample tree 1");
        */

        System.out.println("\ncalling print on sample tree 2A\n\n");
        t = fillSampleTree2A(t);
        print(t, "sample tree 2A");

        System.out.println("\ncalling print on sample tree 2B\n\n");
        t = fillSampleTree2B(t);
        print(t, "sample tree 2B");

        System.out.println("\ncalling print on sample tree 2C\n\n");
        t = fillSampleTree2C(t);
        print(t, "sample tree 2C");

        System.out.println("\ncalling print on sample tree 2\n\n");
        t = fillSampleTree2(t);
        print(t, "sample tree 2");

        System.out.println("\ncalling print on sample tree 3\n\n");
        t = fillSampleTree3(t);
        print(t, "sample tree 3");

        System.out.println("\ncalling print on sample tree 4\n\n");
        t = fillSampleTree4(t);
        print(t, "sample tree 4");
    }

    private static void print(BinaryTree t, String description) {
        System.out.println("/*****************************************************/");
        System.out.println("\t\t" + description);
        // System.out.print(" In preorder: ");
        // t.printPreorder();
        // System.out.print(" In inorder: ");
        // t.printInorder();
        // System.out.print(" In postorder: ");
        // t.printPostorder();
        System.out.print(" Cambridge notation :");
        t.cambridge_notation();
        System.out.println();
        System.out.println(" Height of tree     : " + t.height());
        System.out.println(" Count of  nodes    : " + t.count());
        System.out.println(" Completely Balanced: " + t.isCompletelyBalanced());
        System.out.println();
        System.out.println(" ascii art tree");
        BTreePrinter.printNode(t.root());
        System.out.println();
        System.out.println("/*****************************************************/");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    public static void userinput() {
        BinaryTree t = new BinaryTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("EOF to terminate  (^d or ^z)");
        do {
            String s;
            System.out.println(
                    "To ADD node to the tree enter 'a' followed by the number(s) to ADD: ");
            System.out.println("To REMOVE enter 'r' followed by the number(s) to REMOVE: ");
            if (sc.hasNextLine()) {
                s = sc.next();
                if (s.charAt(0) == 'r') {
                    while (sc.hasNextInt()) t.delete(new Integer(sc.nextInt()));
                } else if (s.charAt(0) == 'a') {
                    while (sc.hasNextInt()) t.insert(new Integer(sc.nextInt()));
                }
                System.out.print(" Tree: ");
                t.cambridge_notation();
                System.out.println("\n Height: " + t.height());
                System.out.println(" Node count: " + t.count());
                BTreePrinter.printNode(t.root());
            }
        } while (sc.hasNext());
        sc.close();
    }
}
