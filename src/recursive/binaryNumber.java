package recursive;

public class binaryNumber {
	private static String div(int n) {
		// TODO Auto-generated method stub
		String s= "";
		if (n==0) {
			return "";
		} else {
			s= Integer.toString(n%2);
		}
		return div(n/2)+s;
	}
	
	public static void main(String[] args) {
		System.out.println(div(30));
	}
}
