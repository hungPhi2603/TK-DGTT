package Trial_and_Error;

/**
 * @aim: generate a binary string length n
 */
public class BinaryString {
	
	static int[]a= new int [100];
	
	private static void binary(int n, int i) {
		for(int j=0;j<=1;j++) {
	        a[i]=j;
	        if(i==n-1) {
	        	for(int x=0;x<n;x++) {
	    	        System.out.print(a[x]);
	        	}
	        	System.out.println();
	        }
	        else binary(n, i+1);
	    }
	}
	
	
	public static void main(String[] args) {
		binary(3, 0);		
	}
}
