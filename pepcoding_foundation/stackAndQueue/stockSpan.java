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

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   Stack<Integer> st = new Stack<>();
   int[] ss = new int[arr.length];
   
   ss[0] = 1;
   st.push(0);
   
   for(int i = 1; i<arr.length; i++){
       
     // remove the smaller elements
     while(st.size() > 0 && arr[st.peek()] < arr[i] ){
         st.pop();
     }
     
     // put index into the ss array
     if(st.size() == 0){
         ss[i] = i+1;
     }
     else{
         ss[i] = i - st.peek();
     }
     
     // update the stack
     st.push(i);
    }
    return ss;
 }

}