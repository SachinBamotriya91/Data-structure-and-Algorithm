public class NaiveSearch{
	public static void main(String args[]){
		String text="My Name is Sachin Bamotriya";
		String pattern="Bamotriya";
		NaiveSearch.search(text,pattern);
	}
	public static void search(String text,String pattern){
		int m=pattern.length();
		int n=text.length();
		int j;
		for(int i=0;i<=n-m;i++){
			for(j=0;j<m;j++)
				if(pattern.charAt(j)!=text.charAt(i+j))
					break;
			if(j==m)
				System.out.println("Pattern "+pattern+" found at Index :"+i);
		}
	}
}