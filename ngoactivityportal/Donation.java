package ngoactivityportal;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public  class Donation extends JFrame implements ActionListener{
    
    JScrollPane donation_sp;
    JPanel donation_para_1,donation_get_data;
    JButton proceed_button,urgent_needs_btn;
    JComboBox select_sector;
    JPanel donation = new JPanel();
    JTextArea para_content;
    String causes[] = { " ","HEALTH","EDUCATION", "FOOD", "OTHERS"};


    Donation(){


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1300,700);
        setLayout(null);


        donation.setBackground(Color.WHITE);


        add(donation);
        donation.setLayout(null);
        donation.setBounds(30,50,900,400);
        donation.setPreferredSize(new Dimension(400,500));
        
        
        donation_para_1 = new JPanel();
        donation_get_data = new JPanel();
        
        donation.add(donation_para_1);
        donation.add(donation_get_data);

        urgent_needs_btn = new JButton("View urgent needs");
        urgent_needs_btn.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,18));
        urgent_needs_btn.setBounds(1150,0,200,30);
        urgent_needs_btn.addActionListener(this);
        urgent_needs_btn.setBackground(new Color(23,43,79));
        urgent_needs_btn.setForeground(Color.WHITE);
        donation.add(urgent_needs_btn);
        JLabel heading_donate=new JLabel("NO ONE HAS EVER BECOME POOR BY GIVING");
        heading_donate.setForeground(new Color(23,43,79));
        heading_donate.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        heading_donate.setBounds(70,10,600,100);
        donation_get_data.add(heading_donate);
        JTextArea body=new JTextArea("When courage, genius, and generosity hold hands, all things are possible.\n" +"–Unknown\n" +"\n" +"It is more rewarding to watch money change the world than to watch it accumulate.\n" +"–Gloria Steinem\n" +"\n" +"The greatest use of a life is to spend it on something that will outlast it.\n" +"–William James");
        body.setFont(new Font("Serif", Font.PLAIN, 14));
        body.setVisible(true);
        body.setLineWrap(true);
        body.setEditable(false);
        body.setColumns(50);
        body.setRows(10);
        body.setBounds(50,100,600,200);
        donation_get_data.add(body);
        JLabel cause = new JLabel("CHOOSE SECTOR");
        cause.setFont(new Font("Serif", Font.PLAIN, 25));
        cause.setBounds(200,310,250,20);
        donation_get_data.add(cause);

        select_sector = new JComboBox(causes);
        select_sector.setFont(new Font("Arial", Font.PLAIN, 14));
        select_sector.setBorder(BorderFactory.createLineBorder(new java.awt.Color(23,43,79)));
        select_sector.setBounds(220,350,150,30);
        donation_get_data.add(select_sector);

        proceed_button = new JButton("PROCEED");
        proceed_button.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 15));
        proceed_button.setBounds(220,390,150,30);
        proceed_button.setBackground(new Color(23,43,79));
        proceed_button.setForeground(Color.WHITE);
        proceed_button.addActionListener(this);
        donation_get_data.add(proceed_button);

        donation_para_1.setLayout(null);
        donation_para_1.setBackground(Color.WHITE);
        donation_get_data.setLayout(null);
        donation_get_data.setBackground(Color.WHITE);
        JLabel heading=new JLabel("YOUR HEALING BEGINS WITH CHARITY");
        heading.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
        heading.setBounds(80,10,400,100);
        heading.setForeground(new Color(23,43,79));
        heading.setHorizontalAlignment(JLabel.CENTER);
        donation_para_1.add(heading);
        para_content =new JTextArea("      WE FOR YOU has been working in India for 70 years, focusing on alleviating poverty and social exclusion among marginalised women and girls through 53 programmes on the ground, spanning 19 states and 90+districts. In 2019-20, we reached out to 50.4 million providing them with quality education, maternal and child health care services, sustainable livelihood opportunities, and relief and rehabilitation during natural disasters. Today we face an unprecedented crisis in India with the second wave of COVID-19 and WE FOR YOU is on the ground responding with setting up COVID Care facilities, providing medical consumables including oxygen generators and PPE kits to Frontline workers. We are leveraging our experience of responding to over 30 natural disasters in the last decade.\n" +
        "Saving lives is now our priority along side the development work which we continue to do among the community.\n" +
        "Your support is needed TODAY! To save lives and change lives forever.");  
        para_content.setBounds(0,100,600,300); 
        para_content.setFont(new Font("Serif", Font.PLAIN, 14));
        para_content.setLineWrap(true);
        para_content.setEditable(false);
        para_content.setWrapStyleWord(true);
        donation_para_1.add(para_content);

        donation_para_1.setBounds(20,30,600,500);
        donation_get_data.setBounds(650,50,700,500);

        donation_para_1.setPreferredSize(new Dimension(600,1200));
        donation_get_data.setPreferredSize(new Dimension(200,200));

        
        donation_sp = new JScrollPane(donation);
        donation_sp.setVisible(true);
        donation_sp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, false));
        donation_sp.setBounds(10,50,1370,550);
        
        //add(donation_sp);

        setVisible(false);
    }

//    public static void main(String args[]) {
//          new DonationF(); 
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object obj_source = e.getSource();
        if(obj_source==proceed_button){


            DonorData bean = new DonorData();

            String chosen_cause = (String) select_sector.getSelectedItem();
            if(chosen_cause.equals(" ")){
                JOptionPane.showMessageDialog(null,"Select sector");
            }
            else{
                
                bean.setSector(chosen_cause);
                Home.callGetDonorDetails(bean);
            }


        }
        if(obj_source==urgent_needs_btn){
            Home.callViewUrgentNeeds();
        }
    }
}