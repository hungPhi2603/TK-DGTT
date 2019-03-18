package recursive;

/**
 * @aim:
 */
public class Fibonacci {
	private static int findNumber(int n) {
		// TODO Auto-generated method stub
		if(n==1 || n==2) return 1;
		else {
			return findNumber(n-1) + findNumber(n-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findNumber(5));
	}
}
