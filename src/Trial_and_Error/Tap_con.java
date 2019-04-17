package Trial_and_Error;
import java.util.Scanner; 
public class Tap_con {

	public static void showResult(int a[],int k){
		int i; 
        for(i=1 ; i<=k ; i++){
            System.out.print(" "+a[i]);
        }
        System.out.println(); 
	}
	public static void try_backTrack(int a[], int n, int k, int i){ 
        int j;
        for(j=a[i-1]+1 ; j<=(n-k+i) ; j++){ 
           a[i]= j;
           if(i== k) showResult(a,k);
           else try_backTrack(a, n, k, i+1);
        }
	}
	public static void main(String[] args) { 
        int n= 6;
        int[] array= new int[n+1]; 
        int k;
        System.out.println("Liet ke tat ca cac tap con k phan tu cua 1,2,..,"+n+" : "); 
        for(k=1 ; k<=n ; k++){
        	System.out.println("\n Tap con "+k+" phan tu: "); 
        		try_backTrack(array,n,k,1);
        }
	}
} 