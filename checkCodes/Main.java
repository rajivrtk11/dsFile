 import java.util.ArrayList;
 import java.util.*;
 import java.lang.*;
 class Main{
  public static class Node{
        int data;
        Node left = null;
        Node right = null;
        Node(int data){
            this.data = data;
        }
    }
    static int idx = 0;
    public static Node construct(int[] arr){
        if(idx >= arr.length || arr[idx] == -1){
            idx++;
            return null;
        }

        Node node = new Node(arr[idx++]);
        node.left = construct(arr);
        node.right = construct(arr);
        return node;
    }
    public static void display(Node root){
        if(root == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append(root.left == null?".":root.left.data+" ");
        sb.append("<- "+ root.data + " ->");
        sb.append(root.right == null?".":root.right.data+" ");
        System.out.println(sb);

        display(root.left);
        display(root.right);
    }
    public static void width(Node root, int level, int[] ans){
        // base
        if(root == null){
            return;
        }
        //calculation
        ans[0] = Math.min(level,ans[0]);
        ans[1] = Math.max(level, ans[1]);
        // calls
        width(root.left, level-1, ans);
        width(root.left, level+1, ans);
    }
    public static void callDiagonalView(Node root){
        int ans[] = new int[2];
        width(root, 0, ans);
        ArrayList<Integer>[] alOfA = new ArrayList[0-ans[0]+1];
        for(int i =0; i < alOfA.length; i++) alOfA[i] = new ArrayList<>();
        diagonalView(root,-ans[0],alOfA);
        for(int i = 0; i< alOfA.length; i++){
            System.out.println(alOfA[i]);
        }
    }
    public static void diagonalView(Node root, int level, ArrayList<Integer> ans[]){
        if(root == null){
            return;
        }
        ans[level].add(root.data);
        diagonalView(root.left, level-1, ans);
        diagonalView(root.right, level, ans);

    }
    public static class pair{
        Node node = null;
        int val = 0;
        pair(Node node, int val){
            this.node = node;
            this.val = val;
        }
        // public int compareTo(pair o){
        //     return this.val - o.val;
        // }
    }
    

    public static void virticalTraversal(Node root){
        int coor[] = new int[2];
        width(root,0,coor);
        ArrayList<Integer> ans[] = new ArrayList[coor[1]-coor[0]];
        for(int i = 0; i < ans.length; i++){
            ans[i] = new ArrayList<>();
        }
        LinkedList<pair> que = new LinkedList<>();
        que.add(new pair(root,-coor[0]));
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                pair vtx = que.remove();
                ans[vtx.val].add(vtx.node.data);
                if(vtx.node.left != null) que.add(new pair(vtx.node.left, vtx.val-1));
                if(vtx.node.right != null) que.add(new pair(vtx.node.right, vtx.val+1));
            }
        }
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }

    }
    public static void virticalTraversal_2(Node root){
        int coor[] = new int[2];
        width(root,0,coor);
        ArrayList<Integer> ans[] = new ArrayList[coor[1]-coor[0]];
        for(int i = 0; i < ans.length; i++){
            ans[i] = new ArrayList<>();
        }
        PriorityQueue<pair> que = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });
        que.add(new pair(root,-coor[0]));
        while(que.size() != 0){
            
            pair vtx = que.remove();
            ans[vtx.val].add(vtx.node.data);
            if(vtx.node.left != null) que.add(new pair(vtx.node.left, vtx.val-1));
            if(vtx.node.right != null) que.add(new pair(vtx.node.right, vtx.val+1));
            
        }
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }

    }
    //================================================bottom view=================================================
    public static void topView(Node root){
        int coor[] = new int[2];
        width(root,0,coor);
        int ans[] = new int[coor[1]-coor[0]];
        
        LinkedList<pair> que = new LinkedList<>();
        que.add(new pair(root,-coor[0]));
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                pair vtx = que.remove();
                ans[vtx.val] = vtx.node.data;
                if(vtx.node.left != null) que.add(new pair(vtx.node.left, vtx.val-1));
                if(vtx.node.right != null) que.add(new pair(vtx.node.right, vtx.val+1));
            }
        }
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }

    }

    //================================================leetcode 987=================================================
    /* public static void virTrav(Node root){
        int coor[] = new int[2];
        width(root,0,coor);
        ArrayList<Integer> ans[] = new ArrayList[coor[1]-coor[0]];
        for(int i = 0; i < ans.length; i++){
            ans[i] = new ArrayList<>();
        }
        PriorityQueue<pair> que = new PriorityQueue<>( (a,b)->{
             return a.x-b.x;
            //else if(a.x == b.x) return a.node.val - b.node.val;
        });
        que.add(new pair(root,-coor[0]));
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                pair vtx = que.remove();
                ans[vtx.val].add(vtx.node.data);
                if(vtx.node.left != null) que.add(new pair(vtx.node.left, vtx.val-1));
                if(vtx.node.right != null) que.add(new pair(vtx.node.right, vtx.val+1));
            }
        }
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    } */
    //================================================size of binary tree=================================================
    public static int size(Node node){
        // return node == null? 0: size(node.left)+size(node.right)+1;
        if(node == null ){
            return 0;
        }
        int lh = size(node.left);
        int rh = size(node.right);
        return lh+rh+1;
    }

    public static void solve(){
        int[] arr={10,20,40,80,-1,-1,90,100,-1,-1,-1,50,-1,-1,30,60,110,120,-1,-1,140,-1,-1,-1,70,-1,-1};
        //int idx = 0;
        Node root = construct(arr);
        //callDiagonalView(root);
        //virticalTraversal(root);
        //virticalTraversal_2(root);
        //topView(root);
        //virTrav(root);
        System.out.println(size(root));
    }

    public static void main(String[] args){
        
        //display(root);
        // int ans[] = new int[2];
        // width(root,0,ans);
        // System.out.println(-ans[0]);
        // System.out.println(ans[1]);
        solve();
        

    }
}