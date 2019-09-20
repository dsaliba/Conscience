import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionFrame extends JFrame {

    Game g;
    //questionFrame q = new questionFrame(this.g);

    public questionFrame(Game g){
        this.g = g;


        setSize(1000, 500);
        setLayout(null);
        setAlwaysOnTop (true);
        setLocation(340,490);
        setUndecorated(true);
        setVisible(false);
        System.out.println("Question Frame... Launched!");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void askQuestion(){

        JButton firstAnswer = new JButton("Insert Text Variable");
        JButton secondAnswer = new JButton("Insert Text Variable2");
        System.out.println();
        JTextArea questionArea = new JTextArea(g.activeQuestion.question);

        Font questionFont = new Font("Ariel", Font.BOLD, 20);

        questionArea.setEditable(false);
        questionArea.setFont(questionFont);

        questionArea.setBounds(100, 100, 750,200);
        firstAnswer.setBounds(100, 300, 300, 100);
        secondAnswer.setBounds(550, 300, 300, 100);
        firstAnswer.setBorderPainted(true);
        firstAnswer.setFocusPainted(true);
        firstAnswer.setContentAreaFilled(false);

        secondAnswer.setBorderPainted(true);
        secondAnswer.setFocusPainted(true);
        secondAnswer.setContentAreaFilled(false);

        firstAnswer.setVisible(true);
        secondAnswer.setVisible(true);
        this.add(firstAnswer);
        this.add(secondAnswer);
        this.add(questionArea);

        firstAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             System.out.println("Answer 1");
             setVisible(false);
            }

        });

        secondAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             System.out.println("Answer2");
             setVisible(false);
            }
        });


    }
}
