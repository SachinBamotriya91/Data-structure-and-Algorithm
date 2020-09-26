
import java.io.*;
import java.util.*;

public class IsBinarySerachTree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int height(Node node) {
        if (node == null) {
            return -1;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        int th = Math.max(lh, rh) + 1;
        return th;
    }

    public static class BSTPair {
        int max;
        int min;
        boolean isBST;

    }

    public static BSTPair isBST(Node node) {
        if (node == null) {
            BSTPair bp = new BSTPair();
            // identity of min value is +infinity
            bp.min = Integer.MAX_VALUE;
            // identity of max value is -infinity
            bp.max = Integer.MIN_VALUE;
            // empty node always be a bst so its will be true by default
            bp.isBST = true;
            return bp;
        }

        // left pair of node which contens three info. max min and isBST
        BSTPair lp = isBST(node.left);

        // right pair of node which contens three info. max min and isBST
        BSTPair rp = isBST(node.right);

        // we need to calculate our node isBST min max too because node might have
        // parent which required node's max min isBST to calculate its max min IsBST

        BSTPair mp = new BSTPair();
        // left should be bst and right too and node its selft must be bst
        //
        mp.isBST = lp.isBST && rp.isBST && (node.data > lp.max && node.data < rp.min);
        mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
        mp.max = Math.max(node.data, Math.max(lp.max, rp.max));

        return mp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        BSTPair bp = isBST(root);
        System.out.println(bp.isBST);
    }

}