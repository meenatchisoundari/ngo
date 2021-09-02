package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

class CampaignAdmin extends JFrame implements ActionListener{
    
    OrganizationDetails od=new  OrganizationDetails();
    JPanel Campaign_admin = new JPanel(),Campaign_details= new JPanel(),subPanel,campaign,cardCampaignDetails,cardVolunteerDetails,form1,subPanel1,form2,buttonPanel;
    JLabel l_campaign_id,l_campaign_name,l_sector,l_startDate,l_endDate,l_venue,l_description,l_status,l_volunteer_name,l_contact_no,l_mail_id,l_campaign_id1,l_sector1,l_profession,l_status1;;
    JButton addCampaignBtn,updateCampaignBtn,deleteCampaignBtn,showCampaignBtn,clearCampaignBtn,showVolunteerBtn,deleteVolunteerBtn,clearVolunteerBtn,campaignDetailsBtn,volunteerDetailsBtn;
    JTextField tf_campaignID,tf_campaign_id,tf_campaign_name,tf_sector,tf_startDate,tf_endDate,tf_venue,tf_description,tf_status,tf_volunteer_name,tf_contact_no,tf_mail_id,tf_campaign_id1,tf_sector1,tf_profession,tf_status1;;
    
    CampaignAdmin(){
        
        /*setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,700);
        setLayout(null);
        */
        
        Campaign_admin.setBackground(Color.white);
        Campaign_admin.setLayout(null);
       
        Campaign_details.setBackground(Color.white);
        Campaign_details.setBounds(0,30,1400,550);
        Campaign_details.setVisible(true);
       
        campaign = new JPanel();
        CardLayout cards = new CardLayout();
        campaign.setLayout(cards);
        campaign.setPreferredSize(new Dimension(1300,450));
       
        cardCampaignDetails = new JPanel();
        cardCampaignDetails.setBackground(Color.white);
        cardCampaignDetails.setLayout(new BorderLayout());
       
        cardVolunteerDetails = new JPanel(new BorderLayout());
        cardVolunteerDetails.setBackground(Color.white);
       
        tf_campaignID=new JTextField();
        tf_campaignID.setPreferredSize(new Dimension(100,30));
        addCampaignBtn=new JButton("ADD");
        addCampaignBtn.addActionListener(this);
        updateCampaignBtn=new JButton("UPDATE");
        updateCampaignBtn.addActionListener(this);
        updateCampaignBtn.setEnabled(false);
        deleteCampaignBtn=new JButton("DELETE");
        deleteCampaignBtn.addActionListener(this);
        deleteCampaignBtn.setEnabled(false);
        showCampaignBtn=new JButton("SHOW");
        showCampaignBtn.addActionListener(this);
        clearCampaignBtn=new JButton("CLEAR ALL");
        clearCampaignBtn.addActionListener(this);
       
        subPanel=new JPanel();
        subPanel.setBackground(Color.white);
        subPanel.add(addCampaignBtn);
        subPanel.add(tf_campaignID);
        subPanel.add(updateCampaignBtn);
        subPanel.add(deleteCampaignBtn);
        subPanel.add(showCampaignBtn);
        subPanel.add(clearCampaignBtn);
        cardCampaignDetails.add(subPanel,BorderLayout.SOUTH);
       
        l_campaign_id=new JLabel("CAMPAIGN ID");
        tf_campaign_id=new JTextField();
        l_campaign_name=new JLabel("CAMPAIGN NAME");
        tf_campaign_name=new JTextField();
        l_sector=new JLabel("SECTOR");
        tf_sector=new JTextField();
        l_startDate=new JLabel("START DATE");
        tf_startDate=new JTextField();
        l_endDate=new JLabel("END DATE");
        tf_endDate=new JTextField();
        l_venue=new JLabel("VENUE");
        tf_venue=new JTextField();
        l_description=new JLabel("DESCRIPTION");
        tf_description=new JTextField();
        l_status=new JLabel("STATUS");
        tf_status=new JTextField();
        form1=new JPanel(new GridLayout(8,1));
        form1.setPreferredSize(new Dimension(500,500));
        form1.setVisible(true);
        form1.setBackground(Color.white);
        form1.add(l_campaign_id);
        form1.add(tf_campaign_id);
        form1.add(l_campaign_name);
        form1.add(tf_campaign_name);
        form1.add(l_startDate);
        form1.add(tf_startDate);
        form1.add(l_endDate);
        form1.add(tf_endDate);
        form1.add(l_venue);
        form1.add(tf_venue);
        form1.add(l_sector);
        form1.add(tf_sector);
        form1.add(l_description);
        form1.add(tf_description);
        form1.add(l_status);
        form1.add(tf_status);      
        cardCampaignDetails.add(form1,BorderLayout.CENTER);
       
           
        showVolunteerBtn=new JButton("SHOW");
        deleteVolunteerBtn=new JButton("DELETE");
        clearVolunteerBtn=new JButton("CLEAR ALL");
        deleteVolunteerBtn.setEnabled(false);
        showVolunteerBtn.addActionListener(this);
        deleteVolunteerBtn.addActionListener(this);
        clearVolunteerBtn.addActionListener(this);
        subPanel1=new JPanel();
        subPanel1.setBackground(Color.white);
        subPanel1.add(showVolunteerBtn);
        subPanel1.add(deleteVolunteerBtn);
        subPanel1.add(clearVolunteerBtn);
        cardVolunteerDetails.add(subPanel1,BorderLayout.SOUTH);
         
        l_volunteer_name=new JLabel("VOLUNTEER NAME");
        tf_volunteer_name=new JTextField();
        tf_volunteer_name.setEditable(false);
        l_contact_no=new JLabel("CONTACT NUMBER");
        tf_contact_no=new JTextField();
        tf_contact_no.setEditable(false);
        l_mail_id=new JLabel("MAIL ID");
        tf_mail_id=new JTextField();
        l_campaign_id1=new JLabel("CAMPAIGN ID");
        tf_campaign_id1=new JTextField();
        l_sector1=new JLabel("SECTOR");
        tf_sector1=new JTextField();
        tf_sector1.setEditable(false);
        l_profession=new JLabel("PROFESSION");
        tf_profession=new JTextField();
        tf_profession.setEditable(false);
        form2=new JPanel(new GridLayout(7,1));
        form2.setPreferredSize(new Dimension(500,500));
        form2.setVisible(true);
        form2.setBackground(Color.white);
        form2.add(l_volunteer_name);
        form2.add(tf_volunteer_name);
        form2.add(l_campaign_id1);
        form2.add(tf_campaign_id1);
        form2.add(l_sector1);
        form2.add(tf_sector1);
        form2.add(l_contact_no);
        form2.add(tf_contact_no);
        form2.add(l_mail_id);
        form2.add(tf_mail_id);
        form2.add(l_profession);
        form2.add(tf_profession);      
        cardVolunteerDetails.add(form2,BorderLayout.CENTER);
       
        campaign.add(cardCampaignDetails);
        campaign.add(cardVolunteerDetails);
       
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(1300,40));
       
