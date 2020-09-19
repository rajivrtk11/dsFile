import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int m = scn.nextInt();
            printMazepaths(0,0,n-1,m-1,"");
           
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazepaths(int sr, int sc, int dr, int dc, String psf) {
                if(sr == dr && sc == dc ){
                    System.out.println(psf);
                    return;
                }
                 
                 if(sr > dr || sc > dc){
                     return;
                 }
        
        		for(int j = 1; j<= dc; j++){
        			printMazepaths(sr,sc+j,dr,dc,psf+"h"+j);
        		}
        
        		for(int i = 1; i<= dr; i++){
                    printMazepaths(sr+i,sc,dr,dc,psf+"v"+i);
                }
        
                
                for(int m = 1; m <= dr -sr && m <= dc-sc  ; m++ ){
                    printMazepaths(sr+m,sc+m,dr, dc, psf+"d"+m);
                }
        }

}