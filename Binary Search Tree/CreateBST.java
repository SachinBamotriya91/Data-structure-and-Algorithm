import java.util.concurrent.CyclicBarrier;

public class CreateBST {
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

    public static Node construct(int arr[], int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi) / 2;
        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);

        Node nn = new Node(data, lc, rc);
        return nn;
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

    public static void main(String[] args) {
        int arr[] = { 12, 25, 37, 50, 62, 75, 87 };
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }

}
