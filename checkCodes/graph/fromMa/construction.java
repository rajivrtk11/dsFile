import java.util.*;

public class construction{
    public static void main(String[] args){

        int[][] mat = {{1,2},{0,2},{0,1}};
        ArrayList<Integer>[] graph = new ArrayList [mat.length];
        for(int i = 0; i < mat.length; i++) graph[i] = new ArrayList<Integer>();

        for(int i = 0; i< mat.length ; i++){
            for(int j = 0; j < mat[i].length; j++){
                graph[i].add(mat[i][j]);
            }
        }

        for(int i = 0; i<graph.length; i++){
            System.out.print(i+"->");
            for(int val : graph[i]) System.out.println("(" + val +"), ");
            System.out.println();
        }
        
    }
}