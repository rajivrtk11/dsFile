import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        
        int lpsLength = 0;
        int dp[][] = new int[str.length()][str.length()];
        
        for(int g = 0; g < dp.length; g++){
            int sp = 0; 
            int ep = g;
            while(ep < dp.length){
                if(g==0){
                    dp[sp][ep] = 1;
                }
                else if(g == 1){
                    if(str.charAt(sp) == str.charAt(ep)){
                        dp[sp][ep] = 2;
                    }
                }
                else{
                    if(str.charAt(sp) == str.charAt(ep) && dp[sp+1][ep-1] != 0){
                        dp[sp][ep] = 2 +dp[sp+1][ep-1];
                    }
                }
                lpsLength = Math.max(dp[sp][ep],lpsLength);
                sp++;
                ep++;
            }
        }
        System.out.println(lpsLength);
         
    }

}