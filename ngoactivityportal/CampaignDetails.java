package ngoactivityportal;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CampaignDetails extends JFrame  implements ActionListener{
    
    OrganizationDetails od=new OrganizationDetails();
    JPanel campaign_user=new JPanel(),event_Details=new JPanel(),volunteer=new JPanel(new GridLayout(7,1));
    JTable table;
    JLabel l_heading,l_volunteer_name,l_campaign_id,l_sector,l_contact_no,l_mail_id,l_profession;
    JTextField tf_volunteer_name,tf_campaign_id,tf_sector,tf_contact_no,tf_mail_id,tf_profession; 
    JButton volunteer_btn,back_btn,submit_btn;
    String data[][]=new String[6000][6000];
    String columnNames[]={"CAMPAIGN ID","CAMPAIGN NAME","START DATE","END DATE","VENUE","SECTOR","DESCRIPTION","STATUS"};
    
    CampaignDetails(){
        
        /*setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,700);
        setLayout(null);
        */
        campaign_user.setVisible(true);
        campaign_user.setBackground(Color.white);
        campaign_user.setLayout(null);
        campaign_user.setBounds(0,50,1400,550); 
        
        event_Details.setVisible(true);
        event_Details.setBackground(Color.white);
        event_Details.setLayout(new GridLayout());
        event_Details.setBounds(0,40,1400,500); 
        
        l_heading=new JLabel("EVENT DETAILS");
        l_heading.setFont(new Font("Verdana" , Font.BOLD , 15));
        l_heading.setForeground(new Color(23, 43, 79));
        l_heading.setBounds(640,5,150,30);
        campaign_user.add(l_heading);
        
        volunteer_btn=new JButton("VOLUNTEER TO EVENTS");
        volunteer_btn.setBounds(1100, 5, 250, 30);
        volunteer_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        volunteer_btn.setForeground(Color.WHITE);
        volunteer_btn.setBackground(new Color(23, 43, 79));
        volunteer_btn.addActionListener(this);
        campaign_user.add(volunteer_btn);
        
        try{
            Connection con = GetConnection.getConnection();
            String sql = "select * from campaign";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i=0;
            while(rs.next()){
                int j=0;           
                data[i][j++] = rs.getString("campaign_id");
                data[i][j++]= rs.getString("campaign_name");
                data[i][j++]= rs.getString("start_date");
                data[i][j++]=rs.getString("end_date");
                data[i][j++]=rs.getString("venue");
                data[i][j++]= rs.getString("sector");
                data[i][j++]=rs.getString("description");
                data[i][j++]=rs.getString("status");
                i++;
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        table = new JTable(data,columnNames);
        table.setBackground(Color.white);
        table.setBounds(100, 100, 1000, 900);
        
        event_Details.add(new JScrollPane(table));
        
        
        volunteer.setVisible(true);
        volunteer.setBackground(Color.white);
        volunteer.setLayout(new GridLayout(7,1));
        volunteer.setBounds(430,60,550,400);
        volunteer.setPreferredSize(new Dimension(500,500));
        
        l_volunteer_name=new JLabel("VOLUNTEER NAME");
        l_campaign_id=new JLabel("CAMPAIGN ID");
        l_sector=new JLabel("SECTOR");
        l_contact_no=new JLabel("CONTACT NUMBER");
        l_mail_id=new JLabel("E-MAIL");
        l_profession=new JLabel("PROFESSION");
        tf_volunteer_name=new JTextField();
        tf_campaign_id=new JTextField();
        tf_sector=new JTextField();
        tf_contact_no=new JTextField();
        tf_mail_id=new JTextField();
        tf_profession=new JTextField();
        
        back_btn=new JButton("BACK");
        back_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        back_btn.setForeground(Color.WHITE);
        back_btn.setBackground(new Color(23, 43, 79));
        back_btn.addActionListener(this);
        
        
        submit_btn=new JButton("SUBMIT");
        submit_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        submit_btn.setForeground(Color.WHITE);
        submit_btn.setBackground(new Color(23, 43, 79));
        submit_btn.addActionListener(this);
        
       
        volunteer.add(l_volunteer_name);
        volunteer.add(tf_volunteer_name);
        volunteer.add(l_campaign_id);
        volunteer.add(tf_campaign_id);
        volunteer.add(l_sector);
        volunteer.add(tf_sector);
        volunteer.add(l_contact_no);
        volunteer.add(tf_contact_no);
        volunteer.add(l_mail_id);
        volunteer.add(tf_mail_id);
        volunteer.add(l_profession);
        volunteer.add(tf_profession);
        volunteer.add(back_btn);
        volunteer.add(submit_btn);
        
        campaign_user.add(event_Details);
        
        
        //add(campaign_user);
        setVisible(false);         
    }
    public void actionPerformed(ActionEvent ae){
        Object obj=ae.getSource();
        if(obj==volunteer_btn){
            volunteer.setVisible(true);
            event_Details.setVisible(false);
            volunteer_btn.setEnabled(false);
            campaign_user.add(volunteer);
        }
        if(obj==back_btn){
            tf_volunteer_name.setText(null);
            tf_campaign_id.setText(null);
            tf_sector.setText(null);
            tf_contact_no.setText(null);
            tf_mail_id.setText(null);
            tf_profession.setText(null);
            od.setCampaignID(null);
            od.setVolunteerName(null);
            od.setSector(null);
            od.setContactNo(null);
            od.setMailID(null);
            od.setProfession(null);
            volunteer.setVisible(false);
            event_Details.setVisible(true);
            volunteer_btn.setEnabled(true);
            campaign_user.add(event_Details);   
        }
        if(obj==submit_btn){
            String volunteer_name=tf_volunteer_name.getText();
            String campaign_id=tf_campaign_id.getText();
            String sector=tf_sector.getText();
            String contact_no=tf_contact_no.getText();
            String mail_id=tf_mail_id.getText();
            String profession=tf_profession.getText();
            
            
            if(!Validate.nameIsValid(volunteer_name)){
                 JOptionPane.showMessageDialog(this, "Inavlid name format", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!Validate.mobilenoIsValid(contact_no)){
                 JOptionPane.showMessageDialog(this, "Inavlid mobile number format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(!Validate.emailIsValid(mail_id)){
                        JOptionPane.showMessageDialog(this, "Inavlid e-mail id format", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        od.setVolunteerName(volunteer_name);
                        od.setCampaignID(campaign_id);
                        od.setSector(sector);
                        od.setContactNo(contact_no);
                        od.setMailID(mail_id);
                        od.setProfession(profession);
                    
                        try{
                            Connection con=GetConnection.getConnection();
                            String query="insert into volunteer values(?,?,?,?,?,?)";
                            PreparedStatement pstmt=con.prepareStatement(query);
                            pstmt.setString(1,od.getVolunteerName());
                            pstmt.setString(2,od.getCampaignID());
                            pstmt.setString(3,od.getSector());
                            pstmt.setString(4,od.getContactNo());
                            pstmt.setString(5,od.getMailID());
                            pstmt.setString(6,od.getProfession());


                            pstmt.executeUpdate();
                            con.setAutoCommit(true);
                            con.close();

                            JOptionPane.showMessageDialog(this, "Registered Successfully!");
                            tf_volunteer_name.setText(null);
                            tf_campaign_id.setText(null);
                            tf_sector.setText(null);
                            tf_contact_no.setText(null);
                            tf_mail_id.setText(null);
                            tf_profession.setText(null);
                            od.setCampaignID(null);
                            od.setVolunteerName(null);
                            od.setSector(null);
                            od.setContactNo(null);
                            od.setMailID(null);
                            od.setProfession(null);

                            volunteer.setVisible(false);
                            event_Details.setVisible(true);
                            volunteer_btn.setEnabled(true);
                            campaign_user.add(event_Details);
                        }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,"Enter valid campaign id");
                        }
                    }
                }
            }
        }
    }
}

class Validate{
    
    private static final String namePattern="^[a-zA-Z]{0,20}$"; 
    private static final Pattern pattern_n=Pattern.compile(namePattern);
    private static final String emailPattern="^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern_e=Pattern.compile(emailPattern);
    private static final String datePattern="^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    private static final Pattern pattern_d=Pattern.compile(datePattern);
    private static final String mobilenoPattern="(0/91)?[7-9][0-9]{9}";
    private static final Pattern pattern_m= Pattern.compile(mobilenoPattern);
    
    public static boolean nameIsValid(final String name) {
        Matcher matcher = pattern_n.matcher(name);
        return matcher.matches();
    }
    public static boolean mobilenoIsValid(final String mobileno) {
        Matcher matcher = pattern_m.matcher(mobileno);
        return matcher.matches();
    }  
    public static boolean emailIsValid(final String email) {
        Matcher matcher = pattern_e.matcher(email);
        return matcher.matches();
    }
    public static boolean dateIsValid(final String date) {
        Matcher matcher = pattern_d.matcher(date);
        return matcher.matches();
    }
}


  