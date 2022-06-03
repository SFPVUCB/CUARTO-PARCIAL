package bo.edu.ucb.ingsoft.hhrr.api;

import bo.edu.ucb.ingsoft.hhrr.bl.CityBl2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class CityController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private CityBl2 cityBl2;

    @GetMapping(path = "/ciudad/{city_id}")
    public ResponseDto findCiudadById(@PathVariable Integer city_id) {
        CityDto city = cityBl2.findCiudadById(city_id);
        if (city != null) {
            return new ResponseDto( true, city, null);
        } else {
            return new ResponseDto( false, null, "No existe ");
        }
    }

    @GetMapping(path = "/ciudad2/{city_id}")
    public List<CityDto> findAllCiudades(@PathVariable Integer city_id)
    {
        List<CityDto> city = cityBl2.findAllCiudades(city_id);
        return cityBl2.findAllCiudades(city_id);
    }
    @GetMapping(path = "/ciudad1")
    public List<CityDto> findAllCiudad() {
        return cityBl2.findAllCiudad();
    }
}
