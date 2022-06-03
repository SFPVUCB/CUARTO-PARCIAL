package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityDao
{
    @Select("SELECT city_id, cityname FROM city")
    List<CityDto> findcity(@Param("id") String botChatId);
}
