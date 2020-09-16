public class Reverse{
	public static void main(String args[]){
		int n=100;
		  for (int i=1; i<=Math.sqrt(n); i++) 
        { 
            if (n%i==0) 
            { 
                // If divisors are equal, print only one 
                if (n/i == i) 
                    System.out.printf("%d ", i); 
       
               /* else // Otherwise print both 
                    System.out.printf("%d %d ", i, n/i); */
            } 
        } 
		
		/*
		String s="I.love.programming";
		String arr[]=s.split("\\.");
		String s1="";
		for(int i=arr.length-1;i>=1;i--){
			s1=s1+arr[i]+".";
		}
		s1=s1+arr[0];
		System.out.print(s1);*/
	}
}