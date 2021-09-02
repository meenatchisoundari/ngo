package ngoactivityportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static ngoactivityportal.ViewUrgentNeeds.contact_number_display;
import static ngoactivityportal.ViewUrgentNeeds.description_text;
import static ngoactivityportal.ViewUrgentNeeds.display_product_label;
import static ngoactivityportal.ViewUrgentNeeds.display_user_name_label;
import static ngoactivityportal.ViewUrgentNeeds.location_text;
import static ngoactivityportal.ViewUrgentNeeds.mail_display;
import static ngoactivityportal.ViewUrgentNeeds.needs_content;


public  class Home extends JFrame implements ActionListener{
    
    static JScrollPane donate_sp,donor_details,filter_panel,filter_health = new JScrollPane(),report_panel;
    static JPanel donation,home_center,payment,edit_panel,needs,campaign_panel,aid_panel,about_panel,des_panel,partners_panel,founders_panel,profile_panel,sponser_panel;
    static JTable table_filter,table_filter_health;
    static DonorData fin = new DonorData();
    static JPanel p1=new JPanel();
    static JPanel p2=new JPanel();
    JScrollPane scroll_1=new JScrollPane();
    static JScrollPane hom;
    JButton donate_btn,report,campaign,aid,about;
    static JButton logout_btn,myprofile_btn,b1,report_btn,home;   
    static String username;
    static String ed_user_name;
    static Profile pro ;
    static String phone_no;
    static EditPage edit;
    
    public Home(){
           
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,700);
        setTitle("WE FOR YOU");
        
        setLayout(null);
        
        Image t_icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\LOG.png");  
        setIconImage(t_icon);  
        
        add(p1);
        add(p2);

        home_center = new JPanel();
        home_center.setBackground(Color.WHITE);
        add(home_center);
        home_center.setBounds(0,50,1400,550);
        home_center.setLayout(null);
        
        Homepage homee = new Homepage();
        hom = homee.scroll;
        hom.setBounds(0,0,1360,550);
        hom.setVisible(true);
        home_center.add(hom);

        NgoReport objt  = new NgoReport();
        report_panel =objt.sp;
        report_panel.setBounds(2,2,1365,540);
        report_panel.setVisible(false);
        report_panel.setBackground(Color.yellow);
        home_center.add(report_panel);
             
        CampaignDetails objx = new CampaignDetails();
        campaign_panel = objx.campaign_user;
        campaign_panel.setBounds(10,10,1350,535);
        campaign_panel.setVisible(false);
        home_center.add(campaign_panel);

        Aidform object_aid=new Aidform();
        aid_panel=object_aid.home;
        aid_panel.setBounds(0,0,1400,550);
        aid_panel.setVisible(false);         
        home_center.add(aid_panel);
             
        About abo = new About();
        about_panel = abo.panel;
        about_panel.setBounds(50,0,1350,550);
        about_panel.setVisible(false);
        home_center.add(about_panel);

        Description des = new Description();
        des_panel = des.panel;
        des_panel.setBounds(20,0,1320,550);
        des_panel.setVisible(false);
        home_center.add(des_panel);

        Partners par = new Partners();
        partners_panel = par.panel;
        partners_panel.setBounds(0,0,1400,550);
        partners_panel.setVisible(false);
        home_center.add(partners_panel);

        Founder found = new Founder();
        founders_panel = found.panel;
        founders_panel.setBounds(0,0,1400,550);
        founders_panel.setVisible(false);
        home_center.add(founders_panel);
             
        profile_panel = founders_panel;
        profile_panel.setVisible(false);
        
        edit_panel = founders_panel;
        edit_panel.setVisible(false);

        Donation obj  = new Donation();
        donate_sp = obj.donation_sp;
        donate_sp.setBounds(10,10,1350,525);
        donate_sp.setVisible(false);
        home_center.add(donate_sp);            
           
        GetDonorDetails object = new GetDonorDetails();
        donor_details = object.get_donor_details_sp;
        donor_details.setBounds(10,10,1350,525);
        donor_details.setVisible(false);
        home_center.add(donor_details);

        PaymentInitiation pay = new PaymentInitiation();
        payment = pay.start_transaction;
        payment.setVisible(false);
        home_center.add(payment);

        ViewUrgentNeeds viewneeds = new ViewUrgentNeeds();
        needs = viewneeds.urgent_needs;
        needs.setBackground(Color.WHITE);
        needs.setBounds(10,10,1350,525);
        needs.setVisible(false);
        home_center.add(needs);

        DisplaySponsorDetails dis = new DisplaySponsorDetails();
        sponser_panel = dis.sponsor_panel;
        sponser_panel.setBounds(10,10,1350,525);
        sponser_panel.setVisible(false);
        home_center.add(sponser_panel);

        filter_panel = viewneeds.filter_pane;
        filter_panel.setBounds(100,20,500,600);
        filter_panel.setBackground(Color.WHITE);
        filter_panel.setVisible(false);
        home_center.add(filter_panel);

        filter_health = new JScrollPane();
        filter_health.setBounds(100,20,500,450);
        filter_health.setBackground(Color.WHITE);
        filter_health.setVisible(false);
        home_center.add(filter_health);

