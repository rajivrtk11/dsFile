class hello{
    // to add
    public static int add(int a, int b){
        int sum = a + b;
        return sum;
    }
    // to subtract
    public static int sub(int a, int b){
        int sub = a - b;
        return sub;
    }
    // to multiply
    public static int multiply(int a, int b){
        int sub = a * b;
        return sub;
    }
    // to divide
    public static int divide(int a, int b){
        int sub = a / b;
        return sub;
    }

    public static void main(String[] args){
        int add = add(4,5);
        int sub = sub(9,4);
        int mul = multiply(2,4);
        int div = divide(4,2);
        
        System.out.println(mul);
        System.out.println(div);
        System.out.println(add);
        System.out.println("hello world");
    }
}