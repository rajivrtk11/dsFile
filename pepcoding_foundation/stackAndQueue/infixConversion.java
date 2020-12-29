import java.io.*;
import java.util.*;

public class Main {

    public static int getPrecedence(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        // code
        Stack < Character > st = new Stack < > ();
        Stack < String > postfix = new Stack < > ();
        Stack < String > prefix = new Stack < > ();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                //posfix
                postfix.push(ch + "");
                //prefix
                prefix.push(ch + "");
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (st.size() > 0 && postfix.size() > 1 && st.peek() != '(') {
                    char op = st.pop();
                    //postfix
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postVal = postv1 + postv2 + op;
                    postfix.push(postVal);

                    //prefix
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preVal = op + prev1 + prev2;
                    prefix.push(preVal);
                }
                st.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                while (st.size() > 0 && postfix.size() > 1 && st.peek() != '(' &&
                    getPrecedence(st.peek()) >= getPrecedence(ch)) {
                    char op = st.pop();
                    //postfix
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postVal = postv1 + postv2 + op;
                    postfix.push(postVal);

                    //prefix
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preVal = op + prev1 + prev2;
                    prefix.push(preVal);
                }
                st.push(ch);
            }
        }
        
        while(st.size()>0 && postfix.size()>1){
                    char op = st.pop();
                    //postfix
                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postVal = postv1 + postv2 + op;
                    postfix.push(postVal);

                    //prefix
                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String preVal = op + prev1 + prev2;
                    prefix.push(preVal);
        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());


    }
}