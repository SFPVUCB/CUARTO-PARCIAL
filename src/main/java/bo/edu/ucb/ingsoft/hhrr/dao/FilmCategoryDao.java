package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmCategoryDto;
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
public class FilmCategoryDao
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public FilmCategoryDto findFilmCategoryById(Integer filmcategory_id) {
        FilmCategoryDto result = new FilmCategoryDto();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM filmcategory WHERE filmcategory_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, filmcategory_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setFilmcategory_id(rs.getInt("filmcategory_id"));
                result.setFilm_film_id(rs.getInt("film_id"));
                result.setCategory_id(rs.getInt("category_id"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<FilmCategoryDto> findAllFilmsCategory() {
        List<FilmCategoryDto> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM filmcategory");
            while (rs.next())
            {
                FilmCategoryDto filmcategory = new FilmCategoryDto();
                filmcategory.setFilmcategory_id(rs.getInt("filmcategory_id"));
                filmcategory.setFilm_film_id(rs.getInt("film_id"));
                filmcategory.setCategory_id(rs.getInt("category_id"));
                result.add(filmcategory);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }

}
