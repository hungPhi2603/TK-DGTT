package DynamicPrograming;

import java.util.Arrays;

/**
 * @aim: 
 */
public class ExchangeMoney {
	static long count(int S[], int m, int n) 
	{ 
		long[] table = new long[n+1]; 

		Arrays.fill(table, 0);

		table[0] = 1; 

		for (int i=0; i<m; i++) 
			for (int j=S[i]; j<=n; j++) 
				table[j] += table[j-S[i]]; 

		return table[n]; 
	} 

	public static void main(String args[]) 
	{ 
		int arr[] = {1, 2, 5}; 
		int m = arr.length; 
		int n = 4; 
		System.out.println(count(arr, m, n)); 
	} 
}
