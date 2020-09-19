import java.util.*;

public class bTreeCons {
    
    public static class Node{
        int data;
        Node left;
        Node right;
        
        //constructor    
        public Node(int data , Node left , Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    

    public static class Myclass{
        Node node;
        int state;
        
        //constructor
        public Myclass(Node node , int state){
            this.node = node;
            this.state = state;
        }
    }
    
    
    
    public static Node construct(Integer arr[]){
        Stack<Myclass> st = new Stack<>();
        Node root = new Node( arr[0] , null , null );
        // Myclass p = new Myclass(root , 1);
        st.push(new Myclass(root , 1));
        int i=1;
        while(st.size() != 0 ){
            Myclass top = st.peek();
            if(top.state==1){
                if(arr[i] != null){
                Node nn = new Node(arr[i] , null , null);
                top.node.left = nn;
                top.state++;
                st.push( new Myclass(nn , 1));
                }
                else{
                 top.state++;   
                }
                i++;
            }
            else if(top.state == 2){
               if(arr[i] != null){
                   Node nn = new Node(arr[i] , null , null);
                   top.node.right = nn;
                   top.state++;
                   st.push(   new Myclass(nn , 1));
                }
                else{
                 top.state++;   
                }
                i++;
            }
            else{
               st.pop();
            }
        }
        return root;
    }
    
    
    public static void display(Node node){
        
        if(node ==  null){
            return;
        }
        String s = "";
        //add left child
        
        s+= node.left == null ? ". <- " : node.left.data + " <- ";  
        
        // if(node.left != null){
        //     s += node.left.data + " <- ";
        // }
        // else{
        //     s+= ". <- ";
        // }
        //add node.data
          s += node.data;
        
        //add right child
        s += node.right == null ? " -> ." : " -> " + node.right.data;  
        // if(node.right != null){
        //     s += " -> " + node.right.data;
        // }
        // else{
        //     s+= " -> .";
        // }
        System.out.println(s);
        display(node.left);
        display(node.right);
    }
    
    public static void main(String[] args) {
Integer arr[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
            
            Node root = construct(arr);
            display(root);
            // traversal(root);
            // System.out.println(pre);
            // System.out.println(in);
            // System.out.println(post);
        
    }
}
