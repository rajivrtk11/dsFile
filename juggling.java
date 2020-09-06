
import java.util.*;
import java.io.*;
class juggling{
    public static void solve(int[] arr){
        if(arr.length%2 != 0) System.out.println("T");
        else System.out.println("HL");
    }

    public static void subArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++ ){
                for(int k = i; k <= j; k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
            }
        }
    }
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int t = Integer.parseInt(br.readLine());
    //     for(int tc = 0; tc < t; tc++ ){
    //         int n = Integer.parseInt(br.readLine());
    //         int arr[] = new int[n];
    //         String line = br.readLine();
    //         int j = 0;
    //         for(String st: line.split("\\s")){
    //             arr[j++] = Integer.parseInt(st);
    //         }
    //         solve(arr);
    //     }

    //     int[] arr = {20, 8, 3, 4, 9, 5};
    //     subArray(arr);
    // }
     public static void main(String[] args){
        // int[] arr = {20, 8, 3, 4, 9, 5};
        // subArray(arr);
       TreeMap<Integer,String> tm = new TreeMap<>();
        tm.put(3, "Geeks"); 
        tm.put(2, "For"); 
        tm.put(1, "Geeks");
        System.out.println(tm);
    }
}