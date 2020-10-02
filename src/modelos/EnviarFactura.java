package modelos;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnviarFactura {

    public void enviarFactura(String CorreoCliente,String idFactura) {
        final String username = "richardjreese501@gmail.com";
        final String password = "0989960567luis";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("richardjreese501@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(CorreoCliente));
            message.setSubject("Factura Electronica");
            message.setText("Muchas Gracias por su compra, adjunto su factura aqui.");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            Multipart multipart = new MimeMultipart();

            messageBodyPart = new MimeBodyPart();
            String file = "C:/temporal/factura"+idFactura+".pdf";
            String fileName = "factura"+idFactura+".pdf";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            System.out.println("Sending");

            Transport.send(message);

            JOptionPane.showMessageDialog(null,"Done");

        } catch (MessagingException e) {
            System.err.println("Error al enviar factura "+e);
        }
    }
}
