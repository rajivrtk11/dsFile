import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i< n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(csvj(n,arr));
    }
    // climb stair with variable jump
    public static int csvj(int n, int[]arr){
        int[] tab = new int[n];
        
        tab[arr.length-1] = 1;
        for(int i = n-2; i>= 0; i--){
            for(int j = 1; j<= arr[i]; j++){
                if(i+j<n){
                    tab[i] += tab[i+j];
                }
            }
        }
        return tab[0];
    }

}