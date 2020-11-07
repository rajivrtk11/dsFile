class construct{

    // Node class
    static class Node{
        int data = 0;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    // construct function
    static int idx = 0;
    static Node construct(int[] arr){
        if(idx >= arr.length || arr[idx] == -1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }
    // display function
    static void display(Node node){
        if(node == null ) return;
        String str = "";
        str += node.left != null ? node.left.data+" <-:":"."+"<-: ";
        str += node.data;
        str += node.right != null ? " :-> " + node.right.data:" :-> "+".";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args){
        System.out.println("hello world");
        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        Node root = construct(arr);
        display(root);
    }
}