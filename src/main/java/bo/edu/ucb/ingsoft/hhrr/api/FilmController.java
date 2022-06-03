package bo.edu.ucb.ingsoft.hhrr.api;

import bo.edu.ucb.ingsoft.hhrr.bl.CityBl2;
import bo.edu.ucb.ingsoft.hhrr.bl.FilmBl2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class FilmController
{
    @Autowired
    public DataSource dataSource;

    @Autowired
    private FilmBl2 filmBl2;

    @GetMapping(path = "/film/{film_id}")
    public ResponseDto findFilmById(@PathVariable Integer film_id) {
        FilmDto film = filmBl2.findFilmById(film_id);
        if (film != null) {
            return new ResponseDto( true, film, null);
        } else {
            return new ResponseDto( false, null, "No existe :");
        }
    }

    @GetMapping(path = "/film2/{film_id}")
    public List<FilmDto> findAllFilmsById(@PathVariable Integer film_id)
    {
        List<FilmDto> film = filmBl2.findAllFilmsById(film_id);
        return filmBl2.findAllFilmsById(film_id);
    }
    @GetMapping(path = "/film3")
    public List<FilmDto> findAllFilms() {
        return filmBl2.findAllFilms();
    }


    @PostMapping(path = "/film4")
    public FilmDto createFilmDto(@RequestBody FilmDto filmDto)
    {

        return filmBl2.crearFilm(filmDto);
    }
    @GetMapping(path = "/film5/{title}")
    public List<FilmDto> findAllVeterinariosApellido(@PathVariable String title) {
        List<FilmDto> filmDto = filmBl2.findAllFilmsByTitle(title);
        return filmBl2.findAllFilmsByTitle(title);
    }


}
