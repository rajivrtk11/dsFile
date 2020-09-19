import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        maximumSum(arr);
    }
    public static void maximumSum(int[]arr){
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        
        int maxSum = dp[0];
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] = dp[i]+arr[i];
            maxSum = Math.max(maxSum,dp[i]);
        }
        System.out.println(maxSum);
    }

}