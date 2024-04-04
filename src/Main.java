import java.util.*;

abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;

    public Animal() {
        // Default constructor
    }

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public abstract void eat();

    public abstract String getVoice();

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Weight: " + weight;
    }
}

abstract class Mammal extends Animal {
    public Mammal() {
        // Default constructor
    }

    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    // Additional method specific to Mammal class
    public abstract void run();
}

abstract class Bird extends Animal {
    protected String featherColor;

    public Bird() {
        // Default constructor
    }

    public Bird(String name, int age, double weight, String featherColor) {
        super(name, age, weight);
        this.featherColor = featherColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    // Additional method specific to Bird class
    public abstract void fly();
}

abstract class Fish extends Animal {
    public Fish() {
        // Default constructor
    }

    public Fish(String name, int age, double weight) {
        super(name, age, weight);
    }

    // Additional method specific to Fish class
    public abstract void swim();
}

class Dog extends Mammal {
    public Dog() {
        // Default constructor
    }

    public Dog(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }

    @Override
    public String getVoice() {
        return "Woof Woof";
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}

class Pigeon extends Bird {
    private String species;

    public Pigeon() {
        // Default constructor
    }

    public Pigeon(String name, int age, double weight, String featherColor, String species) {
        super(name, age, weight, featherColor);
        this.species = species;
    }

    @Override
    public void eat() {
        System.out.println("Pigeon is eating");
    }

    @Override
    public String getVoice() {
        return "Coo Coo";
    }

    @Override
    public void fly() {
        System.out.println("Pigeon is flying");
    }

    // Additional method specific to Pigeon class
    public void coo() {
        System.out.println("Pigeon is cooing");
    }
}

class Blowfish extends Fish {
    public Blowfish() {
        // Default constructor
    }

    public Blowfish(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void eat() {
        System.out.println("Blowfish is eating");
    }

    @Override
    public String getVoice() {
        return "No voice";
    }

    @Override
    public void swim() {
        System.out.println("Blowfish is swimming");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Dog("Buddy", 3, 12.5);
        animals[1] = new Pigeon("Pidgey", 2, 0.5, "Gray", "Rock Pigeon");
        animals[2] = new Blowfish("Bubba", 1, 0.3);

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.eat();
            System.out.println("Voice: " + animal.getVoice());

            if (animal instanceof Mammal) {
                ((Mammal) animal).run();
            } else if (animal instanceof Bird) {
                ((Bird) animal).fly();
            } else if (animal instanceof Fish) {
                ((Fish) animal).swim();
            }

            if (animal instanceof Pigeon) {
                ((Pigeon) animal).coo();
            }

            System.out.println();
        }
    }
}