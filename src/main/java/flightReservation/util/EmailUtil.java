package flightReservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender sender;
	
	
	
	public void sendItinerary(String to, String filePath) {
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(to);
			helper.setSubject("Flight itinerary");
			helper.setText("Please find your flight itinerary attached");
			helper.addAttachment("itinerary", new File(filePath));
			
		} catch (MessagingException e) {
		
			e.printStackTrace();
		}
		sender.send(message); 
	}
}
