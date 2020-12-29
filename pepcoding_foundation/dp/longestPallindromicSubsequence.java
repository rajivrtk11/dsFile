import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        // int sp = 0;
        // int ep = str.length()-1;
        
        int[][] dp = new int[str.length()][str.length()];
        
        
        for(int gap = 0; gap <dp.length; gap++){
            int sp = 0;
            int ep = gap;
            while(ep<dp.length){
                
                if(gap == 0){
                    dp[sp][ep] = 1;
                }
                else{
                   if(str.charAt(sp) == str.charAt(ep)){
                    dp[sp][ep] = 2+dp[sp+1][ep-1];
                }
                else{
                    dp[sp][ep] = Math.max(dp[sp][ep-1],dp[sp+1][ep]);
                } 
                }
                
                
                sp++;
                ep++;
            }
        }
        System.out.println(dp[0][str.length()-1]);
    }

}