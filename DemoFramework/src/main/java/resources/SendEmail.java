package resources;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmail {

	public static void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("akhil.tomar@3pillarGlobal.com", "Password@123"));
		email.setSSLOnConnect(true);
		email.setFrom("akhil.tomar@3pillarGlobal.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("akhiltomar111@gmail.com");
		email.send();
	}

	
	
	
}
