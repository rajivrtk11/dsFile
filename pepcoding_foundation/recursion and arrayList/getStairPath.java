import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String> res = getStairPaths(n);
        System.out.println(res);
    }

    public static ArrayList<String> getStairPaths(int n) {
        
       if(n == 0){
           ArrayList<String> base  = new ArrayList<>();
           base.add("");
           return base;
       }
       
        ArrayList<String> myList  = new ArrayList<>();
        
        if(n-1 >= 0){
            ArrayList<String> len1  = getStairPaths(n-1);
            for(int idx = 0; idx <len1.size();idx++){
                myList.add(1 + len1.get(idx));
            }
        }
        
        if(n-2 >= 0){
            ArrayList<String> len2  = getStairPaths(n-2);
            for(int idx = 0; idx <len2.size();idx++){
                myList.add(2 + len2.get(idx));
            }
        }
        
        if(n-3 >= 0){
            ArrayList<String> len3  = getStairPaths(n-3);
            for(int idx = 0; idx <len3.size();idx++){
                myList.add(3 + len3.get(idx));
            }
        }
        return myList;
    }

}