import java.util.*;

class maxMin{

    public static int fib(int n, int[] dp){
        if(n <= 1) return dp[n] = n;

        if(dp[n] != 0) return dp[n];
        int a = fib(n-1, dp);
        int b = fib(n-2, dp);

        return dp[n] = a+b;

    }

    public static void solve(){
        int[] dp = new int[6];
        int ans = fib(5, dp);
        System.out.println(ans);
        
    }

    public static void main(String[] args){
        solve();
        System.out.println("hello world");
    }
} 