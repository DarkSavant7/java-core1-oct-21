package ru.geekbrains.java_core1.lessons.lesson7_oop;

public enum Operator {
    SUM {
        public int operation(int a, int b) {
            return a + b;
        }
    },
    MUL {
        public int operation(int a, int b) {
            return a * b;
        }
    };

    public abstract int operation(int a, int b);
}
