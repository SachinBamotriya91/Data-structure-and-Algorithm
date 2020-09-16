import java.util.ArrayList;
import java.util.Scanner;

public class StairPaths {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        ArrayList<String> dp[] = new ArrayList[n + 1];
        ArrayList<String> paths = getStairPaths(n, dp);

        System.out.println(paths);

    }

    public static ArrayList<String> getStairPaths(int n, ArrayList<String> dp[]) {
        if (n == 0) {
            ArrayList<String> rr = new ArrayList<>();
            rr.add("");
            return rr;
        } else if (n < 0) {
            ArrayList<String> em = new ArrayList<String>();
            return em;
        }
        if (dp[n] != null) {
            return dp[n];
        }

        ArrayList<String> paths1 = getStairPaths(n - 1, dp);
        ArrayList<String> paths2 = getStairPaths(n - 2, dp);
        ArrayList<String> paths3 = getStairPaths(n - 3, dp);
        ArrayList<String> paths = new ArrayList<>();
        System.out.println("hello" + n);
        for (String val : paths1) {
            paths.add(1 + val);
        }
        for (String val : paths2) {
            paths.add(2 + val);
        }
        for (String val : paths3) {
            paths.add(3 + val);
        }
        dp[n] = paths;
        return paths;
    }

}
