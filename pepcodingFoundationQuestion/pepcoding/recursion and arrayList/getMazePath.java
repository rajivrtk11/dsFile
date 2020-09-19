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
        if(sr == dr && sc == dc){
              ArrayList<String> path = new ArrayList<>();
              path.add("");
              return path;
        }
        
        ArrayList<String> path = new ArrayList<>();
        if(sc + 1 <= dc){
            
        ArrayList<String> pathH = getMazePaths(sr,sc+1,dr,dc);
        
        for(int idx = 0; idx < pathH.size(); idx++){
            path.add("h"+pathH.get(idx));
        }
        }
        if(sr +1 <= dr){
            
        ArrayList<String> pathV = getMazePaths(sr+1,sc,dr,dc);
        
        for(int idx = 0; idx < pathV.size(); idx++){
            path.add("v"+pathV.get(idx));
        }
        
        }
        
        return path;
    }

}