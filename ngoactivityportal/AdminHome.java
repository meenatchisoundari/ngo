package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminHome extends JFrame implements ActionListener{
    
    JPanel home1= new JPanel();
    JButton campaign,donation,b1;
    JPanel top ,bottom,donate;
    
    
    AdminHome(){  
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,700);
        setLayout(null);

        home1.setBackground(Color.yellow);
       
        CampaignAdmin object=new CampaignAdmin();
        home1=object.Campaign_admin;
        home1.setBounds(0,50,1400,700);
        home1.setVisible(true);
        
        
        top = new JPanel();
        top.setLayout(null);
        
        DonationAdmin don = new DonationAdmin();
        donate = don.table__panel;
        donate.setBounds(0,50,1400,700);
        
        donate.setVisible(false);
          
        
        JLabel logo=new JLabel();
        top.add(logo);
        logo.setBounds(0,0,100,50);
        ImageIcon icon_logo= new ImageIcon("C:/Users/A MAHALAKSHMI/Desktop/log.PNG");
        Image img_logo=icon_logo.getImage();
        Image newImg_logo=img_logo.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_logo=new ImageIcon(newImg_logo);
        logo.setIcon(newImc_logo);
        
        campaign=new JButton("CAMPAIGN");
      	top.add(campaign);
        campaign.setBounds(500,0,150,50);
        campaign.setFont(new Font("Verdana" , Font.BOLD , 15));
        campaign.setForeground(Color.WHITE);
        campaign.setBackground(Color.BLACK);
        campaign.addActionListener(this);
        campaign.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,0,0,80)));
        
        
        donation=new JButton("DONATION");
        top.add(donation);
        donation.setBounds(650,0,150,50);
        donation.setFont(new Font("Verdana" , Font.BOLD , 15));
        donation.setForeground(Color.WHITE);
        donation.setBackground(Color.BLACK);
        donation.addActionListener(this);
        donation.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0,0,0,80)));
        
        JLabel login=new JLabel();
        top.add(login);
        login.setBounds(1130,10,50,30);
        ImageIcon iconlogin= new ImageIcon("C:/Users/A MAHALAKSHMI/Desktop/login.PNG");
        Image imglogin=iconlogin.getImage();
        Image newImglogin=imglogin.getScaledInstance(login.getWidth(), login.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImclogin=new ImageIcon(newImglogin);
        login.setIcon(newImclogin);
        
        b1=new JButton("ADMIN LOGOUT");
        top.add(b1);
        b1.setBounds(1180,0,200,50);
        b1.setFont(new Font("Verdana" , Font.BOLD , 14));
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(1.0f,1.0f,1.0f,0.5f)));
        
        top.setBackground(Color.WHITE);
        home1.setBackground(Color.WHITE);
        
        top.setBounds(0,0,1400,50);
        home1.setBounds(0,50,1400,650);
        
        add(top);
        add(home1);
        add(donate);
       
        setVisible(true);  
    }

    @Override  
    public void actionPerformed(ActionEvent ae){
        
        Object oj=ae.getSource();
        if(oj==campaign){
            donate.setVisible(false);
            home1.setVisible(true);
        }
        if(oj==b1){
            setVisible(false);
        }
        if(oj==donation){
            home1.setVisible(false);
            donate.setVisible(true);
        }
    }
}

