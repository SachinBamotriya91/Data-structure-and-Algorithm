public class FindGreaterNumber{
	public static void main(String args[]){
		int a[]={4,3,2,1};
		int n=a.length;
		String result=FindGreaterNumber.result(a,n);
		System.out.print(result+"  ");
	}
	public static String result(int a[],int n){
		int max=a[n-1];
		int maxindex=n-1;
		String s="";
		
		for(int i=n-2;i>=0;i--){  
			if(a[i]>max)
			{
				max=a[i];
				maxindex=i;
			}
		}
		if(maxindex==0)
		return("not possible");
		
		int temp=a[maxindex];
		a[maxindex]=a[n-1];
		a[n-1]=temp;
		
		temp=a[maxindex];
		a[maxindex]=a[maxindex-1];
		a[maxindex-1]=temp;
		
		for(int i=0;i<n;i++)
			s=s+a[i];
		return s;
		
	}
}