package ngoactivityportal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Feedback extends JFrame implements ActionListener {
	
    JTextField t1,t2;
    JTextArea a1;
    JButton b1,back;

    Feedback()  {

        new JFrame("FeedBack");
        setTitle("WE FOR YOU - FEEDBACK");
        setLayout(null);
        setBounds(0,0,1370,1000);

        Container co=getContentPane();
        co.setBackground(new Color(23,43,79));
        
        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(5,5,100,25);
        back.setFont(new Font("serif",Font.BOLD,10));
        back.addActionListener(this);
        add(back);

        JLabel email=new JLabel("Email Us:");
        add(email);
        email.setBounds(200,200,1000,50);
        email.setFont(new Font("Verdana", Font.BOLD, 15));
        email.setForeground(Color.BLACK);

        JLabel our_email=new JLabel("weforyou@gmail.com");
        add(our_email);
        our_email.setBounds(150,250,1000,50);
        our_email.setFont(new Font("Verdana", Font.BOLD, 15));
        our_email.setForeground(Color.WHITE);

        JLabel contact=new JLabel("Contact Us:");
        add(contact);
        contact.setBounds(190,300,1000,50);
        contact.setFont(new Font("Verdana", Font.BOLD, 15));
        contact.setForeground(Color.BLACK);

        JLabel our_contact=new JLabel("9698704403");
        add(our_contact);
        our_contact.setBounds(180,350,1000,50);
        our_contact.setFont(new Font("Verdana", Font.BOLD, 15));
        our_contact.setForeground(Color.WHITE);

        JLabel add=new JLabel("Visit Us:");
        add(add);
        add.setBounds(200,400,1000,50);
        add.setFont(new Font("Verdana", Font.BOLD, 15));
        add.setForeground(Color.BLACK);

        JLabel our_add=new JLabel("NO:123 , Gandhiji Road , Guindy , Chennai");
        add(our_add);
        our_add.setBounds(90,450,1000,50);
        our_add.setFont(new Font("Verdana", Font.BOLD, 15));
        our_add.setForeground(Color.WHITE);

        JPanel info=new JPanel();
        add(info);
        info.setBounds(20,150,460,420);
        info.setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.5f));

        JLabel message=new JLabel("Please fill out the form below and we will address it ");
        add(message);
        message.setBounds(650,100,1000,50);
        message.setFont(new Font("Verdana", Font.BOLD, 20));
        message.setForeground(Color.BLACK);

        JLabel message_1=new JLabel("as soon as possible");
        add(message_1);
        message_1.setBounds(840,150,1000,50);
        message_1.setFont(new Font("Verdana", Font.BOLD, 20));
        message_1.setForeground(Color.BLACK);

        JLabel name=new JLabel("NAME :");
        add(name);
        name.setBounds(700,250,1000,50);
        name.setFont(new Font("Verdana", Font.PLAIN, 15));
        name.setForeground(Color.WHITE);

        t1=new JTextField();
        add(t1);
        t1.setBounds(700,300,500,25);
        t1.setBackground(Color.black);
        t1.setForeground(Color.white);
        t1.setBorder(BorderFactory.createLineBorder(Color.black));

        JSeparator s1=new JSeparator();
        add(s1);
        s1.setBounds(700,325,500,1);
        s1.setBackground(Color.white);

        JLabel mail=new JLabel("MAIL :");
        add(mail);
        mail.setBounds(700,330,1000,50);
        mail.setFont(new Font("Verdana", Font.PLAIN, 15));
        mail.setForeground(Color.WHITE);

        t2=new JTextField();
        add(t2);
        t2.setBounds(700,375,500,25);
        t2.setBackground(Color.black);
        t2.setForeground(Color.white);
        t2.setBorder(BorderFactory.createLineBorder(Color.black)); 

        JSeparator s2=new JSeparator();
        add(s2);
        s2.setBounds(700,400,500,1);
        s2.setBackground(Color.white);

        JLabel feed=new JLabel("FEEDBACK :");
        add(feed);
        feed.setBounds(700,410,1000,50);
        feed.setFont(new Font("Verdana", Font.PLAIN, 15));
        feed.setForeground(Color.WHITE);

        a1=new JTextArea();
        add(a1);
        a1.setBounds(700,450,500,100);
        a1.setBackground(Color.black);
        a1.setForeground(Color.white);
        a1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(1.0f,1.0f,1.0f,0.5f)));

        b1=new JButton("SUBMIT");
        add(b1);
        b1.setBounds(890,610,150,40);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Verdana", Font.BOLD, 20));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);

        JPanel feedback=new JPanel();
        add(feedback);
        feedback.setBounds(650,250,590,350);
        feedback.setBackground(Color.black);

        JPanel feedback_1=new JPanel();
        add(feedback_1);
        feedback_1.setBounds(595,50,700,600);
        feedback_1.setBackground(Color.white);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        Object obj=e.getSource();
        if(obj==back){
            setVisible(false);
          
        }
        if(obj==b1){
            
            String name=t1.getText().toString();
            String mail=t2.getText().toString();
            String feed=a1.getText().toString();

            final String username = "meenuthulasi2000@gmail.com";
            final String password = "mee...msd16";
            final String from = "meenuthulasi2000@gmail.com";
            
            final String to = "19tucs120@skct.edu.in";


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

            try {

                Message message = new MimeMessage(session);

                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
                message.setSubject("FEEDBACK");
                message.setText("NAME:"+name+"\n"+"FROM:"+mail+"\n"+"FEEDBACK:"+feed);

                Transport.send(message);
            } catch (MessagingException ee) {
                    System.out.println(ee);
            }
            JOptionPane.showMessageDialog(null,"THANKYOU so much for taking the time to send this!We are always trying our best to make your experience memorable");
            setVisible(false);
          

        }
       
    }

//    public static void main(String args[]) {	
//            new Feedback();
//    }
}
