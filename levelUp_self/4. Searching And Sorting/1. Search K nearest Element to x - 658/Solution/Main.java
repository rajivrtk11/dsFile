class Main{

    public static void main(String[] args){
        findClosestElements(arr,k, x);
    }
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        List<Integer> arr = new ArrayList<>();
        for(int ele : A) arr.add(ele);
        
        int n = A.length;
        
        if(x <= A[0]) return arr.subList(0,k);
        else if(x >= A[n - 1]) return arr.subList(n - k, n);
        else{
            
            int idx = binarySearch(A,x);   // where we suppose to find the x element.
            int si = Math.max(0,idx - k);
            int ei = Math.min(n - 1, idx + k);
            
            while((ei - si + 1) > k){
                if((x - A[si]) > (A[ei] - x)) si++;
                else ei--;
            }
            return arr.subList(si, ei + 1);
        }
    }

    // m-2
    // here we direct shift lo and hi range no element so we get our low at the perfect position and adding k into it get the range
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return Arrays.stream(A, left, left + k).boxed().collect(Collectors.toList());
    }
}