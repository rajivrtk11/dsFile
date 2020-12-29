import java.io.*;
import java.util.*;

public class Main{
  
public static int solve(int v1 , int v2 , char op){
        if(op=='+'){
            return v1+v2;
        }
        else if(op=='-'){
            return v1-v2;
        }
        else if(op=='*'){
            return v1*v2;
        }
        else{
            return v1/v2;
        }
    }
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> st = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    
    for(int i=exp.length()-1 ; i>=0 ; i--){
        char ch = exp.charAt(i);
        if(ch >='0' && ch<='9'){
            st.push(ch-'0');
            infix.push(ch+"");
            postfix.push(ch+"");
        }
        else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
            //evaluation
            int v1 = st.pop();
            int v2 = st.pop();
            int val = solve(v1 , v2 , ch);
            st.push(val);
            
            //infix
            String inv1 = infix.pop();
            String inv2 = infix.pop();
            String inVal = "(" + inv1 + ch + inv2 + ")";
            infix.push(inVal);
            
            //postfix
            String prev1 = postfix.pop();
            String prev2 = postfix.pop();
            String preVal = prev1+prev2+ch;
            postfix.push(preVal);
        }
    }
    System.out.println(st.pop());
    System.out.println(infix.pop());
    System.out.println(postfix.pop());
 }
}