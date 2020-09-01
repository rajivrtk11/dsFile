
import java.util.*;
import java.io.*;
class Main{
    public static void solve(int[] arr){
        if(arr.length%2 != 0) System.out.println("T");
        else System.out.println("HL");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++ ){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];
            String line = br.readLine();
            int j = 0;
            for(String st: line.split("\\s")){
                arr[j++] = Integer.parseInt(st);
            }
            solve(arr);
        }
    }
}