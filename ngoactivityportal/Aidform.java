package ngoactivityportal;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import javax.swing.*;

public class Aidform extends JFrame{

    JPanel home=new JPanel();
    JPanel feeds;
    JTextField t1,t2,t3,t4,t5;
    JTextArea a1,a2;
    JComboBox c1;
    JButton b1;

    Aidform(){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);
//        add(home);

        home.setBounds(0,50,1400,550);
        home.setBackground(Color.WHITE);
        home.setLayout(null);

        JLabel email=new JLabel("Email Us:");
        home.add(email);
        email.setBounds(200,120,1000,50);
        email.setFont(new Font("Verdana", Font.BOLD, 15));
        email.setForeground(new Color(23, 43, 79));

        JLabel our_email=new JLabel("weforyou@gmail.com");
        home.add(our_email);
        our_email.setBounds(150,170,1000,50);
        our_email.setFont(new Font("Verdana", Font.BOLD, 15));
        our_email.setForeground(Color.white);

        JLabel contact=new JLabel("Contact Us:");
        home.add(contact);
        contact.setBounds(190,220,1000,50);
        contact.setFont(new Font("Verdana", Font.BOLD, 15));
        contact.setForeground(new Color(23, 43, 79));

        JLabel our_contact=new JLabel("9698704403");
        home.add(our_contact);
        our_contact.setBounds(180,270,1000,50);
        our_contact.setFont(new Font("Verdana", Font.BOLD, 15));
        our_contact.setForeground(Color.white);

        JLabel add=new JLabel("Visit Us:");
        home.add(add);
        add.setBounds(200,320,1000,50);
        add.setFont(new Font("Verdana", Font.BOLD, 15));
        add.setForeground(new Color(23, 43, 79));

        JLabel our_add=new JLabel("NO:123 , Gandhiji Road , Guindy , Chennai");
        home.add(our_add);
        our_add.setBounds(90,370,1000,50);
        our_add.setFont(new Font("Verdana", Font.BOLD, 15));
        our_add.setForeground(Color.white);

        JLabel message=new JLabel("FILL YOUR NEEDS ");
        home.add(message);
        message.setBounds(870,17,1000,50);
        message.setFont(new Font("Verdana", Font.BOLD, 15));
        message.setForeground(new Color(23, 43, 79));

        JLabel name=new JLabel("NAME :");
        home.add(name);
        name.setBounds(700,50,1000,20);
        name.setFont(new Font("Verdana", Font.PLAIN, 15));
        name.setForeground(new Color(23, 43, 79));

