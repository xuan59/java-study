package gui;

import java.awt.*;

public class GridLayout {

    public static void main(String[] args) {

        Frame frame = new Frame("GridLayout");
        frame.setLayout(new java.awt.GridLayout(3, 3));
        frame.setSize(300,300);
        frame.setLocation(400, 300);

        for(int i=1; i<10; i++){
            Button button = new Button("button"+i);
            frame.add(button);
        }
        frame.setVisible(true);

    }

}
