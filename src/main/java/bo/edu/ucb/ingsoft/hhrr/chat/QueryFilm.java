package bo.edu.ucb.ingsoft.hhrr.chat;

import bo.edu.ucb.ingsoft.hhrr.bl.FilmBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class QueryFilm extends AbstractProcess {

    private FilmBl filmBl;

    @Autowired
    public QueryFilm(FilmBl filmBl) {
        this.filmBl = filmBl;
        this.setName("Consultar solicitudes pasadas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, StoreVideoLongPollingBot bot)
    {
        Long chatId = update.getMessage().getChatId();
        List<FilmDto> filmList = filmBl.findFilmByChatId();
        StringBuffer sb = new StringBuffer();
        StringBuffer sb1 = new StringBuffer();

        sb.append("Contamos Actualmente con  " ).append(filmList.size()+" Peliculas\r\n");

        for(FilmDto films: filmList)
        {
            sb.append(films.toString()).append("\n\r");
            sendStringBuffer(bot, chatId, sb);
            sb.setLength(0);
        }
        sb1.append("-------------------------------------------------------------------\r\n");
        sb1.append("Precione cualquier tecla para volver al Menu\r\n");
        sb1.append("-------------------------------------------------------------------\r\n");
        sendStringBuffer(bot, chatId, sb1);


        return new MenuCartelera();
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
