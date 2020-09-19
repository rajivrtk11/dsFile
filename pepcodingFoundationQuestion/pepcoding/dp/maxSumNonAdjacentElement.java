import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int [] arr = new int[n];
        
        for(int i = 0; i<n ; i++){
           arr[i] = scn.nextInt(); 
        }
        
        int[] include = new int[n];
        int[] exclude = new int[n];
        
        include[0] = arr[0];
        exclude[0] = 0;
        
        for(int i =1; i<n ; i++){
            include[i] = exclude[i-1] + arr[i];
            exclude[i] = Math.max(include[i-1],exclude[i-1]);
        }
        
        int val = Math.max(include[n-1], exclude[n-1]);
        System.out.println(val);
       // System.out.println(exclude[n-1]);
    }
}