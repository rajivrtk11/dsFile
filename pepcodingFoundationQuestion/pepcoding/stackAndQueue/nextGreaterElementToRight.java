import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "
");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve
   Stack<Integer> st = new Stack<>();
   int[] nge = new int[arr.length];
   nge[nge.length-1] = -1;
   st.push(arr[arr.length-1]);
   
   for(int i = arr.length-2; i>=0; i--){
      
      // pop all small elements
      while(st.size() > 0 && st.peek() <= arr[i]){
          st.pop();
      }
      
      // check stack size
      nge[i] = st.size() == 0? -1:st.peek();
      
      // update stack size
      st.push(arr[i]);
   }
   return nge;
 }

}