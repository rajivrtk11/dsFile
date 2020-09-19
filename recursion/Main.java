import java.util.ArrayList;
public class Main{

    static void StringCompare(){
        String s1 = "abcd";
        String s2 = "acd";
        boolean val = s1.equals(s2);
        System.out.println(val);
    }
    //==================================SubSequence genearation=======================================================
     static ArrayList<String> SubSequence(String str, int idx){
          // base
          if(idx == str.length()){
              ArrayList<String> al = new ArrayList<>();
              al.add(" ");
              return al;
          }

          // call 
          ArrayList<String> smallAns = SubSequence(str, idx+1);
          ArrayList<String> myAns = new ArrayList<>();
          for(String s : smallAns){
              myAns.add(s);
              myAns.add(str.charAt(idx)+s);
          }
          return myAns;
      }
    //-------------------------------------------------------------------------------------------------
     static void callSubSeq(){
        System.out.println(SubSequence("abc",0));
     }


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
        //count();
        //callSubSeq();
        StringCompare();
    }
    //=========================================================================================
    public static void main(String[] args){
        solve();
    }
}