        p1.setLayout(null);
            
        JLabel logo=new JLabel();
        p1.add(logo);
        logo.setBounds(0,0,100,50);
        ImageIcon icon_logo= new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/log.PNG");
        Image img_logo=icon_logo.getImage();
        Image newImg_logo=img_logo.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_logo=new ImageIcon(newImg_logo);
        logo.setIcon(newImc_logo);
        
        home=new JButton("HOME");
      	p1.add(home);
        home.setBounds(100,0,150,50);
        home.setFont(new Font("Verdana" , Font.BOLD , 15));
        home.setForeground(Color.WHITE);
        home.setBackground(new Color(23, 43, 79));
        home.addActionListener(this);
        home.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        about=new JButton("ABOUT US");
      	p1.add(about);
        about.setBounds(250,0,150,50);
        about.setFont(new Font("Verdana" , Font.BOLD , 15));
        about.setForeground(Color.WHITE);
        about.setBackground(new Color(23, 43, 79));
        about.addActionListener(this);
        about.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        donate_btn=new JButton("DONATION");
        p1.add(donate_btn);
        donate_btn.setBounds(400,0,150,50);
        donate_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        donate_btn.setForeground(Color.WHITE);
        donate_btn.setBackground(new Color(23, 43, 79));
        donate_btn.addActionListener(this);
        donate_btn.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        campaign=new JButton("CAMPAIGN");
        p1.add(campaign);
        campaign.setBounds(550,0,150,50);
        campaign.setFont(new Font("Verdana" , Font.BOLD , 15));
        campaign.setForeground(Color.WHITE);
        campaign.setBackground(new Color(23, 43, 79));
        campaign.addActionListener(this);
        campaign.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        aid=new JButton("AID");
        p1.add(aid);
        aid.setBounds(700,0,150,50);
        aid.setFont(new Font("Verdana" , Font.BOLD , 15));
        aid.setForeground(Color.WHITE);
        aid.setBackground(new Color(23, 43, 79));
        aid.addActionListener(this);
        aid.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        report_btn = new JButton("REPORT");
        p1.add(report_btn);
        report_btn.setBounds(850,0,150,50);
        report_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        report_btn.setForeground(Color.WHITE);
        report_btn.setBackground(new Color(23, 43, 79));
        report_btn.addActionListener(this);
        report_btn.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        logout_btn = new JButton("LOGOUT");
        p1.add(logout_btn);
        logout_btn.setBounds(1000,0,150,50);
        logout_btn.setFont(new Font("Verdana" , Font.BOLD , 15));
        logout_btn.setForeground(Color.WHITE);
        logout_btn.setBackground(new Color(23, 43, 79));
        logout_btn.addActionListener(this);
        logout_btn.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        logout_btn.setVisible(false);
        
