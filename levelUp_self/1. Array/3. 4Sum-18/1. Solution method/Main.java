import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main{

    // this solution is very modular and we should do this kind of solution if were asked in any face to face interview by 
    // breaking every task into a different function
    public static void makeAns(int ele, List<List<Integer>> ans,List<List<Integer>> smallAns){
        if(smallAns.size() > 0){
            for(int i = 0; i < smallAns.size(); i++){
                smallAns.get(i).add(ele);
                ans.add(smallAns.get(i));
            }
        }
    }

    public static List<List<Integer>> twoSum(int[] arr,int data,int si,int ei){
        List<List<Integer>> ans = new ArrayList<>();
        int i = si, j = ei;
        while(i < j){
            int sum = arr[i] + arr[j];
            if(sum == data){
                ans.add( new ArrayList(Arrays.asList(arr[i],arr[j])));
                i++;
                j--;

                while(i < j && arr[i] == arr[i - 1]) i++;
                while(i < j && arr[j] == arr[j + 1]) j--;
            }
            else if(sum < data) i++;
            else j--;
        }

        return ans;
    }

    public static List<List<Integer>> threeSum(int[] arr,int data,int si,int ei){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = si; i <= ei;i++){
            if(i != si && arr[i] == arr[i - 1]) continue;
            List<List<Integer>> smallAns = twoSum(arr,data - arr[i], i + 1, ei);
            makeAns(arr[i], ans,smallAns);   
        }

        return ans;
    }

    public static List<List<Integer>> fourSum(int[] arr, int data,int si,int ei) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = si;i <= ei;i++){
            if(i != si && arr[i] == arr[i - 1]) continue;
            List<List<Integer>> smallAns = threeSum(arr,data - arr[i], i + 1, ei);
            makeAns( arr[i], ans,smallAns);
        }

        return ans;
    }

    public static List<List<Integer>> fourSum(int[] arr, int data) {
        if(arr.length < 4) return new ArrayList<>();
        Arrays.sort(arr);
        
        int n = arr.length;
        return fourSum(arr,data,0,n - 1);
    }

    public static void main(String[] args){

        int[] arr = {1,0,-1,0,-2,2};
        int data = 0;
        List<List<Integer>> ans = fourSum(arr, data);
        System.out.println(ans);
    }
}