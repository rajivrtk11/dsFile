public class pract{
    static int fact(int n){
        if(n == 1) return 1;
        int ans = n*fact(n-1);
        return ans;
    }
    static ArrayList<String> mazePath_HVD(int sr, int sc, int er, int ec){

        ArrayList<String> hr = mazePath_HVD(sr, sc+1, er, ec);

        ArrayList<String> hr = mazePath_HVD(sr, sc+1, er, ec);

        ArrayList<String> hr = mazePath_HVD(sr, sc+1, er, ec);
        
        ArrayList<String> mazePath_HVD
    }
    public static void main(String[] args){
        ArrayList<String> al = mazePath_HVD(0,0,3,3);
    }
}