import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] coins = new int[n];
        for(int i =0 ;i<n;i++){
            coins[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();
        
        boolean[][] dp = new boolean[n][target+1];
        
        for(int i = 0; i<dp.length;i++){
            for(int j = 0 ; j<dp[0].length; j++){
                
                if(i == 0 ){
                    if(j == coins[i]){
                        dp[i][j] = true;
                    }
                }
                
                else if(j == 0){
                    dp[i][j] = true;
                }
                   
                else{
                    dp[i][j] = dp[i-1][j];
                    
                    if(dp[i][j] == false){
                        if(j >= coins[i]){
                            dp[i][j] = dp[i-1][j-coins[i]];
                        }
                     }
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}