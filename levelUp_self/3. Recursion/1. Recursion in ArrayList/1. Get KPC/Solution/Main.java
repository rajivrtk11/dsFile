
import java.util.ArrayList;
//import java.io.InputStreamReader;
import java.io.*;

class Main{

    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        String str = scn.nextLine();
        System.out.println(getKPC(str,0));
    }

    public static ArrayList < String > getKPC(String str, int idx) {
        
        // base case
        if(str.length() == idx){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        int idxString = str.charAt(idx)-'0';
        
        // call function
        ArrayList<String> ans = getKPC(str,idx+1);
        
        // myAns
        ArrayList<String> myAns = new ArrayList<>();
        String currString = codes[idxString];
        
        for(int i = 0; i < currString.length(); i++ ){
            char currChar = currString.charAt(i);
            for(String ele : ans){
                myAns.add(currChar+ele);
            }
        }
        return myAns;
    }

}