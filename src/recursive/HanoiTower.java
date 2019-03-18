package recursive;

/**
 * @author hung
 *
 * @aim: 
 */
public class HanoiTower {
	private static void play(int n, String a, String b, String c) {
		// TODO move the tower from A to B (A, B, C are stakes)
		if (n==1) {
			System.out.println(a + " -> " + b);
		}
		else {
			play(n-1, a, c, b);
			System.out.println(a + " -> " + b);
			play(n-1, c, b, a);
		}
	}
	
	public static void main(String[] args) {
		play(3, "a", "b", "c");
	}
}
