class checkIfPreInPostofSameTree{
    public static void main(String[] args){
        int[] pre= {36,30,28,40,38,48,45,50};
        int[] in = {28,30,36,38,40,45,48,50};
        int[] post = {28,30,38,45,50,48,40,36 };
        System.out.println(checkTree(pre,in,post));
     }
    int idx = 0;
    public static boolean checkTree(int[] preorder,int psi,int pei, int[] inorder,int isi,int iei,int[] post){
        if(psi > pei) return true;

        int idx = isi;
        boolean flag = false;
        while(idx < iei){
            if(inorder[idx] == preorder[psi]){
                flag = true;
                break;
            }
            idx++;
        }

        if(!flag) return false; 

        int count = idx - isi; // countOfNodesInLeftSubTree.

        if(!checkTree(preorder,psi+1,psi+count,inorder,isi,idx-1,post)) return  false;
        if(!checkTree(preorder,psi+count+1,pei,inorder,idx+1,iei,post)) return  false;
        
        if(preorder[psi] != post[idx++]) return false;
        
        return true;
    }


    public static TreeNode checkTree(int[] preorder, int[] inorder,int[] post) {
        if(preorder.length==0) return null;
        int n = preorder.length;

        return checkTree(preorder,0,n-1,inorder,0,n-1,post);
    }
     
}