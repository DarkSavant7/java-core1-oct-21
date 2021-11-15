package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritage.zoo;

public class Bird extends Animal {
    public static final String TYPE = "BIRD";
    public Bird(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice() {
        System.out.printf("%s chik chireek\n", name);
    }

    public final void fly() {
        System.out.printf("Bird %s flies!\n", name);
    }
}
