package email;

import classroom.notifier.entity.Alumno;
import classroom.notifier.implement.MedioComunicacion;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class Email implements MedioComunicacion {
    public String name = "Email";
    @Override
    public void Notificar(String Materia, String Aula, List<Alumno> destinatarios) {
        String msj = "La materia: "+ Materia+" cambio a Aula -> "+ Aula;
        String subject = "Cambio de Aula de la materia->" + Materia;
        String dest = "fabian.mamani@hotmail.com";
        sendMail(dest, subject, msj);

    }

    public void sendMail(String to, String subject, String body){
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Correo enviado con éxito!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String getMedio() {
        return name;
    }
}
