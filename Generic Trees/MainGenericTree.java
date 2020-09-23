import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class MainGenericTree {
    static class GenericTree implements Iterable<Integer> {
        Node root;

        public GenericTree(Node root) {
            this.root = root;
        }

        // Interface oobject cannt be created but it can hold a reference of object of
        // that class which implement it (interface)
        @Override
        public Iterator<Integer> iterator() {
            Iterator<Integer> obj = new GTPreorderIterator(root);
            return obj;
        }
    }

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    // feauture of preorder and loop will be done in this class
    static class GTPreorderIterator implements Iterator<Integer> {
        // default value of Integer is null and int =0
        // int value stored into the stack but Integer referenced will be stored in
        // stack and value in heap
        Integer nval;
        Stack<Pair> st;

        public GTPreorderIterator(Node root) {
            st = new Stack<>();
            st.push(new Pair(root, -1));
            // executing once next because initially nval ==null so it will set the nval
            // value
            next();
        }

        // provide whether the value is available or not in list or tree;
        @Override
        public boolean hasNext() {
            if (nval == null)
                return false;
            else
                return true;
        }

        // next Method return the value and set it to the nextValue;
        @Override
        public Integer next() {
            Integer fval = nval;

            // setting next value if not possible set it to null;
            nval = null;

            while (st.size() > 0) {
                Pair top = st.peek();
                if (top.state == -1) {
                    nval = top.node.data;
                    top.state++;
                    break;
                } else if (top.state == top.node.children.size()) {
                    st.pop();
                } else {
                    Pair cp = new Pair(top.node.children.get(top.state), -1);
                    st.push(cp);
                    top.state++;

                }
            }

            return fval;
        }

    }

    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);
        GenericTree gt = new GenericTree(root);

        Iterator<Integer> itr = gt.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }
}
