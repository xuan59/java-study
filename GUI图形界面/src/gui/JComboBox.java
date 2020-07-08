package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComboBox extends JFrame {

    private javax.swing.JComboBox comboBox;
    private JTextField jTextField;
    public JComboBox(){
        JPanel jPanel = new JPanel();
        comboBox = new javax.swing.JComboBox();
        comboBox.addItem("请选择城市");
        comboBox.addItem("北京");
        comboBox.addItem("上海");
        comboBox.addItem("杭州");
        comboBox.addItem("重庆");
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = (String) comboBox.getSelectedItem();
                if (item.equals("请选择城市")){
                    jTextField.setText("");
                }else{
                    jTextField.setText(item);
                }
            }
        });
        jTextField = new JTextField(20);
        jPanel.add(comboBox);
        jPanel.add(jTextField);
        this.add(jPanel, BorderLayout.NORTH);
        this.setSize(350, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JComboBox();
    }
}
