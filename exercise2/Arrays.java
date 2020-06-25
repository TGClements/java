package exercise2;

class Arrays {
    //Take the arrays.js file, and refactor the code into Java in this file.
    static int[] nums = { 10, 23, 3, 4, 5, 2, 1 };
    static String[] greetings = { "hello", "howdy", "hallo", "hola", "bonjour", "ciao", "أهلا" };
    static boolean[] binaries = { false, true, true, true, false, false, false, true, true, true, true, true, false,
            true, false, false, true, false };

    static void printNums() {
        for (int i : nums) {
            System.out.println(i);
        }
    };

    static void printGreetings() {
        for (String s : greetings) {
            System.out.println(s);
        }
    };

    static void printBinaries() {
        for (boolean b : binaries) {
            System.out.println(b);
        }
    };

    public static void main(String args[]) {
        printNums();
        printGreetings();
        printBinaries();
    }
}
