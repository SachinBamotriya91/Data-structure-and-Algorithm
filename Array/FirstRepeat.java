public class FirstRepeat{
	public static void main(String args[]){
		int arr[]={10, 5, 3, 4, 3, 8, 6};
		int r=FirstRepeat.firstRepeat(arr);
		System.out.println("First Repeating Element :"+r);
	}
	public static int firstRepeat(int arr[]){
		int temp;
		for(int i=0;i<arr.length;i++){
			temp=arr[i];
			for(int j=i+1;j<arr.length;j++){
				if(temp==arr[j])
					return temp;
			}
		}
		return -1;
	}
}