import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    long[] sp = new long[n+1];
    long[] bl = new long[n+1];
    
    sp[1] = 1;
    bl[1] =1;
    
    
    for(int i = 2; i < n+1; i++){
        sp[i] = sp[i-1] + bl[i-1];
        bl[i] = sp[i-1];
    }
    
    long way  = sp[n] + bl[n];
    long bothWay = way*way;
    
    System.out.println(bothWay);
    
 }

}