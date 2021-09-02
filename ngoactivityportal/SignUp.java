package ngoactivityportal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


@SuppressWarnings({ "unused", "serial" })
public class SignUp extends JFrame implements ActionListener {
    
    Container con;
    String profes[] = {"None","Not yet employed","Student","Doctor","Farmer","Software_Developer","Lawyer","Teacher","Professor","Physician","Accountant","Actor","Police","Government_Employees"};
    JButton back,register,add_other;
    ButtonGroup bg_gender;
    @SuppressWarnings("rawtypes")
    JComboBox cb_profession;
    JRadioButton jrb_male,jrb_female,jrb_other;
    JTextField other;
    JTextField tusername,tfname,tlname,tf_dob,tmobile,temail,tpincode,tpassword,tcon_password;
    TextArea taddress;

    public SignUp() {
	Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	int w = (int) dm.getWidth();
	int h = (int) dm.getHeight();
			
	setTitle("REGISTER");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(w, h);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
	setResizable(true);
	        
        con= getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(23,43,79));

        JLabel heading = new JLabel(" REGISTER ");
        heading.setBounds(550,60,250,30);
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        con.add(heading);

        JLabel username= new JLabel("USER NAME : ");
        username.setBounds(150,150,250,20);
        username.setFont(new Font("Serif",Font.BOLD,20));
        username.setForeground(Color.BLACK);
        con.add(username);


        JLabel fname= new JLabel("FIRST NAME : ");
        fname.setBounds(150,200,250,20);
        fname.setFont(new Font("Serif",Font.BOLD,20));
        fname.setForeground(Color.BLACK);
        con.add(fname);
	        
        JLabel lname= new JLabel("LAST NAME : ");
        lname.setBounds(150,250,250,20);
        lname.setFont(new Font("Serif",Font.BOLD,20));
        lname.setForeground(Color.BLACK);
        con.add(lname);


        JLabel gender= new JLabel("GENDER : ");
        gender.setBounds(150,300,250,20);
        gender.setFont(new Font("Serif",Font.BOLD,20));
        gender.setForeground(Color.BLACK);
        con.add(gender);

        JLabel dob= new JLabel("DATE OF BIRTH : ");
        dob.setBounds(150,350,250,20);
        dob.setFont(new Font("Serif",Font.BOLD,20));
        dob.setForeground(Color.BLACK);
        con.add(dob);

        JLabel mobilenum= new JLabel("MOBILE NO : ");
        mobilenum.setBounds(150,400,250,20);
        mobilenum.setFont(new Font("Serif",Font.BOLD,20));
        mobilenum.setForeground(Color.BLACK);
        con.add(mobilenum);

        JLabel email= new JLabel("MAIL ID : ");
        email.setBounds(750,150,150,20);
        email.setFont(new Font("Serif",Font.BOLD,20));
        email.setForeground(Color.BLACK);
        con.add(email);

        JLabel profession= new JLabel("PROFESSION : ");
        profession.setBounds(750,200,150,20);
        profession.setFont(new Font("Serif",Font.BOLD,20));
        profession.setForeground(Color.BLACK);
        con.add(profession);

        JLabel address= new JLabel("ADDRESS : ");
        address.setBounds(750,250,150,20);
        address.setFont(new Font("Serif",Font.BOLD,20));
        address.setForeground(Color.BLACK);
        con.add(address);

        JLabel pincode= new JLabel("PINCODE : ");
        pincode.setBounds(750,350,150,20);
        pincode.setFont(new Font("Serif",Font.BOLD,20));
        pincode.setForeground(Color.BLACK);
        con.add(pincode);

        JLabel password= new JLabel("PASSWORD : ");
        password.setBounds(750,400,150,20);
        password.setFont(new Font("Serif",Font.BOLD,20));
        password.setForeground(Color.BLACK);
        con.add(password);

        JLabel con_password= new JLabel("CONFIRM PASSWORD : ");
        con_password.setBounds(650,450,250,20);
        con_password.setFont(new Font("Serif",Font.BOLD,20));
        con_password.setForeground(Color.BLACK);
        con.add(con_password);


