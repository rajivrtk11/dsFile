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
	   
        HashSet<Character> fqt = new HashSet<>();
        int left = 0;
        int len = -(int)1e8;
        for(int i = 0; i < st.length() && left < st.length(); i++){
            char ch = st.charAt(i);
            // acquire
            if(!fqt.contains(ch)){
                fqt.add(ch);
                int tempLen = i - left + 1;
                if(len < tempLen){
                    len = tempLen;
                }
            }else{
                while(fqt.contains(ch)){
                    fqt.remove(st.charAt(left));
                    left++;
                }
                fqt.add(ch);
                
            }
        
        
        }
	   // if(lenInd == -1){
	   //     return "-1";
	   // }
	    return len;
	}
}