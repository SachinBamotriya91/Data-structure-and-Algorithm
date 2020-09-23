import java.io.*;
import java.util.*;

public class LevelOrderLinewise {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }

        Node(int data) {
            this.data = data;
        }
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    /* first approach using two queues; */
    public static void levelOrderLinewise(Node node) {
        Deque<Node> mq = new ArrayDeque<>();
        mq.add(node);
        Deque<Node> cq = new ArrayDeque<>();
        while (mq.size() > 0) {
            Node temp = mq.remove();
            System.out.print(temp.data + " ");
            for (Node child : temp.children) {
                cq.add(child);
            }
            if (mq.size() == 0) {
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    // second approach which is delimeter
    public static void levelOrderLinewise1(Node node) {
        Deque<Node> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(new Node(-1));
        while (mq.size() > 0) {
            Node temp = mq.remove();
            if (temp.data == -1) {
                if (mq.size() > 0) {
                    mq.add(new Node(-1));
                    System.out.println();
                }
            } else {
                System.out.print(temp.data + " ");

                for (Node child : temp.children) {
                    mq.add(child);
                }
            }

        }
    }

    // third approach is count
    public static void levelOrderLinewise2(Node node) {
        Deque<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (mq.size() > 0) {
            int c1cl = mq.size();
            for (int i = 0; i < c1cl; i++) {
                Node temp = mq.remove();
                System.out.print(temp.data + " ");

                for (Node child : temp.children) {
                    mq.add(child);
                }
            }
            System.out.println();
        }
    }

    private static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;

        }
    }

    public static void levelOrderLinewise3(Node node) {
        Deque<Pair> mq = new ArrayDeque<>();
        mq.add(new Pair(node, 1));
        int level = 1;
        while (mq.size() > 0) {
            Pair p = mq.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }

            System.out.print(p.node.data + " ");
            for (Node child : p.node.children) {
                Pair cq = new Pair(child, p.level + 1);
                mq.add(cq);

            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        levelOrderLinewise2(root);
    }

}