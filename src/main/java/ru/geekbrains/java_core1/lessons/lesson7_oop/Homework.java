package ru.geekbrains.java_core1.lessons.lesson7_oop;

public class Homework {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 15),
                new Cat("Murka", 12),
                new Cat("Rizhik", 20)
        };
        Bowl bowl = new Bowl();
        bowl.putFood(30);
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
