package ngoactivityportal;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GetDonorDetails extends JFrame implements ActionListener{
    
    JPanel paragraph_panel_1;
    JScrollPane get_donor_details_sp;
    JPanel get_donor_details;
    JLabel email_address_label,heading;
    JButton back_to_donation,urgent_needs,proceed_to_payment;
    JTextField phone_number_field,email_address,name_field,address_line1,address_line2,city_field,pincode_field,cvv_field,amount_field,select_state;
    JComboBox gender_title;
    JRadioButton male,female;
    ButtonGroup gendergp;
    JDateChooser date_chooser;
    String countries[] = {"Select country","India"};
    String states[] = {" ","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jharakhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarkhand","West Bengal"};
   
    
    public  GetDonorDetails(){
        
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);
       
        get_donor_details = new JPanel();
        
        add(get_donor_details);
        get_donor_details.setBounds(0,50,1400,525);
        get_donor_details.setBackground(Color.white);

        get_donor_details.setPreferredSize(new Dimension(100,500));

        get_donor_details.setLayout(null);

        heading=new JLabel("DONOR FORM");
        heading.setFont(new Font("Serif", Font.BOLD, 20));
        heading.setForeground(new Color(23,43,79));
        heading.setSize(200, 100);
        heading.setLocation(600,-30);
        get_donor_details.add(heading);
        email_address_label = new JLabel("EMAIL ADDRESS");
        email_address_label.setFont(new Font("Serif", Font.PLAIN, 14));
        email_address_label.setSize(120, 20);
        email_address_label.setLocation(525,50);
        get_donor_details.add(email_address_label);

        email_address = new JTextField();
        email_address.setForeground(Color.GRAY);
        email_address.setText("Email Address");
        email_address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (email_address.getText().equals("Email Address")) {
                    email_address.setText("");
                    email_address.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (email_address.getText().isEmpty()) {
                    email_address.setForeground(Color.GRAY);
                    email_address.setText("Email Address");
                }
            }
        });

        email_address.setSize(140,25);
        email_address.setLocation(675, 50);
        get_donor_details.add(email_address);

        JLabel name_label = new JLabel("FULL NAME");
        name_label.setFont(new Font("Serif", Font.PLAIN, 14));
        name_label.setSize(100, 40);
        name_label.setLocation(525,80);
        get_donor_details.add(name_label);

        name_field = new JTextField();
        name_field.setForeground(Color.GRAY);
        name_field.setText("Full Name");
        name_field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (name_field.getText().equals("Full Name")) {
                    name_field.setText("");
                    name_field.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (name_field.getText().isEmpty()) {
                    name_field.setForeground(Color.GRAY);
                    name_field.setText("Full Name");
                }
            }
        });
        name_field.setSize(140,25);
        name_field.setLocation(675, 90);
        get_donor_details.add(name_field);

        JLabel address_label = new JLabel("ADDRESS");
        address_label.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 14));
        address_label.setSize(100, 20);
        address_label.setLocation(525,130);
        get_donor_details.add(address_label);

        address_line1 = new JTextField();
        address_line1.setForeground(Color.GRAY);
        address_line1.setText("Address Line 1");
        address_line1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (address_line1.getText().equals("Address Line 1")) {
                    address_line1.setText("");
                    address_line1.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (address_line1.getText().isEmpty()) {
                    address_line1.setForeground(Color.GRAY);
                    address_line1.setText("Address Line 1");
                }
            }
        });
        address_line1.setSize(140,25);
        address_line1.setLocation(675,130);
        get_donor_details.add(address_line1);

        address_line2 = new JTextField();
        address_line2.setForeground(Color.GRAY);
        address_line2.setText("Address Line 2");
        address_line2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (address_line2.getText().equals("Address Line 2")) {
                    address_line2.setText("");
                    address_line2.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (address_line2.getText().isEmpty()) {
                    address_line2.setForeground(Color.GRAY);
                    address_line2.setText("Address Line 2");
                }
            }
        });
        address_line2.setSize(140,25);
        address_line2.setLocation(675,170);
        get_donor_details.add(address_line2);

        JLabel city_label = new JLabel("CITY");
        city_label.setFont(new Font("Serif", Font.PLAIN, 14));
        city_label.setSize(100, 20);
        city_label.setLocation(525,210);
        get_donor_details.add(city_label);

        city_field = new JTextField();
        city_field.setForeground(Color.GRAY);
        city_field.setText("City");
        city_field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (city_field.getText().equals("City")) {
                    city_field.setText("");
                    city_field.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (city_field.getText().isEmpty()) {
                    city_field.setForeground(Color.GRAY);
                    city_field.setText("City");
                }
            }
        });
        city_field.setSize(140,25);
        city_field.setLocation(675, 210);
        get_donor_details.add(city_field);

        JLabel state_label = new JLabel("STATE");
        state_label.setFont(new Font("Serif", Font.PLAIN, 14));
        state_label.setSize(100, 20);
        state_label.setLocation(525,250);
        get_donor_details.add(state_label);

        select_state = new JTextField();
        select_state.setForeground(Color.GRAY);
        select_state.setText("State");
        select_state.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (select_state.getText().equals("State")) {
                    select_state.setText("");
                    select_state.setForeground(Color.BLACK);
                }

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (select_state.getText().isEmpty()) {
                    select_state.setForeground(Color.GRAY);
                    
                    select_state.setText("State");
                }
            }
        });
        select_state.setSize(140,25);
        select_state.setLocation(675,250);
        get_donor_details.add(select_state);

        JLabel pincode_label = new JLabel("PINCODE");
        pincode_label.setFont(new Font("Serif", Font.PLAIN, 14));
        pincode_label.setSize(100, 20);
        pincode_label.setLocation(525,290);
        get_donor_details.add(pincode_label);


        pincode_field = new JTextField();
        pincode_field.setForeground(Color.GRAY);
        pincode_field.setText("Pincode");
        pincode_field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (pincode_field.getText().equals("Pincode")) {
                    pincode_field.setText("");
                    pincode_field.setForeground(Color.BLACK);
                }

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (pincode_field.getText().isEmpty()) {
                    pincode_field.setForeground(Color.GRAY);
                    pincode_field.setText("Pincode");
                }
            }
        });
        pincode_field.setSize(140,25);
        pincode_field.setLocation(675,290);
        get_donor_details.add(pincode_field);


        JLabel phone_number_label = new JLabel("PHONE NUMBER");
        phone_number_label.setFont(new Font("Serif", Font.PLAIN, 14));
        phone_number_label.setSize(125, 20);
        phone_number_label.setLocation(525,330);
        get_donor_details.add(phone_number_label);


        phone_number_field = new JTextField();
        phone_number_field.setForeground(Color.GRAY);
        phone_number_field.setText("Phone number");
        phone_number_field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (phone_number_field.getText().equals("Phone number")) {
                    phone_number_field.setText("");
                    phone_number_field.setForeground(Color.BLACK);
                }

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (phone_number_field.getText().isEmpty()) {
                    phone_number_field.setForeground(Color.GRAY);
                    phone_number_field.setText("Phone number");
                }
            }
        });
        phone_number_field.setSize(140,25);
        phone_number_field.setLocation(675,330);
        get_donor_details.add(phone_number_field);


        JLabel dob_label = new JLabel("DATE OF BIRTH");
        dob_label.setSize(125,20);
        dob_label.setLocation(525,370);
        dob_label.setFont(new Font("Serif", Font.PLAIN, 14));
        get_donor_details.add(dob_label);


        date_chooser = new JDateChooser();
        date_chooser.setFont(new Font("Serif", Font.PLAIN, 14));
        date_chooser.setBounds(675,370,120,20);
        get_donor_details.add(date_chooser);
        date_chooser.setDateFormatString("yyyy-MM-dd");
        
        
        JLabel gender_label = new JLabel("GENDER");
        gender_label.setBounds(525,410,100,20);
        gender_label.setFont(new Font("Serif", Font.PLAIN, 14));
        get_donor_details.add(gender_label);
        
         
        male = new JRadioButton("Male");
        male.setBounds(675,410,70,20);
        male.setFont(new Font("Serif", Font.PLAIN, 14));
        male.setSelected(true);
        get_donor_details.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Serif", Font.PLAIN, 14));
        female.setBounds(750,410,70,20);
        female.setSelected(false);
        get_donor_details.add(female);

        gendergp = new ButtonGroup();
        gendergp.add(male);
        gendergp.add(female);


        JLabel amount_label = new JLabel("ENTER AMOUNT ");
        amount_label.setSize(200,20);
        amount_label.setLocation(525,450);
        amount_label.setFont(new Font("Serif", Font.PLAIN, 14));
        get_donor_details.add(amount_label);

        amount_field = new JTextField();
        amount_field.setForeground(Color.GRAY);
        amount_field.setText("Enter amount");
        amount_field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (amount_field.getText().equals("Enter amount")) {
                    amount_field.setText("");
                    amount_field.setForeground(Color.BLACK);
                }

            }
            @Override
            public void focusLost(FocusEvent e) {
                if (amount_field.getText().isEmpty()) {
                    amount_field.setForeground(Color.GRAY);
                    amount_field.setText("Enter amount");
                }
            }
        });

        amount_field.setSize(140,25);
        amount_field.setLocation(675, 450);
        get_donor_details.add(amount_field);
        
        
        proceed_to_payment = new JButton("PROCEED TO PAY");
        proceed_to_payment.setFont(new Font("Serif", Font.PLAIN, 15));
        proceed_to_payment.setSize(180, 20);
        proceed_to_payment.setLocation(590,490);
        proceed_to_payment.setForeground(Color.WHITE);
        proceed_to_payment.setBackground(new Color(23,43,79));
        proceed_to_payment.addActionListener(this);  
        

        get_donor_details.add(proceed_to_payment);
        get_donor_details_sp= new JScrollPane(get_donor_details);
        get_donor_details_sp.setVisible(true);
        get_donor_details_sp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, false));
        get_donor_details_sp.setBounds(0,50,1370,525);


        add(get_donor_details_sp);

        setVisible(false);
    }
        
