package ngoactivityportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DonationAdmin extends JFrame
{
    Connection con;
    JScrollPane js;
    JTable table;
    JPanel table__panel,health;
    DefaultTableModel t_m;
    JButton remove;
    
    DonationAdmin(){
        
//  setExtendedState(JFrame.MAXIMIZED_BOTH);
//  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  setLocationRelativeTo(null);
//            setTitle("");
//	    setSize(1300,700);
//	    setLayout(null);

        health=new JPanel();
        health.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        health.setBounds(200,10,1000,1700);
        health.setBackground(Color. WHITE);
        table__panel=new JPanel();
        table__panel.setLayout(null);
        table__panel.setBounds(0,50,1400,700);
        table__panel.setBackground(Color.WHITE);
        try{
            con=GetConnection.getConnection(); 
            con.commit();
            String q="SELECT * FROM aid";
            Statement stmt1=con.createStatement();        
            ResultSet rs=stmt1.executeQuery(q);
            int i=0;
            while(rs.next())
            {
               i++;
            }
            rs=stmt1.executeQuery(q);
            String data[][]=new String[i][10];
            int k=0;
            while(rs.next())
            {
                int j=0;
                data[k][j++]=rs.getString("aid_id");
                data[k][j++]=rs.getString("name");
                data[k][j++]=rs.getString("mail_id");
                data[k][j++]=rs.getString("mobile_no");
                data[k][j++]=rs.getString("sector");
                data[k][j++]=rs.getString("item");
                data[k][j++]=rs.getString("district");
                data[k][j++]=rs.getString("description");
                data[k][j++]=rs.getString("address");
                data[k++][j++]=rs.getString("posted_date");
            }
            String ro[]={"Emp_Id","First_name","Last_name","DOB","Age","Mobile","Exp","City","Mail"};
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

        String message="Are you sure to delete?";
        String m="DELETE DETAILS";
        table.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                
                int index = table.getSelectedRow();
                TableModel model = table.getModel();
                try{
                    String clic = (String) model.getValueAt(index,0);
                    
                    int reply = JOptionPane.showConfirmDialog(null, message, m,JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {

                        con = GetConnection.getConnection();
                        
                        String sql_q = "Delete from aid where aid_id=?";
                        PreparedStatement pstmt=con.prepareStatement(sql_q);
                        pstmt.setString(1,clic);
                        pstmt.executeUpdate();
                        con.setAutoCommit(true);
                    }    
                }        
                catch(Exception vr){
                    System.out.println(vr);
                }
            }
        });
           
        health.add(new JScrollPane(table),BorderLayout.CENTER);
           
        table__panel.add(health);
           
//       add(table__panel);
//       setVisible(true);
    }
    
//    public static void main(String args[]){
//        new DonationAdmin();
//    }
}
