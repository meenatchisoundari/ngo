package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Description extends JFrame{
	
    JPanel panel = new JPanel();
        
    Description(){
           
            
//		    setExtendedState(JFrame.MAXIMIZED_BOTH);
//		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		    setLocationRelativeTo(null);
//		    setSize(1300,700);
//		    setLayout(null);  

        panel.setBackground(Color.WHITE);
        panel.setBounds(0,50,1400,550);

        panel.setPreferredSize(new Dimension(200, 2270));
	panel.setLayout(null);
  
        JLabel label16=new JLabel("DESCRIPTION");
        label16.setBounds(560,10, 200,40);
    	label16.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 30));
    	label16.setForeground(new Color(23,43,79));
    	JLabel label17=new JLabel("WE FOR YOU is an NGO based in Chennai, India. It was established in 2002 and had a presence in 25 states. As of 2017,");
    	label17.setBounds(70,50,1500,70);
    	label17.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label17.setForeground(Color.BLACK);
    	JLabel label18=new JLabel("the foundation reaches approximately 4 lakh children and their families. The purpose of");
    	label18.setBounds(20,90,1500,70);
    	label18.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label18.setForeground(Color.BLACK);
    	JLabel label19=new JLabel("We For You Foundation for Education in India was to promote education among the ");
    	label19.setBounds(20,130,1500,70);
    	label19.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label19.setForeground(Color.BLACK);
    	JLabel label20=new JLabel("underprivileged. Their development program includes Education,health, livelihood for ");
    	label20.setBounds(20,170,1500,70);
    	label20.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label20.setForeground(Color.BLACK);
    	JLabel label25=new JLabel("children and women, provision to be equally affected by lack of resources.");
    	label25.setBounds(20,210,1500,70);
    	label25.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label25.setForeground(Color.BLACK);
    	JLabel label21=new JLabel("We For You is also taking action against universal, pension, healthcare, Elder Abuse ");
    	label21.setBounds(70,250,1500,70);
    	label21.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label21.setForeground(Color.BLACK);
    	JLabel label22=new JLabel("at the national,state and social levels with the central,state governments and advocates");
    	label22.setBounds(20,290,1500,70);
    	label22.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label22.setForeground(Color.BLACK);
    	JLabel label23=new JLabel("for the needy. It runs various age care programs to cater to the more significant needs.");
    	label23.setBounds(20,330,1500,70);
    	label23.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label23.setForeground(Color.BLACK);
    	JLabel label24=new JLabel("It aims to serve the disadvantaged elders holistically to lead an active,dignified and healthy life.");
    	label24.setBounds(20,370,1500,70);
    	label24.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	label24.setForeground(Color.BLACK);
    	JButton button1 = new JButton("OUR PARTNERS");
    	button1.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
        button1.setBounds(20,490,252,50);
        button1.setBackground(new Color(23,43,79));
        button1.setForeground(Color.WHITE);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    Home.callPartners();
            }
    		
    	});
	    
        JButton button2 = new JButton("HEADQUARTERS AND FOUNDER DETAILS ");
        button2.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
        button2.setBounds(271,490,600,50);
        button2.setBackground(new Color(23,43,79));
        button2.setForeground(Color.WHITE);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    Home.callFounders();
            }
    		
    	});
        
        JButton button3 = new JButton("REPORTS");
        button3.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
        button3.setBounds(860,490,270,50);
        button3.setForeground(Color.WHITE);
        button3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               Home.callReports();
            }
        });
        button3.setBackground(new Color(23,43,79));

      
        JButton b=new JButton("BACK");
    	b.setBounds(1122,490,220,50);
    	b.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 18));
    	b.setBackground(new Color(23,43,79));
        b.setForeground(Color.WHITE);
        b.addActionListener(new ActionListener() {
    		
            @Override
            public void actionPerformed(ActionEvent e) {
                    Home.callAboutus();
            }
    	});
    	
    	JLabel pic4=new JLabel();
    	pic4.setBounds(770,120,470,290);
        ImageIcon icon4 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\des1.jpg");
        Image img4=icon4.getImage();
    	Image newImg4=img4.getScaledInstance(pic4.getWidth(), pic4.getHeight(), Image.SCALE_SMOOTH);
    	ImageIcon newImc4=new ImageIcon(newImg4);
    	pic4.setIcon(newImc4);
     
        panel.add(label16);
        panel.add(label17);
        panel.add(label18);
        panel.add(label19);
        panel.add(label20);
        panel.add(label21);
        panel.add(label22);
        panel.add(label23);
        panel.add(label24);
        panel.add(label25);
        panel.add(b);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(pic4);
        //add(panel);
    
        setVisible(false);      
    }      
//    public static void main(String args[]) {
//              
//        new Description();
//               
//    }
}