import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
         int m = scn.nextInt();
         
         int[][] gold = new int[n][m];
         
         for(int i=0; i < n ; i++){
            for(int j=0; j < m ; j++){
               gold[i][j] = scn.nextInt(); 
            }
         }
         
         int[][] dp = new int[n][m];
         
         //int max = Integer.MIN_VALUE;
         for(int col = gold[0].length-1; col>=0; col--){
             for(int row = gold.length-1; row >= 0; row--){
                 
                if(col == dp[0].length-1){
                    dp[row][col] = gold[row][col];
                }
                else if(row == dp.length-1){
                    dp[row][col] = gold[row][col] +Math.max(dp[row][col+1],dp[row-1][col+1]);
                }
                
                else if(row == 0){
                    dp[row][col] = gold[row][col] +Math.max(dp[row][col+1],dp[row+1][col+1]);
                }
                else{
                    dp[row][col] = gold[row][col] + Math.max(dp[row-1][col+1],Math.max(dp[row][col+1],dp[row+1][col+1]));
                }
    }
             
         }
         int max = dp[0][0];
         for(int i = 1; i<dp.length-1; i++){
             max = Math.max(max,dp[i][0]);
         }
         System.out.println(max);

}
    
}