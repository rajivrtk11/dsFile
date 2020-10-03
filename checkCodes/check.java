class check{
    public static void main(String[] args){
        int[] pre = {10,8,9,14,13,15};
        int[] in = {7,8,9,10,14,13,15};
        int[] arr = new int[(int)1e8];
        for(int i = 0; i<pre.length; i++){
            int j = 0;
            while(in[j] != pre[i]){
                j++;
            }
            arr[pre[i]] = j;
        }
    }
}