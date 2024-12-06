package email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

public class Email implements Observer {
    public String name = "Email";

    public void sendMail(String body){

        String subject = "Aviso de cambio de aula";
        String dest = "fabian.mamani@hotmail.com";

        final String username = "classroomnotifier3@gmail.com"; // tu correo
        final String password = "nnefcpfpsacpzxnb"; // tu contraseña
        //Grupo4.2024
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dest));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Correo enviado con éxito!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        sendMail(new String((String) arg));
    }
}
