import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(gss(str));
        

    }

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        String ros = str.substring(1);
        ArrayList<String> subs = new ArrayList<>();
        ArrayList<String> ret = gss(ros);
        
        for(String ans: ret){
            subs.add(ans);
        }
        char ch = str.charAt(0);
        for(String ans: ret){
            subs.add(ch+ans);
        }
        
        
        
        
        return subs;
    }

}