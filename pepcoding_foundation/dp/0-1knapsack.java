import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] val = new int[n];
        for(int i =0; i<n; i++){
            val[i] = scn.nextInt();
        }
        
        int[] wt = new int[n];
        for(int i =0; i<n; i++){
            wt[i] = scn.nextInt();
        }
        int cap = scn.nextInt();
        
        int[][] dp = new int[n][cap+1];
        
        for(int i = 0; i<dp.length; i++){
            for(int j =0; j <dp[0].length; j++){
                if(i == 0){
                    if(j >= wt[i]){
                        dp[i][j] = val[i];
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    if(j >= wt[i]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-wt[i]]+val[i]);
                    }
                }
            }
        }
        
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}