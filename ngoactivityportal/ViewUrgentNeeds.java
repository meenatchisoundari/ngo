package ngoactivityportal;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.MouseInputListener;

public class ViewUrgentNeeds extends JFrame implements MouseInputListener{
    
    static JPanel urgent_needs,displaydata,needs_content;
    static JLabel user_name_label ,display_user_name_label,product_label,display_product_label,description_label,location_label,state_label,state_display,mail_id_label,mail_display,contact_number_label,contact_number_display;
    static JTable table;//table_filter,edu_table;
    static JTextArea description_text,location_text;
    JComboBox select_sector;
    JScrollPane pane = new JScrollPane();
    JScrollPane filter_pane = new JScrollPane();
    JScrollPane education_pane = new JScrollPane();
    String causes[] = { "ALL SECTORS","HEALTH","EDUCATION", "FOOD", "OTHERS"};
    String[][] data = new String[0][4];
    
    
//    public static void main(String[] args)  {
//        new ViewUrgentNeeds();
//    }
    
    
    public ViewUrgentNeeds(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
        setSize(1300,700);
        setLayout(null);
        urgent_needs = new JPanel();
  
        urgent_needs.setBackground(Color.WHITE);
        urgent_needs.setLayout(null);
        urgent_needs.setBounds(0,50,1400,550);
        urgent_needs.setPreferredSize(new Dimension(1200,200));
        
        select_sector = new JComboBox(causes);
        select_sector.setFont(new Font("Arial", Font.PLAIN, 14));
        select_sector.setBounds(29,2,180,30);
        select_sector.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                if(select_sector.getSelectedItem()=="FOOD" ){
                    pane.setVisible(false);
                    Home.callFilterFood();
                }
                 
                
                if(select_sector.getSelectedItem()=="EDUCATION" ){
                    pane.setVisible(false);
                    Home.callFilterEducation();
                }
                 
                if(select_sector.getSelectedItem()=="HEALTH" ){
                    pane.setVisible(false);
                    Home.callFilterHealth();
                }
                if(select_sector.getSelectedItem()=="OTHERS" ){
                    pane.setVisible(false);
                    Home.callOtherPurpose();   
                }
                if(select_sector.getSelectedItem()=="ALL"){    
                    filter_pane.setVisible(false);
                    Home.callAll();
                }
            }   
        });
        urgent_needs.add(select_sector);
        defaultTable();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(false);
    }
 
    public static void UrgentNeedsContent(){
        
        needs_content = new JPanel();
        needs_content.setLayout(null);
        needs_content.setBounds(700,30,600,480);
        needs_content.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
        needs_content.setBackground(Color.WHITE);
        JTextArea text=new JTextArea("    We believe in Oscar Wildes's words that the smallest act of kindness is worth more than the grandest intention.You can donate even the slightest you can by means of products or cash. To ease the process we have categorised  urgent needs into sectore like food, health, education and others.\n WFU India is providing relief to flood affected people in Purnia district (Bihar), Raigad district (Maharashtra) and Uttar Pradesh by providing them relief kits, including 24 essential items like soaps, towel, change of clothes, sanitary napkin, washable baby napkin etc along with water purification tablets and bleaching powder." );
        text.setForeground(new Color(23,43,79));
        text.setBackground(Color.WHITE);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        //text.setColumns(30);
        //text.setRows(10);
        text.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        text.setBounds(21,200,560,250); 
        needs_content.add(text);
        ImageIcon education1 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/urgentneed.jpeg");
        JLabel edu_image1 = new JLabel(education1);
        edu_image1.setBounds(250,50,100,100);
        needs_content.add(edu_image1);
        urgent_needs.add(needs_content);
        
    }
  
    public static void displayDetails(String clicked_id) {
        displaydata = new JPanel();
        displaydata.setPreferredSize(new Dimension(400,400));
        
        
        displaydata.setBounds(800,60,400,400);
        displaydata.setLayout(null);
        displaydata.setBackground(Color.WHITE);
        displaydata.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
        
        user_name_label = new JLabel("Name                  :");
        user_name_label.setBounds(10,10,150,30);
        user_name_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(user_name_label);
        
        display_user_name_label = new JLabel("");
        display_user_name_label.setBounds(150,10,150,30);
        display_user_name_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(display_user_name_label);
        
        
        product_label = new JLabel("Product               :");
        product_label.setBounds(10,50,150,30);
        product_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(product_label);
        
        display_product_label = new JLabel("");
        display_product_label.setBounds(150,50,150,30);
        display_product_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(display_product_label);
        
        description_label = new JLabel("Description        :");
        description_label.setBounds(10,90,150,30);
        description_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(description_label);
        
        description_text = new JTextArea();
        description_text.setBounds(150,90,170,60);
        description_text.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
        displaydata.add(description_text);
                
        
        location_label = new JLabel("Location             :");
        location_label.setBounds(10,160,150,30);
        location_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(location_label);
        
        location_text = new JTextArea();
        location_text.setBounds(150,160,170,60);
        location_text.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
        displaydata.add(location_text);

        mail_id_label = new JLabel("Mail id                :");
        mail_id_label.setBounds(10,240,150,30);
        mail_id_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(mail_id_label);
        
        mail_display = new JLabel("");
        mail_display.setBounds(150,240,150,30);
        mail_display.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        displaydata.add(mail_display);
        
        contact_number_label = new JLabel("Contact number :");
        contact_number_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        contact_number_label.setBounds(10,280,150,30);
        displaydata.add(contact_number_label);
        
        contact_number_display = new JLabel("");
        contact_number_display.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,17));
        contact_number_display.setBounds(150,280,100,30);
        displaydata.add(contact_number_display);
        
        displaydata.setVisible(true);
        urgent_needs.add(displaydata);
    } 
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int index = table.getSelectedRow();
        TableModel model = table.getModel();
        String clicked_id = (String) model.getValueAt(index,0);
        
        displaydata.setVisible(true);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void defaultTable() {
        try{
                
            GetConnection getConn = new GetConnection();
            Connection conn = getConn.getConnection();
            Statement st = conn.createStatement();

            String sql = "select * from aid";

            ResultSet rs = st.executeQuery(sql);
            int rowsNumber = 0;
            while(rs.next()){
                rowsNumber++;
            }

            rs = st.executeQuery(sql);
            data = new String[rowsNumber][4];
            int row_count = 0;

            while(rs.next()){
                int i=0;
                data[row_count][i++] = rs.getString("AID_ID");

                data[row_count][i++] = rs.getString("ITEM");
                data[row_count][i++] = rs.getString("DISTRICT");
                data[row_count][i++] = rs.getString("NAME");
                row_count++;

            }

            conn.close();
        }
        catch(Exception e){
            System.out.println();
        }
  
        String col[] = {"ID","Product Needed","District","User Name"};
        table = new JTable(data,col);
        JTableHeader header = table.getTableHeader();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                needs_content.setVisible(false);\
                displayDetails("id");
                int index = table.getSelectedRow();
                TableModel model = table.getModel();
                String clicked_id = (String) model.getValueAt(index,0);
                displaydata.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
                try{
                                
                    GetConnection getCon = new GetConnection();
                    Connection con = getCon.getConnection();

                    Statement statement_all = con.createStatement();

                    String sql_q = "select * from aid where aid_id='"+clicked_id+"'";
                    ResultSet res = statement_all.executeQuery(sql_q);

                    while(res.next()){

                        display_user_name_label.setText(res.getString("NAME"));
                        display_product_label.setText(res.getString("ITEM"));
                        description_text.setText(res.getString("DESCRIPTION"));
                        location_text.setText(res.getString("ADDRESS"));
                        mail_display.setText(res.getString("MAIL_ID"));
                        contact_number_display.setText(res.getString("MOBILE_NO"));
                        con.close();
                    }

                }
                catch(Exception vr){
                }
            }
        });
        
        pane = new JScrollPane(table);
        pane.setBackground(Color.WHITE);
        pane.setBounds(30,40,640,470);
 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        urgent_needs.add(pane);
        UrgentNeedsContent();
        add(urgent_needs);
    }
}
