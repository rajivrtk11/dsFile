import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;


class freqSort{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<t; i++){
           // int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            
            System.out.println(frequencySort(str));
        }
    }
    public static String frequencySort(String str){
        HashMap<Integer,Character> hm = new HashMap<>();
        for(int i = 0; i< str.length(); i++){
           char ch = str.charAt(i);
           hm.put(i,ch);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return hm.get(b)-hm.get(a);
        });

        for(Integer ch: hm.keySet()){
            pq.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Integer ch = pq.remove();
            Character freq = hm.get(ch);
             sb.append(freq);
        }
        return sb.toString();

    }
}