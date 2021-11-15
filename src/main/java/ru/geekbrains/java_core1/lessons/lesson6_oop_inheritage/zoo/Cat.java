package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritage.zoo;

public class Cat extends Animal {
//    private int name;

    public Cat(String name, String color) {
        super(name, color);
    }

    @Override
    public void voice() {
        System.out.printf("%s meaw\n", name);
    }

}
