import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

     Scanner scn = new Scanner(System.in);
     int n = scn.nextInt();
     int m = scn.nextInt();
     System.out.println(getMazePaths(0,0,n-1,m-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc ){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // if(sr > dr || sc > dc ){
        //     ArrayList<String> empty  = new ArrayList<>();
        //     return empty;
        // }
        
         ArrayList<String> path = new ArrayList<>();
         
            
          for(int i = 1; i <= dc - sc; i++ ){
              ArrayList<String> pathH = getMazePaths(sr,sc+i, dr,dc);
          
              for(int j = 0 ; j< pathH.size(); j++){
                  path.add("h"+i+pathH.get(j));
              }
        
          }  
          
      
          for(int i = 1; i <= dr - sr; i++ ){
              ArrayList<String> pathV = getMazePaths(sr+i,sc, dr,dc);
          
              for(int j = 0 ; j< pathV.size(); j++){
                  path.add("v"+i+pathV.get(j));
              }
        
          }  
          
     
        
        for(int i =1; i <= Math.min(dr-sr,dc-sc); i++){
            ArrayList<String> pathD = getMazePaths(sr+i,sc+i, dr,dc);
            
            for(int j = 0; j<pathD.size();j++){
                path.add("d"+i+pathD.get(j));
            }
            
        }
        return path;
    }

}