package bo.edu.ucb.ingsoft.hhrr.chat;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class MenuPrincipal extends AbstractProcess {

    public MenuPrincipal() {
        this.setName("Menú principal");
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

        if (this.getStatus().equals("STARTED")) {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2

            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                String text = message.getText(); // El texto contiene asdasdas
                try {
                    int opcion = Integer.parseInt(text);
                    switch (opcion){
                        case 1 : result = context.getBean(QueryCity.class) ;
                        break;
                        case 2 : result = new MenuCartelera();
                        break;
                        case 3 :
                            break;

                        case 4 : result = context.getBean(RegistroCustomer.class);
                            break;
                        default: showMainMenu(bot, chatId);
                        break;
                    }
                } catch (NumberFormatException ex) {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado
            } else { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
            }
        }
        return result;
    }

    private void showMainMenu(StoreVideoLongPollingBot bot, Long chatId) {
        StringBuffer sb = new StringBuffer();
        String photo = "https://www.spgtalleres.com/_images/news/248/7562_modal.jpg";
        sb.append("-----------------TE ENCONTRAS EN: -----------------------------------------\r\n");
        sb.append("          ***MENU PRINCIPAL TIENDA VIDEOS ***\r\n");
        sb.append("---------------------------------------------------------------------------\r\n");
        sb.append("1. Sucursales\n");
        sb.append("2. Menu Cartelera\r\n");
        sb.append("3. Reservar Pelicula\r\n");
        sb.append("4. Registrarme\r\n");
        sb.append("Elija una opción:\r\n");
        sendPhotoB(bot,chatId,photo);
        sendStringBuffer(bot, chatId, sb);



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
