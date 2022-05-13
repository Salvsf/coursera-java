public class HelloGoodbye {
    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        String t = a;
        a = b;
        b = t;
        System.out.println("Hello " + args[0] + " and " + args[1] + ".");
        System.out.println("Goodbye " + a + " and " + b + ".");
    }
}
