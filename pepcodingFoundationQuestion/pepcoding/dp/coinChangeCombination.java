import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int dp[] = new int[amt+1];
        
        dp[0] = 1;
        for(int j = 0; j<arr.length; j++){
        for(int i = 1; i<dp.length; i++){
                
                if(i>=arr[j]){
                    dp[i] += dp[i-arr[j]];
                }
            }
        }
        System.out.println(dp[amt]);
    }
    
    // public static int coinCount(int arr,int amt){
        
        
    //     return dp[dp.length-1];
    // }
}