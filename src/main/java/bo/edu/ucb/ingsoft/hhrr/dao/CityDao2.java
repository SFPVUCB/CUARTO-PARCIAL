package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityDao2
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public CityDto findCiudadById(Integer city_id) {
        CityDto result = new CityDto();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM city WHERE city_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, city_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setCity_id(rs.getInt("city_id"));
                result.setCity(rs.getString("cityname"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<CityDto> findAllCiudades(Integer city_id) {
        List<CityDto> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM city WHERE city_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, city_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                CityDto city = new CityDto();
                city.setCity_id(rs.getInt("city_id"));
                city.setCity(rs.getString("cityname"));

                result1.add(city);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;

    }
    public List<CityDto> findAllCiudad() {
        List<CityDto> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM city");
            while (rs.next())
            {
                CityDto city = new CityDto();
                city.setCity_id(rs.getInt("city_id"));
                city.setCity(rs.getString("cityname"));
                result.add(city);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

}
