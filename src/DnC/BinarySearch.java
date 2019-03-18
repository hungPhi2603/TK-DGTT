package DnC;

/**
 * @aim: find an element in sorted array
 */
public class BinarySearch {
	private static int binarySearch(int x, int[] a, int l, int r) {
		// TODO Auto-generated method stub
		if(l==r) return (x==a[l] ? l : -1);
		else {
			int m= (l+r)/2;
			if(x==a[m]) return m;
			else {
				if(x < a[m]) return binarySearch(x, a, l, m);
				else return binarySearch(x, a, m+1, r);
			}
		}
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] a= {1, 4, 6, 9, 10, 15, 16, 17, 18, 19, 20, 22, 23, 25, 30, 32, 35, 36, 40};
		System.out.println(binarySearch(21, a, 0, a.length-1));
		long end = System.nanoTime();
        long t = end - start;
        System.out.println(t);
	}
}
