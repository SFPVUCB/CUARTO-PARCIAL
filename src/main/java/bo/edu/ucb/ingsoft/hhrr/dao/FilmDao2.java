package bo.edu.ucb.ingsoft.hhrr.dao;

import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmDao2
{
    @Autowired
    private DataSource dataSource;

    @Autowired
    private SequenceDao sequenceDao;

    public FilmDto crearFilm (FilmDto filmDto) {
        filmDto.setFil_id(sequenceDao.getPrimaryKeyForTable("film"));
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO film VALUES (?,?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1, filmDto.getFil_id());
            stmt.setInt(2, filmDto.getLanguage_id());
            stmt.setString(3, filmDto.getTitle());
            stmt.setString(4, filmDto.getDescription());
            stmt.setInt(5, filmDto.getRealeseYear());
            stmt.setInt(6, filmDto.getRealeseDuration());
            stmt.setDouble(7, filmDto.getRentalAmount());
            stmt.setInt(8, filmDto.getDuration());
            stmt.setInt(9, filmDto.getRating());
            stmt.setString(10, filmDto.getImage());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException sqex) {
                    // No hacer nada intencionalemte;
                }
            }
        }
        return filmDto;
    }

    public FilmDto findFilmById(Integer film_id) {
        FilmDto result = new FilmDto();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM film WHERE film_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, film_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result.setFil_id(rs.getInt("film_id"));
                result.setLanguage_id(rs.getInt("language_id"));
                result.setTitle(rs.getString("title"));
                result.setDescription(rs.getString("description"));
                result.setRealeseYear(rs.getInt("releaseyear"));
                result.setRealeseDuration(rs.getInt("rentalduration"));
                result.setRentalAmount(rs.getDouble("rentalamount"));
                result.setDuration(rs.getInt("duration"));
                result.setRating(rs.getInt("rating"));
                result.setImage(rs.getString("image"));

            } else { // si no hay valores de BBDD
                result = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    public List<FilmDto> findAllFilmsById(Integer language_id) {
        List<FilmDto> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM film WHERE language_id = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setInt(1, language_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                FilmDto film = new FilmDto();
                film.setFil_id(rs.getInt("film_id"));
                film.setLanguage_id(rs.getInt("language_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRealeseYear(rs.getInt("releaseyear"));
                film.setRealeseDuration(rs.getInt("rentalduration"));
                film.setRentalAmount(rs.getDouble("rentalamount"));
                film.setDuration(rs.getInt("duration"));
                film.setRating(rs.getInt("rating"));
                film.setImage(rs.getString("image"));

                result1.add(film);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;

    }
    public List<FilmDto> findAllFilms() {
        List<FilmDto> result = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM film");
            while (rs.next())
            {
                FilmDto film = new FilmDto();
                film.setFil_id(rs.getInt("film_id"));
                film.setLanguage_id(rs.getInt("language_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setRealeseYear(rs.getInt("releaseyear"));
                film.setRealeseDuration(rs.getInt("rentalduration"));
                film.setRentalAmount(rs.getDouble("rentalamount"));
                film.setDuration(rs.getInt("duration"));
                film.setRating(rs.getInt("rating"));
                film.setImage(rs.getString("image"));
                result.add(film);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
        //apellidos
    }
    public List<FilmDto> findAllFilmsByTitle(String title) {
        List<FilmDto> result1 = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                     "FROM film WHERE title = ?")
        ) {  // TRY WITH RESOURCES
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                FilmDto filmDto = new FilmDto();
                filmDto.setFil_id(rs.getInt("film_id"));
                filmDto.setLanguage_id(rs.getInt("language_id"));
                filmDto.setTitle(rs.getString("title"));
                filmDto.setDescription(rs.getString("description"));
                filmDto.setRealeseYear(rs.getInt("releaseyear"));
                filmDto.setRealeseDuration(rs.getInt("rentalduration"));
                filmDto.setRentalAmount(rs.getDouble("rentalamount"));
                filmDto.setDuration(rs.getInt("duration"));
                filmDto.setRating(rs.getInt("rating"));
                filmDto.setImage(rs.getString("image"));
                result1.add(filmDto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result1;
        //apellidos
    }

}
