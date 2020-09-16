import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        int countPaths = countPaths(n, new int[n + 1]);
        System.out.println("Total paths :" + countPaths);
    }

    // greedy approach
    /*
     * public static int countPaths(int n) {
     * 
     * if (n == 0) { return 1; } else if (n < 0) { return 0; }
     * 
     * int r1 = countPaths(n - 1); int r2 = countPaths(n - 2); int r3 = countPaths(n
     * - 3); int r = r1 + r2 + r3; return r; }
     */

    // memoized technique
    public static int countPaths(int n, int qb[]) {

        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int r1 = countPaths(n - 1, qb);
        int r2 = countPaths(n - 2, qb);
        int r3 = countPaths(n - 3, qb);
        int r = r1 + r2 + r3;
        qb[n] = r;
        return r;
    }

    // tabulation technique in dp;
    public static int countPathsTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];

    }

}
