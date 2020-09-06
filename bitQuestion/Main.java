
class Main{

    static void nAnd1(){
        int n =2;
        if((n&1)== 0){
            System.out.println(n);
        }
        System.out.println(typeOf(n&1));
    }

    static void callingFn(){
        nAnd1();
    }

    public static void main(String[] args){
        callingFn();
        
    }
    
}