package singleton;

public class Singleton {
     static final Singleton instance =
        new Singleton();

    private Singleton(){
        System.out.println("object created");
    }
    public static Singleton getInstance(){
       return instance;
    }
    public String getMsg(){
        return "hi.....";
    }

    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();
        Singleton obj4 = Singleton.getInstance();

        System.out.println(obj1 == obj2);
        System.out.println(obj2 == obj3);
        System.out.println(obj3 == obj4);

    }
}
