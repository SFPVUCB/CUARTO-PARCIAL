package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.CityDao2;
import bo.edu.ucb.ingsoft.hhrr.dao.FilmDao2;
import bo.edu.ucb.ingsoft.hhrr.dto.db.CityDto;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmBl2
{
    @Autowired
    FilmDao2 filmDao2;
    public FilmDto findFilmById(Integer film_id)
    {
        return filmDao2.findFilmById(film_id);
    }

    public List<FilmDto> findAllFilmsById(Integer film_id) {
        return filmDao2.findAllFilmsById(film_id);
    }

    public List<FilmDto> findAllFilms() {
        return filmDao2.findAllFilms();
    }

    //crear una pelicula
    public FilmDto crearFilm(FilmDto filmDto) {

        return filmDao2.crearFilm(filmDto);
    }
    public List<FilmDto> findAllFilmsByTitle(String title) {
        return filmDao2.findAllFilmsByTitle(title);
    }



}
