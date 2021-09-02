package ngoactivityportal;

public class OrganizationDetails {
    private String campaign_id;
    private String campaign_name;
    private String sector;
    private String start_date;
    private String end_date;
    private String venue;
    private String description;
    private String status;
    private String volunteer_name;
    private String contact_no;
    private String mail_id;
    private String profession;
    
    public String getCampaignID(){
        return campaign_id;
    }
    public void setCampaignID(String campaign_id){
        this.campaign_id=campaign_id;
    }
    public String getCampaignName(){
        return campaign_name;
    }
    public void setCampaignName(String campaign_name){
        this.campaign_name=campaign_name;
    }
    public String getSector(){
        return sector;
    }
    public void setSector(String sector){
        this.sector=sector;
    }
    public String getStartDate(){
        return start_date;
    }
    public void setStartDate(String start_date){
        this.start_date=start_date;
    }
    public String getEndDate(){
        return end_date;
    }
    public void setEndDate(String end_date){
        this.end_date=end_date;
    }
    public String getVenue(){
        return venue;
    }
    public void setVenue(String venue){
        this.venue=venue;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getVolunteerName(){
        return volunteer_name;
    }
    public void setVolunteerName(String volunteer_name){
        this.volunteer_name=volunteer_name;
    }
    public String getContactNo(){
        return contact_no;
    }
    public void setContactNo(String contact_no){
        this.contact_no=contact_no;
    }
    public String getMailID(){
        return mail_id;
    }
    public void setMailID(String mail_id){
        this.mail_id=mail_id;
    }
    public String getProfession(){
        return profession;
    }
    public void setProfession(String profession){
        this.profession=profession;
    }
}
