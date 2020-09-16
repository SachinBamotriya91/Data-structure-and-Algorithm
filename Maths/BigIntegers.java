import java.math.*;
public class BigIntegers{
	public static void main(String args[]){
		int n=30;
		System.out.println(factorial(n));
	}
	public static BigInteger factorial(int n){
		BigInteger f=new BigInteger("1");
		for(int i=2;i<=n;i++){
			f=f.multiply(BigInteger.valueOf(i));
		}
		return f;
	}
}