import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        scn.close();
        int d = getValueIndecimal(n, b);
        System.out.println(d);
    }

    public static int getValueIndecimal(int n, int b) {
        int result = 0;
        int p = 1;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            result = result + digit * p;
            p = p * b;
        }
        return result;
    }

}