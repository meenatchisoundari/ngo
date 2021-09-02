package ngoactivityportal;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class DisplaySponsorDetails extends JFrame
{
    Connection con;
    JScrollPane js;
    JTable table;
    JPanel sponsor_panel,health;
    DefaultTableModel t_m;
    JButton remove;
    JLabel sponsor_label;

    DisplaySponsorDetails(){
        
//    setExtendedState(JFrame.MAXIMIZED_BOTH);
//    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    setLocationRelativeTo(null);
//    setTitle("");
//    setSize(1300,700);
//    setLayout(null);

        health=new JPanel();
        health.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        health.setBounds(200,10,1000,1700);
        health.setBackground(Color.WHITE);
        sponsor_panel=new JPanel();
        sponsor_panel.setLayout(null);
        sponsor_panel.setBounds(0,50,1370,550);
        sponsor_panel.setBackground(Color.WHITE);

        sponsor_label = new JLabel("SPONSORS");
        sponsor_label.setBounds(500,10,100,20);
        sponsor_label.setForeground(new Color(23,43,79));
        sponsor_label.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        health.add(sponsor_label);


        try{
            con=GetConnection.getConnection(); 
            con.commit();
            String q="SELECT * FROM sponsor";
            Statement stmt1=con.createStatement();
            ResultSet rs=stmt1.executeQuery(q);
            int i=0;
            while(rs.next())
            {
                i++;
            }

            rs=stmt1.executeQuery(q);
            String data[][]=new String[i][4];
            int k=0;
            while(rs.next())
            {
                int j=0;
                data[k][j++]=rs.getString("sponsor_name");
                data[k][j++]=rs.getString("contact_info");
                data[k][j++]=rs.getString("mail_id");
                data[k++][j++]=rs.getString("cause_for_donation");
            }
            String ro[]={"Sponser name","Contact Info","Mail ID","Cause for donation"};
            t_m=new DefaultTableModel(data,ro);
            table=new JTable(t_m);
          
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
             
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);   
        table.setPreferredScrollableViewportSize(new Dimension(1000,500));
        table.setBounds(100,100,1000,600);
       
       
        health.add(new JScrollPane(table),BorderLayout.CENTER);
        sponsor_panel.add(health);
            
        //add(sponsor_panel);
        
        setVisible(false);
    }
//    public static void main(String[] args){
//        new DisplaySponsorDetails();
//    }
}
