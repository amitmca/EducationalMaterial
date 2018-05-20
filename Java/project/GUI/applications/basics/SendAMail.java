package applications.basics;

/**
   This is a test and ist sends an E-Mail

**/

import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;
import javax.mail.internet.*;

public class SendAMail {


  String from = null;
  public void    setFrom(String v) { from = v; }
  public String  getFrom() { return from; }


  String to = null;
  public void    setTo(String v) { to = v; }
  public String  getTo() { return to; }


  String cc = null;
  public void    setCc(String v) { cc = v; }
  public String  getCc() { return cc; }

  String bcc = null;
  public void    setBcc(String v) { bcc = v; }
  public String  getBcc() { return bcc; }

  
  String subject = null;
  public void    setSubject(String v) { subject = v; }
  public String  getSubject() { return subject; }

  String text = null;
  public void    setText(String v) { text = v; }
  public String  getText() { return text; }


  String mailhost = "localhost";
  public void   setMailhost(String v) { mailhost = v; }
  public String getMailHost() { return mailhost; }

  String mailer = "msgsend";
  public void   setMailer(String v) { mailer = v; }
  public String getMailer() { return mailer; }


  public String sendMail() {

        String wasOK = "Error";
	Properties props = System.getProperties();
	// XXX - could use Session.getTransport() and Transport.connect()
	// XXX - assume we're using SMTP
	if (mailhost != null)
	  props.put("mail.smtp.host", mailhost);

	// Get a Session object
	Session session = Session.getDefaultInstance(props, null);

	try {

	    // construct the message
	    Message msg = new MimeMessage(session);
	    if (getFrom() != null)
		msg.setFrom(new InternetAddress(getFrom()));
	    else
		msg.setFrom();

	    msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(getTo(), false));
	    if (getCc() != null)
		msg.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(getCc(), false));
	    if (getBcc() != null)
		msg.setRecipients(Message.RecipientType.BCC,
					InternetAddress.parse(getBcc(), false));

	    msg.setSubject(getSubject());
	    msg.setText(getText());
	    msg.setHeader("X-Mailer", getMailer());
	    msg.setSentDate(new Date());

	    // send the thing off
	    Transport.send(msg);
	    wasOK = "OK";

	} catch (Exception e) {
	    wasOK = e.getMessage();
	}


	    return wasOK;

  }



  public SendAMail() {

    // all parameters set by application

  }

  public SendAMail(String args[]) {

        boolean sendIt = false;
	int i = 0;

	while ( i < args.length) {

	    if (args[i].equals("-f")) {
		i++;
		setFrom(args[i]);
	    }
	    if (args[i].equals("-c")) {
		i++;
		setCc(args[i]);
	    }
	    if (args[i].equals("-r")) {
		i++;
		setTo(args[i]);
	    }
	    if (args[i].equals("-b")) {
		i++;
		setBcc(args[i]);
	    }
	    if (args[i].equals("-s")) {
		i++;
		setSubject(args[i]);
	    }
	    if (args[i].equals("-t")) {
		i++;
		setText(args[i]);
	    }
	    if (args[i].equals("-m")) {
		i++;
		setMailhost(args[i]);
	    }
	    if (args[i].equals("-h")) {
		System.out.println("Fredy's SendAMail\n" +
                                   "-----------------\n" +
				   "Syntaxt: -f from\n"  +
				   "         -c cc\n" +
				   "         -b bcc\n" +
				   "         -r receiver\n" +
				   "         -s subject\n" +
				   "         -t text\n" +
				   "         {-m mailhost |default=localhost}\n" +
				   "         -h this message\n" +
				   "         -x send this mail");
	    }
	    

	    if (args[i].equals("-x")) {
	      sendIt = true;
	    }
	    i++;
	}
	if (sendIt) sendMail();
  }

  public static void main(String args[]) {
    SendAMail s = new SendAMail(args);

  }
}
