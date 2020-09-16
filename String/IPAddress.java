public class IPAddress{
	public static void main(String args[]){
		String ip="";
		boolean result=IPAddress.isValid(ip);
		if(result)
			System.out.println("valid Ip");
		else
			System.out.println(" not a valid Ip");
	}
	public static boolean isValid(String ip){
		
		String arr[]=ip.split("\\.");
		if(arr.length!=4){
			return false;
		}
		for(int i=0;i<arr.length;i++){
			if(Integer.parseInt(arr[i])>255)
				return false;
		}
		return true;
		
	}
}