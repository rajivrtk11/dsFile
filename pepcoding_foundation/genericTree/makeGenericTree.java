import java.util.*;

public class Main {
    
    public static class Node{
        int data ;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static Node construct(int arr[]){
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            
         if(arr[i] == -1){
             st.pop();
         }
         else{
             Node node = new Node();
             node.data = arr[i];
             
             if(st.size() == 0){
                 root = node;
             }
             else{
                 st.peek().children.add(node);
             }
             st.push(node);
         }
        }
        return root;
    }
    
    public static void display(Node node){
        System.out.print(node.data + " -> ");
        for(Node child : node.children){
          System.out.print(child.data + " , ");
        }
        System.out.println();
        for(Node child : node.children){
            display(child);
        }
    }
    
    public static void main(String[] args) {
       int arr[] = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
       Node root = construct(arr);  
       display(root);
    }
}
