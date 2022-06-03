package bo.edu.ucb.ingsoft.hhrr.chat;

import bo.edu.ucb.ingsoft.hhrr.bl.FilmBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.HashMap;
import java.util.List;

@Service
public class BusquedaFilmRating extends AbstractProcess
{
    private FilmBl filmbl;
    @Autowired
    public BusquedaFilmRating(FilmBl filmbl)
    {
        this.filmbl=filmbl;
        this.setName("Busqueda por Rating");
        this.setDefault(true);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, StoreVideoLongPollingBot bot)
    {
        AbstractProcess result = this; // sigo en el mismo proceso.
        Long chatId = update.getMessage().getChatId();
        StringBuffer sb1 = new StringBuffer();

        if (this.getStatus().equals("STARTED")) {

            showMainMenu(bot, chatId);
        } else if (this.getStatus().equals("AWAITING_USER_RESPONSE")) {
            // Estamos esperando por un numero 1 o 2

            Message message = update.getMessage();
            if ( message.hasText() ) {
                // Intentamos transformar en número
                Integer text = Integer.parseInt(message.getText()); // El texto contiene asdasdas


                try
                {
                    List<FilmDto> filmdto = filmbl.findFilmByRating(text);
                    StringBuffer sb = new StringBuffer();
                    for(FilmDto films: filmdto) {
                        sb.append(films.toString()).append("\n\r");
                    }
                    sendStringBuffer(bot, chatId, sb);
                    result = new MenuCartelera();


                }
                catch (NumberFormatException ex)
                {
                    showMainMenu(bot, chatId);
                }
                // continuar con el proceso seleccionado

            }

            else
            { // Si me enviaron algo diferente de un texto.
                showMainMenu(bot, chatId);
            }

        }
        /*
        sb1.append("-------------------------------------------------------------------\r\n");
        sb1.append("Precione cualquier tecla para volver al Menu\r\n");
        sb1.append("-------------------------------------------------------------------\r\n");
        sendStringBuffer(bot, chatId, sb1);

         */
        return result;

    }


    private void showMainMenu(StoreVideoLongPollingBot bot, Long chatId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Ingrese el numero de rating entre 1-5 \n\r");
        sendStringBuffer(bot,chatId,sb);
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