        t1=new JTextField();
        home.add(t1);
        t1.setBounds(700,70,500,25);
        t1.setBackground(Color.white);
        t1.setForeground(new Color(23, 43, 79));
        t1.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));

        JLabel mail=new JLabel("MAIL :");
        home.add(mail);
        mail.setBounds(700,100,500,20);
        mail.setFont(new Font("Verdana", Font.PLAIN, 15));
        mail.setForeground(new Color(23, 43, 79));

        t2=new JTextField();
        home.add(t2);
        t2.setBounds(700,120,500,25);
        t2.setBackground(Color.white);
        t2.setForeground(new Color(23, 43, 79));
        t2.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79))); 

        JLabel num=new JLabel("PHONE NUMBER :");
        home.add(num);
        num.setBounds(700,150,225,20);
        num.setFont(new Font("Verdana", Font.PLAIN, 15));
        num.setForeground(new Color(23, 43, 79));

        t3=new JTextField();
        home.add(t3);
        t3.setBounds(700,170,225,25);
        t3.setBackground(Color.white);
        t3.setForeground(new Color(23, 43, 79));
        t3.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));

        JLabel sector=new JLabel("CHOOSE YOUR SECTOR :");
        home.add(sector);
        sector.setBounds(950,150,500,20);
        sector.setFont(new Font("Verdana", Font.PLAIN, 15));
        sector.setForeground(new Color(23, 43, 79));

        c1=new JComboBox();  
        home.add(c1);
        c1.addItem("FOOD");
        c1.addItem("HEALTH");
        c1.addItem("EDUCATION");
        c1.addItem("OTHERS");
        c1.setBackground(Color.white);
        c1.setForeground(new Color(23, 43, 79));
        c1.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79))); 
        c1.setBounds(950,170,240,25);    

        JLabel item=new JLabel("ENTER THE ITEM :");
        home.add(item);
        item.setBounds(700,200,225,20);
        item.setFont(new Font("Verdana", Font.PLAIN, 15));
        item.setForeground(new Color(23, 43, 79));

        t4=new JTextField();
        home.add(t4);
        t4.setBounds(700,220,225,25);
        t4.setBackground(Color.white);
        t4.setForeground(new Color(23, 43, 79));
        t4.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79))); 

        JLabel district=new JLabel("DISTRICT :");
        home.add(district);
        district.setBounds(950,200,225,20);
        district.setFont(new Font("Verdana", Font.PLAIN, 15));
        district.setForeground(new Color(23, 43, 79));

        t5=new JTextField();
        home.add(t5);
        t5.setBounds(950,220,240,25);
        t5.setBackground(Color.white);
        t5.setForeground(new Color(23, 43, 79));
        t5.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79))); 

        JLabel feed=new JLabel("DESCRIPTION :");
        home.add(feed);
        feed.setBounds(700,260,1000,20);
        feed.setFont(new Font("Verdana", Font.PLAIN, 15));
        feed.setForeground(new Color(23, 43, 79));

        a1=new JTextArea();
        home.add(a1);
        a1.setBounds(700,280,500,100);
        a1.setBackground(Color.white);
        a1.setForeground(new Color(23, 43, 79));
        a1.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));

        JLabel address=new JLabel("ADDRESS :");
        home.add(address);
        address.setBounds(700,380,500,20);
        address.setFont(new Font("Verdana", Font.PLAIN, 15));
        address.setForeground(new Color(23, 43, 79));

        a2=new JTextArea();
        home.add(a2);
        a2.setBounds(700,400,500,100);
        a2.setBackground(Color.white);
        a2.setForeground(new Color(23, 43, 79));
        a2.setBorder(BorderFactory.createLineBorder(new Color(23, 43, 79)));

        b1=new JButton("SUBMIT");
        home.add(b1);
        b1.setBounds(900,510,100,30);
        b1.setFont(new Font("Verdana" , Font.PLAIN , 15));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(23, 43, 79));


        JPanel info=new JPanel();
        home.add(info);
        info.setBounds(20,70,460,420);
        info.setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.5f));

        JPanel feedback=new JPanel();
        home.add(feedback);
        feedback.setBounds(490,1,970,548);
        feedback.setBackground(Color.WHITE);

        JPanel feedback_1=new JPanel();
        home.add(feedback_1);
        feedback_1.setBounds(595,20,700,530);
        feedback_1.setBackground(new Color(23, 43, 79));

        JLabel sideimg=new JLabel();
        home.add(sideimg);
        sideimg.setBounds(2,2,500,1280);
        ImageIcon iconside = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\5.jpg");
        Image imgside=iconside.getImage();
        Image newImgside=imgside.getScaledInstance(sideimg.getWidth(), sideimg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImcside=new ImageIcon(newImgside);
        sideimg.setIcon(newImcside);

        setVisible(false);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Aid_form_validation val=new Aid_form_validation();
                String name=t1.getText().toString();
                boolean valid_name=val.setName(name);
                
                if(valid_name==true){
                    String mail=t2.getText().toString();
                    boolean valid_mail=val.setMail(mail);
                    if(valid_mail==true){
                        String num=t3.getText().toString();
                        boolean valid_num=val.setNumber(num);
                        if(valid_num==true){
                            String item=t4.getText().toString();

                            if(item.length()>=2){
                                String dist=t5.getText().toString();
                                boolean val_dist = val.setDistrict(dist);
                                if(dist.length()>=2 && val_dist) {
                                    
                                    String desc=a1.getText().toString();

                                    if(desc.length()>=2) {
                                        String add=a2.getText().toString();

                                        if(add.length()>=2) {

                                            String user_sector=c1.getSelectedItem().toString();
                                            String user_name=val.getName();
                                            long user_num=val.getNumber();
                                            String user_mail=val.getMail();
                                            String user_item=item;
                                            String user_dist=dist;
                                            String user_desc=desc;
                                            String user_add=add;
                                            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                                            Date d=new Date();
                                            String user_date=sdf.format(d);
                                            SimpleDateFormat sdt=new SimpleDateFormat("HH:mm:ss");
                                            Date t=new Date();
                                            String user_time=sdt.format(t);
                                            SimpleDateFormat sd=new SimpleDateFormat("ddMMyyyy");
                                            Date da=new Date();
                                            String user_dat=sd.format(da);
                                            SimpleDateFormat st=new SimpleDateFormat("HHmmss");
                                            Date ta=new Date();
                                            String user_tim=st.format(ta);
                                            String user_idi="WFUNGO"+user_dat+user_tim;
                                            String user_stamp=user_date+" "+user_time;

                                            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
                                            String dateString = dateFormat.format(new Date()).toString();


                                            DateFormat dateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
                                            String dateString2 = dateFormat2.format(new Date()).toString();
                                            String sub = dateString2.substring(3,5);

                                            int n=Integer.parseInt(sub);
                                            String mon[]={"JAN", "FEB", "MAR","APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

                                            String date_fin =dateString2.substring(0,3)+mon[n-1]+dateString2.substring(5,10)+" "+ dateString;
                                            
                                            try{
                                                Connection con=GetConnection.getConnection();
                                                Statement stm=con.createStatement();
                                                String query="insert into aid values('"+user_idi+"','"+user_name+"','"+user_mail+"',"+user_num+",'"+user_sector+"','"+user_item+"','"+user_dist+"','"+user_desc+"','"+user_add+"','"+date_fin+"')";
                                                stm.executeQuery(query);
                                                con.setAutoCommit(true);
                                                String ans = "	Your need has been registered successfully!" +"\n" + "This is your ID   "+ user_idi ;
                                                JOptionPane.showMessageDialog(null, ans);
                                            }
                                            catch(Exception xe){
                                                JOptionPane.showMessageDialog(null, xe);
                                            }

                                           
                                            Home.callHome();

                                        }
                                        else
                                            JOptionPane.showMessageDialog(null,"Enter the Address");
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null,"Enter the Description");
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Enter the Item");
                            }
                        }
                    }
                }
            }
        });
    }

//    public static void main(String args[]) {
//
//            new Aidform();
//
//    }
}