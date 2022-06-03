package bo.edu.ucb.ingsoft.hhrr.chat;

import bo.edu.ucb.ingsoft.hhrr.bl.CityBl;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
public class QueryCity extends AbstractProcess {

    private CityBl cityBl;

    @Autowired
    public QueryCity(CityBl cityBl) {
        this.cityBl = cityBl;
        this.setName("Consultar solicitudes pasadas");
        this.setDefault(false);
        this.setExpires(false);
        this.setStartDate(System.currentTimeMillis()/1000);
        //this.setUserData(new HashMap<>());
        this.setStatus("STARTED");
    }

    @Override
    public AbstractProcess handle(ApplicationContext context, Update update, StoreVideoLongPollingBot bot) {
        Long chatId = update.getMessage().getChatId();
        List<CityDto> cityList = cityBl.findCityByChatId(chatId);
        StringBuffer sb = new StringBuffer();
        sb.append("Contamos Actualmente con  " ).append(cityList.size()+" Sucursales");
        String photo = "http://images.china.cn/attachement/jpg/site1006/20140414/001ec949faf114b58a7d0b.jpg";

        for(CityDto cities: cityList) {
            sb.append(cities.toString()).append("\n\r");
        }


        sb.append("--------------------------------------------\r\n");
        sb.append("Precione cualquier tecla para volver al Menu\r\n");
        sb.append("--------------------------------------------\r\n");
        sendStringBuffer(bot, chatId, sb);
        sendPhotoB(bot,chatId,photo);
        return new MenuPrincipal();
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
