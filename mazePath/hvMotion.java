import java.util.*;

class hvMotion{
    public static void main(String args[]){
        mazepath_hv(new int[4][4],0,0,3,3,"");
    }
    static int count = 0;
    public static void mazepath_hv(int[][] arr, int sr, int sc, int dr, int dc, String path){
        if(sr > dr || sc > dc)
            return;
        if(sr == dr && sc == dc){
            count++;
            System.out.println(count+". "+path);
            return;
        }
        mazepath_hv(arr,sr,sc+1,dr,dc,path+"H");
        mazepath_hv(arr,sr+1,sc,dr,dc,path+"V");
    }
} 