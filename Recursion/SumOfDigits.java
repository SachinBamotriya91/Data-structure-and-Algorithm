public class SumOfDigits {
    public static void main(String args[]) {
        int n = 1234;
        int sum = sumOfDigits(n);
        System.out.println("Sum of digits " + sum);
    }

    public static int sumOfDigits(int n) {
        int sum = n % 10;
        if (n == 0)
            return 0;
        return sum + sumOfDigits(n / 10);
    }
}
