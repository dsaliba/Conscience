import javax.swing.*;
import java.awt.*;

class ImagePanel extends JComponent {
    private Image image = null;

    public ImagePanel(String url) {
        image = Toolkit.getDefaultToolkit().createImage(url);
        ;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);

        }
    }
}
