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
        int x = scn.nextInt();
        firstIndex(arr,0,x);
        System.out.println();
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(arr[idx] == x){
            System.out.println(idx);
            return idx;
           
        }
        
        firstIndex(arr,idx+1,x);
        
        return -1;
    }

}