import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
            }
        
        int[] lis = new int[n];
        int[] lds = new int[n];
        
        // fill lis
        lis[0] =1;
        
        
        for(int i = 1; i<lis.length; i++){
            int max = 0;
            for(int j = 0; j<i; j++){
                if(arr[j] <= arr[i]){
                    max = Math.max(max,lis[j]);
                }
            }
            lis[i] = max+1;
        }
        
       // fill lds
       lds[lds.length-1] = 1;
       for(int i = lds.length-2; i>=0; i--){
           int max = 0;
           for(int j = lds.length-1; j > i; j--){
               if(arr[j] <= arr[i]){
                   max = Math.max(max,lds[j]);
               }
           }
           lds[i] = max+1;
       }
       
       int bitonic = 0;
       for(int i = 0; i<n; i++){
           bitonic = Math.max(bitonic, lis[i] + lds[i]);
       }
       System.out.println(bitonic-1);
       
    }
    }