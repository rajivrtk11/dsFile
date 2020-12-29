import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printNQueens(new int[n][n],"",0);
        System.out.println();
    }
    
    public static boolean isSafe(int chess[][],int row,int col){
        
        for(int i = row-1, j= col-1; j>=0 && i>=0;i--,j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        
        for(int i = row-1; i>=0;i--){
            if(chess[i][col] == 1){
                return false;
            }
        }
        
        for(int i = row -1, j = col+1; i>=0 && j< chess[0].length;i--,j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf+".");
            return;
        }
        
        for(int col = 0; col<chess[0].length; col++){
            if(isSafe(chess,row,col)){
                chess[row][col] = 1;
                printNQueens(chess,qsf+row+"-"+col+", ",row+1);
                chess[row][col] = 0;
            }
        }
    }
}