        myprofile_btn = new JButton("MY PROFILE");
        p1.add(myprofile_btn);
        myprofile_btn.setBounds(1180,0,200,50);
        myprofile_btn.setFont(new Font("Verdana" , Font.BOLD , 14));
        myprofile_btn.setForeground(Color.WHITE);
        myprofile_btn.setBackground(new Color(23,43,79));
        myprofile_btn.addActionListener(this);
        myprofile_btn.setBorder(BorderFactory.createLineBorder(new Color(48, 107, 120)));
        myprofile_btn.setVisible(false);
        
        
        b1=new JButton("LOGIN/REGISTER");
        p1.add(b1);
        b1.setBounds(1180,0,200,50);
        b1.setFont(new Font("Verdana" , Font.BOLD , 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(23, 43, 79));
        b1.addActionListener(this);
        b1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23, 43, 79)));
        
        p2.setLayout(null);
        
        JLabel name=new JLabel("Enter your Mail:");
        p2.add(name);
        name.setBounds(50,30,200,20);
        name.setFont(new Font("Verdana", Font.BOLD, 15));
        name.setForeground(Color.WHITE);
        
        JTextField t1=new JTextField();
        p2.add(t1);
        t1.setBounds(50,60,500,25);
        t1.setBackground(new Color(23, 43, 79));
        t1.setForeground(Color.white);
        t1.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        JSeparator s1=new JSeparator();
        p2.add(s1);
        s1.setBounds(50,85,500,1);
        s1.setBackground(Color.white);
        
        JButton b2=new JButton("SUBSCRIBE");
        p2.add(b2);
        b2.setBounds(400,20,200,50);
        b2.setFont(new Font("Verdana" , Font.BOLD , 14));
        b2.setForeground(Color.PINK);
        b2.setBackground(new Color(23, 43, 79));
        b2.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));
        
        JLabel event=new JLabel();
        p2.add(event);
        event.setBounds(0,0,40,40);
        ImageIcon iconevent= new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\event.PNG");
        Image imgevent=iconevent.getImage();
        Image newImgevent=imgevent.getScaledInstance(event.getWidth(), event.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImcevent=new ImageIcon(newImgevent);
        event.setIcon(newImcevent);
        
        JPanel feedback=new JPanel();
        p2.add(feedback);
        feedback.setBounds(10,20,590,120);
        feedback.setBackground(new Color(23, 43, 79));
        
        JButton pic0=new JButton();
        p2.add(pic0);
        pic0.setBounds(640,10,45,35);
        ImageIcon icon = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\face.png");
	Image img=icon.getImage();
	Image newImg=img.getScaledInstance(pic0.getWidth(), pic0.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc=new ImageIcon(newImg);
	pic0.setIcon(newImc);
        pic0.setBackground(Color.WHITE);
        pic0.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
        pic0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
	JButton pic1=new JButton();
        p2.add(pic1);
        pic1.setBounds(715,10,42,35);
        ImageIcon icon1 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\instagram.png");
	Image img1=icon1.getImage();
	Image newImg1=img1.getScaledInstance(pic1.getWidth(), pic1.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc1=new ImageIcon(newImg1);
	pic1.setIcon(newImc1);
        pic1.setBackground(Color.WHITE);
        pic1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        pic1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
    
    
	JButton pic2=new JButton();
        p2.add(pic2);
        pic2.setBounds(780,10,45,35);
        ImageIcon icon2 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\you.png");
	Image img2=icon2.getImage();
	Image newImg2=img2.getScaledInstance(pic2.getWidth(), pic2.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc2=new ImageIcon(newImg2);
	pic2.setIcon(newImc2);
        pic2.setBackground(Color.WHITE);
        pic2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
        pic2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
        
	JButton pic3=new JButton();
        p2.add(pic3);
        pic3.setBounds(785,60,40,35);
        ImageIcon icon3 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\link.png");
	Image img3=icon3.getImage();
	Image newImg3=img3.getScaledInstance(pic3.getWidth(), pic3.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc3=new ImageIcon(newImg3);
	pic3.setIcon(newImc3);
        pic3.setBackground(Color.WHITE);
        pic3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
        pic3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
    
	JButton pic4=new JButton();
        p2.add(pic4);
        pic4.setBounds(640 ,60,50,35);
        ImageIcon icon4 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\tw.png");
	Image img4=icon4.getImage();
	Image newImg4=img4.getScaledInstance(pic4.getWidth(), pic4.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc4=new ImageIcon(newImg4);
	pic4.setIcon(newImc4);
        pic4.setBackground(Color.WHITE);
        pic4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    
        pic4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
        
	JButton pic5=new JButton();
        p2.add(pic5);
        pic5.setBounds(715,60,40,35);
        ImageIcon icon5 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\gm.png");
	Image img5=icon5.getImage();
	Image newImg5=img5.getScaledInstance(pic5.getWidth(), pic5.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc5=new ImageIcon(newImg5);
	pic5.setIcon(newImc5);
        pic5.setBackground(Color.WHITE);
        pic5.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        pic5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    Desktop.getDesktop().browse(new URL("https://www.facebook.com/campaign/landing.php?campaign_id=1653993517&extra_1=s%7Cc%7C318504236063%7Ce%7Cfacebook%27%7C&placement=&creative=318504236063&keyword=facebook%27&partner_id=googlesem&extra_2=campaignid%3D1653993517%26adgroupid%3D63066387003%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-362360550869%26loc_physical_ms%3D1007809%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=CjwKCAjw95yJBhAgEiwAmRrutNUCbEaHz90_777skMo2X6rOyCV9di9AaFMhLVbQfnjBRzObK4U03BoCMhEQAvD_BwE").toURI());
                }
                catch(Exception ee){
                    
                }
            }
        });
         
        JLabel l2=new JLabel("Email-ID  :weforyou@gmail.com");
        p2.add(l2);
        l2.setBounds(900,40,1000,50);
        l2.setFont(new Font("Verdana", Font.BOLD, 15));
        l2.setForeground(Color.WHITE);
        
        JLabel l1=new JLabel("Contact-Number:9698704403");
        p2.add(l1);
        l1.setBounds(900,-10,1000,100);
        l1.setFont(new Font("Verdana", Font.BOLD, 15));
        l1.setForeground(Color.WHITE);
    
        JButton feed=new JButton();
        p2.add(feed);
        feed.setBounds(1200,0,200,100);
        ImageIcon icon_feed = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\feel.jfif");
        Image img_feed=icon_feed.getImage();
	Image newImg_feed=img_feed.getScaledInstance(feed.getWidth(), feed.getHeight(), Image.SCALE_SMOOTH);
	ImageIcon newImc_feed=new ImageIcon(newImg_feed);
	feed.setIcon(newImc_feed);
	feed.setBorder(BorderFactory.createLineBorder(Color.white));
    
	JPanel feedbak=new JPanel();
        p2.add(feedbak);
        feedbak.setBounds(880,10,310,130);
        feedbak.setBackground(new Color(23, 43, 79));
        
        p1.setBackground(new Color(23, 43, 79));
        p2.setBackground(Color.white);
        
        p1.setBounds(0,0,1400,50);
        p2.setBounds(0,600,1400,100);

        feed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new Feedback();
                
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Aid_form_validation val=new Aid_form_validation();
                String mail_id=t1.getText();
                boolean valid_mail=val.setMail(mail_id);
                if(valid_mail==true){ 
                    String user_mail=mail_id;
                    try{
                                                     
                        Connection con=GetConnection.getConnection();
                        Statement stm=con.createStatement();
                        String query="insert into newsletter values('"+user_mail+"')";
                        stm.executeQuery(query);
                        con.setAutoCommit(true);
                        String ans = " Registered successfully!" +"\n" + "Event updates will be sent to your mail" +"\n" + "THANK YOU !"  ;
                        JOptionPane.showMessageDialog(null, ans);
                    }
                    catch(Exception xe){
                        JOptionPane.showMessageDialog(null, "User Already Exsist!");
                    }

                    final String username = "meenuthulasi2000@gmail.com";
                    final String password = "mee...msd16";

                    final String from = "meenuthulasi2000@gmail.com";
                    final String to = user_mail;

                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");

                    Session session = Session.getInstance(props,new Authenticator() {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }

                    });
                    try{

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(from));
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
                        message.setSubject("THANK YOU FOR SUBSCRIBING");
                        message.setText("THANK YOU for subscribing to WE FOR YOU NGO ! We are excited to welcome you"+"\n"+"You will get mails regarding our latest campaigns and events"+"\n"+"\n"+"\n"+"\n"+"-WFU NGO FOUNDATION");

                        Transport.send(message);

                    } catch (MessagingException ee) {
                    }
                } 
            }
        });
      
        setVisible(true);
           
        }
        public Home(String str){
            
            setVisible(false);
            new AdminHome();
        }
        static void callEditpage(String edit_username){
            
            ed_user_name = edit_username;
            donate_sp.setVisible(false);
            report_panel.setVisible(false);
            campaign_panel.setVisible(false);
            donor_details.setVisible(false);
            payment.setVisible(false);
            needs.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            sponser_panel.setVisible(false);
            aid_panel.setVisible(false);

            pro = new Profile(username);
            profile_panel = pro.profile;
            profile_panel.setBounds(0,0,1400,550);
            profile_panel.setVisible(false);
            home_center.add(profile_panel);

            edit = new EditPage(ed_user_name);
            edit_panel = edit.editPage;
            edit_panel.setBounds(0,0,1400,550);
            edit_panel.setVisible(true);
            home_center.add(edit_panel);
        }
        public static void main(String args[]) {
            new Home();    
        }   
        
        static void callHomeAfterLogin(String user_name){
            username = user_name;
            b1.setVisible(false);
            myprofile_btn.setVisible(true);
            edit_panel.setVisible(false);
            logout_btn.setVisible(true);
            
        }
        static void callAboutus(){
            
            hom.setVisible(false);
            des_panel.setVisible(false);
            aid_panel.setVisible(false);
            donate_sp.setVisible(false);
            partners_panel.setVisible(false);
            edit_panel.setVisible(false);
            campaign_panel.setVisible(false);
            payment.setVisible(false);
            needs.setVisible(false);
            report_panel.setVisible(false);
            edit_panel.setVisible(false);
            profile_panel.setVisible(false);
            founders_panel.setVisible(false);
            sponser_panel.setVisible(false);
            about_panel.setVisible(true);
        }
        static void callPartners(){
            
            des_panel.setVisible(false);
            about_panel.setVisible(false);
            aid_panel.setVisible(false);
            donate_sp.setVisible(false);
            campaign_panel.setVisible(false);
            donor_details.setVisible(false);
            payment.setVisible(false);
            needs.setVisible(false);
            report_panel.setVisible(false);
            profile_panel.setVisible(false);
            edit_panel.setVisible(false);
            founders_panel.setVisible(false);
            sponser_panel.setVisible(false);
            partners_panel.setVisible(true);
        }
 
        static void callDescription(){
            
            about_panel.setVisible(false);
            aid_panel.setVisible(false);
            campaign_panel.setVisible(false);
            donor_details.setVisible(false);
            payment.setVisible(false);
            partners_panel.setVisible(false);
            report_panel.setVisible(false);
            profile_panel.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            founders_panel.setVisible(false);
            des_panel.setVisible(true);
            
        }
        
        static void callFounders(){
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            sponser_panel.setVisible(false);
            edit_panel.setVisible(false);
            des_panel.setVisible(false);
            founders_panel.setVisible(true);
        }
        
        static void paymentSuccess(DonorData bean2) {
            
            fin.setPaidvia(bean2.getPaidvia());
            fin.setTransactionId(bean2.getTransactionId());

            new SendMail(fin.getEmailId());
           
            try{
                GetConnection getCon = new GetConnection();
                Connection conn = getCon.getConnection();
                Statement stmt = conn.createStatement();

                DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
    	        String dateString = dateFormat.format(new Date()).toString();
    	
    	
                DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                String dateString2 = dateFormat2.format(new Date()).toString();
                String sub = dateString2.substring(3,5);

                int n=Integer.parseInt(sub);
                String mon[]={"JAN", "FEB", "MAR","APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

                String date_fin =dateString2.substring(0,3)+mon[n-1]+dateString2.substring(5,10)+" "+ dateString;
                String query="insert into donation values('"+fin.getTransactionId()+"','"+fin.getEmailId()+"','"+fin.getAmount()+"','"+fin.getPaidvia()+"','"+date_fin+"','"+fin.getSector()+"')";
                
                
                stmt.executeUpdate(query);
                conn.setAutoCommit(true);
                String month = fin.getDob().substring(3,5);
                int m = Integer.parseInt(month);
                
                String dob = fin.getDob().substring(0,3)+mon[m]+fin.getDob().substring(5,10);
                
                Statement stmt1 = conn.createStatement();
                String query2 = "insert into donor_details values('"+fin.getName()+"','"+fin.getEmailId()+"','"+fin.getGender()+"','"+dob+"','"+fin.getAddressLine1()+" "+fin.getAddressLine2()+"','"+fin.getCity()+"','"+fin.getState()+"',"+fin.getPincode()+","+fin.getPhoneNumber()+",'"+fin.getSector()+"')";
                
                stmt1.executeQuery(query2);
                conn.setAutoCommit(true);
                    
            }
            catch(Exception xe){
            }     
            callHome();
            
        }
        
        static void callReports(){
            
            hom.setVisible(false);
            campaign_panel.setVisible(false);
            aid_panel.setVisible(false);
            about_panel.setVisible(false);
            donate_sp.setVisible(false);
            needs.setVisible(false);
            donor_details.setVisible(false);
            profile_panel.setVisible(false);
            edit_panel.setVisible(false);
            about_panel.setVisible(false);
            sponser_panel.setVisible(false);
            partners_panel.setVisible(false);
            edit_panel.setVisible(false);
            des_panel.setVisible(false);
            founders_panel.setVisible(false);
            report_panel.setVisible(true);
        }
        
         static void callGetDonorDetails(DonorData bean){
             
            String sector = bean.getSector();
            fin.setSector(sector);            
            
            needs.setVisible(false);
            filter_health.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            filter_panel.setVisible(false);
            donate_sp.setVisible(false);
            donor_details.setVisible(true);
            
        }
        
        static void callPaymentInitiation(DonorData bean1,String phoneno){
             
            phone_no = phoneno;
            fin.setEmailId(bean1.getEmailId());
            fin.setName(bean1.getName());
            fin.setAddressLine1(bean1.getAddressLine1());
            fin.setAddressLine2(bean1.getAddressLine2());
            fin.setCity(bean1.getCity());
            fin.setState(bean1.getState());
            fin.setPincode(bean1.getPincode());
            fin.setPhoneNumber(bean1.getPhoneNumber());
            fin.setDob(bean1.getDob());
            fin.setGender(bean1.getGender());
            fin.setAmount(bean1.getAmount());
          
            needs.setVisible(false);
            filter_health.setVisible(false);
            filter_panel.setVisible(false);
            donate_sp.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            donor_details.setVisible(false);
            payment.setVisible(true);
        }
         
        static void callHome(){
            
            needs.setVisible(false);
            filter_health.setVisible(false);
            sponser_panel.setVisible(false);
            filter_panel.setVisible(false);
            edit_panel.setVisible(false);
            donate_sp.setVisible(false);
            aid_panel.setVisible(false);
            report_panel.setVisible(false);
            donor_details.setVisible(false);
            needs.setVisible(false);
            payment.setVisible(false);
            hom.setVisible(true);
            
        }
        static void callViewUrgentNeeds(){
            
            donate_sp.setVisible(false);
            donor_details.setVisible(false);
            edit_panel.setVisible(false);
            payment.setVisible(false);
            filter_panel.setVisible(false);
            sponser_panel.setVisible(false);
            needs.setVisible(true); 
            callAll();
            
        }
        
        static void callDisplaySponsorDetails(){
            
            partners_panel.setVisible(false);
            edit_panel.setVisible(false);
            founders_panel.setVisible(false);
            report_panel.setVisible(false);
            sponser_panel.setVisible(true);
        }
        static void callAll(){
            
            donate_sp.setVisible(false);
            donor_details.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            payment.setVisible(false);
                  
            needs.setLayout(null);
            
            filter_panel.setVisible(false);
                    
            try{
                GetConnection getConn = new GetConnection();
                Connection conn = getConn.getConnection();
                Statement statement = conn.createStatement();

                String sql_query = "select * from aid";
                ResultSet res = statement.executeQuery(sql_query);
                int rows = 0;
                while(res.next()){
                    rows++;
                }
                String[][] data_filter = new String[0][4];
                res = statement.executeQuery(sql_query);


                data_filter = new String[rows][4];
                int rows_count = 0;

                while(res.next()){
                    int i=0;
                    data_filter[rows_count][i++] = res.getString("AID_ID");
                    data_filter[rows_count][i++] = res.getString("ITEM");
                    data_filter[rows_count][i++] = res.getString("DISTRICT");
                    data_filter[rows_count][i++] = res.getString("NAME");
                    rows_count++;

                }

                conn.close();

                String column[] = {"ID","Product Needed","District","User Name"};
                table_filter = new JTable(data_filter,column);
                JTableHeader head = table_filter.getTableHeader();
               
                table_filter.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        needs_content.setVisible(false);

                        ViewUrgentNeeds.displayDetails("id");
                        int index = table_filter.getSelectedRow();
                        TableModel model_t = table_filter.getModel();
                        String clicked_id = (String) model_t.getValueAt(index,0);

                        try{

                            GetConnection getCon = new GetConnection();
                            Connection con = getCon.getConnection();

                            Statement statement_all = con.createStatement();

                            String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                           
                            ResultSet res = statement_all.executeQuery(sql_q);

                            while(res.next()){

                                display_user_name_label.setText(res.getString("NAME"));
                                display_product_label.setText(res.getString("ITEM"));
                                description_text.setText(res.getString("DESCRIPTION"));
                                location_text.setText(res.getString("ADDRESS"));
                                mail_display.setText(res.getString("MAIL_ID"));
                                contact_number_display.setText(res.getString("MOBILE_NO"));

                                con.close();
                            }
                        }
                        catch(Exception vr){
                            
                        }     
                    }
                });
                         
                filter_panel = new JScrollPane(table_filter);
                filter_panel.setBackground(Color.pink);
                filter_panel.setBounds(30,40,640,470);
                table_filter.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                needs.add(filter_panel);
                needs.setVisible(true);
            }
            catch(Exception de){
                
            }
            filter_panel.setBounds(30,40,640,470);
        }
        
        static void callOtherPurpose(){
            
            needs.setLayout(null);
            
            filter_panel.setVisible(false);
            try{
                
                GetConnection getConn = new GetConnection();
                Connection conn = getConn.getConnection();

                Statement statement = conn.createStatement();

                String sql_query = "select * from aid where sector='OTHERS'";
                ResultSet res = statement.executeQuery(sql_query);
                int rows = 0;
                while(res.next()){
                    rows++;
                }
                String[][] data_filter = new String[0][4];
                res = statement.executeQuery(sql_query);

                data_filter = new String[rows][4];
                int rows_count = 0;

                while(res.next()){
                    int i=0;
                    data_filter[rows_count][i++] = res.getString("AID_ID");
                    data_filter[rows_count][i++] = res.getString("ITEM");
                    data_filter[rows_count][i++] = res.getString("DISTRICT");
                    data_filter[rows_count][i++] = res.getString("NAME");
                    rows_count++;

                }

                conn.close();
                    
                String column[] = {"ID","Product Needed","District","User Name"};
                table_filter = new JTable(data_filter,column);
                JTableHeader head = table_filter.getTableHeader();
                table_filter.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                            
                    needs_content.setVisible(false);
                    ViewUrgentNeeds.displayDetails("id");
                    int index = table_filter.getSelectedRow();
                    TableModel model_t = table_filter.getModel();
                    String clicked_id = (String) model_t.getValueAt(index,0);

                    try{

                        GetConnection getCon = new GetConnection();
                        Connection con = getCon.getConnection();

                        Statement statement_all = con.createStatement();

                        String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                        ResultSet res = statement_all.executeQuery(sql_q);
                        
                        while(res.next()){

                            display_user_name_label.setText(res.getString("NAME"));
                            display_product_label.setText(res.getString("ITEM"));
                            description_text.setText(res.getString("DESCRIPTION"));
                            location_text.setText(res.getString("ADDRESS"));
                            mail_display.setText(res.getString("MAIL_ID"));
                            contact_number_display.setText(res.getString("MOBILE_NO"));
                            con.close();
                        }
                    }
                    catch(Exception vr){
                        
                    }                         
                }
                });
                

                filter_panel = new JScrollPane(table_filter);
                filter_panel.setBackground(Color.pink);
                filter_panel.setBounds(30,40,640,470);
                table_filter.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                needs.add(filter_panel);
                needs.setVisible(true);
            }
            catch(Exception de){
                
            }
            filter_panel.setBounds(30,40,640,470);
        }
        
        
        static void callFilterHealth(){
            
            needs.setLayout(null);
            filter_panel.setVisible(false);
            try{
                GetConnection getConn = new GetConnection();
                Connection conn = getConn.getConnection();
                Statement statement = conn.createStatement();

                String sql_query = "select * from aid where sector='HEALTH'";
                ResultSet res = statement.executeQuery(sql_query);
                int rows = 0;
                while(res.next()){
                    rows++;
                }
                String[][] data_filter = new String[0][4];
                res = statement.executeQuery(sql_query);

                data_filter = new String[rows][4];
                int rows_count = 0;

                while(res.next()){
                    int i=0;
                    data_filter[rows_count][i++] = res.getString("AID_ID");
                    data_filter[rows_count][i++] = res.getString("ITEM");
                    data_filter[rows_count][i++] = res.getString("DISTRICT");
                    data_filter[rows_count][i++] = res.getString("NAME");
                    rows_count++;

                }

                conn.close();

                String column[] = {"ID","Product Needed","District","User Name"};
                table_filter = new JTable(data_filter,column);
                JTableHeader head = table_filter.getTableHeader();
                table_filter.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        needs_content.setVisible(false);
                        ViewUrgentNeeds.displayDetails("id");
                        int index = table_filter.getSelectedRow();
                        TableModel model_t = table_filter.getModel();
                        String clicked_id = (String) model_t.getValueAt(index,0);
                        try{

                            GetConnection getCon = new GetConnection();
                            Connection con = getCon.getConnection();
                            Statement statement_all = con.createStatement();
                            String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                            ResultSet res = statement_all.executeQuery(sql_q);
                            
                            while(res.next()){
                                display_user_name_label.setText(res.getString("NAME"));
                                display_product_label.setText(res.getString("ITEM"));
                                description_text.setText(res.getString("DESCRIPTION"));
                                location_text.setText(res.getString("ADDRESS"));
                                mail_display.setText(res.getString("MAIL_ID"));
                                contact_number_display.setText(res.getString("MOBILE_NO"));
                                con.close();
                            }
                        }
                        catch(Exception vr){
                            
                        } 
                    }
                });
                
                filter_panel = new JScrollPane(table_filter);
                filter_panel.setBackground(Color.pink);
                filter_panel.setBounds(30,40,640,470);
                table_filter.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                needs.add(filter_panel);
                needs.setVisible(true);
            }
            catch(Exception de){
                
            }
            filter_panel.setBounds(30,40,640,470);
        }
        
        static void callFilterEducation(){
            
            needs.setLayout(null);
            filter_panel.setVisible(false);
              
            try{
                GetConnection getConn = new GetConnection();
                Connection conn = getConn.getConnection();
                Statement statement = conn.createStatement();

                String sql_query = "select * from aid where sector='EDUCATION'";
                ResultSet res = statement.executeQuery(sql_query);
                
                int rows = 0;
                while(res.next()){
                    rows++;
                }
                String[][] data_filter = new String[0][4];
                res = statement.executeQuery(sql_query);


                data_filter = new String[rows][4];
                int rows_count = 0;

                while(res.next()){
                    int i=0;
                    data_filter[rows_count][i++] = res.getString("AID_ID");
                    data_filter[rows_count][i++] = res.getString("ITEM");
                    data_filter[rows_count][i++] = res.getString("DISTRICT");
                    data_filter[rows_count][i++] = res.getString("NAME");
                    rows_count++;

                }

                conn.close();

                String column[] = {"ID","Product Needed","District","User Name"};
                table_filter = new JTable(data_filter,column);
                JTableHeader head = table_filter.getTableHeader();
                table_filter.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        needs_content.setVisible(false);

                        ViewUrgentNeeds.displayDetails("id");
                        int index = table_filter.getSelectedRow();
                        TableModel model_t = table_filter.getModel();
                        String clicked_id = (String) model_t.getValueAt(index,0);

                        try{

                            GetConnection getCon = new GetConnection();
                            Connection con = getCon.getConnection();

                            Statement statement_all = con.createStatement();
                            String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                            ResultSet res = statement_all.executeQuery(sql_q);
                            while(res.next()){
                                display_user_name_label.setText(res.getString("NAME"));
                                display_product_label.setText(res.getString("ITEM"));
                                description_text.setText(res.getString("DESCRIPTION"));
                                location_text.setText(res.getString("ADDRESS"));
                                mail_display.setText(res.getString("MAIL_ID"));
                                contact_number_display.setText(res.getString("MOBILE_NO"));
                                con.close();
                            }
                        }
                        catch(Exception vr){
                            
                        }
                    }
                });
                             
                    filter_panel = new JScrollPane(table_filter);
                    filter_panel.setBackground(Color.pink);
                    filter_panel.setBounds(30,40,640,470);
                    table_filter.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    needs.add(filter_panel);
                    needs.setVisible(true);
                }
                catch(Exception de){
                }
                filter_panel.setBounds(30,40,640,470);
        }
        
        
        static void callFilterFood(){
            
            
            needs.setLayout(null);
            filter_panel.setVisible(false);
                    
            try{
                GetConnection getConn = new GetConnection();
                Connection conn = getConn.getConnection();

                Statement statement = conn.createStatement();

                String sql_query = "select * from aid where sector='FOOD'";
               
                ResultSet res = statement.executeQuery(sql_query);
                int rows = 0;
                while(res.next()){
                    rows++;
                }
                String[][] data_filter = new String[0][4];
                res = statement.executeQuery(sql_query);
                data_filter = new String[rows][4];
                int rows_count = 0;

                while(res.next()){
                    int i=0;
                    data_filter[rows_count][i++] = res.getString("AID_ID");
                    data_filter[rows_count][i++] = res.getString("ITEM");
                    data_filter[rows_count][i++] = res.getString("DISTRICT");
                    data_filter[rows_count][i++] = res.getString("NAME");
                    rows_count++;

                }

                conn.close();

                String column[] = {"ID","Product Needed","District","User Name"};
                table_filter = new JTable(data_filter,column);
                JTableHeader head = table_filter.getTableHeader();
                table_filter.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        needs_content.setVisible(false);
                        ViewUrgentNeeds.displayDetails("id");
                        int index = table_filter.getSelectedRow();
                        TableModel model_t = table_filter.getModel();
                        String clicked_id = (String) model_t.getValueAt(index,0);

                        try{

                            GetConnection getCon = new GetConnection();
                            Connection con = getCon.getConnection();

                            Statement statement_all = con.createStatement();

                            String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                            ResultSet res = statement_all.executeQuery(sql_q);
                  
                            while(res.next()){
                                display_user_name_label.setText(res.getString("NAME"));
                                display_product_label.setText(res.getString("ITEM"));
                                description_text.setText(res.getString("DESCRIPTION"));
                                location_text.setText(res.getString("ADDRESS"));
                                mail_display.setText(res.getString("MAIL_ID"));
                                contact_number_display.setText(res.getString("MOBILE_NO"));
                                con.close();
                            }
                        }
                        catch(Exception vr){
                           
                        }
                    }
                });
                filter_panel = new JScrollPane(table_filter);
                filter_panel.setBackground(Color.pink);
                filter_panel.setBounds(30,40,640,470);
                table_filter.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                needs.add(filter_panel);
                needs.setVisible(true);
            }
            catch(Exception de){
            }
            
            filter_panel.setBounds(30,40,640,470);
            
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object obj_source = e.getSource();
        
        if(obj_source==home){
            
            hom.setVisible(true);
            campaign_panel.setVisible(false);
            aid_panel.setVisible(false);
            about_panel.setVisible(false);
            report_panel.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            donate_sp.setVisible(false);
            donor_details.setVisible(false);
            needs.setVisible(false);
            payment.setVisible(false);
        }
        if(obj_source==donate_btn){
            hom.setVisible(false);
            campaign_panel.setVisible(false);
            aid_panel.setVisible(false);
            about_panel.setVisible(false);
            report_panel.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            donor_details.setVisible(false);
            payment.setVisible(false);
            needs.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            donate_sp.setVisible(true);
        }
        if(obj_source==report_btn){
            
            hom.setVisible(false);
            campaign_panel.setVisible(false);
            aid_panel.setVisible(false);
            about_panel.setVisible(false);
            donate_sp.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            edit_panel.setVisible(false);
            des_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            sponser_panel.setVisible(false);
            report_panel.setVisible(true);
            
        }
        if(obj_source==campaign){
           
            hom.setVisible(false);
            donate_sp.setVisible(false);
            aid_panel.setVisible(false);
            report_panel.setVisible(false);
            about_panel.setVisible(false);
            edit_panel.setVisible(false);
            sponser_panel.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            campaign_panel.setVisible(true);
        }
        if(obj_source==aid){
            
            hom.setVisible(false);
            donate_sp.setVisible(false);
            report_panel.setVisible(false);
            campaign_panel.setVisible(false);
            about_panel.setVisible(false);
            about_panel.setVisible(false);
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            sponser_panel.setVisible(false);
            edit_panel.setVisible(false);
            founders_panel.setVisible(false);
            profile_panel.setVisible(false);
            aid_panel.setVisible(true);
                
        }
        if(obj_source==about){
             
            hom.setVisible(false);
            donate_sp.setVisible(false);
            report_panel.setVisible(false);
            campaign_panel.setVisible(false);
            edit_panel.setVisible(false);
            aid_panel.setVisible(false);
            sponser_panel.setVisible(false);
            profile_panel.setVisible(false);
            about_panel.setVisible(true);
            
        }
        if(obj_source==b1){
            
            Login log = new Login();
            
        }
        if(obj_source==logout_btn){
            logout_btn.setVisible(false);
            campaign_panel.setVisible(false);
            report_panel.setVisible(false);
            donate_sp.setVisible(false);
            founders_panel.setVisible(false);
            des_panel.setVisible(false);
            partners_panel.setVisible(false);
            about_panel.setVisible(false);
            aid_panel.setVisible(false);
            donor_details.setVisible(false);
            needs.setVisible(false);
            payment.setVisible(false);
            sponser_panel.setVisible(false);
            myprofile_btn.setVisible(false);
            edit_panel.setVisible(false);
            hom.setVisible(true);
            b1.setVisible(true);
        }
        if(obj_source==myprofile_btn){
            
            edit_panel.setVisible(false);
            hom.setVisible(false);
            donate_sp.setVisible(false);
            report_panel.setVisible(false);
            campaign_panel.setVisible(false);
            about_panel.setVisible(false);
           
            partners_panel.setVisible(false);
            des_panel.setVisible(false);
            sponser_panel.setVisible(false);
            founders_panel.setVisible(false);
            hom.setVisible(false);
            aid_panel.setVisible(false);
                
            edit = new EditPage(ed_user_name);
            edit_panel = edit.editPage;
            edit_panel.setBounds(0,0,1400,550);
            edit_panel.setVisible(false);
            home_center.add(edit_panel);
            
            pro = new Profile(username);
            profile_panel = pro.profile;
            profile_panel.setBounds(0,0,1400,550);
            profile_panel.setVisible(true);
            home_center.add(profile_panel);
            
        }   
    }  
}
