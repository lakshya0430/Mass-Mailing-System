import java.util.ArrayList;

public class SendEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Email email = new Email();
		ArrayList<String> mails = DatabaseConnection.getMails(); 
		boolean allMailsSent = true;
		
		System.out.println(mails);
		while (!mails.isEmpty()) {
		    String receiver = mails.remove(0); 
		    String sender = "lakshyamsli@gmail.com";
		    String subject = "Demo";
		    String body = "This is sent by a java program";
		    System.out.println(receiver);
		    int result = email.send(receiver, sender, subject, body);
		    if (result == 0) {
		        allMailsSent = false;
		        System.err.println("Error sending mail to " + receiver);
		    }
		}

		if (allMailsSent) {
		    System.out.println("All mails sent successfully");
		} else {
		    System.err.println("Some mails were not sent successfully");
		}

	}

}
