import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i< n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        // traversing from 1 to jth position starting from 0
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
            
            if(maxLen < dp[i]){
                maxLen = dp[i];
            }
        }
        System.out.println(maxLen);
        //System.out.println(Arrays.toString(dp));

    }
}