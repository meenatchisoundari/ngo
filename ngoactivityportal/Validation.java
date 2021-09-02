package ngoactivityportal;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Validation {
    
    private String Username,FirtsName,LastName,Gender,Dob,EmailID,Profession,Address,Password;
    private long MobileNo,Pincode;

    public boolean setUserName(String user_name) {
        String regex_username ="^(?=.*?[a-z])(?=.*[0-9])(?=.*?[#?!@$%^&*-]).{5,}$";
        Pattern pat = Pattern.compile(regex_username);
        Matcher mat = pat.matcher(user_name);
        boolean username_check = mat.matches();
        if(!mat.matches()){

            JOptionPane.showMessageDialog(null, "User Name must contain atleast lowercase,special character and digit "+ " atleast min 5 characters ");
            return false;
        }
        else{
            this.Username = user_name;
            return true;
        }

    }
    public String getUserName() {
            return this.Username;
    }

    public boolean setFname(String f_name) {
           
        String name =f_name.replaceAll("\\s", "");
        String regex_fname = "^[A-Za-z]{3,30}+$";
        Pattern pat = Pattern.compile(regex_fname);
        Matcher mat = pat.matcher(name);
        boolean fname_match = mat.matches();
        if(fname_match==true) {
            this.FirtsName=f_name;
            return fname_match;
        }
        else if(f_name.length()<3){
            JOptionPane.showMessageDialog(null, "First Name should contain atleast 3 characters");
        }
        else {
            Pattern ptfname_check = Pattern.compile("[^a-zA-z]");
            Matcher mtfname = ptfname_check.matcher(f_name);
            boolean splcheck = mtfname.find();
            if(splcheck==true) {
                JOptionPane.showMessageDialog(null, "Special characters and numbers are not allowed in name");
            }
            
        }
        return false;
    }
    public String getFname() {
            return this.FirtsName;
    }
    
    
    public boolean setLname(String l_name) {
        
        String name =l_name.replaceAll("\\s", "");
        String regex_lname = "^[A-Za-z]{1,30}+$";
        Pattern p = Pattern.compile(regex_lname);
        Matcher mlname = p.matcher(name);
        boolean lname_match = mlname.matches();
        if(lname_match==true){
            this.LastName = l_name;
            return lname_match;
        }
        else if(l_name.length()<1){
            JOptionPane.showMessageDialog(null, "Last name should contain atleast 1 character");
        }
        else{
            Pattern ptlname_check = Pattern.compile("[^a-zA-Z]");
            Matcher mtlname = ptlname_check.matcher(l_name);
            boolean spl_check = mtlname.find();
            if(spl_check==true){
                JOptionPane.showMessageDialog(null, "Special characters and numbers not allowed in name");
            }
        }
	return false;
    }
    
    public String getLname() {
            return this.LastName;
    }
	
    
    public void setGender(String gender) {
            this.Gender=gender;
    }
    public String getGender() {
            return this.Gender;
    }

    public boolean setDob(String user_dob) {
        
        boolean dob_check = false;
        if(user_dob.charAt(2)=='.'){
            String PAT="^[0-9]{0,2}[.][0-9]{0,2}[.][0-9]{0,4}$";
            Pattern pt=Pattern.compile(PAT);
            Matcher mt=pt.matcher(user_dob);
            if(!mt.matches()){
                JOptionPane.showMessageDialog(null, "Invalid Date of birth");
            }
            else{
                this.Dob = user_dob.replace(".","-");
                dob_check = true;
            }
        }
        else if(user_dob.charAt(2)=='-'){
            String PAT="^[0-9]{0,2}[-][0-9]{0,2}[-][0-9]{0,4}$";
            Pattern pt=Pattern.compile(PAT);
            Matcher mt=pt.matcher(user_dob);
            if(!mt.matches()){
                JOptionPane.showMessageDialog(null, "Invalid Date of birth");
            }
            else{
                this.Dob = user_dob;
                dob_check =true;
            }
        }
        else if(user_dob.charAt(2)=='/'){
            
            String PAT="^[0-9]{0,2}[/][0-9]{0,2}[/][0-9]{0,4}$";
            Pattern pt=Pattern.compile(PAT);
            Matcher mt=pt.matcher(user_dob);
            if(!mt.matches()){
                JOptionPane.showMessageDialog(null, "Invalid Date of birth");
            }
            else{
                this.Dob = user_dob.replace("/","-");
                dob_check = true;
            }
        }
        return dob_check;
    }
    
    public String getDob() {
            return this.Dob;
    }
	
    public boolean setMobile(String user_mobile) {
        boolean mob_check = false;
        String PAT ="^[6-9]{1}[0-9]{9}$";
        Pattern pt=Pattern.compile(PAT);
        Matcher mt=pt.matcher(user_mobile);
        if(!mt.matches()){
            JOptionPane.showMessageDialog(null, "Invalid mobile number");
        }
        else{
            mob_check = true;
            this.MobileNo = Long.parseLong(user_mobile);
        }
        return mob_check;
    }
    public long getMobile() {
            return this.MobileNo;
    }

    public boolean setEmail(String user_email) {
        String regex_email = "^[\\w!#$%&'+/=?`{|}^-]+(?:\\.[\\w!#$%&'+/=?`{|}^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern ptemail= Pattern.compile(regex_email);
        Matcher memail = ptemail.matcher(user_email);
        boolean email_check = memail.matches();
        if(email_check==true){
            this.EmailID = user_email;
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid mail ID");
        }
        return false;
    }
    public String getEmail() {
            return this.EmailID;
    }

    
    public boolean setProfession(Object p) {
        boolean check_profession = false;
        String str =(String)p;
        if(str.equals(" ")){
            JOptionPane.showMessageDialog(null, "Select Profession ");
        }
        else{
            check_profession = true;
            this.Profession = str;
        }
        return check_profession;
    }
    public String getProfession() {
        return this.Profession;
    }

    

    public boolean setAddress(String user_address) {
        this.Address = user_address;
        return true;
    }
    public String getAddress() {
        return this.Address;
    }

    public boolean setPincode(String user_pincode) {
        boolean pin_check = false;
        String PAT ="^[6]{1}[0-9]{5}$";
        Pattern pt=Pattern.compile(PAT);
        Matcher mt=pt.matcher(user_pincode);
        if(!mt.matches()){
            JOptionPane.showMessageDialog(null, "Invalid pincode ");
        }
        else{
            pin_check = true;
            this.Pincode = Long.parseLong(user_pincode);
        }
        return pin_check;
    }
    public long getPincode() {
        return this.Pincode;
    }
    public boolean setPassword(String user_password) {
        boolean password_check = false;
        String PAT ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#.?!@$%^&*-]).{8,}$";
        Pattern pt=Pattern.compile(PAT);
        Matcher mt=pt.matcher(user_password);
        if(!mt.matches()){
            JOptionPane.showMessageDialog(null, "Password must contain atleast one uppercase,lowercase,special character and digit "
          + "Password should contain atleast 8 characters ");
        }
        else{
            password_check = true;
            this.Password = user_password;
        }
        return password_check;
    }

    public String getPassword() {
        return this.Password;
    }
}