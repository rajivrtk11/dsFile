import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) throws Exception {
            
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            
            int[] val = new int[n];
            for(int i = 0; i<n; i++){
                val[i] = scn.nextInt();
            }
            
            int[] wt = new int[n];
            for(int i = 0; i<n; i++){
                wt[i] = scn.nextInt();
            }
            
            int cap = scn.nextInt();
            
            int[] dp = new int[cap+1];
            
            for(int i =0; i< dp.length; i++){
                for(int j = 0; j<val.length; j++){
                    if(i >= wt[j]){
                        dp[i] = Math.max(dp[i],dp[i-wt[j]]+val[j]);
                    }
                }
            }
           
          
               System.out.print(dp[cap]);
          
	    }
	}