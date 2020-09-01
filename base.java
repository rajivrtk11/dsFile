import java.util.ArrayList;
class base{
    public static void main(String[] args){
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int t = Integer.parseInt(br.readLine());
        // for(int i = 0 ; i<t; i++){
        //     int n = Integer.parseInt(br.readLine());
        //     String str = br.readLine();
        //     int j = 0;
        //     int arr[] = new int[n];
        //     for(String st: str.split("\\s")){
        //         arr[j++] = Integer.parseInt(st);
        //     }

        // }
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        al1.add(2);
        al1.add(2);
        al1.add(3);
        al1.add(4);
        al1.add(5);
        al2.add(1);
        al2.add(2);
        al2.add(3);
        al2.add(4);
        al2.add(5);
        System.out.println(al1.equals(al2));
        

    }
}