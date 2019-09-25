import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class questionFrame extends JFrame {

    Game g;
    mainFrame m;

    public JButton firstAnswer;
    public JButton secondAnswer;
    public JTextArea questionArea;
    public JPanel colorBackground;
    //questionFrame q = new questionFrame(this.g);
    public questionFrame(Game g, mainFrame m){

        this.setBackground(Color.DARK_GRAY);
        this.g = g;
        this.m = m;
        colorBackground = new JPanel(null);
        colorBackground.setBackground(Color.DARK_GRAY);
        colorBackground.setBounds(0, 0, 1000, 500);

        add(colorBackground);
        colorBackground.setVisible(true);


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
        firstAnswer = new JButton();
        secondAnswer = new JButton();

        firstAnswer.setContentAreaFilled(true);
        firstAnswer.setOpaque(true);
        firstAnswer.setBorderPainted(true);
        firstAnswer.setBackground(Color.WHITE);
        secondAnswer.setContentAreaFilled(true);
        secondAnswer.setOpaque(true);
        secondAnswer.setBorderPainted(true);
        secondAnswer.setBackground(Color.WHITE);

        questionArea = new JTextArea();
        questionArea.setForeground(Color.WHITE);
        questionArea.setBackground(Color.DARK_GRAY);
        questionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        setBackground(Color.DARK_GRAY);
        repaint();
    }

    public void askQuestion(){


        firstAnswer.setText(g.activeQuestion.first);
        secondAnswer.setText(g.activeQuestion.second);
        questionArea.setText(g.activeQuestion.question);

        Font questionFont = new Font("Ariel", Font.BOLD, 30);

        questionArea.setEditable(false);
        questionArea.setFont(questionFont);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setBounds(100, 100, 750,200);
        firstAnswer.setBounds(100, 300, 300, 100);
        secondAnswer.setBounds(550, 300, 300, 100);


        firstAnswer.setEnabled(g.activeQuestion.avialable(0, g));
        secondAnswer.setEnabled(g.activeQuestion.avialable(1, g));


        colorBackground.add(firstAnswer);
        colorBackground.add(secondAnswer);
        colorBackground.add(questionArea);
        for (ActionListener a : firstAnswer.getActionListeners()){
            firstAnswer.removeActionListener(a);
        }
        firstAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.activeQuestion.answer(0, g);
             System.out.println("Answer 1");
             setVisible(false);
                g.step();
            }

        });
        for (ActionListener a : secondAnswer.getActionListeners()){
            secondAnswer.removeActionListener(a);
        }
        secondAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.activeQuestion.answer(1, g);
             System.out.println("Answer2");

             setVisible(false);
                g.step();
            }
        });
        System.out.println(g.activeQuestion.question);
        this.setBackground(Color.DARK_GRAY);
        firstAnswer.setVisible(true);
        secondAnswer.setVisible(true);
        questionArea.setVisible(true);
        this.repaint();

    }
}
