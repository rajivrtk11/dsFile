import java.io.*;
import java.util.*;

public class Main {
    
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
    public static int getPrecedence(char ch){
        if(ch=='*' || ch=='/'){
            return 2;
        }
        else{
            return 1;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // code
        
        Stack < Integer > s1 = new Stack < > ();
        Stack < Character > s2 = new Stack < > ();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int num = ch - '0';
                s1.push(num);
            } else if (ch == '(') {
                s2.push(ch);
            } else if (ch == ')') {
                while( s1.size()>1 && s2.size() > 0 && s2.peek() != '('){
                    int v2 = s1.pop();
                    int v1 = s1.pop();
                    char op = s2.pop();
                    int value = solve(v1 , v2 , op);
                    s1.push(value);
                }
                s2.pop();
                
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while(s1.size()>1 && s2.size() > 0 && s2.peek() != '(' 
                && getPrecedence(s2.peek()) >= getPrecedence(ch)){
                    int v2 = s1.pop();
                    int v1 = s1.pop();
                    char op = s2.pop();
                    int value = solve(v1 , v2 , op);
                    s1.push(value);
                }
                s2.push(ch);
            }
        }
        while(s1.size() > 1 && s2.size()>0){
            int v2 = s1.pop();
            int v1 = s1.pop();
            char op = s2.pop();
            int value = solve(v1 , v2 , op);
            s1.push(value);
        }
        System.out.println(s1.pop());
    }
}