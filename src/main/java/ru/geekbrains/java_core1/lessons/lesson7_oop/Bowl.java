package ru.geekbrains.java_core1.lessons.lesson7_oop;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
        System.out.printf("Food increased by %d pts, there is now %d\n", amount, foodAmount);
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount < amount) {
            System.out.printf("Not enough food, you want %d, and there's %d\n", amount, foodAmount);
            return false;
        }
        foodAmount -= amount;
        System.out.printf("Food decreased by %d pts, there is now %d\n", amount, foodAmount);
        return true;
    }


    public int getFoodAmount() {
        return foodAmount;
    }
}
