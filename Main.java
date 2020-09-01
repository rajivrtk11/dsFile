import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
class Main{
   
   static int function(int arr[][],int sx, int sy, int dx, int dy,String path){
        if(sx > dx || sy > dy )
           return 0;
        if(sx == dx && sy == dy){
            System.out.println(path);
            return 1;
        }

        int count = 0;
        count += function(arr,sx+1,sy,dx,dy,path+'H');
        count += function(arr,sx,sy+1,dx,dy,path+'V');
        return count;
        
    }
    
     static int freqCount(int[] arr){
         HashMap<Integer,Integer> hm = new HashMap<>();
         for(int i = 0; i< arr.length; i++){
             hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
         }
         int ans = 0;
         for(int i:hm.keySet()){
             if(i >= hm.get(i)){
                 ans += i+1;
             }else{
                 double nor = (hm.get(i)*1.0)/(i+1);
                 System.out.println(nor);

                 int val = (int)((i+1)*Math.ceil(nor));
                 
                 ans += Math.ceil(val);
             }
         }
         return ans;
     }
     static boolean ap(int[] arr){
         Arrays.sort(arr);
         int d = (arr[arr.length-1]-arr[0])/(arr.length-1);
         HashSet<Integer> hs = new HashSet<>();
         for(int i= 1; i< arr.length; i++){
             hs.add(arr[i]);
         }
         for(int i = 1; i< arr.length; i++){
             if(!hs.contains(arr[i-1]+d)) return false;
         }
         return true;
     }
    //  public static void main (String[] args) {
	//     BufferedReader br = new BufferedReader(new InputSteamReader(System.in));
	//     int n = Integer.parseInt(br.readLine());
	    
	//     for(int i = 0; i<n; i++){
	//        int n1 = Integer.parseInt(br.readLine());
	//        int arr[] = new int[n1];
	//        String line = br.readLine();
	//        int j = 0;
	//        for(String st: line.split("\\s")){
	//            arr[j++] = Integer.parseInt(st);
	//        }
	//        boolean ans = ap(arr);
	//        if(ans) System.out.println("YES");
	//        else System.out.println("NO");
	//     }
	    
	// }
    static void fqMapPos(String arr){
        HashMap<Character,ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < arr.length() ;i++){
            char ch = arr.charAt(i);
            hm.putIfAbsent(ch,new ArrayList<>());
            hm.get(ch).add(i);
        }
        for(Character ch:hm.keySet() ){
            System.out.println(ch+" ->"+hm.get(ch));
        }
    }
    
     public static void main(String args[]){
       //int x =  function(new int[4][4],0,0,3,3,"");
        // int[] arr = {2,2,2,2,4,4,4,6,6,6,3,3,3,3,3,3,7,7};
        // int ans = freqCount(arr);
        // System.out.println(ans);
    //   double val = 4.0/3;
    //   System.out.println(val);
     fqMapPos("ajhvcjhjhagsx1321465kasjdbd8445632");
    }
}