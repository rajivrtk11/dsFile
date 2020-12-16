/*package whatever //do not write package name here */

import java.io.*;
import java.util.ArrayList;

class GFG {
   public static class Node{
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data){
            this.data = data;
        }
    }

    static int idx = 0;
    public static Node constructTree(int[] arr){
        if(idx >= arr.length || arr[idx] == -1){
            idx++;
            return null;
        }


        Node node = new Node(arr[idx++]);
        node.left = constructTree(arr);
        node.right = constructTree(arr);

        return node;
    }

	public static void main (String[] args) {
		int arr[] = {12, 13, -1, -1, 10, 14, 21, -1, -1, 24, -1, -1, 15, 22, -1, -1, 23, -1, -1};
		Node node = constructTree(arr);
		ArrayList<ArrayList<Node>> ans = new ArrayList<ArrayList<Node>>();
		kFar2(node,14,0,ans);
		for(int i = 0; i < ans.size(); i++){
		    for(int j = 0; j < ans.get(i).size(); j++){
		        System.out.print(ans.get(i).get(j).data+" ");
		    }
		    System.out.println();
		}
		
	}
	public static int kFar2(Node node,int data,int k,ArrayList<ArrayList<Node>> ans){
        if(node == null) return -1;

        if(node.data == data){
            kdown(node,null,0,ans);
            return 1;
        }

        int ld = kFar2(node.left, data, k, ans);
        if(ld != -1){
            kdown(node,node.left,ld,ans);
            return ld + 1;
        }

        int rd = kFar2(node.right, data, k, ans);
        if(rd != -1){
            kdown(node,node.right,rd,ans);
            return rd + 1;
        }

        return -1;
    }

	public static void kdown(Node node,Node block,int k,ArrayList<ArrayList<Node>> ans){
        if(node==null || node == block || k < 0) return;

        
        if(ans.size()==k) ans.add(new ArrayList<>());
            ans.get(k).add(node );
            
        

        kdown(node.left,block,k+1,ans);
        kdown(node.right,block,k+1,ans);
    }
}