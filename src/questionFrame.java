import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionFrame extends JFrame {
    public questionFrame(){
        setSize(500, 300);
        setLayout(null);
        setVisible(true);
        System.out.println("Question Frame... Launched!");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void askQuestion(){
        questionFrame q = new questionFrame();
        JButton firstAnswer = new JButton("Insert Text Variable");
        JButton secondAnswer = new JButton("Insert Text Variable2");

        firstAnswer.setBounds(100, 200, 100, 50);

        secondAnswer.setBounds(150, 200, 100, 50);
        firstAnswer.setBorderPainted(true);
        firstAnswer.setFocusPainted(false);
        firstAnswer.setContentAreaFilled(true);


        secondAnswer.setBorderPainted(true);
        secondAnswer.setFocusPainted(false);
        secondAnswer.setContentAreaFilled(true);

        firstAnswer.setVisible(true);
        secondAnswer.setVisible(true);
        q.add(firstAnswer);
        q.add(secondAnswer);

        firstAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             System.out.println("Answer 1");
            }
        });

        secondAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             System.out.println("Answer2");
            }
        });


    }
}
