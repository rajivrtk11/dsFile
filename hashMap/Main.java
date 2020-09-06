/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{

	// public static void main (String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     int t = Integer.parseInt(br.readLine());
    //     for(int tc = 0; tc < t; tc++ ){
    //         int n = Integer.parseInt(br.readLine());
    //         int arr[] = new int[n];
    //         String line = br.readLine();
    //         int j = 0;
    //         for(String st: line.split("\\s")){
    //             arr[j++] = Integer.parseInt(st);
    //         }
    //         int ans = solve(arr);
    //         System.out.println(ans);
    //     }
    // }
     public static void main(String[] args){
        //  String s1 = "fcdhaebg";
        //  String s2 = "cafdhbge";
        //  System.out.println(Arrays.toString(anaMap(s1,s2)));

        // String s1 = "fdbacedgfacgbh";
        // String s2 = "abbgefdfghccad";
        // System.out.println(anaMapWithDup(s1,s2));

        // print alphabet
        printAlphabet();
     }

     // < --------------------------------------print a,b,c,d in a loop-------------------------->
     static void printAlphabet(){
         for(char ch = 'a'; ch <= 'z'; ch++){
             System.out.print(ch+" ");
         }
         System.out.println();
         for(int i = 0; i<26; i++){
            //  int al = ;
            //  char ch = ;
             System.out.print((char)('a'+i)+" ");
         }
     }

     // < --------------------------------------count Substring with equal 0's , 1's and 2's-------------------------->
    /*  Static int countSubst012(int arr[]){
         for(int i = 0 ; i < arr.length; i++){
             for(int j = i+1; j < arr.length; j++ ){
                 
             }
         }
         return 0;
     } */

     //<--------------------- anagram mapping   ----------------------------------------------------------------------->
     /* static int[] anaMapWithDup(String s1, String s2){
        //   HashMap<Character,new PriorityQueue<Integer>()> hm = new HashMap<>();

         int fmap2[] = new int[s2.length()];
         for(int i = 0; i < s1.length(); i++){
             hm.put(s1.charAt(i),i);
             
         } 
         for(int i = 0; i < s2.length(); i++){
             fmap2[i] = hm.get(s2.charAt(i));
         }
         return fmap2;
     } */

     //<--------------------- anagram mapping   ----------------------------------------------------------------------->
     static int[] anaMap(String s1, String s2){
          HashMap<Character,Integer> hm = new HashMap<>();

         int fmap2[] = new int[s2.length()];
         for(int i = 0; i < s1.length(); i++){
             hm.put(s1.charAt(i),i);
             
         } 
         for(int i = 0; i < s2.length(); i++){
             fmap2[i] = hm.get(s2.charAt(i));
         }
         return fmap2;
     }
    // equivalent subArray from hashMap pdf
    static int solve(int arr[]){
            HashSet<Integer> hs = new HashSet<>();
            for(int ele:arr){
                hs.add(ele);
            }
            HashMap<Integer,Integer> hm = new HashMap<>();
            int left = 0;
            int count = 0;
            for(int i = 0; i<arr.length; i++){
                //acquire
                hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
                while(hm.size() == hs.size()){
                    // count
                   count += arr.length - i;
                   // release
                   if(hm.get(arr[left]) > 1)
                   hm.put(arr[left],hm.get(arr[left])-1);
                   else if( hm.get(arr[left]) == 1 ) hm.remove(arr[left]);
                   left++;
                }
            }
            return count;
        }

        // java solution with hashmap and priorityQueue
            //     Map<Character, Integer> map = new HashMap<>();
            //     char[] characters = s.toCharArray();
            //     for(int i=0; i<characters.length(); i++)
            //     {
            //         if(map.containsKey(characters[i]))
            //             map.put(characters[i], map.get(characters[i])+1);
            //         else
            //             map.put(characters[i], 1);
            //     }
                
            //     PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            //             (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : b.getValue()-a.getValue()
            //     );
                
            //     for(Map.Entry<Character, Integer> entry: map.entrySet())
            //     {
            //         pq.offer(entry);
            //     }
                
            //     StringBuilder sb = new StringBuilder();
            //     while(!pq.isEmpty()) {
            //         Map.Entry<Character, Integer> entry = pq.poll();
            //         for(int i=0; i< entry.getValue();i++) {
            //             sb.append(entry.getKey());
            //         }
            //     }
            //     return sb.toString();
            // }
}