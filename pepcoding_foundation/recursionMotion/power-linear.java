import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int n = scn.nextInt();
        
        System.out.print(power(x,n));
    }

    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        //power(x,n-1);
        int ans = x*power(x,n-1);
        return ans;
    }

}