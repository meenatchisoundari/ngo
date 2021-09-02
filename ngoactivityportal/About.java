package ngoactivityportal;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public  class About extends JFrame {
	
        JPanel panel = new JPanel();
        
        About(){
           
//	    setExtendedState(JFrame.MAXIMIZED_BOTH);
//	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    setLocationRelativeTo(null);
//	    setSize(1300,700);
//	    setLayout(null);  

	    panel.setBackground(Color.WHITE);
	    panel.setBounds(0,50,1400,550);
	    
	    panel.setPreferredSize(new Dimension(200, 2270));
            panel.setLayout(null);

            JLabel label1 = new JLabel("ABOUT US ");
            label1.setBounds(570,10, 250,40);
            label1.setFont(new Font("Verdana", Font.BOLD, 25));
            label1.setForeground(new Color(23, 43, 79));
            
            JLabel label2 = new JLabel("VISION  ");
            label2.setBounds(40,94, 150,30);
            label2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 25));
            label2.setForeground(Color.WHITE);
            JLabel label3 = new JLabel(" WE FOR YOU works around the globe ");            
            label3.setBounds(60,10,400,300);
            label3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label3.setForeground(Color.WHITE);
            JLabel label4 = new JLabel ("  to save lives,defeat poverty, ");
            label4.setBounds(60,50,400,300);
            label4.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label4.setForeground(Color.WHITE);
            JLabel label5=new JLabel("  and achieve social justice. ");
            label5.setBounds(60,90,400,300);
            label5.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label5.setForeground(Color.WHITE);
            
            
            JLabel label6 = new JLabel(" MISSION ");
            label6.setBounds(447,122,400,50);
            label6.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 25));
            label6.setForeground(Color.WHITE);
            JLabel label7 = new JLabel("We seek a world of hope,and ");
            label7.setBounds(480,165,400,50);
            label7.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label7.setForeground(Color.WHITE);
            JLabel label8=new JLabel("social justice,where poverty has been ");
            label8.setBounds(480,200,400,50);
            label8.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label8.setForeground(Color.WHITE);
            JLabel label9=new JLabel("overcome and all people live in");
            label9.setBounds(480,235,400,50);
            label9.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label9.setForeground(Color.WHITE);
            JLabel label10=new JLabel("dignity and security.");
            label10.setBounds(480,270,400,50);
            label10.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label10.setForeground(Color.WHITE);
            
            
            JLabel label11=new JLabel("FOCUS");
            label11.setBounds(860,150,400,50);
            label11.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 25));
            label11.setForeground(Color.WHITE);
            JLabel label12=new JLabel("We put women and girls in the center");
            label12.setBounds(888,192,400,50);
            label12.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label12.setForeground(Color.WHITE);
            JLabel label13=new JLabel("because we know that we cannot");
            label13.setBounds(885,226,400,50);
            label13.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label13.setForeground(Color.WHITE);
            JLabel label14=new JLabel("overcome poverty until all people");
            label14.setBounds(885,260,400,50);
            label14.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label14.setForeground(Color.WHITE);
            JLabel label15=new JLabel("have equal rights and opportunities.");
            label15.setBounds(885,294,400,50);
            label15.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 20));
            label15.setForeground(Color.WHITE);

            JButton b=new JButton("GO TO DESCRIPTION");
            b.setBounds(500,490,280,50);
            b.setFont(new Font("Verdana" , Font.BOLD , 15));
            b.setForeground(Color.WHITE);
            b.setBackground(new Color(23, 43, 79));
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Home.callDescription();
                }
    		
    	    });
            
            JLabel pic3=new JLabel();
            pic3.setBounds(30,90,400,250);
            ImageIcon icon3 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\blue.jfif");
            Image img3=icon3.getImage();
            Image newImg3=img3.getScaledInstance(pic3.getWidth(), pic3.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc3=new ImageIcon(newImg3);
            pic3.setIcon(newImc3);
            JLabel pic4=new JLabel();
            pic4.setBounds(440,130,400,250);
            ImageIcon icon4 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\blue.jfif");
            Image img4=icon4.getImage();
            Image newImg4=img4.getScaledInstance(pic4.getWidth(), pic4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc4=new ImageIcon(newImg4);
            pic4.setIcon(newImc4);
            JLabel pic5=new JLabel();
            pic5.setBounds(850,160,400,250);
            ImageIcon icon5 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\blue.jfif");
            Image img5=icon5.getImage();
            Image newImg5=img5.getScaledInstance(pic5.getWidth(), pic5.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImc5=new ImageIcon(newImg5);
            pic5.setIcon(newImc5);
            JLabel pic6=new JLabel();
            pic6.setBounds(430,990,400,250);


            panel.add(label1);
            panel.add(label2);
            panel.add(label3);
            panel.add(label4);
            panel.add(label5);
            panel.add(label6);
            panel.add(label7);
            panel.add(label8);
            panel.add(label9);
            panel.add(label10);
            panel.add(label11);
            panel.add(label12);
            panel.add(label13);
            panel.add(label14);
            panel.add(label15);

            panel.add(pic5);
            panel.add(pic4);
            panel.add(pic3);

            panel.add(b);

            add(panel);

            setVisible(false);

        }

//        public static void main(String args[]) {
//
//              new About();
//
//        }
}