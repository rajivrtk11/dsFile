import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[][] cost = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j =0; j<m ; j++){
               cost[i][j] = scn.nextInt(); 
            }
        }
        
        int[][] dp = new int[n][m];
        
        for(int col = cost[0].length-1; col >=0; col--){
            for(int row = cost.length-1; row >= 0; row--){
                
                if(col == cost[0].length-1 && row == cost.length-1){
                    dp[row][col] = cost[row][col];
                }
                
                else if(col == cost[0].length-1){
                    dp[row][col] = cost[row][col] + dp[row+1][col];
                }
                
                else  if(row == cost.length-1){
                    dp[row][col] = cost[row][col] + dp[row][col+1];
                }
                
                else{
                    dp[row][col] = cost[row][col] + Math.min(dp[row+1][col], dp[row][col+1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }

}