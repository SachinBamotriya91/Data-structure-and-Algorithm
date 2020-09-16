import java.util.Scanner;

public class TowerOfHonoi {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int disk = scan.nextInt();
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        scan.close();
        toh(disk, A, B, C);

    }

    public static void toh(int n, int A, int B, int C) {

        if (n == 0)
            return;
        toh(n - 1, A, C, B);
        System.out.println(n + "[" + A + " -> " + B + "]");
        toh(n - 1, C, B, A);
    }

}
