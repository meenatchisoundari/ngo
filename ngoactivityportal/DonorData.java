package ngoactivityportal;


public class DonorData {
    
    private String donor_type,sector,emailId,name,address_line1,address_line2,city,state,dob,gender,paid_via,transaction_id;
    private int pincode,amount;
    private long phone_number;
    
 
        
    public void setDonorType(String donortype){
        this.donor_type= donortype;
    }
    public String getDonorType(){
        return this.donor_type;
    }

    public void setSector(String s_sector){
        this.sector = s_sector;
    }
    public String getSector(){
        return this.sector;
    }

    public void setEmailId(String email){
        this.emailId = email;
    }
    public String getEmailId(){
        return this.emailId;
    }

    public void setName(String u_name){
        this.name = u_name;
    }
    public String getName(){
        return this.name;
    }


    public void setAddressLine1(String address1){
        this.address_line1 = address1;
    }
    public String getAddressLine1(){
        return this.address_line1;
    }

    public void setAddressLine2(String address2){
        this.address_line2 = address2;
    }
    public String getAddressLine2(){
        return this.address_line2;
    }

    public void setCity(String s_city){
        this.city = s_city;
    }
    public String getCity(){
        return this.city;
    }

    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }

    public void setPincode(int pincode){
        this.pincode = pincode;
    }
    public int getPincode(){
        return this.pincode;
    }

    public void setPhoneNumber(long phone_no){
        this.phone_number = phone_no;
    }
    public long getPhoneNumber(){
        return this.phone_number;
    }


    public void setDob(String s_dob){
        this.dob = s_dob;
    }
    public String getDob(){
        return dob;
    }

    public void setGender(String s_gender){
        this.gender = s_gender;
    }
    public String getGender(){
        return this.gender;
    }

    public void setAmount(int s_amount){
        this.amount = s_amount;
    }
    public int getAmount(){
        return this.amount;
    }

    public void setPaidvia(String s_paid_via){
        this.paid_via = s_paid_via;
    }
    public String getPaidvia(){
        return this.paid_via;
    }

    public void setTransactionId(String trans_id){
        this.transaction_id = trans_id;
    }
    public String getTransactionId(){
        return this.transaction_id;
    }
}
