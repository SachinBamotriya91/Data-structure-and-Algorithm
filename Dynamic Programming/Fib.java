import java.util.Scanner;

public class Fib {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        // int n1 = FibGreedy(n);
        int n1 = FibMemoized(n, new int[n + 1]);
        System.out.println("fib sum  : " + n1);
    }

    public static int FibGreedy(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // System.out.println("heloo" + n);
        int fib1 = FibGreedy(n - 1);
        int fib2 = FibGreedy(n - 2);

        int fib = fib1 + fib2;
        return fib;
    }

    // dynamic programming
    public static int FibMemoized(int n, int[] que) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (que[n] != 0) {

            return que[n];
        }
        System.out.println("heloo" + n);
        int fib1 = FibMemoized(n - 1, que);
        int fib2 = FibMemoized(n - 2, que);
        int sum = fib1 + fib2;
        que[n] = sum;

        return sum;

    }
}