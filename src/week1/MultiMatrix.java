/**
 * 
 */
package week1;

import java.util.Arrays;

/**
 * @author hung
 *
 * @aim: 
 */
public class MultiMatrix {
	/**
	 * 
	 */
	private static int[][] mul(int[][]Y, int[][]Z, int n) {
		// TODO Auto-generated method stub
		int[][]X= new int [n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				X[i][j]= 0;
				for (int k = 0; k < n; k++) {
					X[i][j]= X[i][j] + Y[i][k] * Z[k][j];
				}
			}
		}
		return X;
	}
	
	public static void main(String[] args) {
		int[][]Y= {{1,5,3}, {2, 5, 8}, {8, 7, 4}};
		int[][]Z= {{1,5,3}, {2, 5, 8}, {8, 7, 4}};
		int[][]X= mul(Y, Z, 3);
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X.length; j++) {
				System.out.print(X[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
