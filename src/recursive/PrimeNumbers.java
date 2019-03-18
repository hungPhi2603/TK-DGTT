package recursive;

/**
 * @aim: 
 */
public class PrimeNumbers {
	private static void convert(int n) {
		int d= 2;
		if(n==1) return;
		else {
			while (n % d != 0) {
				d++;
			}
			System.out.println(d);
			convert(n/d);
		}
	}
	
	public static void main(String[] args) {
		convert(24);
	}
}
