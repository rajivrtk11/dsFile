public class pract{
    static int fact(int n){
        if(n == 1) return 1;
        int ans = n*fact(n-1);
        return ans;
    }
    public static void main(String[] args){
        int ans = fact(1);
        System.out.println(ans);
    }
}