class Main{
    
    // time complexity of this algo is o(log(n)) in average case like {6,6,6,6,7,7,2,2,2,3,3,3,4,4,4,5,5,5}
    // in worst case o(n) {2,2,2,2,2,2,2,4,4,4,2,2,2,2,2,2,2} when repeatation of same no is many times

    public static boolean search(int[] arr, int data){
        int lo = 0, hi = arr.length-1;
        while(lo <= hi){
            
            int mid = (hi + lo)/ 2;
            if(arr[mid] == data || arr[lo] == data) return true;
            else if(arr[lo] < arr[mid]){
                if(arr[lo] <= data && data < arr[mid]) hi = mid -1;
                else lo = mid + 1;
            }else if(arr[mid] < arr[hi]){
                if(arr[mid] < data && data <= arr[hi]) lo = mid +1;
                else hi = mid - 1;
            }
            else lo++;
        }
        return false;
    }

    public static void main(String[] args){
        int[] arr = {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0};// it is one of the worst test case for same data 
        
        int data = 1;
        System.out.println(search(arr,data));
    }
}