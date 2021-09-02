package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.*;

public  class Partners extends JFrame {
	
    JPanel panel = new JPanel();

    Partners(){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);  
        panel.setBackground(Color.white);
        panel.setBounds(0,50,1400,550);

        panel.setPreferredSize(new Dimension(200, 2270));
        panel.setLayout(null);

        JLabel label1 = new JLabel("OUR PARTNERS");
        label1.setBounds(540,10, 1200,40);
        label1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 35));
        label1.setForeground(new Color(23, 43, 79));

        JLabel lab1=new JLabel(">>> Our goals are far too ambitious to achieve alone.");
        lab1.setBounds(50,50,1500,70);
        lab1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab1.setForeground(Color.BLACK);

        JLabel lab2=new JLabel(">>> That's why we partner with local organizations that know their communities best and who will continue the work long after we leave.");
        lab2.setBounds(50,100,1500,70);
        lab2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab2.setForeground(Color.BLACK);

        JLabel lab3=new JLabel(">>> We also rely on the passion, knowledge, and support of partners both big and small. From global agencies to individuals like you,");
        lab3.setBounds(50,150,1500,70);
        lab3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab3.setForeground(Color.BLACK);

        JLabel lab4=new JLabel("together we can achieve substantial change.");
        lab4.setBounds(50,200,1500,70);
        lab4.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab4.setForeground(Color.BLACK);

        JLabel lab5=new JLabel("You can also see the details of the partners or sponsors by clicking the 'GO TO DETAILS' button and ");
        lab5.setBounds(200,250,1500,70);
        lab5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab5.setForeground(Color.BLACK);

        JLabel lab6=new JLabel("selecting a name from the drop down list.");
        lab6.setBounds(430,300,1500,70);
        lab6.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        lab6.setForeground(Color.BLACK);

        JButton b=new JButton("BACK");
        b.setBounds(700,400,200,50);
        b.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        b.setBackground(new Color(23, 43, 79));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Home.callDescription();
            }
        });

        JButton details=new JButton("GO TO DETAILS");
        details.setBounds(470,400,200,50);
        details.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
        details.setForeground(Color.white);
        details.setBackground(new Color(23, 43, 79));
        details.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Home.callDisplaySponsorDetails();

            }
        });
        panel.add(b);  
        panel.add(details);
        panel.add(label1);
        panel.add(lab1);
        panel.add(lab2);
        panel.add(lab3);
        panel.add(lab4);
        panel.add(lab5);
        panel.add(lab6);
        //add(panel);
        setVisible(false);
    }

//    public static void main(String args[]) {
//
//        new Partners();
//
//    }
}