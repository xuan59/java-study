package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridBadLayout extends Frame{
    public  void addComponent (String name, GridBagLayout layout, GridBagConstraints c){
        Button button = new Button(name);
        layout.setConstraints(button, c);
        this.add(button);

    }
    public GridBadLayout(String title) {

        //Frame frame = new Frame("GridBagLayout");
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        this.addComponent("button1", layout, constraints);
        this.addComponent("button2", layout, constraints);
        this.addComponent("button3", layout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        this.addComponent("button4", layout, constraints);
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        this.addComponent("button5", layout, constraints);
        constraints.gridwidth = 1;
        this.addComponent("button6", layout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        this.addComponent("button7", layout, constraints);
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.weightx = 2;
        constraints.weighty = 2;
        this.addComponent("button8", layout, constraints);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridheight = 1;
        this.addComponent("button9", layout, constraints);
        this.addComponent("button10", layout, constraints);
        this.pack();
        this.setTitle(title);
        this.setSize(500, 400);
        //this.setLocation(300, 100);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GridBadLayout("GridBadLayout");
    }
}
