package bo.edu.ucb.ingsoft.hhrr.bl;

import bo.edu.ucb.ingsoft.hhrr.dao.FilmCategoryDao;
import bo.edu.ucb.ingsoft.hhrr.dto.db.FilmCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmCategoryBl
{
    @Autowired
    FilmCategoryDao filmcategoryDao;
    public FilmCategoryDto findFilmCategoryById(Integer filmcategory_id)
    {
        return filmcategoryDao.findFilmCategoryById(filmcategory_id);
    }

    public List<FilmCategoryDto> findAllFilmsCategory()
    {
        return filmcategoryDao.findAllFilmsCategory();
    }


}
