/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class smallestWindow {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<tc; i++){
            String st = br.readLine();
            String t = br.readLine();
            String ans = solve(st,t);
            System.out.println(ans);
        }
	}
	public static String solve(String st, String t){
	    if(st.length() < t.length() ){
	        return "-1";
	    }
	    HashMap<Character,Integer> fqt = new HashMap<>();
	    for(int i = 0; i< t.length(); i++){
	        char ch = t.charAt(i);
	        fqt.put(ch, fqt.getOrDefault(ch,0)+1);
	        
	    }
	    int left=0;
	    int length = (int)1e8;
	    int lenInd = -1;
	    int matchCount = 0;
	    
	    for(int i = 0; i < st.length() && left < st.length(); i++){
	        char ch = st.charAt(i);
	        
	        if(fqt.containsKey(ch)){
	            if(fqt.get(ch) > 0){
	                matchCount++;
	            }
	            fqt.put(ch,fqt.get(ch)-1);
	        }
	        while(matchCount == t.length()){
	            int tempLen = i-left+1;
	            if(tempLen < length){
	                length = tempLen;
	                lenInd = left;
	            }
	            
	            if(fqt.containsKey(st.charAt(left)) ){
	                fqt.put(st.charAt(left),fqt.get(st.charAt(left))+1);
    	            if(fqt.get(st.charAt(left)) > 0)
    	              matchCount--; 
	            }
	            left++;
	        }
	        
	    }
	    if(lenInd == -1){
	        return "-1";
	    }
	    return st.substring(lenInd,lenInd+length);
	}
}