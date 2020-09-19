import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        boolean[][] dp = new boolean[str.length()][str.length()];
        
        int count = 0;
        for(int g = 0; g<dp.length; g++){
           int  sp = 0;
            int ep = g;
            while(ep < str.length()){
                
                if(g == 0){
                    dp[sp][ep] = true;
                }
                else if(g == 1){
                    if(str.charAt(sp) == str.charAt(ep)){
                    dp[sp][ep] = true;
                    }
                }
                else{
                   if(str.charAt(sp) == str.charAt(ep) && dp[sp+1][ep-1] == true){
                       dp[sp][ep] = true;
                   } 
                }
                if(dp[sp][ep]){
                    count++;
                }
                sp++;
                ep++;
            }
        }
        
        System.out.println(count);
        }
    }