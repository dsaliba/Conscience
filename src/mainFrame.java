import java.awt.*;
import java.awt.event.*;
public class mainFrame extends Frame implements MouseListener{
    mainFrame(){
        addMouseListener(this);

        setSize(300,300);
        setLayout(null);
        setVisible(true);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

}