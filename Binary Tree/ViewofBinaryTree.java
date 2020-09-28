import java.util.Arrays;

import java.util.Stack;

public class ViewofBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.state = state;
            this.node = node;
        }
    }

    public static Node construct(Integer arr[]) {
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
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    Node rn = new Node(arr[idx], null, null);
                    top.node.right = rn;
                    Pair rp = new Pair(rn, 1);
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
        // node self work

        if (node == null) {
            return;
        }

        String str = "";

        str += node.left == null ? "." : node.left.data;
        str += "<--" + node.data + "-->";
        str += node.right == null ? "." : node.right.data;
        /*
         * if (node.left == null) { str += "."; } else { str += node.left.data; } str +=
         * "<--" + node.data + "-->"; if (node.right == null) { str += "."; } else { str
         * += node.right.data; }
         */
        System.out.println(str);
        // faith left and right of root node know how to print their family
        display(node.left);
        display(node.right);
    }

    static String pre = "";
    static String post = "";
    static String in = "";

    public static void traversal(Node node) {
        if (node == null) {
            return;
        }

        pre += node.data + " ";
        traversal(node.left);
        in += node.data + " ";
        traversal(node.right);
        post += node.data + " ";

    }

    static boolean checkLevels[];

    public static void leftView(Node node, int level) {
        if (node == null) {
            return;
        }
        if (checkLevels[level] != true) {
            System.out.print(node.data + " ");
            checkLevels[level] = true;
        }
        leftView(node.left, level + 1);
        leftView(node.right, level + 1);

    }

    public static void main(String[] args) {
        Integer arr[] = { 50, 25, 12, null, null, 37, null, 30, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        traversal(root);
        // System.out.println("Pre : " + pre);
        // System.out.println("In : " + in);
        // System.out.println("Post :" + post);
        // checkLevels = new ArrayList<>();
        // Collections.fill(checkLevels, false);
        // display(root);
        checkLevels = new boolean[50];
        Arrays.fill(checkLevels, false);
        leftView(root, 1);
    }
}