        tusername = new JTextField();
        tusername.setBackground(Color.white);
        tusername.setForeground(Color.gray);
        tusername.setBounds(330,150,150,20);  
        tusername.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tusername);

        tfname = new JTextField();
        tfname.setBackground(Color.white);
        tfname.setForeground(Color.gray);
        tfname.setBounds(330,200,150,20);
        tfname.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tfname);

        tlname = new JTextField();
        tlname.setBackground(Color.white);
        tlname.setForeground(Color.gray);
        tlname.setBounds(330,250,150,20);
        tlname.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tlname);
	       
        bg_gender = new ButtonGroup();
        jrb_male= new JRadioButton("Male");
        jrb_male.setSelected(true);
        jrb_male.setBounds(330,300,60,20);
        jrb_male.setBackground(Color.white);
        jrb_female= new JRadioButton("Female");
        jrb_female.setSelected(false);
        jrb_female.setBackground(Color.white);
        jrb_female.setBounds(410,300,70,20);
        jrb_other= new JRadioButton("Other");
        jrb_other.setSelected(false);
        jrb_other.setBackground(Color.white);
        jrb_other.setBounds(480,300,70,20);
        jrb_male.setFont(new Font("serif",Font.PLAIN,15));
        jrb_male.setFont(new Font("serif",Font.PLAIN,15));
        jrb_other.setFont(new Font("serif",Font.PLAIN,15));
        bg_gender.add(jrb_male);
        bg_gender.add(jrb_female);
        bg_gender.add(jrb_other);
        con.add(jrb_male);
        con.add(jrb_female);
        con.add(jrb_other);
	         
	       
        tf_dob = new JTextField();
        tf_dob.setForeground(Color.GRAY);
        tf_dob.setText("dd/mm/yyyy");
        tf_dob.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (tf_dob.getText().equals("dd/mm/yyyy")) {
                    tf_dob.setText("");
                    tf_dob.setForeground(Color.BLACK);
                }

            }

            public void focusLost(FocusEvent e) 
            {
                if (tf_dob.getText().isEmpty()) {
                    tf_dob.setForeground(Color.BLACK);
                    tf_dob.setText("dd/mm/yyyy");
                }
            }
        });
        
        tf_dob.setBounds(330, 350, 150,20);
        con.add(tf_dob);
	       
        tmobile = new JTextField();
        //tmobile.setText("Mobile number");
        tmobile.setBackground(Color.white);
        tmobile.setForeground(Color.gray);
        tmobile.setBounds(330,400,150,20);
        tmobile.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tmobile);

        temail = new JTextField();
        //temail.setText("Enter mail id");
        temail.setBackground(Color.white);
        temail.setForeground(Color.gray);
        temail.setBounds(900,150,150,20);
        temail.setFont(new Font("serif",Font.PLAIN,18));
        con.add(temail);
	       
        other = new JTextField();
        other.setText("Other");
        other.setForeground(Color.gray);
        other.setBounds(1060,200,100,20);
        con.add(other);

        add_other = new JButton("Add");
        add_other.setBackground(Color.white);
        add_other.setBounds(1170,200,60,20);
        add_other.addActionListener(this);
        con.add(add_other);
        
        cb_profession = new JComboBox(profes);
        cb_profession.setBounds(900,200,150,20);
        cb_profession.setForeground(Color.black);
        cb_profession.setBackground(Color.white);
        con.add(cb_profession);

        taddress = new TextArea();
        taddress.setBackground(Color.white);
        taddress.setForeground(Color.gray);
        taddress.setBounds(900,250,250,70);
        taddress.setFont(new Font("serif",Font.PLAIN,18));
        con.add(taddress);
	       
        tpincode = new JTextField();
        tpincode.setBackground(Color.white);
        tpincode.setForeground(Color.gray);
        tpincode.setBounds(900,350,150,20);
        tpincode.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tpincode);
	       
	tpassword = new JPasswordField();
        tpassword.setBackground(Color.white);
        tpassword.setForeground(Color.gray);
        tpassword.setBounds(900,400,150,20);
        tpassword.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tpassword);

        tcon_password = new JPasswordField();
        tcon_password.setBackground(Color.white);
        tcon_password.setForeground(Color.gray);
        tcon_password.setBounds(900,450,150,20);
        tcon_password.setFont(new Font("serif",Font.PLAIN,18));
        con.add(tcon_password);
	       
        register = new JButton("REGISTER");
        register.setBackground(Color.white);
        register.setForeground(Color.black);
        register.setBounds(550,550,150,25);
        register.setFont(new Font("serif",Font.BOLD,20));
        register.addActionListener(this);
        con.add(register);

        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(5,5,100,25);
        back.setFont(new Font("serif",Font.BOLD,10));
        back.addActionListener(this);
        con.add(back);
	       
	        
        con = getContentPane();
        con.setLayout(null);
        JPanel panel=new JPanel();  
        panel.setBounds(50,50,w-100,h-160);    
        panel.setBackground(new java.awt.Color(1.0f, 1.0f, 1.0f, 0.5f)) ;
        con.add(panel);
	        
        JPanel panel1=new JPanel();  
        panel1.setBounds(100,100,w-200,h-250);    
        panel1.setBackground(Color.white);
        con.add(panel1);
	        
	    	
	setVisible(true);
    }

    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj = e.getSource();
        if(obj==add_other) {
            cb_profession.addItem(other.getText());
            cb_profession.setSelectedItem(other.getText());
        }
        if(obj==register) {
            Validation v = new Validation();
            String user_name =tusername.getText().toString();
            boolean user = v.setUserName(user_name);
            if(user==true) {
                String f_name = tfname.getText().toString();
                boolean fname = v.setFname(f_name);
                if(fname==true) {
                    String l_name = tlname.getText().toString();
                    boolean lname = v.setLname(l_name);
                    if(lname==true) {
                        if (jrb_male.isSelected()){
                            String gender = "Male";
                            v.setGender(gender);
                        }
                        else if(jrb_female.isSelected()){
                            String gender = "Female";
                            v.setGender(gender);
                        }
                        else {
                            String gender ="Other";
                            v.setGender(gender);
                        }
                        String user_dob = tf_dob.getText().toString();
                        boolean dob = v.setDob(user_dob);

                        if(dob==true) {
                            String user_mobile =tmobile.getText().toString();
                            boolean mobile = v.setMobile(user_mobile);
                            if(mobile==true) {
                                String user_email =temail.getText().toString();
                                boolean email = v.setEmail(user_email);
                                if(email==true) {
                                    Object p = cb_profession.getSelectedItem();
                                    boolean profession= v.setProfession(p);
                                    if(profession==true){
                                        String user_address = taddress.getText().toString();
                                        boolean address = v.setAddress(user_address);
                                        if(address==true) {
                                            String user_pincode = tpincode.getText().toString();
                                            boolean pincode = v.setPincode(user_pincode);
                                            if(pincode==true) { 
                                                String user_password = tpassword.getText().toString();
                                                boolean password = v.setPassword(user_password);
                                                if(password==true) {
                                                    String confirm_password = v.getPassword();
                                                    if(tcon_password.getText().equals(confirm_password)){
                                                        String mem_username = v.getUserName();
                                                        String mem_fname =v.getFname();
                                                        String mem_lname =v.getLname();
                                                        String mem_gender =v.getGender();
                                                        String mem_dob = v.getDob();
                                                        long mem_mobile = v.getMobile();
                                                        String mem_email = v.getEmail();
                                                        String mem_profession = v.getProfession();
                                                        String mem_address = v.getAddress();
                                                        long mem_pincode = v.getPincode();
                                                        String mem_password = v.getPassword();

                                                        try {
                                                            Connection connect = GetConnection.getConnection();
                                                            Statement stmt = connect.createStatement(); 
                                                            String query ="insert into Member_Data values('"+mem_username+"','"+mem_fname+"','"+mem_lname+"','"+mem_gender+"','"+mem_dob+"','"+mem_mobile+"','"+mem_email+"','"+mem_profession+"','"+mem_address+"','"+mem_pincode+"','"+mem_password+"')";
                                                            stmt.executeUpdate(query);
                                                            connect.setAutoCommit(true);
                                                            JOptionPane.showMessageDialog(null, "MEMBER REGISTERED SUCCESSFULLY !");
                                                        }
                                                        catch(Exception ee) {
                                                                JOptionPane.showMessageDialog(null,"USER ALREADY EXISTS");
                                                        }
                                                        setVisible(false);
                                                        Login lg = new Login();
                                                    }
                                                    else{
                                                        JOptionPane.showMessageDialog(null,"PASSWORD DOES NOT MATCH");
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
        }

        if(obj==back) {
            Login lg = new Login();
            setVisible(false);
        }
    } 
//    public static void main(String args[]) {
//            new SignUp();
//    }
}