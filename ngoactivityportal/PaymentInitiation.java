package ngoactivityportal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class PaymentInitiation extends JFrame implements ActionListener{
    
    JButton credit_make_payment,credit_cancel,debit_make_payment,debit_cancel;
    JPanel start_transaction,transfer_funds;
    JTextField credit_card_number,debit_card_number;
    JComboBox credit_card_select_month,credit_card_select_year,debit_card_select_month,debit_card_select_year;
    JPasswordField credit_card_cvv,debit_card_cvv;
    JScrollPane transfer_funds_sp;
    JTabbedPane tp;
    private String months[] = { "Month","Jan(01)","Feb(02)","Mar(03)","Apr(04)","May(05)","June(06)","July(07)","Aug(08)","Sep(09)","Oct(10)","Nov(11)","Dec(12)"};
    String years[] =new String[50];
    Calendar now = Calendar.getInstance();
    int year = now.get(Calendar.YEAR);
    String yearInString = String.valueOf(year);
    
    public  PaymentInitiation(){
          
        transfer_funds = new JPanel();
          
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);
            
        add(transfer_funds);
        transfer_funds.setBounds(0,50,1400,550);
        transfer_funds.setBackground(Color.white);
        transfer_funds.setPreferredSize(new Dimension(100,1500));
        transfer_funds.setLayout(null);
          
        int start = 0;
        years[0] = "Year"; 
        for(start=1;start<50;start++){
            years[start] = String.valueOf(year++);
        }
  
        start_transaction = new JPanel();
        start_transaction.setLayout(null);
        start_transaction.setBounds(0,0,1400,550);
        start_transaction.setBackground(Color.white);
        
        transfer_funds.add(start_transaction);
        
        Border blackline = BorderFactory.createLineBorder(new Color(23,43,79));   
        
        JPanel credit_card_pane=new JPanel();  
        
        JPanel debit_card_pane=new JPanel();  
        JPanel upi_pane=new JPanel(); 
        tp=new JTabbedPane();  
        tp.setBounds(375,70,600,400);  
        tp.add("CREDIT CARD",credit_card_pane);  
        tp.add("DEBIT CARD",debit_card_pane);  
        credit_card_pane.setLayout(null);
        credit_card_pane.setBackground(Color.LIGHT_GRAY);
        debit_card_pane.setBackground(Color.LIGHT_GRAY);
        credit_card_pane.setBorder(blackline);
        debit_card_pane.setBorder(blackline);
        JLabel credit_card_label = new JLabel("Card Number");
        credit_card_label.setBounds(170,10,100,20);
        credit_card_label.setFont(new Font("verdena", Font.PLAIN, 14));
        credit_card_pane.add(credit_card_label);
        

        credit_card_number = new JTextField();
        credit_card_number.setBounds(170,40,250,40);
        credit_card_pane.add(credit_card_number);
        credit_card_number.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                 debit_card_number.setText("");
                 debit_card_cvv.setText("");
                 debit_card_select_month.setSelectedItem("Month");
                 debit_card_select_year.setSelectedItem("Year");

            }
            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
      
        JLabel credit_expiry_date_label = new JLabel("Expiry date:");
        credit_expiry_date_label.setFont(new Font("verdena", Font.PLAIN, 14));
        credit_expiry_date_label.setBounds(170,100,100,20);
        credit_card_pane.add(credit_expiry_date_label);
        

        credit_card_select_month = new JComboBox(months);
        credit_card_select_month.setFont(new Font("Arial", Font.PLAIN, 14));
        credit_card_select_month.setBounds(260,140,80,30);
        credit_card_pane.add(credit_card_select_month);
        
        credit_card_select_year = new JComboBox(years);
        credit_card_select_year.setFont(new Font("Arial", Font.PLAIN, 14));
        credit_card_select_year.setBounds(170,140,80,30);
        credit_card_pane.add(credit_card_select_year);
        
        JLabel credit_card_cvv_label = new JLabel("CVV:");
        credit_card_cvv_label.setBounds(365,100,50,20);
        credit_card_cvv_label.setFont(new Font("verdena", Font.PLAIN, 14));
        credit_card_pane.add(credit_card_cvv_label);

        credit_card_cvv = new JPasswordField();
        credit_card_cvv.setBounds(365,140,50,20);
        credit_card_pane.add(credit_card_cvv);
        
        credit_make_payment = new JButton("Make Payment");
        credit_make_payment.setFont(new Font("verdena", Font.PLAIN, 15));
        credit_make_payment.setBounds(170,190,140,30);
        credit_make_payment.setBackground(new Color(23,43,79));
        credit_make_payment.setForeground(Color.white);
        credit_make_payment.addActionListener(this);
        credit_card_pane.add(credit_make_payment);

        credit_cancel = new JButton("Cancel");
        credit_cancel.setFont(new Font("verdena", Font.PLAIN, 15));
        credit_cancel.setBounds(320,190,100,30);
        credit_cancel.setBackground(new Color(23,43,79));
        credit_cancel.setForeground(Color.white);
        credit_cancel.addActionListener(this);
        credit_card_pane.add(credit_cancel);
        
        debit_card_pane.setLayout(null);
        
        JLabel debit_card_label = new JLabel("Card Number");
        debit_card_label.setBounds(170,10,100,20);
        debit_card_label.setFont(new Font("verdena", Font.PLAIN, 14));
        debit_card_pane.add(debit_card_label);
        
        debit_card_number = new JTextField();
        debit_card_number.setBounds(170,40,250,40);
        debit_card_pane.add(debit_card_number);
        debit_card_number.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                credit_card_number.setText("");
                credit_card_cvv.setText("");
                credit_card_select_month.setSelectedItem("Month");
                credit_card_select_year.setSelectedItem("Year");
                 
            }
            @Override
            public void focusLost(FocusEvent e) {
                
            }
        });
        
        JLabel debit_card_expiry_date_label = new JLabel("Expiry date:");
        debit_card_expiry_date_label.setFont(new Font("verdena", Font.PLAIN, 14));
        debit_card_expiry_date_label.setBounds(170,100,100,20);
        debit_card_pane.add(debit_card_expiry_date_label);
        

        debit_card_select_month = new JComboBox(months);
        debit_card_select_month.setFont(new Font("Arial", Font.PLAIN, 14));
        debit_card_select_month.setBounds(260,140,80,30);
        debit_card_pane.add(debit_card_select_month);
        
        debit_card_select_year = new JComboBox(years);
        debit_card_select_year.setFont(new Font("Arial", Font.PLAIN, 14));
        debit_card_select_year.setBounds(170,140,80,30);
        debit_card_pane.add(debit_card_select_year);

        
        JLabel cvv_label = new JLabel("CVV:");
        cvv_label.setBounds(365,100,50,20);
        cvv_label.setFont(new Font("verdena", Font.PLAIN, 14));
        debit_card_pane.add(cvv_label);

        debit_card_cvv = new JPasswordField();
        debit_card_cvv.setBounds(365,140,50,20);
        debit_card_pane.add(debit_card_cvv);
        
        debit_make_payment = new JButton("Make Payment");
        debit_make_payment.setForeground(Color.white);
        debit_make_payment.setBackground(new Color(23,43,79));
        debit_make_payment.setFont(new Font("verdena", Font.PLAIN, 15));
        debit_make_payment.setBounds(170,190,140,30);
        debit_make_payment.addActionListener(this);
        debit_card_pane.add(debit_make_payment);

        debit_cancel = new JButton("Cancel");
        debit_cancel.setForeground(Color.white);
        debit_cancel.setBackground(new Color(23,43,79));
        debit_cancel.setFont(new Font("verdena", Font.PLAIN, 15));
        debit_cancel.setBounds(320,190,100,30);
        debit_cancel.addActionListener(this);
        debit_card_pane.add(debit_cancel);
 
        
        start_transaction.add(tp);
        
        setVisible(false); 
            
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj_source=e.getSource();
      
        if(obj_source ==credit_make_payment){
            DonorData bean2 = new DonorData();
            String paid_via = new String();
            if(!credit_card_number.getText().equals("")){
                String cred_card_number = credit_card_number.getText();
                ValidateDonationForm check = new ValidateDonationForm();
                boolean card_status = check.validateCreditcard(cred_card_number);
                if(card_status){
                    String selected_month =(String) credit_card_select_month.getSelectedItem();
                    if(!selected_month.equals("Month")){
                        String selected_year = (String) credit_card_select_year.getSelectedItem();
                        if(!selected_year.equals("Year")){
                            if(credit_card_cvv.getText().length()!=0){
                                if(check.validateCvv(credit_card_cvv.getText())){
                                    Random rand = new Random();
                                    
                                    int otp = rand.nextInt(999999);
                                    //System.out.println(otp);
                                    new SendOTP(String.valueOf(otp),String.valueOf(Home.phone_no));
                                    
                                    try{
                                        int try_again=0;
                                        while(true){
                                            if(try_again==3){
                                                JOptionPane.showMessageDialog(null,"Exceeded maximum number of tries.Try after some time");
                                                Home.callHome();
                                                break;
                                            }
                                            String get_otp = JOptionPane.showInputDialog("Enter otp sent to mobile");
                                            if(get_otp.length()!= 0){
                                                try{
                                                    if(otp==Integer.parseInt(get_otp)){
                                                        Boolean flag = false;
                                                        while(flag==false){

                                                            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";

                                                            StringBuilder sb = new StringBuilder(12);
                                                            for (int i = 0; i < 12; i++) {
                                                                int index= (int)(AlphaNumericString.length() * Math.random());
                                                                sb.append(AlphaNumericString
                                                                              .charAt(index));
                                                            }
                                                            try{

                                                                GetConnection getConn = new GetConnection();
                                                                Connection conn = getConn.getConnection();

                                                                Statement st = conn.createStatement();

                                                                String sql = "select * from donation where transaction_id='"+sb+"'";
                                                                ResultSet rs = st.executeQuery(sql);

                                                                int rowsNumber = 0;
                                                                while(rs.next()){
                                                                    rowsNumber++;
                                                                }
                                                                if(rowsNumber==0){
                                                                    flag = true;
                                                                }
                                                                else{
                                                                    continue;
                                                                }
                                                            }
                                                            catch(Exception se){
                                                                System.out.println(se);
                                                            }
                                                            if(flag==true){
                                                                bean2.setTransactionId(new String(sb));
                                                                break;
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(null,"Payment successful");
                                                        bean2.setPaidvia("Credit card");
                                                        Home.paymentSuccess(bean2);
                                                        Home.callHome();

                                                        break;
                                                    }
                                                    else{
                                                        if(try_again<3){
                                                           JOptionPane.showMessageDialog(null,"Incorrect.Try again");
                                                        }
                                                        if(try_again>=3){

                                                            break;
                                                        }
                                                    }
                                                }
                                                catch(Exception xe){
                                                    JOptionPane.showMessageDialog(null,"Incorrect.Try again");
                                                }
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null,"Enter otp");
                                            }
                                            try_again++;
                                        }
                                    }
                                    catch(Exception edd){
                                        
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Enter cvv");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Select expiry year");
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Select expiry month");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter card number");
            }
        }
        
        if(obj_source ==debit_make_payment){
            DonorData bean2 = new DonorData();
            if(!debit_card_number.getText().equals("")){
                String deb_card_number = debit_card_number.getText();
                ValidateDonationForm check = new ValidateDonationForm();
                boolean deb_card_status = check.validateCreditcard(deb_card_number);
                if(deb_card_status){
                    String selected_month =(String) debit_card_select_month.getSelectedItem();
                    if(!selected_month.equals("Month")){
                        String selected_year = (String) debit_card_select_year.getSelectedItem();
                        if(!selected_year.equals("Year")){
                            if(debit_card_cvv.getText().length()!=0){
                                if(check.validateCvv(debit_card_cvv.getText())){
                                    Random rand = new Random();
                                    
                                    int otp = rand.nextInt(999999);
                                    //System.out.println(otp);
                                    new SendOTP(String.valueOf(otp),String.valueOf(Home.phone_no));
                                    try{
                                        int try_again=0;
                                        while(true){
                                            if(try_again==3){
                                                JOptionPane.showMessageDialog(null,"Exceeded maximum number of tries.Try after some time");
                                                Home.callHome();
                                                break;
                                            }
                                            String get_otp = JOptionPane.showInputDialog("Enter otp sent to mobile");
                                            if(get_otp.length()!= 0){
                                                try{
                                                    if(otp==Integer.parseInt(get_otp)){
                                                        Boolean flag = false;
                                                        while(flag==false){
                                                            String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
                                                            StringBuilder sb = new StringBuilder(12);
                                                            for (int i = 0; i < 12; i++) {
                                                                int index= (int)(AlphaNumericString.length() * Math.random());
                                                                sb.append(AlphaNumericString.charAt(index));
                                                            }
                                                            try{

                                                                GetConnection getConn = new GetConnection();
                                                                Connection conn = getConn.getConnection();

                                                                Statement st = conn.createStatement();
                                                                String sql = "select * from donation where transaction_id='"+sb+"'";
                                                                ResultSet rs = st.executeQuery(sql);

                                                                int rowsNumber = 0;
                                                                while(rs.next()){
                                                                    rowsNumber++;
                                                                }
                                                                if(rowsNumber==0){
                                                                    flag = true;

                                                                }
                                                                else{
                                                                    continue;
                                                                }
                                                            }
                                                            catch(Exception se){
                                                                System.out.println(se);
                                                            }
                                                            if(flag==true){
                                                                bean2.setTransactionId(new String(sb));
                                                                break;
                                                            }
                                                        }
                                                        JOptionPane.showMessageDialog(null,"Payment successful");
                                                        bean2.setPaidvia("Debit card");
                                                        Home.paymentSuccess(bean2);

                                                        break;
                                                    }
                                                    else{
                                                        if(try_again<3){
                                                           JOptionPane.showMessageDialog(null,"Incorrect.Try again");
                                                        }
                                                        if(try_again>=3){

                                                            break;
                                                        }
                                                    }
                                                }
                                                catch(Exception xe){
                                                    JOptionPane.showMessageDialog(null,"Incorrect.Try again");
                                                }
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null,"Enter otp");
                                            }
                                            try_again++;
                                        }
                                    }
                                    catch(Exception edd){
                                        
                                    }
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"Enter cvv");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Select expiry year");
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Select expiry month");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Enter card number");
            }
            
        }
        
        if(obj_source==debit_cancel){
            Home.callHome();
        }
        
        if(obj_source==credit_cancel){
            Home.callHome();
        }
        
        transfer_funds_sp= new JScrollPane(transfer_funds);
        transfer_funds_sp.setVisible(true);
        transfer_funds_sp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, false));
        transfer_funds_sp.setBounds(0,50,1370,550);

        //add(transfer_funds_sp);
        setVisible(false);

    }
//    
//    public static void main(String[] args){
//        new PaymentInitiation();
//    }
}