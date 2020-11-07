import java.util.ArrayList;
import java.util.Stack;

public class l004_GT{
    public static class Node{
        int data = 0;
        ArrayList<Node> childs;

        Node(int data){
            this.data = data;
            childs = new ArrayList<Node>();
        }
    }

    public static Node constructTree(int[] arr){
        Stack<Node> st = new Stack<>();
        for(int i=0;i<arr.length-1;i++){
            int ele = arr[i];
            if(ele != -1) st.push(new Node(ele));
            else{
                Node node = st.pop();
                st.peek().childs.add(node);
            }
        }

        return st.pop();
    }

    public static void display(Node node){
        
        StringBuilder sb = new StringBuilder();
        sb.append(node.data + " -> ");
        
        for(Node child : node.childs) sb.append(child.data + " ");
        System.out.println(sb);

        for(Node child : node.childs) display(child);
    }

    public static int height(Node node){ // height in terms of edges.
        int h = -1;
        for(Node child : node.childs) h = Math.max(h,height(child));

        return h + 1;
    }

    public static int size(Node node){
        int s = 0;
        for(Node child : node.childs) s += size(child);

        return s + 1;
    }

    public static boolean find(Node node,int data){
        if(node.data == data) return true;
        
        for(Node child : node.childs) if(find(child,data)) return true;
        
        return false;
    }

    public static boolean nodeToRootPath(Node node,int data,ArrayList<Node> list){

        if(node.data == data){
            list.add(node);
            return true;
        }

        boolean res = false;
        for(Node child : node.childs){
            res = res || nodeToRootPath(child,data,list);
        }

        if(res) list.add(node);
        return res;

    }

    public static Node LCA(Node node,int d1,int d2){
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();

        nodeToRootPath(node,d1,l1);
        nodeToRootPath(node,d2,l2);

        Node LCA = null;
        int i = l1.size()-1;
        int j = l2.size()-1;

        while(i>=0 && j>=0){
            if(l1.get(i) != l2.get(j)) break;

            LCA = l1.get(i);
            i--;
            j--;
        }

        return LCA;
    }

    static Node LCA = null;
    public static boolean LCA_Better(Node node,int d1,int d2){
        if(node == null) return false;
        boolean sf = false;
        if(node.data == d1 || node.data == d2) return true;

        boolean ans = false;
        for(Node child:node.childs){
            ans = LCA_Better(child,d1,d2);

        }
        if(ans) LCA = node;
        return ans;
    }

    // public static boolean LCA_Better(Node node,int d1,int d2){
    //     LCA_Better(node,d1,d2);
    //     return LCA;
    // }
    // minimum No of Switches = EdgeDistance(folder1) + EdgeDistance(folder2) - 2 * EdgeDistance(folderLCA)
    public static int switchesRequiredBetweenTwoDirectory(Node node,int d1,int d2){
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();

        nodeToRootPath(node,d1,l1);
        nodeToRootPath(node,d2,l2);

        Node LCA = null;
        int i = l1.size()-1;
        int j = l2.size()-1;
        int val = i+j;
        int lcaCount = 0;
        while(i>=0 && j>=0){
            if(l1.get(i) != l2.get(j)) break;

            LCA = l1.get(i);
            i--;
            j--;
            lcaCount++;
        }
        //System.out.println(i+","+j);
        return val - 2*(lcaCount-1);
    }
    // how many fwd and how many backward moves are required suppose have to move from d1 to d2
    public static void switchesRequiredBetweenTwoDirectoryCount(Node node,int d1,int d2,int[] arr){
        ArrayList<Node> l1 = new ArrayList<>();
        ArrayList<Node> l2 = new ArrayList<>();

        nodeToRootPath(node,d1,l1);
        nodeToRootPath(node,d2,l2);

        Node LCA = null;
        int i = l1.size()-1;
        int j = l2.size()-1;
        int val = i+j;
        int lcaCount = 0;
        while(i>=0 && j>=0){
            if(l1.get(i) != l2.get(j)) break;

            LCA = l1.get(i);
            i--;
            j--;
            lcaCount++;
        }
        // lcaCount-1 because 1 count inc when data match
        arr[0] = l1.size()-1+lcaCount-1;
        arr[1] = l2.size()-1+lcaCount-1;
        //return arr;
    }


    public static boolean isFoldable(Node node1,Node node2){
        if(node1.childs.size()!=node2.childs.size()) return false;
        
        for(int i=0,j=node1.childs.size()-1; i<=j;i++,j--){
            Node ch1 = node1.childs.get(i);
            Node ch2 = node2.childs.get(j);

            if(!isFoldable(ch1,ch2)) return false;
        }

        return true;
    }

    public static boolean isMirror(Node node1,Node node2){
        if(node1.childs.size()!=node2.childs.size() || node1.data != node2.data) return false;
        
        for(int i=0,j=node1.childs.size()-1; i<=j;i++,j--){
            Node ch1 = node1.childs.get(i);
            Node ch2 = node2.childs.get(j);

            if(!isMirror(ch1,ch2)) return false;
        }

        return true;
    }

    public static Node linearize(Node node){
        if(node.childs.size()==0) return node;

        int n = node.childs.size();
        Node gtail = linearize(node.childs.get(n-1));

        for(int i = n-2;i>=0;i--){
            Node tail = linearize(node.childs.get(i));
           
            tail.childs.add(node.childs.get(i+1));
            node.childs.remove(i+1);
        }

        return gtail;
    }


 
    public static void solve(){
        int[] arr = {10,20,50,-1, 60 ,-1, -1, 30, 70, -1, 80 ,110, -1, 120, -1, -1, 90 ,-1 ,-1, 40, 100 ,-1 ,-1 ,-1};
        //int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,1,-1,2,-1,100,-1,-1,-1};
        Node node = constructTree(arr);
        // display(node);
        // linearize(node);
        // display(node);
        // ArrayList<Node> list = new ArrayList<>();
        // boolean ans = nodeToRootPath(node,110,list);
        // System.out.println(ans);
        // for(Node val:list)
        //    System.out.print(val.data+" ");
        // System.out.println(switchesRequiredBetweenTwoDirectory(node,50,110));
        // int bckFwdarr[] = new int[2];//arr[0] represent bck move and arr[1] represent fwd move
        // switchesRequiredBetweenTwoDirectoryCount(node,50,110,bckFwdarr);
        // System.out.println(bckFwdarr[0]+" "+ bckFwdarr[1]);
        // System.out.println(isFoldable(node,node));
        LCA_Better(node,70,90);
         System.out.println(LCA.data);
    }

    public static void main(String[] args){
        solve();
    }
}