import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printEncodings(str,"");
        System.out.println();
    }

    public static void printEncodings(String ques,String asf) {
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }
         
         char ch = ques.charAt(0);
         if(ch == '0'){
             return;
         }
         else{
             int key = Integer.parseInt(ch+"");
             
             printEncodings(ques.substring(1),asf+(char)('a'+key-1));
             
             if(ques.length() > 1){
                 
                  String num = ques.charAt(0) +""+ques.charAt(1);
                  int numKey = Integer.parseInt(num);
                  
                  if(numKey>=11 && numKey <=26){
                       printEncodings(ques.substring(2),asf+(char)('a'+numKey-1));
                  }
                 
             }
         }
         
    }

}