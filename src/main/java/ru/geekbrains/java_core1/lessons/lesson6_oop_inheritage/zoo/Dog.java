package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritage.zoo;

public class Dog extends Animal {

    public Dog(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice() {
        System.out.printf("%s bark\n", name);
    }

//    @Override
    public static void doSomethingStatic() {
        System.out.println("DOGGGG");
    }

}
