package ngoactivityportal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class Homepage extends JFrame {
	
    JScrollPane scroll;
    JPanel p3=new JPanel();
    JFrame frame = new JFrame();
    JLabel pic , pic1 , pic2;
    Timer tm,tm1,tm2;
    int x1=0 , x2=0,x3=0;
    String[] list= {
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background.jfif",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background1.jpg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background2.jpg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background3.jpg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background4.jpg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\Background5.jpg",
    };
    String[] list_award= {
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\aw1.jpeg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\aw2.jpeg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\aw3.jpeg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\aw4.jpeg"
    };
    String[] list_accredation= {
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\ac1.jpeg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\ac2.jpeg",
        "C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\ac3.jpeg"
    };

    Homepage(){

        p3.setPreferredSize(new Dimension(1300,2500));
        p3.setBounds(0,50,1290,2500);

//            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setLocationRelativeTo(null);
//            frame.setSize(1300,700);
//            frame.setVisible(false);
//            frame.setLayout(null);

        pic=new JLabel();
        pic.setBounds(600,70,700,400);
        setImageSize(5);
        tm= new Timer(2000,new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    setImageSize(x1);
                    x1=x1+1;
                    if(x1>=list.length)
                        x1=0;
                }
        });
        p3.add(pic);
        tm.start();

        JLabel label0=new JLabel("WE FOR YOU is to build an equitable");
        p3.add(label0);
        label0.setBounds(80,100,500,20);
        label0.setForeground(Color.black);
        label0.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l0=new JLabel("relationship of strength, sustenance");
        p3.add(l0);
        l0.setBounds(80,130,500,25);
        l0.setForeground(Color.black);
        l0.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l1=new JLabel("and dignity between the cities and");
        p3.add(l1);
        l1.setBounds(90,160,500,25);
        l1.setForeground(Color.black);
        l1.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l2=new JLabel("villages using the under-utilized");
        p3.add(l2);
        l2.setBounds(100,190,500,25);
        l2.setForeground(Color.black);
        l2.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l3=new JLabel("urban material as a tool to trigger");
        p3.add(l3);
        l3.setBounds(90,220,500,25);
        l3.setForeground(Color.black);
        l3.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l4=new JLabel("development with dignity, across the  ");
        p3.add(l4);
        l4.setBounds(70,250,500,25);
        l4.setForeground(Color.black);
        l4.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel l5=new JLabel("STATES.");
        p3.add(l5);
        l5.setBounds(240,280,500,25);
        l5.setForeground(Color.black);
        l5.setFont(new Font("Verdana", Font.BOLD, 20));

        JLabel symbol=new JLabel();
        p3.add(symbol);
        symbol.setBounds(190,300,180,150);
        ImageIcon icon_symbol = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\winner.jfif");
        Image img_symbol=icon_symbol.getImage();
        Image newImg_symbol=img_symbol.getScaledInstance(symbol.getWidth(), symbol.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_symbol=new ImageIcon(newImg_symbol);
        symbol.setIcon(newImc_symbol);

        JPanel sec=new JPanel();
        p3.add(sec);
        sec.setBounds(50,70,500,400);
        sec.setBackground(Color.white);
        sec.setBorder(BorderFactory.createLineBorder(Color.black));


        JPanel information=new JPanel();
        p3.add(information);
        information.setBounds(0,50,1370,440);
        information.setBackground(Color.white);

        JSeparator s1=new JSeparator();
        p3.add(s1);
        s1.setBounds(0,600,1400,3);
        s1.setBackground(Color.white);

        JLabel label1=new JLabel("YOU CAN DONATE FOR");
        p3.add(label1);
        label1.setBounds(550,620,620,47);
        label1.setForeground(Color.black);
        label1.setFont(new Font("Verdana", Font.BOLD, 20));

        JPanel donation=new JPanel();
        p3.add(donation);
        donation.setBounds(360,603,620,47);
        donation.setBackground(Color.white);

        JLabel education=new JLabel();
        p3.add(education);
        education.setBounds(40,670,300,260);
        ImageIcon icon_edu = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\edu.jpeg");
        Image img_edu=icon_edu.getImage();
        Image newImg_edu=img_edu.getScaledInstance(education.getWidth(), education.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_edu=new ImageIcon(newImg_edu);
        education.setIcon(newImc_edu);
        education.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel food=new JLabel();
        p3.add(food);
        food.setBounds(360,670,300,260);
        ImageIcon icon_food = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\food.jpeg");
        Image img_food=icon_food.getImage();
        Image newImg_food=img_food.getScaledInstance(food.getWidth(), food.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_food=new ImageIcon(newImg_food);
        food.setIcon(newImc_food);
        food.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel health=new JLabel();
        p3.add(health);
        health.setBounds(680,670,300,260);
        ImageIcon icon_health = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\health.jpeg");
        Image img_health=icon_health.getImage();
        Image newImg_health=img_health.getScaledInstance(health.getWidth(), health.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_health=new ImageIcon(newImg_health);
        health.setIcon(newImc_health);
        health.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel other=new JLabel();
        p3.add(other);
        other.setBounds(1000,670,300,260);
        ImageIcon icon_other = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\other.jpeg");
        Image img_other=icon_other.getImage();
        Image newImg_other=img_other.getScaledInstance(other.getWidth(), other.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_other=new ImageIcon(newImg_other);
        other.setIcon(newImc_other);
        other.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel d2=new JPanel();
        p3.add(d2);
        d2.setBounds(360,670,300,260);
        d2.setBackground(Color.white);
        d2.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel d3=new JPanel();
        p3.add(d3);
        d3.setBounds(680,670,300,260);
        d3.setBackground(Color.white);
        d3.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel d4=new JPanel();
        p3.add(d4);
        d4.setBounds(1000,670,300,260);
        d4.setBackground(Color.white);
        d4.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel sector=new JPanel();
        p3.add(sector);
        sector.setBounds(20,650,1300,200);
        sector.setBackground(Color.white);

        JSeparator s2=new JSeparator();
        p3.add(s2);
        s2.setBounds(0,950,1400,3);
        s2.setBackground(Color.white);

        JLabel our_reach=new JLabel("OUR REACH");
        p3.add(our_reach);
        our_reach.setBounds(80,1130,1000,40);
        our_reach.setFont(new Font("Verdana", Font.BOLD, 50));
        our_reach.setForeground(Color.BLACK);

        JLabel on_reach=new JLabel("35+       400+    4000+");
        p3.add(on_reach);
        on_reach.setBounds(300,1240,1000,40);
        on_reach.setFont(new Font("Verdana", Font.BOLD, 38));
        on_reach.setForeground(Color.WHITE);

        JLabel reach=new JLabel("campaign   Projects   Villages and slums");
        p3.add(reach);
        reach.setBounds(300,1300,1000,40);
        reach.setFont(new Font("Verdana", Font.BOLD, 28));
        reach.setForeground(Color.WHITE);

        JPanel reach1=new JPanel();
        p3.add(reach1);
        reach1.setBounds(20,1020,1020,460);
        reach1.setBackground(new java.awt.Color(0,0,0,80));
        JLabel d5=new JLabel();

        p3.add(d5);
        d5.setBounds(0,1000,1000,500);
        ImageIcon icond5 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\reachour.jpg");
        Image imgb5=icond5.getImage();
        Image newImgb5=imgb5.getScaledInstance(d5.getWidth(), d5.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImcb5=new ImageIcon(newImgb5);
        d5.setIcon(newImcb5);


        JLabel d6=new JLabel();
        p3.add(d6);
        d6.setBounds(1000,1000,400,500);
        ImageIcon icond6 = new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\ngoactivityportal\\src\\ngoactivityportal\\img\\tamilnadu.jpg");
        Image imgb6=icond6.getImage();
        Image newImgb6=imgb6.getScaledInstance(d6.getWidth(), d6.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImcb6=new ImageIcon(newImgb6);
        d6.setIcon(newImcb6);

        JSeparator s3=new JSeparator();
        p3.add(s3);
        s3.setBounds(0,1550,1400,3);
        s3.setBackground(Color.white);

        pic1=new JLabel();
        p3.add(pic1);
        pic1.setBounds(150 , 1600 , 500 , 400);
        pic1.setBorder(BorderFactory.createLineBorder(Color.black));
        setImageSizeAccredation(2);
        tm1= new Timer(2000,new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    setImageSizeAccredation(x2);
                    x2=x2+1;
                    if(x2>=list_accredation.length)
                        x2=0;				
                }			
        });		
        tm1.start();

        pic2=new JLabel();
        pic2.setBounds(700,1600,500,400);
        pic2.setBorder(BorderFactory.createLineBorder(Color.black));
        setImageSizeAward(3);		
        tm2= new Timer(2000,new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    setImageSizeAward(x3);
                    x3=x3+1;
                    if(x3>=list_award.length)
                        x3=0;				
                }			
        });
        p3.add(pic2);
        tm2.start();

        JPanel award=new JPanel();
        p3.add(award);
        award.setBounds(150,1600,500,400);
        award.setBackground(new java.awt.Color(0,0,0,80));
        award.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel accredation=new JPanel();
        p3.add(accredation);
        accredation.setBounds(700,1600,500,400);
        accredation.setBackground(new java.awt.Color(0,0,0,80));
        accredation.setBorder(BorderFactory.createLineBorder(Color.black));

        JLabel label2=new JLabel("ACCREDIATIONS");
        p3.add(label2);
        label2.setBounds(270,2000,1000,40);
        label2.setFont(new Font("Verdana", Font.BOLD, 30));
        label2.setForeground(Color.BLACK);


        JLabel label3=new JLabel("AWARDS");
        p3.add(label3);
        label3.setBounds(870,2000,1000,40);
        label3.setFont(new Font("Verdana", Font.BOLD, 30));
        label3.setForeground(Color.BLACK);


        JSeparator s4=new JSeparator();
        p3.add(s4);
        s4.setBounds(0,2100,1400,3);
        s4.setBackground(Color.white);

        JLabel label4=new JLabel("ITS NOT HOW MUCH WE GIVE BUT");
        p3.add(label4);
        label4.setBounds(400,2200,1300,100);
        label4.setFont(new Font("Verdana", Font.BOLD, 30));
        label4.setForeground(Color.WHITE);

        JLabel label5=new JLabel("HOW MUCH LOVE WE PUT INTO GIVING");
        p3.add(label5);
        label5.setBounds(340,2250,1300,100);
        label5.setFont(new Font("Verdana", Font.BOLD, 30));
        label5.setForeground(Color.WHITE);

        JLabel label6=new JLabel("-MOTHER TERESA");
        p3.add(label6);
        label6.setBounds(1000,2300,1300,100);
        label6.setFont(new Font("Verdana", Font.BOLD, 20));
        label6.setForeground(Color.BLACK);

        JPanel quotes=new JPanel();
        p3.add(quotes);
        quotes.setBounds(50,2200,1250,200);
        quotes.setBackground(new java.awt.Color(0,0,0,80));
        quotes.setBorder(BorderFactory.createLineBorder(Color.black));

        p3.setLayout(null);
        p3.setBackground(Color.WHITE);
        /*JLabel background=new JLabel();
        p3.add(background);
        background.setBounds(10,0,1360,2500);
        ImageIcon icon_background = new ImageIcon("C:/Users/A MAHALAKSHMI/Desktop/pink.jfif");
        Image img_background=icon_background.getImage();
        Image newImg_background=img_background.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc_background=new ImageIcon(newImg_background);
        background.setIcon(newImc_background);*/

        scroll = new JScrollPane(p3);
        scroll.setVisible(true);
        frame.add(scroll);
        scroll.setBounds(10,50,1350,550);
    }

    public void setImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img=icon.getImage();
        Image newImg=img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc=new ImageIcon(newImg);
        pic.setIcon(newImc);
    }

    public void setImageSizeAward(int i) {
        ImageIcon icon = new ImageIcon(list_award[i]);
        Image img=icon.getImage();
        Image newImg=img.getScaledInstance(pic2.getWidth(), pic2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc=new ImageIcon(newImg);
        pic2.setIcon(newImc);
    }

    public void setImageSizeAccredation(int i) {
        ImageIcon icon = new ImageIcon(list_accredation[i]);
        Image img=icon.getImage();
        Image newImg=img.getScaledInstance(pic1.getWidth(), pic1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc=new ImageIcon(newImg);
        pic1.setIcon(newImc);
    }

//    public static void main(String args[]) {
//            new Homepage();
//    }
}