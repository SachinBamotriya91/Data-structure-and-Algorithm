public class SubarraySum{
	public static void main(String args[]){
		int arr[]={1, 4, 20, 3, 10, 5};
		int sum=33;
		int temp=0;
		for(int i=0;i<arr.length;i++){
			temp=arr[i];
			for(int j=i+1;j<arr.length;j++){
				temp=temp+arr[j];
				if(temp==sum)
					System.out.print("i="+i+" j="+j);
				else if(temp>sum)
					break;
			}
		}
	}
}