package recursive;

/**
 * @aim: 
 */
public class UCLN {
	private static int ucln(int a, int b) {
		// TODO Auto-generated method stub
		if(b==0) return a;
		else {
			return ucln(a, a%b);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(ucln(6, 3));
	}
}
