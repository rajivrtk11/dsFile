import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i =1 ; i<s.length(); i++){
            if(i == 1){
                int value1 = s.charAt(i) - '0';
                if(value1 != 0){
                    dp[i] = dp[i-1];
                }
                int value2 = s.charAt(i-1) - '0';
                int value = value2*10 + value1;
                if(value >=10 && value <=26){
                    dp[i] += 1;
                }
            }
            else{
                int value1 = s.charAt(i) - '0';
                if(value1 != 0){
                    dp[i] = dp[i-1];
                }
                int value2 = s.charAt(i-1) - '0';
                int value = value2*10 + value1;
                if(value >=10 && value <=26){
                    dp[i] += dp[i-2];
                }
            }
        }
        System.out.println(dp[s.length()-1]);
    }
}