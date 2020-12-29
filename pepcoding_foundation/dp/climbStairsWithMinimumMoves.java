import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(csmm(arr));
        
    }
    public static int csmm(int[] arr){
        
        int[] tab = new int[arr.length];
        tab[arr.length-1] = 0;
        
        for(int i = arr.length-2; i>=0; i--){
            
            tab[i] = Integer.MAX_VALUE;
           if(arr[i] == 0){
               tab[i] = Integer.MAX_VALUE;
               continue;
           }
            for(int j = 1; j<= arr[i] && j+i < arr.length; j++){
                
                
                   tab[i] = Math.min(tab[i],tab[i+j]);
              
                 
            }
            tab[i] = tab[i]+1;
        }
        return tab[0];
    }

}