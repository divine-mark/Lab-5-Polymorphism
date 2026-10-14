class Animal {
    public void sound() {
        System.out.println("Some generic animal sound");
    }

    public String name() {
        return "Animal";
    }
}

class Cat extends Animal {
    @Override
    public void sound() { System.out.println("Meow"); }

    @Override
    public String name() { return "Cat"; }
}

class Cow extends Animal {
    @Override
    public void sound() { System.out.println("Moo"); }

    @Override
    public String name() { return "Cow"; }
}

class Duck extends Animal {
    @Override
    public void sound() { System.out.println("Quack"); }

    @Override
    public String name() { return "Duck"; }
}

public class AnimalDemo {
    public static void main(String[] args) {
        // one array type holds many different subclass objects (upcasting)
        Animal[] animals = {
            new Cat(),
            new Cow(),
            new Duck(),
            new Animal() // base class still works
        };

        for (Animal a : animals) {
            System.out.print(a.name() + ": ");
            a.sound(); // JVM picks the right sound() at run time
        }
    }
}