package ngoactivityportal;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
    static String mail_to = new String();
    public void sendMail(){
        final String username = "meenuthulasi2000@gmail.com";
        final String password = "mee...msd16";

        final String from = "meenthulasi2000@gmail.com";

        final String to = mail_to;


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setSubject("Payment Successful");
            message.setText("Thank you for your support!");

            Transport.send(message);
        } catch (MessagingException e) {
                System.out.println(e);
        }
    }
    public SendMail(String user_mail){
        this.mail_to = user_mail;
        sendMail();

    }
//    public static void main(String[] args) {
//        new SendMail("meenuthulasi2000@gmail.com");
//
//    }
}