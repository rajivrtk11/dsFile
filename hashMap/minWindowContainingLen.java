/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class minWindowContainingLen {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<tc; i++){
            String st = br.readLine();
            //String t = br.readLine();
            int ans = solve(st);
            System.out.println(ans);
        }
	}
	public static int solve(String st){
	   
	    HashMap<Character,Integer> fqt = new HashMap<>();
	    for(int i = 0; i< st.length(); i++){
	        char ch = st.charAt(i);
	        fqt.putIfAbsent(ch,1);
	        
	    }
	    int left=0;
	    int length = (int)1e8;
	    int lenInd = -1;
	    int matchCount = 0;
	    
	    for(int i = 0; i < st.length() && left < st.length(); i++){
	        char ch = st.charAt(i);
	        // acquire
	        if(fqt.containsKey(ch)){
	            if(fqt.get(ch) > 0){
	                matchCount++;
	            }
	            fqt.put(ch,fqt.get(ch)-1);
	        }
	        while(matchCount == fqt.size()){
	            // settle
	            int tempLen = i-left+1;
	            if(tempLen < length){
	                length = tempLen;
	                lenInd = left;
	            }
	            
	            // release
	            if(fqt.containsKey(st.charAt(left)) ){
	                fqt.put(st.charAt(left),fqt.get(st.charAt(left))+1);
    	            if(fqt.get(st.charAt(left)) > 0)
    	              matchCount--; 
	            }
	            left++;
	        }
	        
	    }
	   // if(lenInd == -1){
	   //     return "-1";
	   // }
	    return length;
	}
}