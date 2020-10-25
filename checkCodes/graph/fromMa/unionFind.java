import java.util.*;
import java.io.*;

public class unionFind{
    public static void main(String[] args){
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = scn.nextInt();
            }
            int ans = findShift(arr);
            System.out.println(ans);

        }
    }

    public static int findShift(int[] arr){
        Stack<Integer> st = new Stack<>();
        int i = 0;
        for( i = 0; i<arr.length; i++){
            if(arr[i] == 1) break;
        }
        while(i+1 != arr.length){
            st.push(arr[i]);
        }

        int j = 0;
        while(st.peek() != 1){
            st.pop();
        }
        int count = 0;
        while(st.size() > 0){
            int val = st.pop();
            if(val == 0) count++;
        }
        return count;
    }
}
