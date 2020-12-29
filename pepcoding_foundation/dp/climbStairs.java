import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        //int[] qb = new int[n+1];
        System.out.println(climbStairs(n));
        
    }
    // climb stairs memoized
    public static int climbStairs(int n){
        
        int[] mem = new int[n+1];
        
        mem[0] =1;
        
       for(int i = 1; i<mem.length; i++){
           int ans = 0;
           if(i-1>=0){
               ans += mem[i-1];
           }
           if(i-2>=0){
               ans += mem[i-2];
           }
           if(i-3>=0){
               ans += mem[i-3];
           }
           mem[i] = ans;
       }
        
       
        return mem[n];
    }

}