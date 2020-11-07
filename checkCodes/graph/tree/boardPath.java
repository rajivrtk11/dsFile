import java.util.Arrays;
class boardPath{

    public static int countPath(int sp, int ep, int[] arr){
        // base case
        if(ep == arr.length) return 1; 

        // faith that m sb se ans count karke bhej dunga 
        int count = 0;
        for(int dice = 1; sp+dice <= ep || dice <= 6; dice++){
            csp = sp + dice;
            count += countPath(csp, ep, arr);
        }
        return count;
    }

    public static void main(String[] args){
        int ans = countPath(0, 10, new int[10]);
        System.out.println(ans);
    }
}