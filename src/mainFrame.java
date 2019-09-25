import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends Frame {
    Game g;
    questionFrame qF;
    JButton[] button;
    JProgressBar[] progress;
    JProgressBar[] progress2;
    JLabel character = new JLabel();

    mainFrame(Game g) {
        this.g = g;
        qF = new questionFrame(this.g, this);
        qF.setBackground(Color.DARK_GRAY);
        setSize(1800, 1000);
        setLayout(null);
        setVisible(true);
        setBackground(Color.DARK_GRAY);

        System.out.println("Main Frame... Launched");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });


    }

    public void update() {
        this.updateProgressBars();
        for (int i = 0; i < 6; i++) {
            button[i].setEnabled(g.enabledFactions[i]);
        }
        character.setText(g.character + "");
        this.repaint();


    }

    public void updateProgressBars() {
        for (int i = 0; i < 6; i++) {
            int score = g.factions[i].score;
            this.progress[i].setValue(10 * ((score > 10 ? 10 : score)));
            this.progress2[i].setValue(10 * (score < 10 ? 0 : (score - 10)));
        }
    }

    public void addElements() {



        Font characterFont = new Font("Ariel", Font.BOLD, 50);
        character.setFont(characterFont);
        character.setForeground(Color.WHITE);
        character.setBounds(50, 0, 700, 200);
        character.setText(g.character + "");
        this.add(character);

        JLabel title = new JLabel("Morality");
        title.setForeground(Color.WHITE);
        Font titleFont = new Font("Ariel", Font.BOLD, 200);
        title.setFont(titleFont);
        title.setBounds(450, 200, 1000, 250);
        this.add(title);

        JButton parents = new JButton("");
        JButton friends = new JButton("");
        JButton siblings = new JButton("");
        JButton teachers = new JButton("");
        JButton coworkers = new JButton("");
        JButton yourself = new JButton("");

        JProgressBar parentsBar = new JProgressBar();
        JProgressBar friendsBar = new JProgressBar();
        JProgressBar siblingsBar = new JProgressBar();
        JProgressBar teachersBar = new JProgressBar();
        JProgressBar coworkersBar = new JProgressBar();
        JProgressBar yourselfBar = new JProgressBar();

        JProgressBar parentsBar2 = new JProgressBar();
        JProgressBar friendsBar2 = new JProgressBar();
        JProgressBar siblingsBar2 = new JProgressBar();
        JProgressBar teachersBar2 = new JProgressBar();
        JProgressBar coworkersBar2 = new JProgressBar();
        JProgressBar yourselfBar2 = new JProgressBar();


        parents.setBounds(490, 540, 100, 100);
        friends.setBounds(790, 540, 100, 100);
        teachers.setBounds(1090, 540, 100, 100);
        coworkers.setBounds(490, 750, 100, 100);
        yourself.setBounds(790, 750, 100, 100);
        siblings.setBounds(1090, 750, 100, 100);

        parentsBar.setBounds(490, 660, 100, 30);
        friendsBar.setBounds(790, 660, 100, 30);
        teachersBar.setBounds(1090, 660, 100, 30);
        coworkersBar.setBounds(490, 870, 100, 30);
        yourselfBar.setBounds(790, 870, 100, 30);
        siblingsBar.setBounds(1090, 870, 100, 30);

        parentsBar2.setBounds(490, 700, 100, 30);
        friendsBar2.setBounds(790, 700, 100, 30);
        teachersBar2.setBounds(1090, 700, 100, 30);
        coworkersBar2.setBounds(490, 910, 100, 30);
        yourselfBar2.setBounds(790, 910, 100, 30);
        siblingsBar2.setBounds(1090, 910, 100, 30);

        parents.setActionCommand("questionParents");
        friends.setActionCommand("questionFriends");
        siblings.setActionCommand("questionSiblings");
        teachers.setActionCommand("questionTeachers");
        coworkers.setActionCommand("questionsCoworkers");
        yourself.setActionCommand("questionYourself");


        button = new JButton[]{parents, friends, teachers, coworkers, yourself, siblings};
        progress = new JProgressBar[]{parentsBar, friendsBar, teachersBar, coworkersBar, yourselfBar, siblingsBar};
        progress2 = new JProgressBar[]{parentsBar2, friendsBar2, teachersBar2, coworkersBar2, yourselfBar2, siblingsBar2};
        for (int i = 0; i <= 5; i++) {
            button[i].setBorderPainted(true);
            button[i].setFocusPainted(false);
            button[i].setContentAreaFilled(true);
            button[i].setBackground(Color.WHITE);
            this.add(button[i]);
            progress[i].setVisible(true);
            progress2[i].setVisible(true);
            progress[i].setStringPainted(true);
            progress2[i].setStringPainted(true);
            progress2[i].setForeground(Color.green);

            progress[i].setValue(50); //use base variable
            progress2[i].setValue(0); //only increment if progress[i] value (above) is set to 100;
            this.add(progress[i]);
            this.add(progress2[i]);
            System.out.println("Button " + button[i] + " formating completed.");
            System.out.println("test2222");
            repaint();

            button[0].setIcon(new ImageIcon("Images\\parents.png"));
            button[1].setIcon(new ImageIcon("Images\\friends.png"));
            button[2].setIcon(new ImageIcon("Images\\teachers.png"));
            button[3].setIcon(new ImageIcon("Images\\peers.png"));
            button[4].setIcon(new ImageIcon("Images\\yourself.png"));
            button[5].setIcon(new ImageIcon("Images\\siblings.png"));


            parents.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("parentsQuestion");

                    Question q = g.factions[g.parents].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.parents;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);


                }
            });

            friends.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("friendsQuestion");
                    Question q = g.factions[g.friends].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.friends;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);
                }
            });

            siblings.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("siblingsQuestion");
                    Question q = g.factions[g.siblings].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.siblings;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);
                }
            });

            teachers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("teachersQuestion");
                    Question q = g.factions[g.teachers].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.teachers;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);
                }
            });

            coworkers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("coworkersQuestion");
                    Question q = g.factions[g.peers].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.peers;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);
                }
            });

            yourself.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("yourselfQuestion");
                    Question q = g.factions[g.me].getQuestion();
                    g.activeQuestion = q;
                    qF.askQuestion();
                    qF.setVisible(true);
                    g.enabledFactions[g.lastFaction] = true;
                    g.lastFaction = g.me;
                    g.enabledFactions[g.lastFaction] = false;
                    qF.setBackground(Color.DARK_GRAY);
                }
            });
        }
    }

        public void askQuestion () {
            qF.askQuestion();
            qF.setVisible(true);
            System.out.println("ara ara ara");
        }


    }




/*
    public void createImages() {
        try {
            Image img = ImageIO.read(getClass().getResource("Images/test.gif"));
            bl.setIcon(new ImageIcon(img));

        } catch (Exception ex) {
            System.out.println("Build menu images are not loading.");
        }
    }
    */


