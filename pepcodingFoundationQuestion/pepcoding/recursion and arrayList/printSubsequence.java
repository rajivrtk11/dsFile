import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        printSS(str,"");
        System.out.println();
    }

    public static void printSS(String str,String ssf) {
        
        if(ssf.length() == 0 && str.length() == 0) {
          return; 
        }
        if(str.length() == 0 ) {
            System.out.println(ssf);
            return;
        }
        
        String nstr = str.substring(1);
        char ch = str.charAt(0);
        
        printSS(nstr,ssf);
        printSS(nstr,ssf+ch);
        
    }

}