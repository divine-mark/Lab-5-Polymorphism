class Parent {
    String value = "Parent field"; // field — HIDDEN, not overridden

    String getValue() {            // method — OVERRIDDEN
        return "Parent method";
    }
}

class Child extends Parent {
    String value = "Child field";  // hides Parent.value

    @Override
    String getValue() {
        return "Child method";
    }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child(); // upcast

        System.out.println("Field  via Parent ref: " + p.value);       // Parent field
        System.out.println("Method via Parent ref: " + p.getValue());  // Child method

        Child c = new Child();
        System.out.println("Field  via Child ref:  " + c.value);       // Child field
        System.out.println("Method via Child ref:  " + c.getValue());  // Child method
    }
}