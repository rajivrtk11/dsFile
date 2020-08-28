
class Main{

    public static void main(String args[]){
       int x =  function(new int[4][4],0,0,3,3,"");
       System.out.println(x);
    }
   static int function(int arr[][],int sx, int sy, int dx, int dy,String path){
        if(sx > dx || sy > dy )
           return 0;
        if(sx == dx && sy == dy){
            System.out.println(path);
            return 1;
        }
        int count = 0;
        count += function(arr,sx+1,sy,dx,dy,path+'H');
        count += function(arr,sx,sy+1,dx,dy,path+'V');
        return count;
        hello;
    }
}