package DnC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @aim: 
 */
public class MinMax {
	private static int[] minMax(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		//List<Integer>result= new ArrayList<>();
		int[] result= new int[2];
		if (r - l <= 1) {
			result[0]= min(a[l], a[r]);
			result[1]= max(a[l], a[r]);
			return result;
		}
		else {
			int min1= minMax(a, l, (l+r)/2)[0];
			int max1= minMax(a, l, (l+r)/2)[1];
			int min2= minMax(a, (l+r)/2+1, r)[0];
			int max2= minMax(a, (l+r)/2+1, r)[1];
			result[0]= min(min1, min2);
			result[1]= max(max1, max2);
			return result; 
		}
	}

	private static int max(int i, int j) {
		return (i <= j) ? j : i;
	}

	private static int min(int i, int j) {
		return (i >= j) ? j : i;
	}
	
	public static void main(String[] args) {
		int[] a= {2, 8, 9, 1, 6, 0};
		System.out.println(Arrays.toString(minMax(a, 0, 5)));
	}
}
