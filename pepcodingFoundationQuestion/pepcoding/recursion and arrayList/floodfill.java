import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m =scn.nextInt();
        int [][] maze = new int[n][m];
        for(int i =0; i<n; i++){
            for(int j = 0; j< m; j++){
                maze[i][j] = scn.nextInt();
            }
        }
        
        floodfill(maze,0,0,"",new boolean[n][m]);
    }

    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited){
        int n = maze.length;
        int m = maze[0].length;
        
        if(row == n-1 && col == m-1){
            System.out.println(psf);
            return;
        }
        
        if(visited[row][col] == true || maze[row][col] == 1){
            return;
        }
        
        visited[row][col] =true;
        if(row-1 >=0){
            floodfill(maze,row-1,col,psf+"t",visited);
        }
        
        if(col-1 >= 0){
             floodfill(maze,row,col-1,psf+"l",visited);
        }
        
        if(row +1 < n){
             floodfill(maze,row+1,col,psf+"d",visited);
        }
        
          if(col + 1 < m){
             floodfill(maze,row,col+1,psf+"r",visited);
        }
        visited[row][col] = false;
    }
}