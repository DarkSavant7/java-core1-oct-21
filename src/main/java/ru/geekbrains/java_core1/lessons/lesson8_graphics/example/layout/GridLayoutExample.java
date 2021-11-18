package ru.geekbrains.java_core1.lessons.lesson8_graphics.example.layout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {

    public static void main(String[] args) {
        new MyWindowGrid();
    }
}

class MyWindowGrid extends JFrame {
    MyWindowGrid() {
        setBounds(500,500,400,300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[16];

        setLayout(new GridLayout(4, 3));
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            add(jbs[i]);
        }
        setVisible(true);
    }
}
