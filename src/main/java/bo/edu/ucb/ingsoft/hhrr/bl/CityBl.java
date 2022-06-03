package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.CityDao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityBl
{
    private CityDao cityDao;

    @Autowired
    public CityBl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public List<CityDto> findCityByChatId(Long chatId)
    {
        return cityDao.findcity(chatId+"");

    }
}
