import java.util.Scanner;

public class GCD {
	public static void main(String args[]) {
		int n1, n2;
		Scanner scan = new Scanner(System.in);
		n1 = scan.nextInt();
		n2 = scan.nextInt();
		int result = GCD.gcd(n1, n2);
		scan.close();
		System.out.println("GCD of Two Number :" + result);

	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}