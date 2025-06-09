

import classroom.notifier.interfaces.Observer;
import notificadores.Email;
import org.junit.jupiter.api.Test;



public class EmailTest {

    @Test
    public void EmailTest(){
        Observer notificador = new Email();

        String msj = "La materia SOR2 cambio al aula A07272";
        notificador.update(msj);
    }
}