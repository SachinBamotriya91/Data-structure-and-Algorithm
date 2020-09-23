import java.io.*;
import java.util.*;

public class TreeSize {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

    public static int max(Node node) {
        int max = Integer.MIN_VALUE;
        // this will calculate the max of only children
        for (Node child : node.children) {
            int val = max(child);
            max = Math.max(val, max);
        }
        // we need to find max between root data and children data;
        max = Math.max(max, node.data);
        return max;
    }

    public static int height(Node node) {
        int ht = -1;
        for (Node child : node.children) {
            int val = height(child);
            ht = Math.max(ht, val);
        }
        ht += 1;
        return ht;
    }

    public static int size(Node node) {
        int size = 0;
        for (Node child : node.children) {
            int childsize = size(child);
            size = size + childsize;
        }
        size += 1;
        return size;
    }

    public static void main(String[] args) throws Exception {
        // 12
        // 10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int sz = size(root);
        System.out.println(sz);
        // display(root);
    }

}