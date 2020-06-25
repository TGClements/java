package exercise2;

public class Statically {
    //Once you have finished getting statistically.js to run, refactor the code here in Java.
    private static String glue = "Epoxy";
    String jello = "Jello";

    static void moveAndShake() {
        System.out.println("Never stagnate in life.  Be agile, change, and improve...");
    }

    static void stubborn() {
        moveAndShake();
        System.out.println("Please don't make me change... I just don't like it...");
    }

    static void explain() {
        stubborn();
        System.out.println(glue);
        System.out.println(
                "With static variables in Java, the variable is only allocated its memory once, on the initial load of the program. In JS it is shared between any instances of a class. -variables. Static methods in java dont need an object instance for them to be able to be called. Static methods in js, however, need to be called by the classname, like statically.doMethod().");
    }

    public static void main(String args[]) {

        moveAndShake();
        stubborn();
        explain();

        Statically s = new Statically();

        System.out.println(s.glue);
        System.out.println(s.jello);
    }
}