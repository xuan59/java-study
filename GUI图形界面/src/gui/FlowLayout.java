package gui;

import java.awt.*;

public class FlowLayout {

    public static void main(String[] args) {
        Frame frame = new Frame("FlowLayout");
        frame.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 30));
        frame.setSize(500, 600);
        frame.setLocation(300, 100);
        for (int i=1; i<7; i++){
            frame.add(new Button("我是第"+i+"个按钮"));
        }
        frame.setVisible(true);

    }



}
