
public class main{

    
    public static void main(String[] args){
        int tn = 5;
        int tsp = 1;
        int trow = tn;
        for(int row = 0; row < trow; row++){
            for(int no = 1; no <= tn; no++){
                System.out.print(no);
            }
            if(tsp == 1)tn--;
            for(int sp = 1; sp < tsp; sp++){
                System.out.print(" ");
            }
            
            for(int no = tn; no > 0; no--){
                System.out.print(no);
            }
            if(tsp != 1)tn--;
            tsp += 2;
            
            System.out.println();
        }
    }

    // int main(String[] args){
    //     int tn = 5;
    //     int tsp = 1;
    //     int trow = tn;
    //     for(int row = 0; row < trow; row++){
    //         for(int no = 1; no <= tn; no++){
    //             cout<< no;
    //         }
    //         if(tsp == 1)tn--;
    //         for(int sp = 1; sp < tsp; sp++){
    //             cout<<" ";
    //         }
            
    //         for(int no = tn; no > 0; no--){
    //             cout<< no;
    //         }
    //         if(tsp != 1)tn--;
    //         tsp += 2;
    //         cout<<endl;
    //     }
    // }

}