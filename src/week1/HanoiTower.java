package week1;

/**
 * @author hung
 *
 * @aim: 
 */
public class HanoiTower {
	/**
	 * 
	 */
	private static void play(int n, String a, String b, String c) {
		// TODO Auto-generated method stub
		if(n==1) System.out.println(a + " -> " + b);
		else {
			play(n-1, a, c, b);
			System.out.println(a + " -> " + b);
			play(n-1, c, b, a);
		}
	}
	
	public static void main(String[] args) {
		play(3, "A", "B", "C");
	}
}
