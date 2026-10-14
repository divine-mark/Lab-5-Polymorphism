public class Printer {

    // same name, different parameter lists -> resolved at compile time
    public void print(int value) {
        System.out.println("int: " + value);
    }

    public void print(double value) {
        System.out.println("double: " + value);
    }

    public void print(String value) {
        System.out.println("String: " + value);
    }

    public void print(int[] values) {
        System.out.print("int[]: [");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        p.print(42);
        p.print(3.14);
        p.print("Hello");
        p.print(new int[]{1, 2, 3, 4});
    }
}