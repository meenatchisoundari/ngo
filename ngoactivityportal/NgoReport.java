package ngoactivityportal;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public  class NgoReport extends JFrame {
    
    JScrollPane sp;
    static JPanel MyPanel = new JPanel();
    static JPanel health=new JPanel();
    static JPanel education=new JPanel();
    static JPanel food=new JPanel();
    static JPanel others=new JPanel();
    static JPanel image_panel;
    JTree jt;
    int i=0;
    static Connection con=GetConnection.getConnection();
    JPanel tree_panel=new JPanel();
    
    NgoReport(){

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setSize(1300,700);
//        setLayout(null);

        ImageIcon images[];
        image_panel=new JPanel();
        image_panel.setLayout(null);
        image_panel.setVisible(true);
        image_panel.setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("REPORT - WE FOR YOU");
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setBounds(300,10,400,100);
        heading.setHorizontalAlignment(JLabel.CENTER);
        image_panel.add(heading);
        
        JButton back=new JButton("<<<");
        JButton front=new JButton(">>>");
        back.setBounds(10,250,90,50);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        
        image_panel.add(back);
        front.setBounds(920,250,90,50);
        front.setBackground(Color.WHITE);
        front.setForeground(Color.BLACK);
        image_panel.add(front);

        images = new ImageIcon[4];
        images[0] = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/slider1.jpg");
        images[1] = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/slider2.jpg");
        images[2] = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/slider3.jpg");
        images[3] = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/slider4.jpg");

        JLabel slide_image1 = new JLabel(images[0]);
        slide_image1.setBounds(15,100,1000,400);
        image_panel.add(slide_image1);

        front.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i==images.length-1)
                {
                }
                else
                {
                   i=i+1;
                   slide_image1.setIcon(images[i]);
                }
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i==0)
                {
                }
                else
                {
                    i=i-1;
                    slide_image1.setIcon(images[i]);
                }
            }
        });

        image_panel.setBounds(320,10,1000,1700);
        MyPanel.add(image_panel);

        tree_panel=new JPanel();
        tree_panel.setLayout(null);
        tree_panel.setBounds(100,10,150,300);
        tree_panel.setPreferredSize(new Dimension(150,300));
        tree_panel.setBackground(Color.red);
        MyPanel.setBounds(0,50,1400,550);
        DefaultMutableTreeNode report=new DefaultMutableTreeNode("REPORTS");  
        DefaultMutableTreeNode health_r=new DefaultMutableTreeNode("HEALTH");  
        DefaultMutableTreeNode education_r=new DefaultMutableTreeNode("EDUCATION"); 
        DefaultMutableTreeNode food_r=new DefaultMutableTreeNode("FOOD");
        DefaultMutableTreeNode other_r=new DefaultMutableTreeNode("OTHER SECTORS");
        report.add(health_r);  
        report.add(education_r); 
        report.add(food_r);
        report.add(other_r);

        jt=new JTree(report);
        jt.setSize(700,700);
        jt.setRowHeight(50);
        jt.setOpaque(true);

        tree_panel.add(jt);


        jt.addTreeSelectionListener(new TreeSelectionListener() {
          public void valueChanged(TreeSelectionEvent e) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();
                if (node == report) 
                    image_panel.setVisible(true);
                if(node==health_r)
                {
                    image_panel.setVisible(false);
                    education.setVisible(false);
                    food.setVisible(false);
                    others.setVisible(false);
                    showHealthSector();
                }
                else if(node==education_r)
                {
                    image_panel.setVisible(false);
                    health.setVisible(false);
                    food.setVisible(false);
                    others.setVisible(false);
                    showEducationSector();
                }
                else if(node==food_r)
                {
                    image_panel.setVisible(false);
                    health.setVisible(false);
                    education.setVisible(false);
                    others.setVisible(false);
                    showFoodSector();
                }
                else if(node==other_r)
                {
                    image_panel.setVisible(false);
                    health.setVisible(false);
                    food.setVisible(false);
                    education.setVisible(false);
                    showOtherSectors();
                }
            }
        });
        
        MyPanel.setLayout(null);
        MyPanel.add(tree_panel);
        MyPanel.setBounds(30,50,600,400);
        MyPanel.setPreferredSize(new Dimension(400,1500));;
        MyPanel.setVisible(true); 
        MyPanel.setBackground(Color.WHITE);

        add(MyPanel);
        MyPanel.add(tree_panel);

        sp=new JScrollPane(MyPanel);
        sp.setVisible(true);
        sp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, false));
        sp.setBounds(2,52,1365,540);
        sp.setBackground(Color.WHITE);
        add(sp);

        MyPanel.setVisible(true);
        setVisible(false);

    }
    public static void showHealthSector(){

        MyPanel.add(health);
        health.setLayout(null);
        health.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        health.setBounds(300,10,1000,1700);
        health.setBackground(Color.WHITE);
        JLabel heading=new JLabel("\"HE WHO HAS HEALTH HAS HOPE;AND HE WHO HAS HOPE HAS EVERYTHING\" ");
        heading.setFont(new Font("Serif",Font.BOLD,20));
        heading.setBounds(75,10,800,100);
        heading.setHorizontalAlignment(JLabel.CENTER);
        health.add(heading);
        String text="         Urban slum dwellers suffer from adverse health conditions owing to mainly two reasons –first the lack of education and thus lack of awareness; and second the unwillingness to lose a day’s wage in order to reach the nearest medical facility. Healthcare for underprivileged, which is a desperate need, thus remains unaddressed.The need of the hour is thus a two pronged approach – first to bring quality healthcare services to doorsteps of the needy and second to promote healthcare awareness and contemporary healthcare seeking behavior among the underprivileged.In such a scenario a mobile healthcare services delivery system is the most practical mechanism. And in subscription to this view, WE FOR YOU foundation has initiated the Smile on Wheels programme. This is a unique mobile hospital programme that seeks to address problems of mobility, accessibility and availability of primary healthcare with a special focus on children and women, in urban slums and remote rural areas.The Smile Foundation on Wheels programme has so far provided free healthcare services to more than 15,41,000 children and families.";
        JTextArea body=new JTextArea(text);
        body.setBackground(Color.WHITE);
        body.setEditable(false);
        body.setLineWrap(true);
        body.setWrapStyleWord(true);
        body.setColumns(30);
        body.setRows(10);
        body.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        body.setBounds(50,100,900,200); 
        health.add(body);

        ImageIcon health1 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/healthcampaign1.jpg");
        JLabel image1 = new JLabel(health1);
        image1.setBounds(50,250,400,400);
        health.add(image1);
        ImageIcon health2 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/healthcampaign2.jpg");
        JLabel image2 = new JLabel(health2);
        image2.setBounds(300,250,400,400);
        health.add(image2);
        ImageIcon health3= new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/healthcampaign3.jpg");
        JLabel image3 = new JLabel(health3);
        image3.setBounds(550,250,400,400);
        health.add(image3);
        JLabel subheading=new JLabel("DETAILS");
        subheading.setFont(new Font("Serif",Font.BOLD,25));
        subheading.setBounds(450,500,800,200);
        health.add(subheading);
        JPanel table_panel=new JPanel();
        JTable table;
        table_panel.setBounds(200,700,600,400);
        table_panel.setBackground(Color.WHITE);
        int fund_health=0;
        try{
            con=GetConnection.getConnection(); 
            con.commit();
            String query_sum="SELECT SUM(amount) FROM donation WHERE SECTOR=?";
            PreparedStatement st=con.prepareStatement(query_sum);
            st.setString(1,"HEALTH");
            ResultSet rs_sum=st.executeQuery();
            while (rs_sum.next()) {
               int c = rs_sum.getInt(1);
               fund_health = fund_health+ c;
            }
            JLabel funds_raised=new JLabel("TOTAL FUNDS RAISED:"+fund_health);
            funds_raised.setFont(new Font("Serif",Font.BOLD,25));
            funds_raised.setBounds(350,550,800,200);
            health.add(funds_raised);
            Statement state=con.createStatement();
            String query = "Truncate table REPORT";
            state.execute(query);
            CallableStatement stmt=con.prepareCall("{call getReport(?)}");
            stmt.setString(1,"HEALTH");  
            stmt.execute(); 
            con.commit();
            String q="SELECT * FROM Report";
            Statement stmt1=con.createStatement();
            ResultSet rs=stmt1.executeQuery(q);
            con.setAutoCommit(true);
            con.commit();
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
                data[k][j++]=rs.getString("CAMPAIGN_NAME");
                data[k][j++]=rs.getString("START_DATE");
                data[k][j++]=rs.getString("END_DATE");
                data[k++][j++]=rs.getString("SECTOR");
            }
            String ro[]={"CAMPAIGN_NAME","START_DATE","END_DATE","SECTOR"};
            con.commit();
            table=new JTable(data,ro);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setFillsViewportHeight(true);                   
            table_panel.add(new JScrollPane(table));
        }
        catch(Exception e)
        {
           
        }

        health.add(table_panel);
        health.setVisible(true);
    }
    public static void showEducationSector(){
        MyPanel.add(education);
        education.setLayout(null);
        education.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        education.setBounds(300,10,1000,1700);
        education.setBackground(Color.WHITE);
        JLabel heading=new JLabel("\"Every Child In School\"".toUpperCase());
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setBounds(150,10,800,100);
        heading.setHorizontalAlignment(JLabel.CENTER);
        education.add(heading);
        String text="    WE FOR YOU Foundation's educational initiatives include Pre-school [3-6 yrs], Non Formal Education [6-14 yrs non-school going], Remedial Education [6-14 yrs school going] and Bridge Course [14-18 yrs drop-outs]. It is an education NGOM which works for education for underprivileged children who are under difficult circumstances, such as child labour, children of poorest of the parents, children inflicted and affected with HIV/AIDS, street and runaway children, children with rare disabilities, disaster struck children and slum children. Special emphasis is given on girl education and women education, so that they and their families get empowered.";
        JTextArea body=new JTextArea(text);
        body.setBackground(Color.WHITE);
        body.setEditable(false);
        body.setLineWrap(true);
        body.setWrapStyleWord(true);
        body.setColumns(30);
        body.setRows(10);
        body.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        body.setBounds(50,100,900,110); 
        education.add(body);

        ImageIcon education1 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/education1.jpg");
        JLabel edu_image1 = new JLabel(education1);
        edu_image1.setBounds(50,150,400,400);
        education.add(edu_image1);
        ImageIcon education2 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/education2.jpg");
        JLabel edu_image2 = new JLabel(education2);
        edu_image2.setBounds(300,150,400,400);
        education.add(edu_image2);
        ImageIcon education3= new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/education3.jpg");
        JLabel edu_image3 = new JLabel(education3);
        edu_image3.setBounds(550,150,400,400);
        education.add(edu_image3);
        JPanel table_panel=new JPanel();
        table_panel.setBounds(200,450,600,400);
        table_panel.setBackground(Color.WHITE);
        JLabel subheading=new JLabel("DETAILS");
        subheading.setFont(new Font("Serif",Font.BOLD,25));
        subheading.setBounds(450,400,800,200);
        education.add(subheading);
        JTable table_education;
        table_panel.setBounds(200,600,600,400);
        table_panel.setBackground(Color.WHITE);

        int fund_education=0;
        try{
            con=GetConnection.getConnection();
            con.commit();
            String query_sum="SELECT SUM(amount) FROM donation WHERE SECTOR=?";
            PreparedStatement st=con.prepareStatement(query_sum);
            st.setString(1,"EDUCATION");
            ResultSet rs_sum=st.executeQuery();
            while (rs_sum.next()) {
               int c = rs_sum.getInt(1);
               fund_education = fund_education+ c;
            }
            JLabel funds_raised=new JLabel("TOTAL FUNDS RAISED:"+fund_education);
            funds_raised.setFont(new Font("Serif",Font.BOLD,25));
            funds_raised.setBounds(350,450,800,200);
            education.add(funds_raised);     
            con.commit();
            Statement state=con.createStatement();
            String query = "Truncate table REPORT";
            state.execute(query);
            CallableStatement stmt=con.prepareCall("{call getReport(?)}");
            stmt.setString(1,"EDUCATION");  
            stmt.execute(); 
            con.commit();
            String query_view="SELECT * FROM Report";
            Statement stmt1=con.createStatement();
            ResultSet rs=stmt1.executeQuery(query_view);
            con.setAutoCommit(true);
            con.commit();
            int i=0;
            while(rs.next())
            {
                i++;
            }
            rs=stmt1.executeQuery(query_view);
            String data[][]=new String[i][4];
            int k=0;
            while(rs.next())
                {
                    int j=0;
                    data[k][j++]=rs.getString("CAMPAIGN_NAME");
                    data[k][j++]=rs.getString("START_DATE");
                    data[k][j++]=rs.getString("END_DATE");
                    data[k++][j++]=rs.getString("SECTOR");
                }
            String ro[]={"CAMPAIGN_NAME","START_DATE","END_DATE","SECTOR"};
            con.commit();
            table_education=new JTable(data,ro);
            table_education.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table_education.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table_education.setFillsViewportHeight(true);                   
            table_panel.add(new JScrollPane(table_education));
        }
        catch(Exception e)
        {
            
        }
        education.add(table_panel);
        education.setVisible(true);
    }
    public static void showFoodSector(){
        MyPanel.add(food);
        food.setLayout(null);
        food.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        food.setBounds(300,10,1000,1700);
        food.setBackground(Color.WHITE);
        JLabel heading=new JLabel("\"If You Cant't Feed Hundred,Then Just Feed One\" ".toUpperCase());
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setBounds(150,10,800,100);
        heading.setHorizontalAlignment(JLabel.CENTER);
        food.add(heading);
        String text="    The Food for People (FFP) program provides nutritious meals, clean water, and educational opportunitiesto impoverished communities. Since WE FOR YOU Foundation (TPRF) opened its first Food for People facility in 2006, the signature program has provided clean water and more than 3 million healthy meals to children and elderly adults in poverty-stricken areas of India, Ghana, and Nepal. Health has improved, school enrollment and achievement have skyrocketed, crime has dropped, and local economies have started to bloom.";
        JTextArea body=new JTextArea(text);
        body.setBackground(Color.WHITE);
        body.setEditable(false);
        body.setLineWrap(true);
        body.setWrapStyleWord(true);
        body.setColumns(30);
        body.setRows(10);
        body.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        body.setBounds(50,100,900,110); 
        food.add(body);

        ImageIcon food1 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/food1.jpg");
        JLabel food_image1 = new JLabel(food1);
        food_image1.setBounds(50,120,400,400);
        food.add(food_image1);
        ImageIcon food2 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/food2.jpg");
        JLabel food_image2 = new JLabel(food2);
        food_image2.setBounds(300,120,400,400);
        food.add(food_image2);
        ImageIcon food3= new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/food3.jpg");
        JLabel food_image3 = new JLabel(food3);
        food_image3.setBounds(550,120,400,400);
        food.add(food_image3);
        JLabel subheading=new JLabel("DETAILS");
        subheading.setFont(new Font("Serif",Font.BOLD,25));
        subheading.setBounds(450,380,800,200);
        food.add(subheading);
        JPanel table_panel=new JPanel();
        JTable table_food;
        table_panel.setBounds(200,550,600,400);
        table_panel.setBackground(Color.WHITE);
        int fund_food=0;
        try{
            con=GetConnection.getConnection(); 
            con.commit();
            String query_sum="SELECT SUM(amount) FROM donation WHERE SECTOR=?";
            PreparedStatement st=con.prepareStatement(query_sum);
            st.setString(1,"FOOD");
            ResultSet rs_sum=st.executeQuery();
            while (rs_sum.next()) {
              int c = rs_sum.getInt(1);
              fund_food = fund_food+ c;
            }
            JLabel funds_raised=new JLabel("TOTAL FUNDS RAISED:"+fund_food);
            funds_raised.setFont(new Font("Serif",Font.BOLD,25));
            funds_raised.setBounds(350,420,800,200);
            food.add(funds_raised);     
            Statement state=con.createStatement();
            String query = "Truncate table REPORT";
            state.execute(query);
            CallableStatement stmt=con.prepareCall("{call getReport(?)}");
            stmt.setString(1,"FOOD");  
            stmt.execute(); 
            con.commit();
            String q="SELECT * FROM Report";
            Statement stmt1=con.createStatement();
            ResultSet rs=stmt1.executeQuery(q);
            con.setAutoCommit(true);
            con.commit();
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
                data[k][j++]=rs.getString("CAMPAIGN_NAME");
                data[k][j++]=rs.getString("START_DATE");
                data[k][j++]=rs.getString("END_DATE");
                data[k++][j++]=rs.getString("SECTOR");
            }
            String ro[]={"CAMPAIGN_NAME","START_DATE","END_DATE","SECTOR"};
            con.commit();
            table_food=new JTable(data,ro);
            table_food.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table_food.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table_food.setFillsViewportHeight(true);                   
            table_panel.add(new JScrollPane(table_food));
        }
        catch(Exception e)
        {
        }
        food.add(table_panel);
        food.setVisible(true);
    }
    public static void showOtherSectors(){
        MyPanel.add(others);
        others.setLayout(null);
        others.setBorder(BorderFactory.createLineBorder(new Color(224,224,224), 1, false));
        others.setBounds(300,10,1000,1700);
        others.setBackground(Color.WHITE);
        JLabel heading=new JLabel("Bounty always receives part of its value from the manner in which it is bestowed.");
        heading.setFont(new Font("Serif",Font.BOLD,25));
        heading.setBounds(90,10,900,100);
        heading.setHorizontalAlignment(JLabel.CENTER);
        others.add(heading);
        String text="    Smile Foundation's educational initiatives include Pre-school [3-6 yrs], Non Formal Education [6-14 yrs non-school going], Remedial Education [6-14 yrs school going] and Bridge Course [14-18 yrs drop-outs]. It is an education NGOM which works for education for underprivileged children who are under difficult circumstances, such as child labour, children of poorest of the parents, children inflicted and affected with HIV/AIDS, street and runaway children, children with rare disabilities, disaster struck children and slum children. Special emphasis is given on girl education and women education, so that they and their families get empowered.";
        JTextArea body=new JTextArea(text);
        body.setBackground(Color.WHITE);
        body.setEditable(false);
        body.setLineWrap(true);
        body.setWrapStyleWord(true);
        body.setColumns(30);
        body.setRows(10);
        body.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,16));
        body.setBounds(50,100,900,110); 
        others.add(body);

        ImageIcon others1 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/others1.jpg");
        JLabel others_image1 = new JLabel(others1);
        others_image1.setBounds(-100,60,600,600);
        others.add(others_image1);


        ImageIcon others2 = new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/others2.jpg");
        JLabel others_image2 = new JLabel(others2);
        others_image2.setBounds(200,60,600,600);
        others.add(others_image2);


        ImageIcon others3= new ImageIcon("C:/Users/ELCOT/Documents/NetBeansProjects/ngoactivityportal/src/ngoactivityportal/img/others3.jpg");
        JLabel others_image3 = new JLabel(others3);
        others_image3.setBounds(500,60,600,600);

        JLabel subheading=new JLabel("DETAILS");
        subheading.setFont(new Font("Serif",Font.BOLD,25));
        subheading.setBounds(450,430,800,200);
        others.add(subheading);
        JPanel table_panel=new JPanel();
        JTable table_others;
        table_panel.setBounds(200,600,600,400);
        table_panel.setBackground(Color.WHITE);
        int fund_others=0;
        try{
            con=GetConnection.getConnection(); 
            con.commit();
            String query_sum="SELECT SUM(amount) FROM donation WHERE SECTOR=?";
            PreparedStatement st=con.prepareStatement(query_sum);
            st.setString(1,"OTHERS");
            ResultSet rs_sum=st.executeQuery();
            while (rs_sum.next()) {
               int c = rs_sum.getInt(1);
               fund_others = fund_others+ c;
            }

            JLabel funds_raised=new JLabel("TOTAL FUNDS RAISED:"+fund_others);
            funds_raised.setFont(new Font("Serif",Font.BOLD,25));
            funds_raised.setBounds(350,470,800,200);
            others.add(funds_raised);     
            Statement state=con.createStatement();
            String query = "Truncate table REPORT";
            state.execute(query);
            CallableStatement stmt=con.prepareCall("{call getReport(?)}");
            stmt.setString(1,"OTHERS");  
            stmt.execute(); 
            con.commit();
            String q="SELECT * FROM Report";
            Statement stmt1=con.createStatement();
            ResultSet rs=stmt1.executeQuery(q);
            con.setAutoCommit(true);
            con.commit();
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
               data[k][j++]=rs.getString("CAMPAIGN_NAME");
               data[k][j++]=rs.getString("START_DATE");
               data[k][j++]=rs.getString("END_DATE");
               data[k++][j++]=rs.getString("SECTOR");
            }
            String ro[]={"CAMPAIGN_NAME","START_DATE","END_DATE","SECTOR"};
            con.commit();
            table_others=new JTable(data,ro);
            table_others.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            table_others.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table_others.setFillsViewportHeight(true);                   
            table_panel.add(new JScrollPane(table_others));
        }
        catch(Exception e)
        {
            
        }
        others.add(table_panel);
        others.add(others_image3);
        others.setVisible(true);
    }

//    public static void main(String args[]) {
//          new NgoReport();
//    }
}

    
    

    
