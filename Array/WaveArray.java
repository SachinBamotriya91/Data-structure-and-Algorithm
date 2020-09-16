
import java.util.*;
public class WaveArray{
	public static void main(String args[]){
		int arr[]={1,2,3,4,5,6,7};
		Arrays.sort(arr);
		int left=0;
		int right=left+1;
		
		while(left<=arr.length-1 && right<=arr.length-1){
			int temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left=right+1;
			right=left+1;
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
	}
}