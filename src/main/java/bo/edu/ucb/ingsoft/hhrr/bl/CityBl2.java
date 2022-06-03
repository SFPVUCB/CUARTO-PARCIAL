package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.CityDao2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@Service
public class CityBl2
{
    @Autowired
    CityDao2 ciudadDao2;
    public CityDto findCiudadById(Integer city_id)
    {
        return ciudadDao2.findCiudadById(city_id);
    }

    public List<CityDto> findAllCiudades(Integer ciudad_id) {
        return ciudadDao2.findAllCiudades(ciudad_id);
    }

    public List<CityDto> findAllCiudad() {
        return ciudadDao2.findAllCiudad();
    }


}
