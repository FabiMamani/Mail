
import classroom.notifier.implement.MedioComunicacion;
import email.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmailTest {
    public MedioComunicacion notificador;

    @Test
    public void EmailTest(){
        notificador = new Email();
        notificador.Notificar("Taller de Tesina","7075", null);
    }


}
