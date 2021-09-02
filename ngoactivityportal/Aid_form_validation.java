package ngoactivityportal;

import java.util.regex.*;
import javax.swing.JOptionPane;

public class Aid_form_validation {
	
    private String FirstName,Mail;
    private long phone_num;
    
    
    public boolean setDistrict(String entered_dist){
        
        String city = entered_dist.replaceAll("\\s","");
        String regex_city= "^[A-Za-z]{3,15}+$";
        Pattern p = Pattern.compile(regex_city);
        Matcher m_city = p.matcher(city);
        boolean f_city = m_city.matches();
        if(entered_dist.equals("City")){
            JOptionPane.showMessageDialog(null, "Enter city");
            return false;
        }
        else if(f_city==true){
            return true;
        }
        if(entered_dist.length()<3){
            JOptionPane.showMessageDialog(null, "District should be minimum 3 characters long");
            return false;
        }
        else{
            Pattern pattern_address_check = Pattern.compile("[^a-zA-Z]");
            Matcher matcher_address = pattern_address_check.matcher(entered_dist);
            boolean spl_char_check = matcher_address.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in district name");
                return false;
            }
            return false;
        }
    }
    
    public boolean setName(String first_name){

        String name = first_name.replaceAll("\\s","");
        String regex_f_name = "^[A-Za-z]{3,30}+$";
        Pattern p = Pattern.compile(regex_f_name);
        Matcher m_f_name = p.matcher(name);
        boolean f_name_match = m_f_name.matches();
        if(f_name_match==true){
            this.FirstName = first_name;
            return f_name_match;
        }
        else if(first_name.length()<3){
            JOptionPane.showMessageDialog(null, "First name should be minimum 3 characters long");
        }
        else{
            Pattern pattern_f_name_check = Pattern.compile("[^a-zA-Z]");
            Matcher matcher_f_name = pattern_f_name_check.matcher(first_name);
            boolean spl_char_check = matcher_f_name.find();
            if(spl_char_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in name");
            }
        }
        return false;
    }

    public String getName(){
        return this.FirstName;
    }

    public boolean setMail(String check_email_id){

        String regex_email_id = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern for_email_id = Pattern.compile(regex_email_id);
        Matcher m_email_id = for_email_id.matcher(check_email_id);
        boolean email_id_match = m_email_id.matches();
        if(email_id_match==true){
            this.Mail = check_email_id;
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid mail");
        }
        return false;
    }

    public String getMail(){
        return this.Mail;
    }

    public boolean setNumber(String check_mobile_num){
        boolean mob_match = false;
        String PATTERN ="^[6-9]{1}[0-9]{9}$";
        Pattern patt=Pattern.compile(PATTERN);
        Matcher match=patt.matcher(check_mobile_num);
        if(!match.matches()){
            JOptionPane.showMessageDialog(null, "Invalid mobile number");
        }
        else{
            mob_match = true;
            this.phone_num = Long.parseLong(check_mobile_num);
        }
        return mob_match;
    }


    public long getNumber(){
        return this.phone_num;
    }
	
}
