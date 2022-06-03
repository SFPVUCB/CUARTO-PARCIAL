package bo.edu.ucb.ingsoft.hhrr.chat;

import org.springframework.context.ApplicationContext;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;

public class MenuCartelera extends AbstractProcess
{

    public MenuCartelera()
    {
        this.setName("Menú Cartelera");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    // Retornar un Widget de tipo menu
//    @Override
//    public AbstractWidget onInit() {
//        MenuWidgetImpl menuWidget = new MenuWidgetImpl(messages);
//        return menuWidget;
//    }


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
                        case 1 : result = context.getBean(QueryFilm.class) ;
                        break;
                        case 2 : result = context.getBean(BusquedaFilmTitle.class);
                        break;
                        case 3 : result = context.getBean(BusquedaFilmRating.class);
                        break;
                        case 4 :
                        break;
                        case 5: result = new MenuPrincipal();
                        break;
                        default: showMainMenu(bot, chatId);
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
        sb.append("-----------------TE ENCONTRAS EN: ------------------\r\n");
        sb.append("***MENU CARTELERA ***\r\n");
        sb.append("----------------------------------------------------\r\n");
        sb.append("1. Mostrar todos las Peliculas Disponibles\n");
        sb.append("2. Buscar por Titulo\r\n");
        sb.append("3. Buscar por Rating\r\n");
        sb.append("4. Realizar la reserva\r\n");
        sb.append("5. Voler al MENU PRINCIPAL\r\n");
        sb.append("Elija una opción:\r\n");
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
