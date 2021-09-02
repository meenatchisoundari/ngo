package ngoactivityportal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

@SuppressWarnings("serial")
public  class Profile extends JFrame implements ActionListener {
	
    JPanel profile ;
    private String USER_NAME;
    Container con;
    JButton edit ;

    public Profile(String user_name){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);

        this.USER_NAME = user_name;
        profile = new JPanel();

        profile.setBounds(0,50,1400,550);
        profile.setBackground(Color.white);
        profile.setLayout(null);
        add(profile);  

        JLabel label = new JLabel(" PROFILE ");
        label.setFont(new Font("Serif", Font.BOLD,30));
        label.setForeground(Color.black);
        label.setBounds(560,70,300,30);
        profile.add(label);

        edit = new JButton("Edit Profile");
        edit.setBackground(new Color(23,43,79));
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("serif",Font.PLAIN,15));
        edit.setBounds(1160,215,150,25);
        profile.add(edit);
        edit.addActionListener(this);

        JSeparator s=new JSeparator(); 
        s.setBackground(Color.black);
        profile.add(s);
        s.setBounds(550,110,170,5);		   

        JLabel username = new JLabel("username");
        username.setForeground(Color.black);
        username.setFont(new Font("Serif", Font.BOLD,20));
        username.setBounds(1180,180,200,25);
        profile.add(username);

        JLabel membername = new JLabel();
        membername.setText("MEMBER NAME : ");
        membername.setForeground(Color.black);
        membername.setFont(new Font("Serif", Font.BOLD,20));
        membername.setBounds(500,150,200,20);
        profile.add(membername);

        JLabel mem_name = new JLabel();
        mem_name.setText("FULL NAME");
        mem_name.setFont(new Font("Serif", Font.BOLD,20));
        mem_name.setForeground(new Color(23,43,79));
        mem_name.setBounds(680,150,400,20);
        profile.add(mem_name);

        JLabel dob = new JLabel();
        dob.setText("DATE OF BIRTH : ");
        dob.setForeground(Color.black);
        dob.setFont(new Font("Serif", Font.BOLD,20));
        dob.setBounds(500,200,250,20);
        profile.add(dob);

        JLabel tf_dob = new JLabel();
        tf_dob.setText("dd/mm/yyyy");
        tf_dob.setForeground(new Color(23,43,79));
        tf_dob.setFont(new Font("Serif", Font.BOLD,20));
        tf_dob.setBounds(680,200,300,20);
        profile.add(tf_dob);

        JLabel mobile = new JLabel();
        mobile.setText("MOBILE NO         : ");
        mobile.setForeground(Color.black);
        mobile.setFont(new Font("Serif", Font.BOLD,20));
        mobile.setBounds(500,250,200,20);
        profile.add(mobile);

        JLabel mem_mobile = new JLabel();
        //mem_mobile.setText("");  
        mem_mobile.setForeground(new Color(23,43,79));
        mem_mobile.setFont(new Font("Serif", Font.BOLD,20));
        mem_mobile.setBounds(680,250,300,20);
        profile.add(mem_mobile);

        JLabel gender = new JLabel();
        gender.setText("GENDER               : ");
        gender.setForeground(Color.black);
        gender.setFont(new Font("Serif", Font.BOLD,20));
        gender.setBounds(500,300,200,20);
        profile.add(gender);

        JLabel mem_gender = new JLabel();
        //mem_gender.setText("");
        mem_gender.setForeground(new Color(23,43,79));
        mem_gender.setFont(new Font("Serif", Font.BOLD,20));
        mem_gender.setBounds(680,300,200,20);
        profile.add(mem_gender);


        JLabel email = new JLabel();
        email.setText("MAIL ID                : ");
        email.setForeground(Color.black);
        email.setFont(new Font("Serif", Font.BOLD,20));
        email.setBounds(500,350,200,20);
        profile.add(email);

        JLabel mem_email = new JLabel();
        //mem_email.setText("");
        mem_email.setForeground(new Color(23,43,79));
        mem_email.setFont(new Font("Serif", Font.BOLD,20));
        mem_email.setBounds(680,350,300,20);
        profile.add(mem_email);

        JLabel address = new JLabel();
        address.setText("ADDRESS              : ");
        address.setForeground(Color.black);
        address.setFont(new Font("Serif", Font.BOLD,20));
        address.setBounds(500,400,200,20);
        profile.add(address);

        JLabel mem_address = new JLabel();
        //mem_address.setText("");
        mem_address.setForeground(new Color(23,43,79));
        mem_address.setFont(new Font("Serif", Font.BOLD,20));
        mem_address.setBounds(680,400,450,20);
        profile.add(mem_address);

        JLabel pincode = new JLabel();
        pincode.setText("PINCODE              : ");
        pincode.setForeground(Color.black);
        pincode.setFont(new Font("Serif", Font.BOLD,20));
        pincode.setBounds(500,450,200,20);
        profile.add(pincode);

        JLabel mem_pin = new JLabel();
        //mem_pin.setText("");
        mem_pin.setForeground(new Color(23,43,79));
        mem_pin.setFont(new Font("Serif", Font.BOLD,20));
        mem_pin.setBounds(680,450,200,20);
        profile.add(mem_pin);

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
                mem_name.setText(FullName);
                tf_dob.setText(rset.getString("DOB")); 
                mem_mobile.setText(rset.getString("MOBILE"));
                String gendertable = rset.getString("GENDER");

                if(gendertable.equals("Male")){
                    mem_gender.setText("Male");
                    @SuppressWarnings("unused")
                        JLabel bg2=new JLabel();
                    profile.add(bg2);
                    bg2.setBounds(1170,60,100,100);
                    ImageIcon icon2 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\male2.jpg");
                    Image img2=icon2.getImage();
                    Image newImg2=img2.getScaledInstance(bg2.getWidth(), bg2.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon2=new ImageIcon(newImg2);
                    bg2.setIcon(newImgIcon2);
                }
                else if(gendertable.equals("Female")){
                    mem_gender.setText("Female");
                    JLabel bg3=new JLabel();
                    profile.add(bg3);
                    bg3.setBounds(1170,60,100,100);
                    ImageIcon icon3 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\female2.jpg");
                    Image img3=icon3.getImage();
                    Image newImg3=img3.getScaledInstance(bg3.getWidth(), bg3.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon3=new ImageIcon(newImg3);
                    bg3.setIcon(newImgIcon3);

                }
                else {
                    mem_gender.setText("Not Specified");
                    JLabel bg1=new JLabel();
                    profile.add(bg1);
                    bg1.setBounds(1170,60,100,100);
                    ImageIcon icon = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\icon1.png");
                    Image img=icon.getImage();
                    Image newImg=img.getScaledInstance(bg1.getWidth(), bg1.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImgIcon=new ImageIcon(newImg);
                    bg1.setIcon(newImgIcon);
                }


                mem_email.setText(rset.getString("MAIL_ID"));
                mem_address.setText(rset.getString("ADDRESS"));
                mem_pin.setText(rset.getString("PINCODE"));
            }
            connect.close();
        }
        catch(Exception xe){
        JOptionPane.showMessageDialog(null,xe);
        }         
        profile.setVisible(false);
        setVisible(false);
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj==edit) {
            Home.callEditpage(USER_NAME);
        }
    }

//    public static void main(String args[]){
//       // new Profile("meenu#16");
//    }

}