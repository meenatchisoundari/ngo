package ngoactivityportal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ValidateDonationForm {
    
    public boolean validateEmailId(String check_email_id){
        String regex_email_id = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern for_email_id = Pattern.compile(regex_email_id);
        Matcher m_email_id = for_email_id.matcher(check_email_id);
        boolean email_id_match = m_email_id.matches();
        if(email_id_match==true){
            return true;
        }
        else{
            return false;
        }
       
    }
    
    public boolean validateState(String state) {
        String state_name = state.replaceAll("\\s","");
        String regex_f_state = "^[A-Za-z]{3,30}+$";
        Pattern p = Pattern.compile(regex_f_state);
        Matcher m_f_state = p.matcher(state_name);
        boolean f_state_match = m_f_state.matches();
        if(state.equals("State")){
            JOptionPane.showMessageDialog(null, "Enter your state name");
            return false;
        }
        else if(f_state_match==true){
            return true;
        }
        if(state.length()<3){
            JOptionPane.showMessageDialog(null, "State name should be minimum 3 characters long");
            return false;
        }
        else{
            Pattern pattern_f_name_check = Pattern.compile("[^a-zA-Z]");
            Matcher matcher_f_name = pattern_f_name_check.matcher(state);
            boolean spl_char_check = matcher_f_name.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in State");
                return false;
            }
            return false;
        }
    }
   
    public boolean validateName(String first_name) {
        String name = first_name.replaceAll("\\s","");
        String regex_f_name = "^[A-Za-z]{3,30}+$";
        Pattern p = Pattern.compile(regex_f_name);
        Matcher m_f_name = p.matcher(name);
        boolean f_name_match = m_f_name.matches();
        if(first_name.equals("Full Name")){
            JOptionPane.showMessageDialog(null, "Enter name");
            return false;
        }
        else if(f_name_match==true){
            return true;
        }
        if(first_name.length()<3){
            JOptionPane.showMessageDialog(null, "First name should be minimum 3 characters long");
            return false;
        }
        else{
            Pattern pattern_f_name_check = Pattern.compile("[^a-zA-Z]");
            Matcher matcher_f_name = pattern_f_name_check.matcher(first_name);
            boolean spl_char_check = matcher_f_name.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in name");
                return false;
            }
            return false;
        }
    }

    public boolean validateAddress(String entered_address1) {
        String address = entered_address1.replaceAll("\\s","");
        String regex_address = "^[A-Za-z0-9/-_,+#]{3,30}+$";
        Pattern p = Pattern.compile(regex_address);
        Matcher m_address = p.matcher(address);
        boolean f_address_match = m_address.matches();
        if(entered_address1.equals("Address Line 1")||entered_address1.equals("Address Line 2")){
            JOptionPane.showMessageDialog(null, "Enter address");
            return false;
        }
        else if(f_address_match==true){
            return true;
        }
        if(entered_address1.length()<3){
            JOptionPane.showMessageDialog(null, "Address should contain atleast be 3 letters");
            return false;
        }
        else{
            Pattern pattern_f_name_check = Pattern.compile("[^-,+/#a-zA-Z]");
            Matcher matcher_f_name = pattern_f_name_check.matcher(entered_address1);
            boolean spl_char_check = matcher_f_name.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters allowed in address");
                return false;
            }
            return false;
        }
        
    }

    boolean validateCity(String entered_city) {
        String city = entered_city.replaceAll("\\s","");
        String regex_city= "^[A-Za-z]{3,15}+$";
        Pattern p = Pattern.compile(regex_city);
        Matcher m_city = p.matcher(city);
        boolean f_city = m_city.matches();
        if(entered_city.equals("City")){
            JOptionPane.showMessageDialog(null, "Enter district");
            return false;
        }
        else if(f_city==true){
            return true;
        }
        if(entered_city.length()<3){
            JOptionPane.showMessageDialog(null, "City should be minimum 3 characters long");
            return false;
        }
        else{
            Pattern pattern_address_check = Pattern.compile("[^a-zA-Z]");
            Matcher matcher_address = pattern_address_check.matcher(entered_city);
            boolean spl_char_check = matcher_address.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in city");
                return false;
            }
            return false;
        }
    }

    boolean validatePincode(String entered_pincode) {
        String regex_pincode = "^[6]{1}[0-9]{5}";
        Pattern pattern = Pattern.compile(regex_pincode);
        Matcher m_pincode= pattern.matcher(entered_pincode);
        boolean pincode_match = m_pincode.matches();
        if(pincode_match==true){
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid pincode");
            return false;
        }
    }
    
    boolean validatePhoneNumber(String entered_phone_number) {
        
        String PATTERN ="^[6-9]{1}[0-9]{9}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(entered_phone_number);
        if(!match.matches()){
            
            JOptionPane.showMessageDialog(null, "Invalid mobile number");
            return false;
        }
        else{
            return true;
            
        }
    }

    boolean validateCvv(String entered_cvv) {
        String PATTERN ="^[0-9]{3}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher otp_match=patt.matcher(entered_cvv);
        if(!otp_match.matches()){
            
            JOptionPane.showMessageDialog(null, "Invalid cvv");
            return false;
        }
        else{
            return true;
            
        }
    }

    boolean validateAmount(int entered_amount) {
        if(entered_amount==0){
            JOptionPane.showMessageDialog(null,"Amount cannot be 0");
            return false;
        }
        else if(entered_amount>50000){
            JOptionPane.showMessageDialog(null,"Amount must be less than or equal to 50000");
            return false;
        }
        else{
            return true;
        }
    }

     boolean validateCreditcard(String entered_cred_card_number){
        Boolean bool_card_check = false;
        if(entered_cred_card_number.charAt(0)=='6'){
                
                String PATTERN ="^[6]{1}[0-9]{15}$";
                Pattern patt=Pattern.compile(PATTERN);
                Matcher match=patt.matcher(entered_cred_card_number);
                if(!match.matches()){

                    JOptionPane.showMessageDialog(null, "Invalid card number");
                    bool_card_check = false;
                }
                else{
                     bool_card_check = true;

                }
                
        }
        else if(entered_cred_card_number.charAt(0)=='5'){
            
            String PATTERN ="^[5]{1}[0-9]{15}$";
                Pattern patt=Pattern.compile(PATTERN);
                Matcher match=patt.matcher(entered_cred_card_number);
                if(!match.matches()){

                    JOptionPane.showMessageDialog(null, "Invalid card number");
                    bool_card_check = false;
                }
                else{
                     bool_card_check = true;

                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid card number");
        }
        return bool_card_check;
    }

}
