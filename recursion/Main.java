public class Main{
    //=========================================================================================
    
    //================================count using recursion=========================================================
    public static int count(int n){
        if(n == 1) return n;
        int count = n + count(n-1);
        return count;
    }
    //=========================================================================================
    public static void count(){
        int ans = count(1000);
        System.out.println(ans);
    }

    //===================================factorial question======================================================
    public static int factorial(int n ){
        // base condition
        if(n == 1){
            return 1;
        }
        // call 
        int ans = factorial(n-1)*n;
        return ans;
    }
    //=========================================================================================
    public static void factCall(){
        int ans = factorial(5);
        System.out.println(ans);
    }
    //===================================fibonacci question======================================================
    public static int fibonacci(int n){
        //base
        if(n < 0 )return 0;
        if(n == 0 || n == 1) return n;

        // call
        int ans = 0;
        ans = fibonacci(n-1) + fibonacci(n-2);
        return ans;
    }
    //=========================================================================================
    static void fibCall(){
        int ans = fibonacci(3);
        System.out.println(ans);
    }
    //=========================================================================================
    public static void solve(){
        // call calling function of void type
        //fibCall();
        //factCall();
        count();
    }
    //=========================================================================================
    public static void main(String[] args){
        solve();
    }
}