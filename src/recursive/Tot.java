package recursive;

/**
 * @aim: 
 */
public class Tot {
	public static int countPath(int i, int j, int n, int m)
	{
		if (i < 0 || j < 0) {
			return -1;
		} else if (i == n || j == m) {
			return 1;
		} else {
			return countPath(i+1, j, n, m)+countPath(i, j+1, n, m);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(countPath(2, 1, 3, 5));
	}
}
