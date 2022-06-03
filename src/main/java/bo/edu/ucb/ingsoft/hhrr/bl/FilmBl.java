package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.FilmDao;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmBl
{
    private FilmDao filmdao;

    @Autowired
    public FilmBl(FilmDao filmdao) {
        this.filmdao = filmdao;
    }

    public List<FilmDto> findFilmByChatId()
    {
        return filmdao.findfilm();
    }
    public List<FilmDto> findFilmByTitle(String title)
    {
        return filmdao.findfilmtitle(title);
    }
    public List<FilmDto> findFilmByRating(Integer rating)
    {
        return filmdao.findfilmrating(rating);
    }



}
