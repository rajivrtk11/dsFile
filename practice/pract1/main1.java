
public class main1{
    public static void main(String[] args){
        String s = "a";
        String t = "bc";
        int k = 4;

        int lens = s.length();
        int lent = t.length();

        int i = 1, j = 2;
        while(true){
            if((k-i*lens) > i*lens){
                k = k-i*lens;
                i += 2;
            }else{
                k = k%lens;
                System.out.println(s.charAt(k));
                break;
            }

            if((k-j*lens) > j*lent){
                k = k-j*lent;
                j += 2;
            }else{
                k = k%lent;
                System.out.println(t.charAt(k));
                break;
            }
        }

    }
}