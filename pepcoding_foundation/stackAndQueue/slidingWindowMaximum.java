import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    
    // code 
    Stack<Integer> st = new Stack<>();
    int nge[] = new int[n];
    nge[nge.length-1] = n;
    st.push(nge.length-1);
    
    for(int i =  nge.length-2; i>=0; i--){
        //
        //pop all small elements
        while(st.size() > 0 && a[st.peek()] <= a[i]){
            st.pop();
        }
        // check stack size
        nge[i] = st.size() == 0 ? n: st.peek();
        // update stack
        
        st.push(i);
        
    }
    int[] swm = new int[n-k+1];
    for(int i =0; i<swm.length; i++){
        int j = i;
        while(nge[j] <= i+k-1){
            j = nge[j];
        }
        swm[i] = a[j];
    }
    for(int i = 0; i< swm.length; i++){
        System.out.println(swm[i]);
    }
    
    
 }
}