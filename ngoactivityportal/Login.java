package ngoactivityportal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{

    Container con;
    JLabel login,username,password;
    JButton blogin,signup,b_email,back,b_admin;;
    JTextField tusername,tpassword;
  
    public Login() {
		
        Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) dm.getWidth();
        int h = (int) dm.getHeight();

        setTitle("LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(w, h);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        con = getContentPane();
        con.setLayout(null);
        con.setBackground(new Color(23,43,79));
        
        back = new JButton("BACK");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(5,5,100,25);
        back.setFont(new Font("serif",Font.BOLD,10));
        back.addActionListener(this);
        con.add(back);
        
        ImageIcon icon_a = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\admin.jpg");
        b_admin = new JButton(icon_a);
        b_admin.setBounds(1300,0,50,50);
        b_admin.addActionListener(this);
        con.add(b_admin);
           
        login = new JLabel("LOGIN");
        login.setBounds(650,200,200,30);
        login.setFont(new Font("Verdana",Font.BOLD,25));     
        login.setForeground(Color.black);
        
        username = new JLabel("USER NAME :");
        username.setBounds(530,250, 200, 25);
        username.setFont(new Font("Verdana",Font.BOLD,15));
        username.setForeground(Color.black);

        password = new JLabel("PASSWORD :");
        password.setBounds(530, 300, 200, 25);
        password.setFont(new Font("Verdana",Font.BOLD,15));
        password.setForeground(Color.black);
        
        tusername = new JTextField();
        tusername.setBounds(650,250, 200, 25);
        tusername.setBackground(Color.white);
        tusername.setForeground(Color.black);
        tusername.setBorder(BorderFactory.createLineBorder(Color.white)); 
        JSeparator s1=new JSeparator(); 
        con.add(s1);
        s1.setBounds(650,275,200,1);
        s1.setBackground(Color.white);

        tpassword = new JPasswordField();
        tpassword.setBounds(650,300, 200, 25);
        tpassword.setBackground(Color.white);
        tpassword.setForeground(Color.black);
        tpassword.setBorder(BorderFactory.createLineBorder(Color.white)); 

        JSeparator s2=new JSeparator(); 
        con.add(s2);
        s2.setBounds(650,325,200,1);
        s2.setBackground(Color.white);

        blogin = new JButton("Login");
        blogin.setBackground(Color.white);
        blogin.setBounds(630,350,100,25);
        blogin.setFont(new Font("serif",Font.PLAIN,20));
        blogin.addActionListener(this);
		
        JLabel or1 = new JLabel("or");
        or1.setBounds(670,390,200,20);
        or1.setFont(new Font("Verdana",Font.PLAIN,15));

        JLabel email = new JLabel("Login with mail ID ");
        email.setBounds(530,430,200,20);
        email.setFont(new Font("Verdana",Font.PLAIN,15));

        ImageIcon icon = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/email1.jpg");
	b_email =new JButton(icon);
        b_email.setBounds(670, 420,50,40);
        b_email.setBackground(Color.white);
        b_email.setForeground(Color.white);
        b_email.addActionListener(this);
		
        JLabel or2 = new JLabel("Doesn't have an account ?then ");
        or2.setBounds(530,470,250,20);
        or2.setFont(new Font("Verdana",Font.PLAIN,15));
		
        signup = new JButton("Sign Up");
        signup.setBackground(Color.white);
        signup.setForeground(Color.black);
        signup.setBounds(765,469,100,25);
        signup.setFont(new Font("serif",Font.PLAIN,18));
	signup.addActionListener(this);
		
        con.add(login);
        con.add(username);
        con.add(password);
        con.add(tusername);
        con.add(tpassword);
        con.add(blogin);
        con.add(or1);
        con.add(email);
        con.add(b_email);
        con.add(or2);
        con.add(signup);
        
        JPanel panel=new JPanel();  
        panel.setBounds(450,150,w/3,h/2);    
        panel.setBackground(Color.white);  
        con.add(panel);
        	
	setVisible(true);
    }
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		new  Login();
//
//	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object obj = e.getSource();
        if(obj==blogin) {
            String user_password = null;
            GetConnection connect = new GetConnection();
            String  user_name= tusername.getText().toString();
            if(user_name.length()<1){
                JOptionPane.showMessageDialog(null,"Enter User Name");
            }
            else {
                user_password =tpassword.getText().toString();
                if(user_password.length()<1){
                    JOptionPane.showMessageDialog(null,"Enter Password");
                }
            }
            try{
                @SuppressWarnings("static-access")
                    Connection connection = connect.getConnection();
                boolean check = false;
                String query = "select USERNAME from Member_Data";
                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rset = pst.executeQuery();

                while(rset.next()){
                    if(user_name.equals(rset.getString("USERNAME"))){
                        check = true;
                        break;
                    }
                }
                connection.close();
                if(check){
                    @SuppressWarnings("static-access")
                        Connection conn1 = connect.getConnection();
                    @SuppressWarnings("unused")
                        boolean check_pass = false;
                    String query1 = "Select USERNAME,USER_PASSWORD from Member_Data where USERNAME='"+user_name+"'";
                    PreparedStatement pst1 = conn1.prepareStatement(query1);
                    ResultSet rset1 = pst1.executeQuery();
                    String password1= "";
                    String username1="";
                    while(rset1.next()){
                        username1 +=rset1.getString("USERNAME");
                        password1 +=rset1.getString("USER_PASSWORD");
                        break;
                    } 
                    if(password1.equals(user_password) && username1.equals(user_name)){
                        setVisible(false);
                        Home.callHomeAfterLogin(user_name);   
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD");
                    }
                }
                else if(user_name.length()>1){
                    JOptionPane.showMessageDialog(null,"User Name doesn't exist, Please Register!");
                }
            }
            catch(Exception ee){
                 JOptionPane.showMessageDialog(null,ee); 
            }  
        }

        if(obj==b_email) {

            String user_email =null;
            String user_password = null;
            user_email =JOptionPane.showInputDialog(null, "Enter Registered Mail ID", "LOGIN",JOptionPane.PLAIN_MESSAGE);
            try {
                if(user_email.length()<13) {
                    JOptionPane.showMessageDialog(null,"Enter a Valid Mail ID");
                }
                else if(user_email.length()>13) {
                    user_password =  JOptionPane.showInputDialog(null, "Enter Password","LOGIN",JOptionPane.PLAIN_MESSAGE);
                }
                if(user_password.length()<3) {
                    JOptionPane.showMessageDialog(null,"Enter a Valid Password");
                }
                else {
                    try{
                        Connection connect = GetConnection.getConnection();
                        boolean check = false;
                        String query = "select MAIL_ID from Member_Data";
                        PreparedStatement pst = connect.prepareStatement(query);
                        ResultSet rset = pst.executeQuery();

                        while(rset.next()){
                            if(user_email.equals(rset.getString("MAIL_ID"))){
                                check = true;
                                break;
                            }
                        }
                        connect.close();
                        if(check){
                            @SuppressWarnings("static-access")
                                Connection connect1 = GetConnection.getConnection();

                            String query1 = "Select MAIL_ID,USER_PASSWORD from Member_Data where MAIL_ID='"+user_email+"'";
                            PreparedStatement pst1 = connect1.prepareStatement(query1);
                            ResultSet rset1 = pst1.executeQuery();

                            String password1= "";
                            String mailid1="";
                            while(rset1.next()){
                               mailid1 +=rset1.getString("MAIL_ID");
                               password1 +=rset1.getString("USER_PASSWORD");
                               break;
                            }

                            if(password1.equals(user_password) && mailid1.equals(user_email)){

                                try{

                                    Connection connect2 = GetConnection.getConnection();
                                    Statement st = connect2.createStatement();
                                    String sql = "select * from Member_Data where MAIL_ID='"+user_email+"'";
                                    ResultSet rset2 = st.executeQuery(sql);
                                    int rows = 0;
                                    while(rset2.next()){
                                        rows++;
                                    }
                                    rset2 = st.executeQuery(sql);
                                    @SuppressWarnings("unused")
                                        String[][] database = new String[rows][8];
                                    @SuppressWarnings("unused")
                                        int row_count = 0;
                                    while(rset2.next()){
                                        @SuppressWarnings("unused")
                                            int i=0;

                                        String Username = rset2.getString("USERNAME");
                                        setVisible(false);
                                        Home.callHomeAfterLogin(Username);   
                                    }
                                    connect.close();

                                }
                                catch(Exception xe){
                                    JOptionPane.showMessageDialog(null,xe);
                                }   
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"INCORRECT PASSWORD");
                            }
                        }
                        else if(check==false){
                            JOptionPane.showMessageDialog(null,"Mail ID doesn't exist, Please Register!");
                        }
                    } 
                    catch(Exception ee){
                        JOptionPane.showMessageDialog(null,ee);
                    }
                }	
            }
            catch (Exception ee) {
            }
        }
        if(obj==signup) {
                new SignUp();
                setVisible(false);

        }
        if(obj==back){
            setVisible(false);
        }

        if(obj==b_admin) {
            String a_user,user_password=null;
            try{
                a_user = JOptionPane.showInputDialog(null, "ENTER USER NAME/ID ","ADMIN LOGIN" ,JOptionPane.CLOSED_OPTION);
                if(a_user.length()>3) {
                    user_password =  JOptionPane.showInputDialog(null, "ENTER PASSWORD","USER LOGIN",JOptionPane.PLAIN_MESSAGE);
                }

                Connection con = GetConnection.getConnection();
                String query2 = "Select USERNAME,PASSWORD from Admin where USERNAME='"+a_user+"'";
                PreparedStatement pst2 = con.prepareStatement(query2);
                ResultSet rset2 = pst2.executeQuery();

                String password1 ="";
                String username1 ="";

                while(rset2.next()){
                    username1 +=rset2.getString("USERNAME");
                    password1 +=rset2.getString("PASSWORD");
                    break;
                }
                if(username1.equals(a_user) && password1.equals(user_password)) {
                    JOptionPane.showMessageDialog(null, "LOGIN SUCCESS!","ADMIN LOGIN",JOptionPane.PLAIN_MESSAGE);
                   
                    this.setVisible(false);
                    new Home("Username");
                  
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong User name or Password ");
                }
            }

            catch (Exception ee){

            }
        }
    }

}