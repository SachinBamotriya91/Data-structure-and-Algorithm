public class RemoveDuplicate{
	public static void main(String args[]){
		int a[]={1,2,2,3,4,5,5,6,7,7};
		int temp[]=new int[a.length];
		int j=0;
		for(int i=0;i<a.length-1;i++){
			if(a[i]!=a[i+1])
			temp[j++]=a[i];
		}
		temp[j++]=a[a.length-1];
		
		for(int i=0;i<j;i++){
		a[i]=temp[i];
	}
	for(int i=0;i<j;i++){
		System.out.print(a[i]+"  ");
	}
	}
	
}