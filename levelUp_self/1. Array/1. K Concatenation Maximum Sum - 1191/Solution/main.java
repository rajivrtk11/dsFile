import java.util.*;

public class main{

    static int mod = (int)1e9 + 7;

    public static long kadanesAlgo(int[] arr){
    long gMaxSum = 0, runningSum = 0;
        for(int ele : arr){
            runningSum += ele;
            
            if(runningSum > gMaxSum) gMaxSum = runningSum;
            
            if(runningSum <= 0) runningSum = 0;
        }

        return gMaxSum;
    }

    // sum from starting
    public static long prefixSum(int[] arr){
        long gSum = -(int)1e9;
        long cSum = 0;
        for(int ele : arr){
            cSum = (cSum + ele) % mod;
            gSum = Math.max(gSum, cSum); 
        }

        return gSum;
    }

    // sum from last
    public static long suffixSum(int[] arr){
        long gSum = -(int)1e9;
        long cSum = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            cSum = (cSum + arr[i]) % mod;
            gSum = Math.max(gSum, cSum); 
        }

        return gSum;
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {
        long KadanesSum = kadanesAlgo(arr) % mod;
        if(k == 1) return (int)KadanesSum;

        long sumOfArray = 0;
        for(int ele : arr) sumOfArray += ele;

        long prefixSum = prefixSum(arr);
        long suffixSum = suffixSum(arr);

        if(sumOfArray > 0){
            long APSum = ((k - 2) * sumOfArray  % mod + suffixSum % mod + prefixSum % mod) % mod;
            return (int)Math.max(APSum, KadanesSum);
        }else{
            return (int)(Math.max(suffixSum + prefixSum, KadanesSum));
        }
    }

    // Best method-2
    
    public static long kadanesSum(int[] arr,int k){
        int gMaxSum = 0, runningSum = 0;
        int n = arr.length;
        
        for(int i = 0; i < n * k; i++){
            runningSum = (runningSum + arr[i % n]) % mod;
            
            if(runningSum > gMaxSum) gMaxSum = runningSum;
            
            if(runningSum <= 0) runningSum = 0;
        }

        return gMaxSum % mod;
    }

    public static int kConcatenationMaxSum2(int[] arr, int k) {
        long prevSum = 0;
        for(int i = 1 ; i <= k && i <= 3;i++){
            long KSum =  kadanesSum(arr, i);
            if(i == k) return (int)KSum;
            
            if(i == 3){
                return (int)((prevSum + (k - 2) * (KSum - prevSum)) % mod);
            }

            prevSum = KSum;
        }
        return  0;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        int ans = kConcatenationMaxSum(arr,k);
        System.out.println(ans);
    }

}