        buttonPanel.setBackground(Color.white);
        campaignDetailsBtn = new JButton("CampaignDetails");
        campaignDetailsBtn.setBackground(Color.white);
        volunteerDetailsBtn = new JButton("VolunteerDetails");
        volunteerDetailsBtn.setBackground(Color.white);
        buttonPanel.add(campaignDetailsBtn);
        buttonPanel.add(volunteerDetailsBtn);
       
        campaignDetailsBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                cards.first(campaign);
            }
        });
        volunteerDetailsBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                cards.last(campaign);
            }
        });
        Campaign_details.add(campaign, BorderLayout.CENTER);
        Campaign_details.add(buttonPanel, BorderLayout.SOUTH);
       
        Campaign_admin.add(Campaign_details);
        //add(Campaign_admin);
       
        Campaign_admin.setBounds(0,50,1400,700);
        setVisible(false);
    }
    
    public void actionPerformed(ActionEvent ae){
        Object obj=ae.getSource();
        if(obj==addCampaignBtn){
            String campaign_id=tf_campaign_id.getText();
            String campaign_name=tf_campaign_name.getText();
            String sector=tf_sector.getText();
            String startDate=tf_startDate.getText();
            String endDate=tf_endDate.getText();
            String venue=tf_venue.getText();
            String description=tf_description.getText();
            String status=tf_status.getText();
           
            if(!Validate.dateIsValid(startDate)){
                 JOptionPane.showMessageDialog(this, "Inavlid Start date format", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!Validate.dateIsValid(endDate)){
                 JOptionPane.showMessageDialog(this, "Inavlid End date format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    od.setCampaignID(campaign_id);
                    od.setCampaignName(campaign_name);
                    od.setSector(sector);
                    od.setStartDate(startDate);
                    od.setEndDate(endDate);
                    od.setVenue(venue);
                    od.setDescription(description);
                    od.setStatus(status);
                   
                    try{
                        Connection con=GetConnection.getConnection();
                        String query="insert into campaign values(?,?,?,?,?,?,?,?)";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(1, od.getCampaignID());
                        pstmt.setString(2,od.getCampaignName());
                        pstmt.setString(3,od.getStartDate());
                        pstmt.setString(4,od.getEndDate());
                        pstmt.setString(5,od.getVenue());
                        pstmt.setString(6,od.getSector());
                        pstmt.setString(7,od.getDescription());
                        pstmt.setString(8,od.getStatus());
                       
                        pstmt.executeUpdate();
                        con.setAutoCommit(true);
                        con.close();
                        JOptionPane.showMessageDialog(this, "CAMPAIGN ADDED SUCCESSFULLY!");
                        tf_campaign_id.setText(null);
                        tf_campaign_name.setText(null);
                        tf_startDate.setText(null);
                        tf_endDate.setText(null);
                        tf_venue.setText(null);
                        tf_sector.setText(null);
                        tf_description.setText(null);
                        tf_status.setText(null);
                        od.setCampaignID(null);
                        od.setCampaignName(null);
                        od.setStartDate(null);
                        od.setEndDate(null);
                        od.setVenue(null);
                        od.setSector(null);
                        od.setDescription(null);
                        od.setStatus(null);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ex.toString());
                    }
                }
            }
        }
        else if(obj==deleteCampaignBtn){
            String campignID=tf_campaignID.getText();
           
            od.setCampaignID(campignID);
            try{
                Connection con=GetConnection.getConnection();
                String query="delete from campaign where campaign_id=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, od.getCampaignID());
                pstmt.executeUpdate();
                con.setAutoCommit(true);
               
                JOptionPane.showMessageDialog(this, "Deleted Successfully!");
                con.close();
                tf_campaign_id.setText(null);
                tf_campaign_name.setText(null);
                tf_startDate.setText(null);
                tf_endDate.setText(null);
                tf_venue.setText(null);
                tf_sector.setText(null);
                tf_description.setText(null);
                tf_status.setText(null);
                od.setCampaignID(null);
                od.setCampaignName(null);
                od.setStartDate(null);
                od.setEndDate(null);
                od.setVenue(null);
                od.setSector(null);
                od.setDescription(null);
                od.setStatus(null);
                tf_campaignID.setText(null);
                tf_campaign_id.setEditable(true);
                tf_campaignID.setEditable(true);
                updateCampaignBtn.setEnabled(false);
                deleteCampaignBtn.setEnabled(false);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
        else if(obj==showCampaignBtn){
            updateCampaignBtn.setEnabled(true);
            deleteCampaignBtn.setEnabled(true);
            String campaignID=tf_campaignID.getText();
            tf_campaignID.setEditable(false);
            tf_campaign_id.setText(campaignID);
            tf_campaign_id.setEditable(false);
           
            try{
               
                Connection con1=GetConnection.getConnection();
                String query1="select * from campaign where campaign_id=?";
                PreparedStatement pstmt1=con1.prepareStatement(query1);
                pstmt1.setString(1,campaignID);
               
                ResultSet rset=pstmt1.executeQuery();
                if(rset.next()){
                    tf_campaign_name.setText(rset.getString("campaign_name"));
                    tf_sector.setText(rset.getString("sector"));
                    tf_startDate.setText(rset.getString("start_date"));
                    tf_endDate.setText(rset.getString("end_date"));
                    tf_venue.setText(rset.getString("venue"));
                    tf_description.setText(rset.getString("description"));
                    tf_status.setText(rset.getString("status"));
                }
                con1.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.toString());
            }
        }
        else if(obj==updateCampaignBtn){
            String campignID=tf_campaignID.getText();
            String campaign_name=tf_campaign_name.getText();
            String sector=tf_sector.getText();
            String startDate=tf_startDate.getText();
            String endDate=tf_endDate.getText();
            String venue=tf_venue.getText();
            String description=tf_description.getText();
            String status=tf_status.getText();
            if(!Validate.dateIsValid(startDate)){
                 JOptionPane.showMessageDialog(this, "Inavlid Start date format", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                if(!Validate.dateIsValid(endDate)){
                 JOptionPane.showMessageDialog(this, "Inavlid End date format", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    od.setCampaignID(campignID);
                    od.setCampaignName(campaign_name);
                    od.setSector(sector);
                    od.setStartDate(startDate);
                    od.setEndDate(endDate);
                    od.setVenue(venue);
                    od.setDescription(description);
                    od.setStatus(status);
                   
                    try{
                        Connection con=GetConnection.getConnection();
                        String query="update campaign set campaign_name=?,start_date=?,end_date=?,venue=?,sector=?,description=?,status=? where campaign_id=?";
                        PreparedStatement pstmt=con.prepareStatement(query);
                        pstmt.setString(8, od.getCampaignID());
                        pstmt.setString(1,od.getCampaignName());
                        pstmt.setString(2,od.getStartDate());
                        pstmt.setString(3,od.getEndDate());
                        pstmt.setString(4,od.getVenue());
                        pstmt.setString(5,od.getSector());
                        pstmt.setString(6,od.getDescription());
                        pstmt.setString(7,od.getStatus());
                       
                        pstmt.executeUpdate();
                        con.setAutoCommit(true);
                        con.close();
                        JOptionPane.showMessageDialog(this, "Updated Successfully!");
                        tf_campaign_id.setText(null);
                        tf_campaign_name.setText(null);
                        tf_startDate.setText(null);
                        tf_endDate.setText(null);
                        tf_venue.setText(null);
                        tf_sector.setText(null);
                        tf_description.setText(null);
                        tf_status.setText(null);
                        od.setCampaignID(null);
                        od.setCampaignName(null);
                        od.setStartDate(null);
                        od.setEndDate(null);
                        od.setVenue(null);
                        od.setSector(null);
                        od.setDescription(null);
                        od.setStatus(null);
                        tf_campaignID.setText(null);
                        tf_campaign_id.setEditable(true);
                        tf_campaignID.setEditable(true);
                        updateCampaignBtn.setEnabled(false);
                        deleteCampaignBtn.setEnabled(false);
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(this, ex.toString());
                    }
                }
            }
        }
        else if(obj==clearCampaignBtn){
            updateCampaignBtn.setEnabled(false);
            deleteCampaignBtn.setEnabled(false);
            tf_campaign_id.setText(null);
            tf_campaign_name.setText(null);
            tf_startDate.setText(null);
            tf_endDate.setText(null);
            tf_venue.setText(null);
            tf_sector.setText(null);
            tf_description.setText(null);
            tf_status.setText(null);
            od.setCampaignID(null);
            od.setCampaignName(null);
            od.setStartDate(null);
            od.setEndDate(null);
            od.setVenue(null);
            od.setSector(null);
            od.setDescription(null);
            od.setStatus(null);
            tf_campaignID.setText(null);
            tf_campaign_id.setEditable(true);
            tf_campaignID.setEditable(true);
        }
        else if(obj==deleteVolunteerBtn){
            String campaign_id1,mail_id;
            mail_id=tf_mail_id.getText();
            campaign_id1=tf_campaign_id1.getText();
            tf_volunteer_name.setEditable(true);
            tf_contact_no.setEditable(true);
            tf_sector1.setEditable(true);
            tf_profession.setEditable(true);
            try{
               
                Connection con=GetConnection.getConnection();
                String query="delete from volunteer where campaign_id=? and mail_id=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, campaign_id1);
                pstmt.setString(2, mail_id);
                pstmt.executeUpdate();
                con.setAutoCommit(true);
               
                JOptionPane.showMessageDialog(this, "Deleted Successfully!");
                con.close();
                tf_volunteer_name.setText(null);
                tf_campaign_id1.setText(null);
                tf_sector1.setText(null);
                tf_contact_no.setText(null);
                tf_mail_id.setText(null);
                tf_profession.setText(null);
                tf_campaign_id1.setEditable(true);
                tf_mail_id.setEditable(true);
                deleteCampaignBtn.setEnabled(false);
                tf_volunteer_name.setEditable(false);
                tf_contact_no.setEditable(false);
                tf_sector1.setEditable(false);
                tf_profession.setEditable(false);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
        else if(obj==showVolunteerBtn){
            tf_volunteer_name.setEditable(true);
            tf_contact_no.setEditable(true);
            tf_sector1.setEditable(true);
            tf_profession.setEditable(true);
            deleteVolunteerBtn.setEnabled(true);
            String mail_id=tf_mail_id.getText();
            String campaign_id1=tf_campaign_id1.getText();
            tf_campaign_id1.setEditable(false);
            tf_mail_id.setEditable(false);
            tf_campaign_id1.setText(campaign_id1);
            tf_mail_id.setText(mail_id);
           
            try{
                Connection con1=GetConnection.getConnection();
                String query1="select volunteer_name,sector,contact_number,profession from volunteer where campaign_id=? and mail_id=?";
                PreparedStatement pstmt1=con1.prepareStatement(query1);
                pstmt1.setString(1,campaign_id1);
                pstmt1.setString(2,mail_id);
               
                ResultSet rset=pstmt1.executeQuery();
                if(rset.next()){
                    tf_volunteer_name.setText(rset.getString("volunteer_name"));
                    tf_sector1.setText(rset.getString("sector"));
                    tf_contact_no.setText(rset.getString("contact_number"));
                    tf_profession.setText(rset.getString("profession"));
                }
                con1.close();
                tf_volunteer_name.setEditable(false);
                tf_contact_no.setEditable(false);
                tf_sector1.setEditable(false);
                tf_profession.setEditable(false);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e.toString());
            }
        }
        else if(obj==clearVolunteerBtn){
            tf_volunteer_name.setText(null);
            tf_campaign_id1.setText(null);
            tf_sector1.setText(null);
            tf_contact_no.setText(null);
            tf_mail_id.setText(null);
            tf_profession.setText(null);
            tf_campaign_id1.setEditable(true);
            tf_mail_id.setEditable(true);
            deleteVolunteerBtn.setEnabled(false);
            deleteCampaignBtn.setEnabled(false);
        } 
    }
}

