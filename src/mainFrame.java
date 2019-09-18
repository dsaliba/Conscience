import java.awt.*;
import java.awt.event.*;
import java.awt.swing.*;

public class mainFrame extends Frame implements MouseListener{
    mainFrame(){
        addMouseListener(this);

        setSize(1200,1000);
        setLayout(null);
        setVisible(true);
        System.out.println("FRAMEEEE");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });

        JButton b = new JButton("Submit");
        b.setBounds(50, 150, 100, 30);
        f.add(b);
    }


    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

}