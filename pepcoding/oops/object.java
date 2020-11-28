public class object{

    public static class Person{
        int age;
        String name;

        void saysHi(){
            System.out.println(name + "[" + age + "]" + "says hi");
        }
    }

    public static void main(String[] args){
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "A";
        p1.saysHi();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "B";
        p2.saysHi();

        // Person p3 = p1;// just referece get copied any change reflect in p1
        // p3.age = 30;
        // p3.saysHi();
        // p1.saysHi();

        // swap only occur in referece and does not reflect in main function and only occur in swap
        // p1.saysHi();
        // p2.saysHi();
        // swap(p1, p2);
        // p1.saysHi();
        // p2.saysHi();
    }

    public static void swap(Person psn1, Person psn2){
        Person temp = psn1;
        psn1 = psn2;
        psn1 = temp;
    }

    // swap get  because chagnes occurs in heap memory directly
    public static void swap1(Person psn1, Person psn2){
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        String name = psn1.name;
        psn1.name = psn2.name;
        psn2.name = name;

    }

    public static swap2(Person psn1, Person psn2){
        psn1 = new Person();

        since new instance is created and so changes get reflected p2 and not in p1;
        int age = psn1.age;
        psn1.age = psn2.age;
        psn2.age = age;

        psn2 = new Person();

        here both psn1 and psn2 both are curren instance so no name changes are reflected in p1 and p2
        String name  = Person();
        psn1.name = psn2.name;
        psn2.name = name;
    }
}