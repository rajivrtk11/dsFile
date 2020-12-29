import java.io.*;
import java.util.*;

public class Main {

    static String[] codes = {
       ";", "abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"
    };
    
    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            String str  = scn.nextLine();
            ArrayList<String> arrlist = getKPC(str);
            System.out.println(arrlist);
    }
    
    public static ArrayList<String> getKPC(String str) {
        
        if(str.length() == 0){
            ArrayList<String> ansList = new ArrayList<>();
            ansList.add("");
            return ansList;
        }
        
        
        
        String ros = str.substring(1);
        ArrayList<String>retValues = getKPC(ros);
        ArrayList<String> myAns = new ArrayList<>();
        
        String firstChar = str.substring(0,1);
        int idx = Integer.parseInt(firstChar);
        
        for(int i = 0 ; i< codes[idx].length();i++){
          char ch = codes[idx].charAt(i);
          for(String ans : retValues){
              myAns.add(ch+ans);
          }
        }
        
        return myAns;
    }

}