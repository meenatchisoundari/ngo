package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public  class Founder extends JFrame {
	
    JPanel panel = new JPanel();

    Founder(){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);  

        panel.setBackground(Color.WHITE);
        panel.setBounds(0,50,1400,550);
        panel.setPreferredSize(new Dimension(200, 2270));
        panel.setLayout(null);

        JLabel label1 = new JLabel("FOUNDER AND HEADQUARTERS");
        label1.setBounds(420,10,670,40);
        label1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 30));
        label1.setForeground(new Color(23, 43, 79));   
        JLabel label2=new JLabel("WE FOR YOU is founded by Prof.Venugopal Srinivasan in the year 2002.");
        label2.setBounds(600,70,1500,70);
        label2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label2.setForeground(Color.BLACK);
        JLabel label3=new JLabel("The headquarters of the NGO is located in Chennai and has branches in 9 places.");
        label3.setBounds(530,120,1500,70);
        label3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label3.setForeground(Color.BLACK);
        JLabel label4=new JLabel("Prof.Venugopal Srinivasan(born in India, 1947) is the founding Executive Director ");
        label4.setBounds(530,170,1500,70);
        label4.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label4.setForeground(Color.BLACK);
        JLabel label5=new JLabel("of the 'WE FOR YOU' NGO.He is a former Collegiate Professor of social work and");
        label5.setBounds(530,220,1500,70);
        label5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label5.setForeground(Color.BLACK);
        JLabel label6=new JLabel("Human Resources Management at the Madurai Institute of social sciences,Madurai.");
        label6.setBounds(530,270,1500,70);
        label6.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label6.setForeground(Color.BLACK);
        JLabel label7=new JLabel("He received his master's degree in Social work with human resources management (HRM)");
        label7.setBounds(530,320,1500,70);
        label7.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label7.setForeground(Color.BLACK);
        JLabel label8=new JLabel("as a field of specialisation from the Loyola College (University of Madras),Chennai.");
        label8.setBounds(530,370,1500,70);
        label8.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        label8.setForeground(Color.BLACK);

        JLabel pic4=new JLabel();
        pic4.setBounds(0,100,500,350);
        ImageIcon icon4 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\ss11.png");
        Image img4=icon4.getImage();
        Image newImg4=img4.getScaledInstance(pic4.getWidth(), pic4.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc4=new ImageIcon(newImg4);
        pic4.setIcon(newImc4);

        JLabel pic3=new JLabel();
        pic3.setBounds(243,126,235,300);
        ImageIcon icon3 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\female2.jpg");
        Image img3=icon3.getImage();
        Image newImg3=img3.getScaledInstance(pic3.getWidth(), pic3.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc3=new ImageIcon(newImg3);
        pic3.setIcon(newImc3);

        JButton b=new JButton("BACK");
        b.setBounds(1200,460,100,50);
        b.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 22));
        b.setBackground(new Color(23, 43, 79));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.callDescription();
            }
        });

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(pic3);
        panel.add(pic4);

        panel.add(b);
        //add(panel);
        setVisible(false);
    }

//    public static void main(String args[]) {
//
//        new Founder();
//          
//    }
}