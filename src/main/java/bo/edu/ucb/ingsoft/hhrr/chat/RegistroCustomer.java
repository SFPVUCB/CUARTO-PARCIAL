package bo.edu.ucb.ingsoft.hhrr.chat;

import bo.edu.ucb.ingsoft.hhrr.bl.CustomerBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

@Service
public class RegistroCustomer extends AbstractProcess
{
    private CustomerBl customerbl;
    private CustomerDto customerdto;
    @Autowired
    public RegistroCustomer(CustomerBl customerbl)
    {

        this.customerbl=customerbl;
        this.setName("Registra Cliente");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }


    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, StoreVideoLongPollingBot bot) {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        Integer c=1;
        CustomerDto customerdto = new CustomerDto();
        if (this.getStatus().equals("STARTED"))
        {
            showFormulario(bot,chatId,c);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2

            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try
                {
                    switch (c)
                    {
                        case 1:
                            customerdto.setName(text);
                            this.setStatus("STARTED");

                            break;
                        case 2:

                            this.setStatus("AWAITING_USER_RESPONSE");
                            break;
                        case 3:

                            break;
                        case 4:


                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

                            break;
                        case 9:

                        default:
                            result = new MenuPrincipal();
                    }
                    c++;


                }
                catch (NumberFormatException ex)
                {
                    showFormulario(bot, chatId,c);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showFormulario(bot, chatId,c);
            }
        }
        return result;
    }

    private void showMainMenu(StoreVideoLongPollingBot bot, Long chatId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Ingrese el Titulo de la Pelicula \n\r");
        sendStringBuffer(bot,chatId,sb);
        this.setStatus("AWAITING_USER_RESPONSE");
    }
    private void showFormulario(StoreVideoLongPollingBot bot, Long chatId,Integer contador)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Ingresar nombre \n\r");
        sendStringBuffer(bot,chatId,sb);
        this.setStatus("AWAITING_USER_RESPONSE");
        switch (contador)
        {
            case 1:
                sb.append("Ingresar nombre \n\r");
                sendStringBuffer(bot,chatId,sb);

                this.setStatus("AWAITING_USER_RESPONSE");

                break;
            case 2:
                sb.append("Ingresar apellido\n\r");
                sendStringBuffer(bot,chatId,sb);
                this.setStatus("AWAITING_USER_RESPONSE");
                break;
            case 3:
                sb.append("Ingresar telefono\n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            case 4:
                sb.append("Ingresar correo\n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            case 5:
                sb.append("Ingresar NombreUsuario\n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            case 6:
                sb.append("Ingresar Contrasenia\n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            case 7:
                sb.append("Ingresar URL de su imagen\n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            case 9:
                sb.append("Ingresar \n\r");
                sendStringBuffer(bot,chatId,sb);

                break;
            default:
                break;

        }
        this.setStatus("AWAITING_USER_RESPONSE");
    }




    @Override
    public AbstractProcess onError() {
        return null;
    }

    @Override
    public AbstractProcess onSuccess() {
        return null;
    }

    @Override
    public AbstractProcess onTimeout() {
        return null;
    }
}
