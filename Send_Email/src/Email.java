import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;

public class Email {

	public int send(String to, String from, String subject, String text) {
		
		//Properties properties = new Properties();
		
//		properties.put("mail.smtp.auth", true);
//		properties.put("mail.smtp.starttls", true);
//		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");


		String username = "lakshyamsli";
		String password = "pcke rzsb smkq voat";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(text);
			Transport.send(message);
			return 1;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
