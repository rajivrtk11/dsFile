class construct{

    class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data, Node left, Node right){
            this.data = data; 
        }
    }

    static int idx = 0;
    public static Node construct(int[] arr){
        if(idx >= arr.length || arr[idx] == -1 ) return null;

        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);

        return node;
    }

    public static void solve(){
        construct();
    }
    public static void main(String[] args){
        
    }

}