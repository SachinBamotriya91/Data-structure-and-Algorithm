import java.util.*;
public class MaxMin{
	public static void main(String args[]){
		int arr[]={1,32,54,61,753};
		Arrays.sort(arr);
		System.out.println("MAX="+arr[0]+"  MIN="+arr[arr.length-1]);
	}
}