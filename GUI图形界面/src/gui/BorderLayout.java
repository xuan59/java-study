package gui;

import java.awt.*;

public class BorderLayout {
    public static void main(String[] args) {

        Frame frame = new Frame("BorderLayout");
        frame.setLayout(new java.awt.BorderLayout());
        frame.setSize(300, 300);
        frame.setLocation(300, 100);
        frame.setVisible(true);
        Button button1 = new Button("东");
        Button button2 = new Button("南");
        Button button3 = new Button("西");
        Button button4 = new Button("北");
        Button button5 = new Button("中");
        frame.add(button1, java.awt.BorderLayout.EAST);
        frame.add(button2, java.awt.BorderLayout.SOUTH);
        frame.add(button3, java.awt.BorderLayout.WEST);
        frame.add(button4, java.awt.BorderLayout.NORTH);
        frame.add(button5, java.awt.BorderLayout.CENTER);


    }
}
