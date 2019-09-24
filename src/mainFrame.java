import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends Frame {
    Game g;
    questionFrame qF;
    JButton[] button;
    JProgressBar[] progress;
    JProgressBar[] progress2;

    mainFrame(Game g) {
        this.g = g;
        qF  = new questionFrame(this.g, this);

        setSize(1800, 1000);
        setLayout(null);
        setVisible(true);
        System.out.println("Main Frame... Launched");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });


    }

    public void update(){
        this.updateProgressBars();
        for (int i = 0; i < 6; i++){
            button[i].setEnabled(g.enabledFactions[i]);
        }

        this.repaint();

    }

    public void updateProgressBars (){
        for (int i = 0; i < 6; i++){
            int score = g.factions[i].score;
            this.progress[i].setValue(10 * ((score>10?10:score)));
            this.progress2[i].setValue(10 * (score<10?0:(score-10)));
        }
    }

    public void addElements() {
        JButton parents = new JButton("Parents");
        JButton friends = new JButton("Friends");
        JButton siblings = new JButton("Siblings");
        JButton teachers = new JButton("Teachers");
        JButton coworkers = new JButton("Coworkers");
        JButton yourself = new JButton("Yourself");

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
            button[i].setContentAreaFilled(false);
            this.add(button[i]);
            progress[i].setVisible(true);
            progress2[i].setVisible(true);
            progress[i].setValue(50); //use base variable
            progress2[i].setValue(0); //only increment if progress[i] value (above) is set to 100;
            this.add(progress[i]);
            this.add(progress2[i]);
            System.out.println("Button " + button[i] + " formating completed.");
            System.out.println("test2222");
        }

        this.repaint();


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
            }
        });
    }

    public void askQuestion(){
        qF.askQuestion();
        qF.setVisible(true);
        System.out.println("testtesttest3");
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


