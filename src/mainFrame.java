import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainFrame extends Frame {
    Game g;
    questionFrame qF;

    JLabel background;


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



        JButton[] button = {parents, friends, teachers, coworkers, yourself, siblings};
        progress = new JProgressBar[]{parentsBar, friendsBar, teachersBar, coworkersBar, yourselfBar, siblingsBar};
        progress2 = new JProgressBar[]{parentsBar2, friendsBar2, teachersBar2, coworkersBar2, yourselfBar2, siblingsBar2};
        for (int i = 0; i <= 5; i++) {
            button[i].setBorderPainted(true);
            button[i].setFocusPainted(false);
            button[i].setContentAreaFilled(true);
            button[i].setBackground(Color.WHITE);
            this.add(button[i]);
            progress[i].setMaximum(10);
            progress2[i].setMaximum(10);
            progress[i].setStringPainted(true);
            progress2[i].setStringPainted(true);
            progress[i].setVisible(true);
            progress2[i].setVisible(true);
            progress[i].setValue(5); //use base variable
            progress2[i].setValue(0); //only increment if progress[i] value (above) is set to 100;
            this.add(progress[i]);
            this.add(progress2[i]);
            System.out.println("Button " + button[i] + " formating completed.");
            System.out.println("test2222");
        }
        this.setBackground(Color.DARK_GRAY);
        this.repaint();
    try {
        BufferedImage backgroundImage = null;
        backgroundImage = ImageIO.read(
                new File("Images\\Background.png"));
        System.out.println("Get Image: " + backgroundImage);
        System.out.println("Load image into frame");

        background = new JLabel(new ImageIcon(backgroundImage));
        this.add(background);
        background.setVisible(true);
    }catch (Exception exp){
        System.out.println("Image not Working");
        }

        parents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("parentsQuestion");

               Question q = g.factions[g.parents].getQuestion();
                g.activeQuestion = q;
                qF.askQuestion();
                qF.setVisible(true);


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
            }
        });
    }

public void setProgress(String faction, int value){
    switch(faction){
        case "parents":
            parentsBar.setValue(value);
            break;
        case "friends":
            friendsBar.setValue(value);
            break;
        case "teachers":
            teachersBar.setValue(value);
            break;
        case "coworkers":
            coworkersBar.setValue(value);
            break;
        case "yourself":
            yourselfBar.setValue(value);
            break;
        case "siblings":
            siblingsBar.setValue(value);
            break;

    }

}

public void addProgress(String faction, int add){


}

public void subProgress(String faction, int sub){

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


