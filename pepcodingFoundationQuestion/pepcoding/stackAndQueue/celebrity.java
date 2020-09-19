import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it''s index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        int[] person = new int[arr.length];
        
        
        // push all array elements
        for(int i = 0; i<person.length; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            //pop top two elements
            int a = st.pop();
            int b = st.pop();
            
            // check if they knows each other
             if(knows(a,b,arr) == true){
                  st.push(b);
             }
             else{
                 st.push(a);
             }
         }
         
         int c = st.peek();
         boolean get = getCeleb(c,arr);
         
         if(get){
             System.out.println(c);
         }
         else{
            System.out.println("none"); 
         }
         
        
        
    }
    
    public static boolean knows(int a, int b, int[][] arr){
        
        if(arr[a][b] == 1){
            return true;
        }
        return false;
    }
    
    public static boolean getCeleb(int n,int[][] arr){
        
        for(int i = 0; i<arr[0].length; i++){
            
            if(i == n){
                continue;
            }
            else if(arr[n][i] != 0 || arr[i][n] != 1){
                return false;
            }
        }
        return true;
    }

}