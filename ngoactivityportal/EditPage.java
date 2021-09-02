package ngoactivityportal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public  class EditPage extends JFrame implements ActionListener {
	
    JPanel editPage = new JPanel();
    private String USER_NAME;
    Container con;
    JButton save ;
    private JTextField mem_name;
    private JTextField mem_name1;
    private JLabel membername,email;
    private Component dob;
    private JTextField mem_dob;
    private JTextField mem_mobile;
    private Component mobile;
    private JLabel gender;
    private JTextField mem_gender,mem_email;
    private JTextField mem_address;
    private JLabel address;
    private JLabel username;
    private Container pincode;
    private JTextField mem_pin;
    private ButtonGroup bg_gender;
    private JRadioButton jrb_male;
    private JRadioButton jrb_female;
    private JRadioButton jrb_other;
        
    public EditPage (String user_name){
           
        this.USER_NAME = user_name;
        
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);

        editPage.setBounds(0,50,1400,550);
        editPage.setBackground(Color.white);
        editPage.setLayout(null);
        //add(editPage);
         
        JLabel label = new JLabel(" PROFILE ");
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setForeground(Color.black);
        label.setBounds(560,70,300,30);
        editPage.add(label);

        save = new JButton("Save Changes");
        save.setBackground(new Color(23,43,79));
        save.setForeground(Color.WHITE);
        save.setFont(new Font("serif",Font.PLAIN,15));

        save.setBounds(1160,215,150,25);
        editPage.add(save);
        save.addActionListener(this);

        JSeparator s=new JSeparator(); 
        editPage.add(s);
        s.setBounds(550,110,170,5);
        s.setBackground(Color.black);
     		
        username = new JLabel();
        username.setText("USER NAME");
        username.setForeground(Color.black);
        username.setFont(new Font("Serif", Font.BOLD,20));
        username.setBounds(1180,180,200,25);
        editPage.add(username);

        membername = new JLabel();
        membername.setText("MEMBER NAME ");
        membername.setForeground(Color.black);
        membername.setFont(new Font("Serif", Font.BOLD,20));
        membername.setBounds(500,150,200,20);
        editPage.add(membername);

        mem_name = new JTextField();
        //mem_name.setText("FULL NAME");
        mem_name.setBackground(Color.white);
        mem_name.setForeground(Color.black);      
        mem_name.setBounds(680,150,150,20);
        editPage.add(mem_name);
        	
        mem_name1 = new JTextField();
        mem_name1.setBackground(Color.white);
        mem_name1.setForeground(Color.black);
        mem_name1.setBounds(840,150,100,20);
        editPage.add(mem_name1);
            
        dob = new JLabel("DATE OF BIRTH ");
        dob.setForeground(Color.black);
        dob.setFont(new Font("Serif", Font.BOLD,20));
        dob.setBounds(500,200,240,20);
        editPage.add(dob);
			
        mem_dob = new JTextField();
        mem_dob.setText("dd/mm/yyyy");
        mem_dob.setBackground(Color.white);
        mem_dob.setForeground(Color.black);
        mem_dob.setBounds(680,200,150,20);
        editPage.add(mem_dob);
        	
        mobile = new JLabel("MOBILE NO ");
        mobile.setForeground(Color.black);
        mobile.setFont(new Font("Serif", Font.BOLD,20));
        mobile.setBounds(500,250,200,20);
        editPage.add(mobile);
            
        mem_mobile = new JTextField();
        mem_mobile.setBackground(Color.white);
        mem_mobile.setForeground(Color.black);
        mem_mobile.setBounds(680,250,150,20);
        editPage.add(mem_mobile);
        	
        gender= new JLabel("GENDER ");
        gender.setForeground(Color.black);
        gender.setFont(new Font("Serif", Font.BOLD,20));
        gender.setBounds(500,300,200,20);
        editPage.add(gender);
            
        bg_gender = new ButtonGroup();
        jrb_male= new JRadioButton("Male");
        jrb_male.setBounds(680,300,60,20);
        jrb_male.setBackground(Color.white);
        jrb_female= new JRadioButton("Female");
        jrb_female.setBackground(Color.white);
        jrb_female.setBounds(745,300,70,20);
        jrb_other= new JRadioButton("Other");
        jrb_other.setBackground(Color.white);
        jrb_other.setBounds(825,300,70,20);
        bg_gender.add(jrb_male);
        bg_gender.add(jrb_female);
        bg_gender.add(jrb_other);
        editPage.add(jrb_male);
        editPage.add(jrb_female);
        editPage.add(jrb_other);

        email = new JLabel();
        email.setText("MAIL ID ");
        email.setForeground(Color.black);
        email.setFont(new Font("Serif", Font.BOLD,20));
        email.setBounds(500,350,200,20);
        editPage.add(email);
            
        mem_email = new JTextField();
        mem_email.setText("");
        mem_email.setBackground(Color.white);
        mem_email.setForeground(Color.black);
        mem_email.setBounds(680,350,150,20);
        editPage.add(mem_email);

        address = new JLabel("ADDRESS ");
        address.setForeground(Color.black);
        address.setFont(new Font("Serif", Font.BOLD,20));
        address.setBounds(500,400,200,20);
        editPage.add(address);
            
        mem_address = new JTextField();  
        mem_address.setBackground(Color.white);
        mem_address.setForeground(Color.black);
        mem_address.setBounds(680,400,150,20);
        editPage.add(mem_address);

        pincode = new JLabel("PINCODE ");
        pincode.setForeground(Color.black);
        pincode.setFont(new Font("Serif", Font.BOLD,20));
        pincode.setBounds(500,450,200,20);
        editPage.add(pincode);

        mem_pin = new JTextField();
        mem_pin.setBackground(Color.white);
        mem_pin.setForeground(Color.black);
        mem_pin.setBounds(680,450,150,20);
        editPage.add(mem_pin);
           
       try{

            Connection connect = GetConnection.getConnection();
            Statement st = connect.createStatement();
            String sql = "select * from Member_Data where USERNAME='"+USER_NAME+"'";
            ResultSet rset = st.executeQuery(sql);
            int rows = 0;
            while(rset.next()){
                rows++;
            }
            rset = st.executeQuery(sql);
            @SuppressWarnings("unused")
                    String[][] database = new String[rows][8];
            @SuppressWarnings("unused")
                    int row_count = 0;
            while(rset.next()){
                
                @SuppressWarnings("unused")
                    int i=0;

                username.setText(USER_NAME);
                String Fname = rset.getString("FIRST_NAME");
                String Lname = rset.getString("LAST_NAME");
                String FullName = Fname+" "+Lname;
                mem_name.setText(Fname);
                mem_name1.setText(Lname);
                mem_dob.setText(rset.getString("DOB"));  
                mem_mobile.setText(rset.getString("MOBILE"));
                String gendertable = rset.getString("GENDER");
                if(gendertable.equals("Male")){
                    jrb_male.setSelected(true);
                    @SuppressWarnings("unused")
    			JLabel bg2=new JLabel();
                    editPage.add(bg2);
                    bg2.setBounds(1170,60,100,100);
                    ImageIcon icon2 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\male2.jpg");
                    Image img2=icon2.getImage();
                    Image newImg2=img2.getScaledInstance(bg2.getWidth(), bg2.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon2=new ImageIcon(newImg2);
                    bg2.setIcon(newImgIcon2);
      
                }
                else if(gendertable.equals("Female")){
                    jrb_female.setSelected(true);
                    JLabel bg3=new JLabel();
                    editPage.add(bg3);
                    bg3.setBounds(1170,60,100,100);
                    ImageIcon icon3 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\female2.jpg");
                    Image img3=icon3.getImage();
                    Image newImg3=img3.getScaledInstance(bg3.getWidth(), bg3.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon3=new ImageIcon(newImg3);
                    bg3.setIcon(newImgIcon3);

                }
                else {
                    jrb_other.setSelected(true);
                    JLabel bg1=new JLabel();
                    editPage.add(bg1);
            	    bg1.setBounds(1170,60,100,100);
            	    ImageIcon icon = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\icon1.png");
                    Image img=icon.getImage();
                    Image newImg=img.getScaledInstance(bg1.getWidth(), bg1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon=new ImageIcon(newImg);
                    bg1.setIcon(newImgIcon);
                }
               
                mem_email.setText(rset.getString("MAIL_ID")) ;
                mem_address.setText(rset.getString("ADDRESS"));
                mem_pin.setText(rset.getString("PINCODE"));
                
          }
          connect.close();
         
        }
        catch(Exception xe){
           JOptionPane.showMessageDialog(null,xe);
        }         
         
   	editPage.setVisible(false);
        setVisible(false);
           
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj1 = e.getSource();

        if(obj1==save) {
            Validation v = new Validation();

            String fname = mem_name.getText().toString();
            boolean edit_fname = v.setFname(fname);
            if(edit_fname==true) {
                String lname = mem_name1.getText().toString();
                boolean edit_lname = v.setLname(lname);
                if(edit_lname==true) {
                    String dob = mem_dob.getText().toString();
                    boolean edit_dob = v.setDob(dob);
                    if(edit_dob==true) {
                        String mobile = mem_mobile.getText().toString();
                        boolean edit_mobile = v.setMobile(mobile);
                        if(edit_mobile==true) {
                            if(jrb_male.isSelected()) {
                                    String gender ="Male";
                                    v.setGender(gender);
                            }else if(jrb_female.isSelected()) {
                                    String gender = "Female";
                                    v.setGender(gender);
                            }else {
                                    String gender ="Others";
                                    v.setGender(gender);
                            }
                            String email = mem_email.getText().toString();
                            boolean edit_email = v.setEmail(email);
                            if(edit_email==true) {
                                String address = mem_address.getText().toString();
                                boolean edit_address = v.setAddress(address);
                                if(edit_address==true) {
                                    String pincode = mem_pin.getText().toString();
                                    boolean edit_pincode = v.setPincode(pincode);
                                    if(edit_pincode==true) {
                                        String Fname = v.getFname();
                                        String Lname = v.getLname();
                                        String Dob = v.getDob();
                                        Long Mobile = v.getMobile();
                                        String Gender = v.getGender();
                                        String Email = v.getEmail();
                                        String Address = v.getAddress();
                                        long Pincode = v.getPincode();

                                        try {
                                            Connection connect = GetConnection.getConnection();
                                            Statement stm = connect.createStatement();
                                            String query_edit = "Update Member_Data set FIRST_NAME='"+Fname+"',LAST_NAME='"+Lname+"',DOB='"+Dob+"',MOBILE='"+Mobile+"',GENDER='"+Gender+"',MAIL_ID='"+Email+"',ADDRESS='"+Address+"',PINCODE='"+Pincode+"'Where USERNAME='"+USER_NAME+"'";
                                            stm.executeUpdate(query_edit);
                                            connect.setAutoCommit(true);
                                            JOptionPane.showMessageDialog(null,"Changes Saved");
                                            setVisible(false);
                                            new Profile(USER_NAME);

                                        }catch(Exception ee) {
                                                JOptionPane.showMessageDialog(null,ee);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}