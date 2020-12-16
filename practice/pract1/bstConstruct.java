

class bstConstruct {

    static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }

    public static Node constTree(int[] arr, int si, int ei){
        if(si > ei) return null;

        int mid = (si+ei)/2;

        Node node = new Node(arr[mid]);
        node.left = constTree(arr, si, mid-1);
        node.right = constTree(arr, mid+1, ei);

        return node;
    }
    
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,60,70,80,90,100,110,120};
        
        Node root = new constTree(arr,si,ei);

    }
}