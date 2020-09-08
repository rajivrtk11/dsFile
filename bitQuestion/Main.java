import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;
class Main{

    static void nAnd1(){
        int n =2;
        if((n&1)== 0){
            System.out.println(n);
        }
        //System.out.println(typeOf(n&1));
    }
    //<---------------------------------------calling function ---------------------------------------------->

    // static int[] countBits(int n){
    //     ArrayList<Integer> al = new ArrayList<>();
    //     for(int i = 0; i <= n; i++){
    //         int count = 0;
    //         while(n >= 0){
    //             n &= n-1;
    //             count++;
    //         }
    //         al.add(count);
    //     }
    //     int arr[] = new int[al.size()];
    //     for(int i = al.size()-1; i >= 0 ; i--){
    //        arr[i] =  al.remove(i);
    //     }
    //     return arr;
    // }
    //<---------------------------------------calling function ---------------------------------------------->
    static int getIthBit(int n, int i){
        int mask = 1<<i;
        int ans = (n & mask) != 0? 1: 0;
        return ans;
    }
    //<---------------------------------------calling function ---------------------------------------------->
    public static void setIthBit(int n, int i){
        int mask = (1<<i);
        int n = (n|mask);
    }
    //<---------------------------------------calling function ---------------------------------------------->

    static void callingFn(){
        nAnd1();
    }
    //<---------------------------------------main function ---------------------------------------------->
    public static void main(String[] args){
        //callingFn();
        // int arr[] = countBits(2);
        // System.out.println(Arrays.toString(arr));
        // int ans = getIthBit(5,5);
        setIthBit(5,1);
        System.out.println(ans);        
    }
    
}