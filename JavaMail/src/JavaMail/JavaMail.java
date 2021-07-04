package JavaMail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public static void main(String[] args) {
		String seuEmail = ""; //digite seu email
		String suaSenha = ""; //digite sua senha de acesso
		
		//dados de validação do provedor
		Properties props = new Properties();
         props.put("mail.transport.protocol", "smtp");
         props.put("mail.smtp.host", "smtp.live.com");
         props.put("mail.smtp.socketFactory.port", "587");
         props.put("mail.smtp.socketFactory.fallback", "false");
         props.put("mail.smtp.starttls.enable", "true");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "587");

		    Session session = Session.getDefaultInstance(props,
		      new javax.mail.Authenticator() {
		           protected PasswordAuthentication getPasswordAuthentication()
		           {
		                 return new PasswordAuthentication(seuEmail, suaSenha);
		           }
		      });
		    session.setDebug(true);

		    //Bloco TryCatch para tratarmos em caso de erro !
		    try {
		      Message message = new MimeMessage(session);

		      //Email do remetente
		      message.setFrom(new InternetAddress("educaciencia-fastcode@outlook.com"));
		      
		      //Email do Destinatario - vetor 
		      Address[] toUser = InternetAddress //Destinatário(s)
		                 .parse("educaciencia-fastcode@outlook.com");
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      
		      //Assunto do email
		      message.setSubject("Artigo EducaCiencia Fast Code JavaMail");
		      
		      //Assunto no corpo do email
		      message.setText("Teste de envio de email pelo JavaMail!");
		      
		      //enviar mensagem
		      Transport.send(message);

		      //Para imprimir no console em caso de sucesso
		      System.out.println("Artigo EducaCiencia Fast Code JavaMail - enviado !!!");

		     } catch (MessagingException e) {
		      System.err.println("Ocorreu erro no processo !");
		        throw new RuntimeException("Ocorreu erro : " + e);
		    }
		  }
		}
