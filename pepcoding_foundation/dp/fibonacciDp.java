import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n =  scn.nextInt();
    int[] qb = new int[n+1];
    
    System.out.println(fibM(n,qb));
 }
  public static int fibM(int n, int[]qb){
      if(n == 0 || n == 1){
          return n;
      }
      //Long start = System.currentTimeMillis();
      int fib1 = fibM(n-1,qb);
      int fib2 = fibM(n-2,qb);
      
      
      int res = fib1+fib2;
      qb[n] = res;
      
      return res;
  }

}