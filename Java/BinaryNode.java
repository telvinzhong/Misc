import java.util.*;

public class BinaryNode {
    public int data;
    public BinaryNode left;
    public BinaryNode right;

    BinaryNode(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }
    
    public static List <Integer> preorder(BinaryNode root) {
        List <Integer> ans = new LinkedList <Integer> ();
        if (root == null) {
            return ans;
        }

        // Root, left, right.
        ans.add(root.data);
        ans.addAll(preorder(root.left));
        ans.addAll(preorder(root.right));

        return ans;
    }

    public static List <Integer> inorder(BinaryNode root) {
        List <Integer> ans = new LinkedList <Integer> ();
        if (root == null) {
            return ans;
        }

        // Left, root, right.

        ans.addAll(inorder(root.left));
        ans.add(root.data);
        ans.addAll(inorder(root.right));

        return ans;
    }

    public static List <Integer> postorder(BinaryNode root) {
        List <Integer> ans = new LinkedList <Integer> ();
        if (root == null) {
            return ans;
        }

        // Left, right, root.
        ans.addAll(postorder(root.left));
        ans.addAll(postorder(root.right));
        ans.add(root.data);

        return ans;
    }

    public void insertLeft(int node) {
        if (this.left == null) {
            this.left = new BinaryNode(node);
        } else {
            BinaryNode temp = this.left;
            this.left = new BinaryNode(node);
            this.left = temp;
        }
    }

    public void insertLeft(BinaryNode node) {
        if (this.left == null) {
            this.left = node;
        } else {
            BinaryNode temp = this.left;
            this.left = node;
            this.left = temp;
        }
    }

        public void insertRight(int node) {
        if (this.right == null) {
            this.right = new BinaryNode(node);
        } else {
            BinaryNode temp = this.right;
            this.right = new BinaryNode(node);
            this.right = temp;
        }
    }

    public void insertRight(BinaryNode node) {
        if (this.right == null) {
            this.right = node;
        } else {
            BinaryNode temp = this.right;
            this.right = node;
            this.right = temp;
        }
    }

    public static void main(String[] args) {
        BinaryNode A = new BinaryNode(1);
        BinaryNode B = new BinaryNode(2);
        BinaryNode C = new BinaryNode(3);
        BinaryNode D = new BinaryNode(4);
        BinaryNode E = new BinaryNode(5);
        BinaryNode F = new BinaryNode(6);
        BinaryNode G = new BinaryNode(7);
        BinaryNode H = new BinaryNode(8);
        BinaryNode I = new BinaryNode(9);
        BinaryNode J = new BinaryNode(10);
        BinaryNode K = new BinaryNode(11);
        BinaryNode L = new BinaryNode(12);
        BinaryNode M = new BinaryNode(13);
        BinaryNode N = new BinaryNode(14);
        BinaryNode O = new BinaryNode(15);
        BinaryNode P = new BinaryNode(16);
        BinaryNode Q = new BinaryNode(17);
        BinaryNode R = new BinaryNode(18);
        BinaryNode S = new BinaryNode(19);
        BinaryNode T = new BinaryNode(20);
        BinaryNode U = new BinaryNode(21);
        BinaryNode V = new BinaryNode(22);
        BinaryNode W = new BinaryNode(23);
        BinaryNode X = new BinaryNode(24);
        BinaryNode Y = new BinaryNode(25);
        BinaryNode Z = new BinaryNode(26);

        A.insertLeft(B);
        A.insertRight(C);

        B.insertLeft(D);
        B.insertRight(E);
        C.insertLeft(F);
        C.insertRight(G);

        D.insertLeft(H);
        D.insertRight(I);
        E.insertLeft(J);
        E.insertRight(K);
        F.insertLeft(L);
        F.insertRight(M);
        G.insertLeft(N);
        G.insertRight(O);

        H.insertLeft(P);
        H.insertRight(Q);
        I.insertLeft(R);
        I.insertRight(S);
        J.insertLeft(T);
        J.insertRight(U);
        K.insertLeft(V);
        K.insertRight(W);
        M.insertLeft(X);
        M.insertRight(Y);
        N.insertRight(Z);

        System.out.println("\nPreorder result: ");
        System.out.println(preorder(A));
        System.out.println("\nInorder result: ");
        System.out.println(inorder(A));
        System.out.println("\nPostorder result: ");
        System.out.println(postorder(A));
    }
}

