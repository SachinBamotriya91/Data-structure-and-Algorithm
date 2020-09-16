import java.util.*;
public class Prime{
	public static void main(String args[]){
		boolean isPrime[]=seiveOfEratoSthenes(20);
		for(int i=2;i<=20;i++){
			if(isPrime[i]==true)
			System.out.print(i+" ");
		}
	}
	public static boolean[] seiveOfEratoSthenes(int n){
		
		boolean isPrime[]=new boolean[n+1];
		Arrays.fill(isPrime,true);
		isPrime[0]=false;
		isPrime[1]=false;
		for(int i=2;i*i<=n;i++){
			if(isPrime[i]==true){
				for(int j=2*i;j<=n;j+=i)
					isPrime[j]=false;
			}
		}
		return isPrime;
	}
}