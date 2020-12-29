class Main{

    public static boolean checkIsValid(int[] arr, double mid, int K){
        int count = 0;
        for(int i = 1; i < arr.length; i++){
            count += (int)( (arr[i] - arr[i-1])/mid );
            if(count > K) return true;
        }
        return false;
    }

    public static double minmaxGasDist(int[] arr, int K){
        double lo = 0.0, hi = 1e9, mid = 0.0;
        while((hi - lo ) >= 1e-5){
            mid = lo +(hi - lo)/2.0;

            if(checkIsValid(arr, mid, K)) lo = mid  + 1e-6;
            else hi = mid;

        }
        return hi;
    }

    public static void main(String[] args){
        //int arr[] = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
        int arr[] = {1,2, 3, 4, 5, 6, 7, 8, 9, 100};
        int k = 2;
        System.out.println(minmaxGasDist(arr, k));
    }
}