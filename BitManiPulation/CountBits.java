import java.util.Scanner;

//Time complexity is O(no of bits);
public class CountBits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = countBits(n);
        scan.close();
        System.out.println("by using simple method Set bits are " + count);
        count = countFastBits(n);
        System.out.println("by uisng fast method  set bits are " + count);
        System.out.println("Ith Bit of n is " + getIthBit(n, 2));
        setIthBit(n, 1);
        int i = 2;
        System.out.println("After clearning after ith bit " + clearIthBit(n, i));
        System.out.println(2 << 3);
        System.out.println(~2);
    }

    public static int countBits(int n) {
        int counter = 0;
        while (n > 0) {
            counter += n & 1;
            n = n >> 1;
        }
        return counter;
    }

    public static int countFastBits(int n) {
        int counter = 0;
        while (n > 0) {
            counter++;
            n = n & (n - 1);
        }
        return counter;
    }

    public static int getIthBit(int n, int i) {
        return (n & (1 << i)) != 0 ? 1 : 0;
    }

    public static void setIthBit(int n, int i) {
        int result = n | 1 << i;
        System.out.println("Number before setting a bit " + n + " after " + result);
    }

    public static int clearIthBit(int n, int i) {
        int temp = ~(1 << i);

        return n & temp;
    }

    // power of 2 number will have only one set bit;
    public static boolean isPowerofTwo(long n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        if (count == 1)
            return true;
        return false;
    }

    // number sparse or not // if no two or more consecative bits are set then
    // number is sparse ;
    public static boolean isSparse(int n) {
        int b = n & n >> 1;
        if (b != 0)
            return false;
        return true;
    }

}