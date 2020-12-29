
class Main{
    public static int search(int[] arr, int data){
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = ( (hi + lo)/ 2 );

            if(arr[mid] == data) return mid;
            else if( arr[lo] <= arr[mid]){
                if(arr[lo] <= data && data < arr[mid]) hi = mid;
                else lo = mid + 1;
            }
            else{
                if(arr[mid] < data && data <= arr[hi]) lo = mid;
                else hi = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String... args){
        int arr[] = {4, 5, 6, 6, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}