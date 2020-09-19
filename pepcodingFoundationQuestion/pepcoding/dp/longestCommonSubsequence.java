import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String str1 = scn.nextLine();
		String str2 = scn.nextLine();
		
		int n = str1.length();
		int m = str2.length();
		System.out.println(lcs(str1,str2,n,m,new int[n][m]));
		scn.close();
		
	}
	public static int lcs(String X,String Y, int n, int m,int[][]qb){
		if(n == 0 || m == 0){
			return 0;
		}
		if(qb[n-1][m-1] != 0){
			return qb[n-1][m-1];
		}
		//int ret = 0;
		if(X.charAt(n-1) == Y.charAt(m-1)){
			qb[n-1][m-1] = 1 + lcs(X,Y,n-1,m-1,qb);
			return qb[n-1][m-1];
		}
		else{
			int val1 = lcs(X,Y,n-1,m,qb);
			int val2 = lcs(X,Y,n,m-1,qb);
			qb[n-1][m-1] = Math.max(val1, val2);
		}
		return qb[n-1][m-1];
	}
}