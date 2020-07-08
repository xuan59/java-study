package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JMenu extends JFrame {

    private JPopupMenu jPopupMenu;

    public JMenu(){
        /*
        *  菜单栏菜单
        * */
        JMenuBar jMenuBar = new JMenuBar();
        this.setJMenuBar(jMenuBar);
        javax.swing.JMenu jMenu = new javax.swing.JMenu("文件");
        jMenuBar.add(jMenu);
        JMenuItem jMenuItem1 = new JMenuItem("新建");
        JMenuItem jMenuItem2 = new JMenuItem("退出");

        jMenuItem1.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JDialog jDialog = new JDialog(JMenu.this, true);
                jDialog.setTitle("新建窗口");
                jDialog.setSize(300, 200);
                jDialog.setLocationRelativeTo(null);
                jDialog.setVisible(true);
            }
        });

        jMenuItem2.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /*
        * 弹出式菜单
        * */
        jPopupMenu = new JPopupMenu();
        JMenuItem refresh = new JMenuItem("刷新");
        JMenuItem create = new JMenuItem("新建");
        JMenuItem exit = new JMenuItem("退出");
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jPopupMenu.add(refresh);
        jPopupMenu.add(create);
        jPopupMenu.addSeparator();
        jPopupMenu.add(exit);

        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == e.BUTTON3){
                    jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });



        jMenu.add(jMenuItem1);
        jMenu.addSeparator();
        jMenu.add(jMenuItem2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JMenu();
    }

}
