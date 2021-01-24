
import java.util.*;


public class main{
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;

        int ans = coinChangePer(arr, tar, 0, "");
    }

    public static int coinChangePer(int[] arr, int tar, int idx, String ans){
        
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        if(tar < 0){
            return 0;
        }

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count += coinChangePer(arr, tar - arr[i], 0, ans + arr[i]);
        }

        return count;
    }
}