package ru.geekbrains.java_core1.lessons.lesson7_oop;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    public void eat(Bowl bowl) {
       isHungry = !bowl.decreaseFood(appetite);
    }

    public boolean isHungry() {
        return isHungry;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isHungry=" + isHungry +
                '}';
    }
}
