package ru.geekbrains.java_core1.lessons.lesson5_oop;

public class Classwork {
    public static void main(String[] args) {
//        Cat cat1 = new Cat("white");
//        cat1.name = "Murzik";
//        cat1.color = "white";
//        cat1.age = 4;
//        cat1.setName("Murzik");
//        System.out.println(cat1.getAge());

//        System.out.println(cat1);
//        System.out.println(cat1.name);
//        System.out.println(cat1.color);
//        System.out.println(cat1.age);

        Cat cat2 = new Cat("Barsik", "black", 10);
        Cat cat3 = new Cat("Murzik", "red", 2);
//        System.out.println(cat2.name);
//        System.out.println(cat2.color);
//        System.out.println(cat2.age);
//        System.out.println(cat1);
        System.out.println(cat2);
        new Cat("Vaska", "red", 2).run();

//        cat1.run();
        cat2.run();
//        cat1.voice();
        cat2.voice();

        System.out.println(cat2.type);
        System.out.println(cat3.type);
        cat2.type = "jk dsjh dv";
        System.out.println(cat2.type);
        System.out.println(cat3.type);
        System.out.println(Cat.type);

        Cat[] cats = new Cat[10];
        cats[0] = new Cat("nfff", "jknfdj", 4);

    }
}
