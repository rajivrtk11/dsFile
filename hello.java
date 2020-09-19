import java.util.*;
import java.io.*;
class hello{
     public static void subArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++ ){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        /* int arr[] = {20,8,3,4,9,5};
        subArray(arr); */
        // char ch = 'a';
        // for(int i = 0; i < 5; i++){
        //     System.out.println(ch++);
        // }

        Scanner scn = new Scanner(new InputStreamReader(System.in));
        
        int arr[] = new int[5];
        for(int i = 0; i < 5; i++){
            arr[i] = scn.nextInt();
        }
        for(int i = 0; i < 5; i++){
            System.out.print(arr[i]+" ");
        }

        }
}