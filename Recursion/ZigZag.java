import java.util.Scanner;

public class ZigZag {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        pzz(n);
    }

    public static void pzz(int n) {
        if (n == 0)
            return;
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
        pzz(n - 1);
        System.out.print(n + " ");
    }

}