//    public static void main(String[] args) {
//        new GetDonorDetails();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj_source=e.getSource();

        if(obj_source==proceed_to_payment){
            DonorData bean1 = new DonorData();
            ValidateDonationForm check = new ValidateDonationForm();
            if(check.validateEmailId(email_address.getText())){
                bean1.setEmailId(email_address.getText());

                if(check.validateName(name_field.getText())){
                    bean1.setName(name_field.getText());

                    if(check.validateAddress(address_line1.getText())){
                        bean1.setAddressLine1(address_line1.getText());

                        if(check.validateAddress(address_line2.getText())){
                            bean1.setAddressLine2(address_line2.getText());

                            if(check.validateCity(city_field.getText())){
                                bean1.setCity(city_field.getText());

                                if(check.validateState( select_state.getText())){
                                    bean1.setState(select_state.getText());

                                    if(check.validatePincode(pincode_field.getText())){
                                        bean1.setPincode(Integer.parseInt(pincode_field.getText()));

                                        if(check.validatePhoneNumber(phone_number_field.getText())){
                                            bean1.setPhoneNumber(Long.parseLong(phone_number_field.getText()));

                                            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                                            try{
                                                String date = df.format(date_chooser.getDate());
                                                if(date!=null){

                                                    bean1.setDob(date);

                                                    if(male.isSelected()){
                                                        bean1.setGender("Male");
                                                    }
                                                    else{
                                                        bean1.setGender("Female");
                                                    }
                                                    try{
                                                        int e_amount = Integer.parseInt(amount_field.getText());
                                                       
                                                        if(check.validateAmount(e_amount)){
                                                            bean1.setAmount(Integer.parseInt(amount_field.getText()));
                                                            Home.callPaymentInitiation(bean1,phone_number_field.getText());
                                                        }
                                                    }
                                                    catch(Exception xe){
                                                        JOptionPane.showMessageDialog(null,"Enter amount");
                                                    }
                                                }
                                                else{
                                                    JOptionPane.showMessageDialog(null,"Select date");
                                                }
                                            }
                                            catch(Exception xe){
                                                JOptionPane.showMessageDialog(null,"Choose date of birth");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid mail");
            }                    
        }
    }
}
                