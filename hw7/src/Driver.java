public class Driver {
    public static void main(String[] args) {
        Dog d = new Dog("dog", 100, true, 12);
        Cat c = new Cat("vcat", 20, 12, true);
        System.out.println("Animal =" + d.superToString());
        System.out.println("Dog =" + d.toString());
        System.out.println("Cat =" + c.toString());
    }
}
