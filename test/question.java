import java.util.*;
import java.io.*;
class question{
    static int countSubstring(String S, int n){  
         
        int ans = 0;  
      
        int i = 0;  
      
        // Traversing the string  
        while (i < n) {  
      
            // Count of consecutive  
            // 0's & 1's  
            int cnt0 = 0, cnt1 = 0;  
      
            // Counting subarrays of  
            // type "01"  
            if (S.charAt(i) == '0') {  
      
                // Count the consecutive  
                // 0's  
                while (i < n && S.charAt(i) == '0') {  
                    cnt0++;  
                    i++;  
                }  
      
                // If consecutive 0's  
                // ends then check for  
                // consecutive 1's  
                int j = i;  
      
                // Counting consecutive 1's  
                while (j < n && S.charAt(j) == '1') {  
                    cnt1++;  
                    j++;  
                }  
            }  
      
            // Counting subarrays of  
            // type "10"  
            else {  
      
                // Count consecutive 1's  
                while (i < n && S.charAt(i) == '1') {  
                    cnt1++;  
                    i++;  
                }  
      
                // If consecutive 1's  
                // ends then check for  
                // consecutive 0's  
                int j = i;  
      
                // Count consecutive 0's  
                while (j < n && S.charAt(j) == '0') {  
                    cnt0++;  
                    j++;  
                }  
            }  
      
            // Update the total count  
            // of substrings with  
            // minimum of (cnt0, cnt1)  
            ans += Math.min(cnt0, cnt1);  
        }  
      
        // Return answer  
        return ans;  
    }  
    static void zOne(int n,String ans){
        if(ans.length() == n){
            System.out.println(ans);
            
            return;
        }
        zOne(n,ans+"0");
        zOne(n,ans+"1");
    }
    // <------------------------------------------------------------------------------------------------------------>
    static void CountBitString_01(int n, int k, String s){
        int zer = 0, one = 0;
            boolean chk = true;
            for(int i = 0; i < k; i++){
                int tmp = -1;
                for(int j = i; j < n; j += k){
                    if(s.charAt(j) != '?'){
                        if(tmp != -1 && s.charAt(j)-'0' != tmp){
                            chk = false;
                            break;
                        }
                        tmp = s.charAt(j)-'0';
                    }
                }
                if(tmp != -1){
                    if(tmp == 0) zer++;
                    else one++;
                    //(tmp == 0 ? zer : one )++;
                }
            }
            if(Math.max(zer, one) > k / 2){
                chk = false;
            }
            System.out.print((chk ? "YES\n" : "NO\n"));
    }
    // <------------------------------------------------------------------------------------------------------------>
    static void CountBitString_02(int n, int k, String sb){
        int zerC = 0, oneC = 0, quesC = 0;
        StringBuilder s = new StringBuilder(sb);
        for(int i = 0; i < k; i++){
            char ch = s.charAt(i);
            if(ch == '0'){
                s.append(ch);
                zerC++;
            }else if(ch == '1'){
                oneC++;
            }else{
                quesC++;
            }
        }
        while(zerC <= k/2 && quesC > 0){
            zerC++;
            quesC--;
        }
        while(oneC <= k/2 && quesC > 0){
            oneC++;
            quesC--;
        }
        int left = 0;
        
        if(zerC == oneC){
            for(int i = k; i < s.length(); i++){
                char ch = s.charAt(i);
                
            }
        }else{
            System.out.println("NO");
        }
        
    }
    // <------------------------------------------------------------------------------------------------------------>
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < t; tc++ ){
            String line1 = br.readLine();
            int arr1[] = new int[2];
            String st[] = line1.split("\\s");

            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);

            String s = br.readLine();
            CountBitString_01(n,k,s);
        }

        // int[] arr = {20, 8, 3, 4, 9, 5};
        // subArray(arr);
    }
    //<------------------------------------------------------------------------------------------------------------>
    
    //<------------------------------------------------------------------------------------------------------------>
    public static void callingFn(){
        zOne(3,"");
    }
    //<------------------------------------------------------------------------------------------------------------>
    /* public static void main(String[] args){
        //callingFn();
        String s = "abcdefgh";
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(4,'p');
        System.out.println(sb.toString());
    } */
}