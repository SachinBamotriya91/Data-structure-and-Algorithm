import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Traversal {
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

    public static void levelOrder(Node node) {
        ArrayDeque<Node> mq = new ArrayDeque<>();
        mq.add(node);
        ArrayDeque<Node> cq = new ArrayDeque<>();
        while (mq.size() > 0) {
            Node top = mq.remove();
            System.out.print(top.data + " ");
            cq.add(node.left);
            cq.add(node.right);
            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();

            }

        }
    }

    static String pre = "";
    static String post = "";
    static String in = "";

    public static void traversal(Node node) {
        if (node == null) {
            return;
        }

        pre += node.data + " "; // before going deep into recursion root will be first
        traversal(node.left);
        in += node.data + " "; // coming from left call and before going into right call and root will be in
                               // middle
        traversal(node.right);
        post += node.data + " "; // coming outer from recursion root will be last

    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<Integer>();
        }
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            System.out.println(true);
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> lpath = nodeToRootPath(node.left, data);
        if (lpath.size() > 0) {
            lpath.add(node.data);
            return lpath;
        }
        ArrayList<Integer> rpath = nodeToRootPath(node.right, data);
        if (rpath.size() > 0) {
            rpath.add(node.data);
            return rpath;
        }
        return (new ArrayList<Integer>());
    }

    public static void main(String[] args) {
        Integer arr[] = { 50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null,
                null };
        Node root = construct(arr);
        traversal(root);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
        // display(root);
        ArrayList<Integer> path = nodeToRootPath(root, 30);
        System.out.println(path);
    }
}
