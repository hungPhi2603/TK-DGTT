package Trial_and_Error;
import java.util.Scanner; 
public class Hoan_vi {
	
	public static void main(String[] args) { 
		int n= 3;
		int[] array= new int[n+2]; 
		int i,j,k=n-1,temp,check=1; 
        for(i=0 ; i<n ; i++){
        	array[i]= i+1;
        }
        System.out.println("Cac hoan vi ke la: "); 
        try{
        	i= n-2; 
            while(check>0){
            	//In ra hoan vi System.out.println(" "); 
            	for(j=0 ; j<n ; j++){
            		System.out.print(" "+array[j]);
            	}
            	System.out.println();
            	for(i= n-2 ; i>=0 ; i--){ 
            		check= 1;
            		if(array[i] < array[i+1]){
            			if(i==n-2){
            				temp= array[i]; 
            				array[i]= array[n-1]; 
            				array[n-1]= temp; 
                            break;
            			}
            			else{
            				//Tim so a[k] nho nhat ma >a[i] trong cac so ben phai a[i] 
            				k= i+1;
            				for(j=i+1 ; j<n ; j++){
            					if(array[i+1]>array[j] && array[j]>array[i]) k=j;
            				}
            				//Doi cho a[k] va a[i] 
        					temp= array[i]; 
        					array[i]= array[k]; 
        					array[k]= temp;
        					//Sap xep lai tu a[i+1] toi a[n] 
        					for(j=i+1 ; j<n ; j++){
        						for(int m= i+1 ; m<n ; m++){ 
        							if(array[j]<array[m]){
        								temp= array[j]; 
        								array[j]= array[m]; 
        								array[m]= temp;
        							}
        						}
        					}
        					break;
            			}
            		}
            		else {
            			check=0;
            			// break;
            		}
            	}
            	//if(i==0)check=0;
            }
        }catch(Exception e){}
	}
} 